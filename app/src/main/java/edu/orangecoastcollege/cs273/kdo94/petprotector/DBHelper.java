package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by kevin_000 on 11/7/2016.
 */

class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "PetProtector";
    private static final String DATABASE_TABLE = "Pets";
    private static final int DATABASE_VERSION = 1;

    private static final String KEY_FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_PHONE_NUMBER = "phone_number";
    private static final String FIELD_PET_IMAGE = "pet_image";

    public DBHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE " + DATABASE_TABLE + "(" +
                KEY_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_NAME + " TEXT, " +
                FIELD_DETAILS + " TEXT, " +
                FIELD_PHONE_NUMBER + " REAL, " +
                FIELD_PET_IMAGE + " TEXT" +")";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
        onCreate(db);
    }

    /**
     * Adds a pet to the Pets table database
     *
     * @param pet Pet to be added to the database
     */
    public void addPet(Pet pet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, pet.getPetName());
        values.put(FIELD_DETAILS, pet.getPetDetails());
        values.put(FIELD_PHONE_NUMBER, pet.getPhoneNumber());
        values.put(FIELD_PET_IMAGE, pet.getPetImageURI().toString());
        db.insert(DATABASE_TABLE, null, values);
        db.close();
    }

    /**
     * Gets all pets in the Pets table database and puts them into a list
     *
     * @return A list of all the pets in the Pets table database
     */
    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> petList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                DATABASE_TABLE,
                new String[] {KEY_FIELD_ID, FIELD_NAME, FIELD_DETAILS, FIELD_PHONE_NUMBER, FIELD_PET_IMAGE},
                null,
                null,
                null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                Pet pet = new Pet(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        Uri.parse(cursor.getString(4)));
                petList.add(pet);
            }while(cursor.moveToNext());
        }

        return petList;
    }
}
