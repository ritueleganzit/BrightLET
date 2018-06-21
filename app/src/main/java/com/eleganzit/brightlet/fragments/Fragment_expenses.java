package com.eleganzit.brightlet.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eleganzit.brightlet.AddExpenseActivity;
import com.eleganzit.brightlet.AddRentActivity;
import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.ExpensesAdapter;
import com.eleganzit.brightlet.model.GetExpenses;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_expenses extends Fragment {


    public Fragment_expenses() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }
    RecyclerView expenses;
    ArrayList<GetExpenses> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("Expenses");
        View v=inflater.inflate(R.layout.fragment_expenses, container, false);

        expenses=v.findViewById(R.id.rc_expenses);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        expenses.setLayoutManager(layoutManager);

        expenses.setAdapter(new ExpensesAdapter(arrayList,getContext()));

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
            startActivity(new Intent(getActivity(), AddExpenseActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
