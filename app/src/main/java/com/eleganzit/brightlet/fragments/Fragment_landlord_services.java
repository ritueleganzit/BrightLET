package com.eleganzit.brightlet.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;

import static android.view.Window.FEATURE_NO_TITLE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_landlord_services extends Fragment {

    public Fragment_landlord_services() {
        // Required empty public constructor
    }
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_landlord_services, container, false);

        tabLayout=v.findViewById(R.id.landlord_services_tabs);
        viewPager=v.findViewById(R.id.landlord_services_view_pager);

        final Dialog dialog=new Dialog(getActivity());

        dialog.getWindow().requestFeature(FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.custom_popup);
        TextView dismiss=dialog.findViewById(R.id.dismiss);

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        
        dialog.setCancelable(false);
        dialog.show();

        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_compliance(),"COMPLIANCE");
        myTabAdapter.addFragment(new Fragment_marketing(),"MARKETING");
        myTabAdapter.addFragment(new Fragment_keys(),"KEYS");
        myTabAdapter.addFragment(new Fragment_concierge(),"CONCIERGE");
        myTabAdapter.addFragment(new Fragment_viewing(),"VIEWING");
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
