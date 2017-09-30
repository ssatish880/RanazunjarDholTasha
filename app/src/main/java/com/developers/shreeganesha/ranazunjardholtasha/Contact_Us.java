package com.developers.shreeganesha.ranazunjardholtasha;


import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Us extends Fragment {

    ImageView con1,con2,con3,con4;

    public Contact_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contact__us, container, false);

        con1 = (ImageView) root.findViewById(R.id.contact_1);
        con2 = (ImageView) root.findViewById(R.id.contact_2);
        con3 = (ImageView) root.findViewById(R.id.contact_3);
        con4 = (ImageView) root.findViewById(R.id.contact_4);

        con1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact1 = "tel:8830698176";
                calling(contact1);
                Toast.makeText(getActivity(),"Calling Rohit Gaikwad",Toast.LENGTH_SHORT).show();
            }
        });

        con2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact1 = "tel:9028079700";
                calling(contact1);
                Toast.makeText(getActivity(),"Calling Tushar Dighe",Toast.LENGTH_SHORT).show();
            }
        });

        con3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact1 = "tel:9762257535";
                calling(contact1);
                Toast.makeText(getActivity(),"Calling Satish Sonwale",Toast.LENGTH_SHORT).show();
            }
        });

        con4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact1 = "tel:9552176198";
                calling(contact1);
                Toast.makeText(getActivity(),"Calling Aaditya Sonwane",Toast.LENGTH_SHORT).show();
            }
        });


        return root;

    }

    public void calling(String number){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(number));
        startActivity(intent);
    }

}
