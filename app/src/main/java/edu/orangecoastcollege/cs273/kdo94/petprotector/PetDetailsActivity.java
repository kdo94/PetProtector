package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PetDetailsActivity extends AppCompatActivity {

    private ImageView detailsPetImageView;
    private TextView detailsNameTextView;
    private TextView detailsPetDetailsTextView;
    private TextView detailsPhoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        detailsPetImageView = (ImageView) findViewById(R.id.detailsPetImageView);
        detailsNameTextView = (TextView) findViewById(R.id.detailsNameTextView);
        detailsPetDetailsTextView = (TextView) findViewById(R.id.detailsPetDetailsTextView);
        detailsPhoneTextView = (TextView) findViewById(R.id.detailsPhoneTextView);

        Intent petDetails = getIntent();
        detailsNameTextView.setText(petDetails.getStringExtra("Pet Name"));
    }
}
