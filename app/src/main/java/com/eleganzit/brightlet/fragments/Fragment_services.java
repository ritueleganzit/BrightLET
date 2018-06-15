package com.eleganzit.brightlet.fragments;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.Service1Adapter;
import com.eleganzit.brightlet.model.GetServices;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_services extends Fragment {


    public Fragment_services() {
        // Required empty public constructor
    }
    RecyclerView services1;
    ArrayList<GetServices> arrayList=new ArrayList<>();
    private Boolean isOut = false;
    private Animation right_to_left,left_to_right;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_services, container, false);

        services1=v.findViewById(R.id.services1);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        services1.setLayoutManager(layoutManager);
        services1.setAdapter(new Service1Adapter(arrayList,getContext()));

        return v;
    }
    /*public void animate(){

        if(isOut){

            fab.startAnimation(right_to_left);
            fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#FFD03131")}));//fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f39200")));

            isOut = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(left_to_right);
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD03131")));

            isOut = true;
            Log.d("Raj","open");

        }
    }*/

}
