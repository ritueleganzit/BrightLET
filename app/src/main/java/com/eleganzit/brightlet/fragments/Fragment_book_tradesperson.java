package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_book_tradesperson extends Fragment {


    public Fragment_book_tradesperson() {
        // Required empty public constructor
    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_book_tradesperson, container, false);
        setHasOptionsMenu(true);

        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("1 Test Lane, TL2");

        tabLayout=v.findViewById(R.id.bk_trdsmn_tabs);
        viewPager=v.findViewById(R.id.bk_trdsmn_viewpager);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_details(),"DETAILS");
        myTabAdapter.addFragment(new Fragment_images(),"IMAGES");
        myTabAdapter.addFragment(new Fragment_tradesperson(),"TRADESPERSON");
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
