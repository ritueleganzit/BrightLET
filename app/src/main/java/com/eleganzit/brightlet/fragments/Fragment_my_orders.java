package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyOrdersAdapter;
import com.eleganzit.brightlet.model.GetMyOrders;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_my_orders extends Fragment {


    public Fragment_my_orders() {
        // Required empty public constructor
    }
    RecyclerView my_orders;
    ArrayList<GetMyOrders> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_my_orders, container, false);

        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("My Orders");
        my_orders=v.findViewById(R.id.rc_my_orders);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        my_orders.setLayoutManager(layoutManager);

        my_orders.setAdapter(new MyOrdersAdapter(arrayList,getActivity()));

        return v;
    }

}
