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
import com.eleganzit.brightlet.adapters.TradesmenMessagesAdapter;
import com.eleganzit.brightlet.model.GetTenantsMessages;
import com.eleganzit.brightlet.model.GetTradesmenMessages;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_tradesmen extends Fragment {


    public Fragment_tradesmen() {
        // Required empty public constructor
    }
    RecyclerView tradesmen_messages;
    ArrayList<GetTradesmenMessages> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tradesmen, container, false);

        tradesmen_messages=v.findViewById(R.id.tradesmen_messages);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        tradesmen_messages.setLayoutManager(layoutManager);

        GetTradesmenMessages getTradesmenMessages=new GetTradesmenMessages(R.drawable.add_user,"zahir","402,akbar");
        GetTradesmenMessages getTradesmenMessages1=new GetTradesmenMessages(R.drawable.add_user,"ahmed","401,akbar");
        GetTradesmenMessages getTradesmenMessages2=new GetTradesmenMessages(R.drawable.add_user,"mala","403,akbar");

        arrayList.add(getTradesmenMessages);
        arrayList.add(getTradesmenMessages1);
        arrayList.add(getTradesmenMessages2);
        arrayList.add(getTradesmenMessages);
        arrayList.add(getTradesmenMessages1);
        arrayList.add(getTradesmenMessages2);
        arrayList.add(getTradesmenMessages);
        arrayList.add(getTradesmenMessages1);
        arrayList.add(getTradesmenMessages2);
        arrayList.add(getTradesmenMessages);
        arrayList.add(getTradesmenMessages1);
        arrayList.add(getTradesmenMessages2);

        tradesmen_messages.setAdapter(new TradesmenMessagesAdapter(arrayList,getContext()));

        return v;
    }

}
