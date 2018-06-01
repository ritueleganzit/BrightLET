package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.ImageFileManagerAdapter;
import com.eleganzit.brightlet.model.GetImageFiles;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_image_file_manager extends Fragment {


    public Fragment_image_file_manager() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    ArrayList<GetImageFiles> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_image_file_manager, container, false);

        recyclerView=v.findViewById(R.id.rc_image_file);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new ImageFileManagerAdapter(arrayList,getContext()));

        return v;
    }

}
