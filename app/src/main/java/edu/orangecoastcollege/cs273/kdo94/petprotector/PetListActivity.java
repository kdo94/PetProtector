package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;

    private ImageView petImageView;
    // This member variable stores the URI to whatever has been selected
    // Default: none.png (R.drawable.none)
    private Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        // Hook up the perImageView to the layout
        petImageView = (ImageView) findViewById(R.id.petImageView);

        // Constructs a full URI to any Android resource
        imageURI = getUriToResource(this, R.drawable.none);

        // Set the imageURI of the imageView in code
        petImageView.setImageURI(imageURI);
    }

    public void selectPetImage(View view){
        // List of all the permissions we need to request from the user
        ArrayList<String> permList = new ArrayList<>();

        // Start by seeing if we have permission to the camera
        int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (cameraPermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.CAMERA);

        int writeStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeStoragePermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        int readStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readStoragePermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.READ_EXTERNAL_STORAGE);

        // If the list has items, we need to request permissions from the user
        if(permList.size() > 0){
            // Convert the ArrayList into an Array of strings
            String[] perms = new String[permList.size()];

            ActivityCompat.requestPermissions(this, permList.toArray(perms), REQUEST_CODE);
        }

        // If we have all three permissions, open the ImageGallery
        if(cameraPermission == PackageManager.PERMISSION_GRANTED &&
                readStoragePermission == PackageManager.PERMISSION_GRANTED &&
                writeStoragePermission == PackageManager.PERMISSION_GRANTED){
            // Use an Intent to launch the gallery and take pictures
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, REQUEST_CODE);
            Toast.makeText(this, "Pet Protector requires camera and external storage permission", Toast.LENGTH_SHORT);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Code to handle when the user closes the image gallery (by selecting an image
        // or pressing the back button)

        // The Intent data is the URI selected from the image gallery
        // Decide if the user selected an image:
        if(data != null && requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            // set the imageURI to the data:
            imageURI = data.getData();
            petImageView.setImageURI(imageURI);
        }
    }

    public static Uri getUriToResource(@NonNull Context context, @AnyRes int resId) throws Resources.NotFoundException{
        // Return a Resources instance for your application's package
        Resources res = context.getResources();
        // Return URI
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + res.getResourcePackageName(resId) +
                        '/' + res.getResourceTypeName(resId) +
                        '/' + res.getResourceEntryName(resId));
    }
}
