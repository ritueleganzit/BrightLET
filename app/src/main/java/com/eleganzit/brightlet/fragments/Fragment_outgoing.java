package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.FinancialBottomAdapter;
import com.eleganzit.brightlet.adapters.FinancialIncomingAdapter;
import com.eleganzit.brightlet.adapters.FinancialOutgoingAdapter;
import com.eleganzit.brightlet.model.GetFinancialBottom;
import com.eleganzit.brightlet.model.GetFinancialIncoming;
import com.eleganzit.brightlet.model.GetFinancialOutgoing;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_outgoing extends Fragment {


    public Fragment_outgoing() {
        // Required empty public constructor
    }
    RecyclerView outgoing;
    RecyclerView bottom_rc;
    ArrayList<GetFinancialOutgoing> arrayList=new ArrayList<>();
    ArrayList<GetFinancialBottom> arrayList1=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_outgoing, container, false);
        outgoing=v.findViewById(R.id.outgoing);
        bottom_rc=v.findViewById(R.id.bottom_rc);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        outgoing.setLayoutManager(layoutManager);

        outgoing.setAdapter(new FinancialOutgoingAdapter(arrayList,getContext()));
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        bottom_rc.setLayoutManager(layoutManager1);

        GetFinancialBottom getFinancialBottom=new GetFinancialBottom("Landlord Services","£38.98");
        GetFinancialBottom getFinancialBottom1=new GetFinancialBottom("Property Managment","£38.98");
        GetFinancialBottom getFinancialBottom2=new GetFinancialBottom("Cost of Rent Collection","£38.98");

        arrayList1.add(getFinancialBottom);
        arrayList1.add(getFinancialBottom1);
        arrayList1.add(getFinancialBottom2);

        bottom_rc.setAdapter(new FinancialBottomAdapter(arrayList1,getContext()));

        return v;    }

}
