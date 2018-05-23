package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eleganzit.brightlet.HomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.PropertyAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllPropertyFragment extends Fragment {

    RecyclerView recyclerView;
    public AllPropertyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_property, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PropertyAdapter propertyAdapter=new PropertyAdapter(new ArrayList<String>(),getActivity());

        recyclerView= (RecyclerView) view.findViewById(R.id.rc1);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(propertyAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        HomeActivity.name.setText("Mobile Case");
        Toast.makeText(getActivity(), ""+HomeActivity.name.getText().toString(), Toast.LENGTH_SHORT).show();

    }*/
}
