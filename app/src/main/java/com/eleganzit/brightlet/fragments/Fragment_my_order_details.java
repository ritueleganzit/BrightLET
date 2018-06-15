package com.eleganzit.brightlet.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.ProfileActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_my_order_details extends Fragment {


    public Fragment_my_order_details() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_my_order_details, container, false);
        setHasOptionsMenu(true);

        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("My Orders");

        tabLayout=v.findViewById(R.id.orders_tabs);
        viewPager=v.findViewById(R.id.orders);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_services(),"SERVICES");
        myTabAdapter.addFragment(new Fragment_billing(),"BILLING");
        viewPager.setAdapter(myTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.orders_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
