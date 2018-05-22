package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.TenantsMessagesAdapter;
import com.eleganzit.brightlet.model.GetTenantsMessages;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_tenants extends Fragment {


    public Fragment_tenants() {
        // Required empty public constructor
    }
    RecyclerView tenants_messages;
    ArrayList<GetTenantsMessages> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tenants, container, false);

        tenants_messages=v.findViewById(R.id.tenants_messages);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        tenants_messages.setLayoutManager(layoutManager);

        GetTenantsMessages getTenantsMessages=new GetTenantsMessages(R.drawable.add_user,"zahir","greetings","402,akbar");
        GetTenantsMessages getTenantsMessages1=new GetTenantsMessages(R.drawable.add_user,"ahmed","greetings","401,akbar");
        GetTenantsMessages getTenantsMessages2=new GetTenantsMessages(R.drawable.add_user,"mala","greetings","403,akbar");

        arrayList.add(getTenantsMessages);
        arrayList.add(getTenantsMessages1);
        arrayList.add(getTenantsMessages2);
        arrayList.add(getTenantsMessages);
        arrayList.add(getTenantsMessages1);
        arrayList.add(getTenantsMessages2);
        arrayList.add(getTenantsMessages);
        arrayList.add(getTenantsMessages1);
        arrayList.add(getTenantsMessages2);
        arrayList.add(getTenantsMessages);
        arrayList.add(getTenantsMessages1);
        arrayList.add(getTenantsMessages2);

        tenants_messages.setAdapter(new TenantsMessagesAdapter(arrayList,getContext()));

        return v;
    }

}
