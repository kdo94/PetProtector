package edu.orangecoastcollege.cs273.kdo94.petprotector;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin_000 on 11/7/2016.
 */

public class PetListAdapter extends ArrayAdapter<Pet>{
    private Context mContext;
    private List<Pet> mPetList = new ArrayList<>();
    private int mResourceId;
    private ImageView petListImageView;
    private TextView nameListTextView;
    private TextView detailsListTextView;
    private LinearLayout petListLinearLayout;

    public PetListAdapter(Context context, int rId, List<Pet> pets){
        super(context, rId, pets);
        mContext = context;
        mResourceId = rId;
        mPetList = pets;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view  = inflater.inflate(mResourceId, null);

        petListLinearLayout = (LinearLayout) view.findViewById(R.id.petListLinearLayout);
        petListImageView = (ImageView) view.findViewById(R.id.petListImageView);
        nameListTextView = (TextView) view.findViewById(R.id.nameListTextView);
        detailsListTextView = (TextView) view.findViewById(R.id.detailsListTextView);
        Pet selectedPet = mPetList.get(pos);
        petListLinearLayout.setTag(selectedPet);

        nameListTextView.setText(selectedPet.getPetName());
        detailsListTextView.setText(selectedPet.getPetDetails());
        petListImageView.setImageURI(Uri.parse(selectedPet.mPetImageURI));


        return view;
    }
}
