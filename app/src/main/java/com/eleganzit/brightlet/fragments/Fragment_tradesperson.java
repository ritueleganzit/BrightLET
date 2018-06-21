package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_tradesperson extends Fragment {


    public Fragment_tradesperson() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tradesperson, container, false);


        return v;
    }

}
