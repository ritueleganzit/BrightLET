package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.RemindersAdapter;
import com.eleganzit.brightlet.model.GetReminders;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_reminders extends Fragment {


    public Fragment_reminders() {
        // Required empty public constructor

    }
    RecyclerView reminders;
    ArrayList<GetReminders> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_reminders, container, false);

        reminders=v.findViewById(R.id.rc_reminders);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        reminders.setLayoutManager(layoutManager);
        reminders.setAdapter(new RemindersAdapter(arrayList,getContext()));

        return v;
    }

}
