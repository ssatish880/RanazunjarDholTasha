package com.developers.shreeganesha.ranazunjardholtasha;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Follow_Us extends Fragment {
    ImageView facebook,insta;
    String uriString;


    public Follow_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_follow__us, container, false);
        facebook = (ImageView) root.findViewById(R.id.facebook_Ranazunjar);
        insta = (ImageView) root.findViewById(R.id.instagram_Ranazunjar);


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                //uriString = "http://facebook.com/ranazunjar";
                uriString = getFacebookPageURL(getContext());
                intent.setData(Uri.parse(uriString));
                startActivity(intent);
            }
        });


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/ranazunjar");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/ranazunjar")));
                }
                // Toast.makeText(getActivity(),"Instagram Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        return root;
    }

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String FACEBOOK_URL = "http://facebook.com/ranazunjar";
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;

            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return FACEBOOK_URL;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

}


