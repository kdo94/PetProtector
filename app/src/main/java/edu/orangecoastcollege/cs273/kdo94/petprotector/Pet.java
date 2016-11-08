package edu.orangecoastcollege.cs273.kdo94.petprotector;

/**
 * Created by kevin_000 on 11/7/2016.
 */

public class Pet {
    int mId;
    String mPetName;
    String mPetDetails;
    int mPhoneNumber;
    String mPetImageURI;

    public Pet() {
        mId = -1;
        mPetName = "";
        mPetDetails = "";
        mPhoneNumber = 0;
        mPetImageURI = "";
    }

    public Pet(int id, String petName, String petDetails, int phoneNumber, String petImageURI) {
        mId = id;
        mPetName = petName;
        mPetDetails = petDetails;
        mPhoneNumber = phoneNumber;
        mPetImageURI = petImageURI;
    }

    public Pet(String petName, String petDetails, int phone){
        this(-1, petName, petDetails, phone, "");
    }

    public Pet(String petName, String petDetails, int phone, String petImage){
        this(-1, petName, petDetails, phone, petImage);
    }

    public int getId(){
        return mId;
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

    public int getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getPetImageURI() {
        return mPetImageURI;
    }

    public void setPetImageURI(String petImageURI) {
        mPetImageURI = petImageURI;
    }
}

