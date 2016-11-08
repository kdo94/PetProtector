package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.net.Uri;


/**
 * Created by kevin_000 on 11/7/2016.
 */

/**
 * Represents a pet in need.
 * Includes a name, picture, phone-number, and info on pet.
 *  */
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

    /**
     * Creates a new Pet with the given name, details, phoneNumber, and petImage
     * Phone number should be 10 digits long for CA
     *
     * @param id id of the pet for the database.
     * @param petName the name of the pet
     * @param petDetails a small description for the pet
     * @param phoneNumber contact info for the person
     * @param petImageURI link to get to the image of pet
     * */
    public Pet(int id, String petName, String petDetails, long phoneNumber, Uri petImageURI) {
        mId = id;
        mPetName = petName;
        mPetDetails = petDetails;
        mPhoneNumber = phoneNumber;
        mPetImageURI = petImageURI;
    }

    /**
     * Creates a new Pet with the given name, details, phoneNumber, and petImage
     * Phone number should be 10 digits long for CA
     *
     * @param petName the name of the pet
     * @param petDetails a small description for the pet
     * @param phone contact info for the person
     * @param petImage link to get to the image of pet
     * */
    public Pet(String petName, String petDetails, long phone, Uri petImage){
        this(-1, petName, petDetails, phone, petImage);
    }

    /**
     * Gets the name of the pet
     *
     * @return mPetName this pet's name
     * */
    public String getPetName() {
        return mPetName;
    }

    /**
     * Changes the name of the pet
     *
     * @param petName the pet's new name
     * */
    public void setPetName(String petName) {
        mPetName = petName;
    }

    /**
     * Gets the details about the pet
     *
     * @return mPetDetails this pet's small description
     * */
    public String getPetDetails() {
        return mPetDetails;
    }

    /**
     * Changes the description of the pet
     *
     * @param petDetails the pet's new small description
     * */
    public void setPetDetails(String petDetails) {
        mPetDetails = petDetails;
    }

    /**
     * Gets the phone number of the current owner of the pet
     *
     * @return mPhoneNumber the phone number of the current owner
     * */
    public long getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * Changes the phone number/contact info for the pet
     *
     * @param phoneNumber the pet's contact info
     * */
    public void setPhoneNumber(int phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    /**
     * Gets the picture of the pet
     *
     * @return mPetImageURI this pet's picture
     * */
    public Uri getPetImageURI() {
        return mPetImageURI;
    }

    /**
     * Changes the link for the image of the pet
     *
     * @param petImageURI the pet's image link
     * */
    public void setPetImageURI(Uri petImageURI) {
        mPetImageURI = petImageURI;
    }

}

