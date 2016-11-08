package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.net.Uri;


/**
 * Created by kevin_000 on 11/7/2016.
 */

public class Pet {
    int mId;
    String mPetName;
    String mPetDetails;
    long mPhoneNumber;
    Uri mPetImageURI;

    public Pet() {
        mId = -1;
        mPetName = "";
        mPetDetails = "";
        mPhoneNumber = 0;
        mPetImageURI = Uri.parse("getUriToResource(this, R.drawable.none)");
    }

    public Pet(int id, String petName, String petDetails, long phoneNumber, Uri petImageURI) {
        mId = id;
        mPetName = petName;
        mPetDetails = petDetails;
        mPhoneNumber = phoneNumber;
        mPetImageURI = petImageURI;
    }

    public Pet(String petName, String petDetails, long phone, Uri petImage){
        this(-1, petName, petDetails, phone, petImage);
    }

    public String getPetName() {
        return mPetName;
    }

    public void setPetName(String petName) {
        mPetName = petName;
    }

    public String getPetDetails() {
        return mPetDetails;
    }

    public void setPetDetails(String petDetails) {
        mPetDetails = petDetails;
    }

    public long getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Uri getPetImageURI() {
        return mPetImageURI;
    }

    public void setPetImageURI(Uri petImageURI) {
        mPetImageURI = petImageURI;
    }

}

