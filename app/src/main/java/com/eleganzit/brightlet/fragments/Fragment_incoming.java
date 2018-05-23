package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.FinancialIncomingAdapter;
import com.eleganzit.brightlet.model.GetFinancialIncoming;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_incoming extends Fragment {


    public Fragment_incoming() {
        // Required empty public constructor
    }
    RecyclerView incoming;
    ArrayList<GetFinancialIncoming> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_incoming, container, false);
        incoming=v.findViewById(R.id.incoming);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        incoming.setLayoutManager(layoutManager);

        incoming.setAdapter(new FinancialIncomingAdapter(arrayList,getContext()));

        return v;
    }

}
