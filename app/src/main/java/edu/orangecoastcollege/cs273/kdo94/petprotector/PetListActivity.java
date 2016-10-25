package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

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
        //imageURI = getUriToResource(this, R.drawable.none);

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

            ActivityCompat.requestPermissions(this, permList.toArray(perms), 0);
        }
    }
}
