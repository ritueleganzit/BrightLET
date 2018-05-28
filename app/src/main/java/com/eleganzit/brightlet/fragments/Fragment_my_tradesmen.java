package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyOrdersAdapter;
import com.eleganzit.brightlet.adapters.MyTradesmenAdapter;
import com.eleganzit.brightlet.model.GetMyOrders;
import com.eleganzit.brightlet.model.GetMyTradesmen;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_my_tradesmen extends Fragment {


    public Fragment_my_tradesmen() {
        // Required empty public constructor
    }
    RecyclerView my_tradesmen;
    ArrayList<GetMyTradesmen> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_my_tradesmen, container, false);

        my_tradesmen=v.findViewById(R.id.rc_my_tradesmen);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        my_tradesmen.setLayoutManager(layoutManager);

        my_tradesmen.setAdapter(new MyTradesmenAdapter(arrayList,getActivity()));

        return v;
    }

}
