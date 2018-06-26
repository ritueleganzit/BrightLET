package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.ComplianceAdapter;
import com.eleganzit.brightlet.model.GetCompliance;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_compliance extends Fragment {


    public Fragment_compliance() {
        // Required empty public constructor
    }
    RecyclerView compliance;
    ArrayList<GetCompliance> arrayList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_compliance, container, false);

        compliance=v.findViewById(R.id.rc_compliance);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false);
        compliance.setLayoutManager(layoutManager);
        compliance.setAdapter(new ComplianceAdapter(arrayList,getContext()));

        return v;
    }

}
