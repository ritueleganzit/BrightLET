package com.eleganzit.brightlet.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.SelectTenantActivity;
import com.eleganzit.brightlet.adapters.MyTabAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_messages extends Fragment {


    public Fragment_messages() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_messages, container, false);
        setHasOptionsMenu(true);

        tabLayout=v.findViewById(R.id.messages_tabs);
        viewPager=v.findViewById(R.id.messages_view_pager);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_tenants_messages(),"TENANTS");
        myTabAdapter.addFragment(new Fragment_tradesmen_messages(),"TRADESMEN");
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
        inflater.inflate(R.menu.add_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.menu_search) {
            Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.menu_add) {
            getActivity().startActivity(new Intent(getActivity(),SelectTenantActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

}
