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
import com.eleganzit.brightlet.adapters.AppointmentsAdapter;
import com.eleganzit.brightlet.adapters.RemindersAdapter;
import com.eleganzit.brightlet.model.GetAppointments;
import com.eleganzit.brightlet.model.GetReminders;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_appointment extends Fragment {


    public Fragment_appointment() {
        // Required empty public constructor
    }
    RecyclerView appointments;
    ArrayList<GetAppointments> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_appointment, container, false);
        setHasOptionsMenu(true);

        appointments=v.findViewById(R.id.appointments);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        appointments.setLayoutManager(layoutManager);
        appointments.setAdapter(new AppointmentsAdapter(arrayList,getContext()));

        return v;
    }
    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }*/

}
