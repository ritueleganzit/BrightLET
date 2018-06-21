package com.eleganzit.brightlet.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.eleganzit.brightlet.AddRentActivity;
import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_rent extends Fragment {


    public Fragment_rent() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        View v=inflater.inflate(R.layout.fragment_rent, container, false);



        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_rent_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.menu_rent) {
            Toast.makeText(getContext(), "Rent", Toast.LENGTH_SHORT).show();

            return true;
        }

        if (id == R.id.menu_add) {
            Toast.makeText(getContext(), "Add", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), AddRentActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
