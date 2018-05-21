package com.eleganzit.brightlet.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Uv on 5/20/2018.
 */

public class MyTabAdapter extends FragmentPagerAdapter {

    ArrayList<String> titleArrayList=new ArrayList<>();
    ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

    public MyTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment,String title)
    {
        fragmentArrayList.add(fragment);
        titleArrayList.add(title);
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public CharSequence getPageTitle(int position)
    {
        return titleArrayList.get(position);
    }

}
