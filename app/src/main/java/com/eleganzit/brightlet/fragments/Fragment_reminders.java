package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_reminders extends Fragment {


    public Fragment_reminders() {
        // Required empty public constructor
    }
    RecyclerView reminders;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reminders, container, false);
    }

}
