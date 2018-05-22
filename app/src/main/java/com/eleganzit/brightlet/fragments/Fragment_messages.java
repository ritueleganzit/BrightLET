package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_messages extends Fragment {


    public Fragment_messages() {
        // Required empty public constructor
    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_messages, container, false);

        tabLayout=v.findViewById(R.id.messages_tabs);
        viewPager=v.findViewById(R.id.messages_view_pager);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_tenants(),"TENANTS");
        myTabAdapter.addFragment(new Fragment_tradesmen(),"TRADESMEN");
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

}
