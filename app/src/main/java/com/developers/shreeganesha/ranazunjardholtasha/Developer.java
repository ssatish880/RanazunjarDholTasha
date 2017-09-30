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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Developer extends Fragment {

    ImageView facebook,insta,twitter;
    String uriString;
    private String Ranazunjar;


    public Developer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root = inflater.inflate(R.layout.fragment_developer, container, false);

        facebook = (ImageView) root.findViewById(R.id.facebook);
        insta = (ImageView) root.findViewById(R.id.instagram);
        twitter = (ImageView) root.findViewById(R.id.twiter);

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



        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://twitter.com/satish_sonwale");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.twitter.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://twitter.com/satish_sonwale")));
                }

               // Toast.makeText(getActivity(),"Twitter Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/satish_sonwale");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/satish_sonwale")));
                }
               // Toast.makeText(getActivity(),"Instagram Clicked", Toast.LENGTH_SHORT).show();
            }
        });


            return root;
    }


    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String FACEBOOK_URL = "http://facebook.com/satish.sonwale.334";
        Ranazunjar = "satish.sonwale.334";
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;

            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "http://facebook.com/satish.sonwale.334";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }


}
