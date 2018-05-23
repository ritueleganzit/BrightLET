package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.TenantsAdapter;
import com.eleganzit.brightlet.model.GetTenants;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_tenants extends Fragment {


    public Fragment_tenants() {
        // Required empty public constructor
    }
    RecyclerView tenants;
    ArrayList<GetTenants> getTenantses=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_tenants, container, false);
        tenants=v.findViewById(R.id.tenants);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        tenants.setLayoutManager(layoutManager);

        tenants.setAdapter(new TenantsAdapter(getTenantses,getContext()));
        return v;
    }

}
