package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.DocumentsAdapter;
import com.eleganzit.brightlet.adapters.ImageFileManagerAdapter;
import com.eleganzit.brightlet.model.GetImageFiles;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_documents_centre extends Fragment {


    public Fragment_documents_centre() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    ArrayList<GetImageFiles> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("Documents Centre");
        View v=inflater.inflate(R.layout.fragment_documents_centre, container, false);

        recyclerView=v.findViewById(R.id.rc_documents);

        linearLayout=v.findViewById(R.id.main);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new DocumentsAdapter(arrayList,getContext(),linearLayout));

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}