package com.developers.shreeganesha.ranazunjardholtasha;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Ranazunjar extends Fragment {

    TextView practice_Place;


    public Home_Ranazunjar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_home__ranazunjar, container, false);
        practice_Place = (TextView) root.findViewById(R.id.place);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Shivaji05.ttf");
        practice_Place.setTypeface(typeface);
        return root;
    }

}
