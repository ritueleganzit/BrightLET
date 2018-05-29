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

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_FinancialStatement extends Fragment {


    public Fragment_FinancialStatement() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment__financial_statement, container, false);
        setHasOptionsMenu(true);

        tabLayout=v.findViewById(R.id.financial_statement_tabs);
        viewPager=v.findViewById(R.id.financial_statement_view_pager);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_incoming(),"INCOMING");
        myTabAdapter.addFragment(new Fragment_outgoing(),"OUTGOING");
        myTabAdapter.addFragment(new Fragment_total(),"TOTAL");
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
        inflater.inflate(R.menu.statements, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}

