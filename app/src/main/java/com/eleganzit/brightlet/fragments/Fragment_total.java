package com.eleganzit.brightlet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.FinancialIncomingAdapter;
import com.eleganzit.brightlet.adapters.FinancialTotalAdapter;
import com.eleganzit.brightlet.model.GetFinancialBottom;
import com.eleganzit.brightlet.model.GetFinancialIncoming;
import com.eleganzit.brightlet.model.GetTotal;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_total extends Fragment {


    public Fragment_total() {
        // Required empty public constructor
    }
    RecyclerView total;
    ArrayList<GetTotal> arrayList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_total, container, false);
        total=v.findViewById(R.id.total);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        total.setLayoutManager(layoutManager);


        GetTotal getTotal=new GetTotal("Profit from Properties","£38.98");
        GetTotal getTotal1=new GetTotal("Tax Free Personal Allowance","£38.98");
        GetTotal getTotal2=new GetTotal("Taxable Pay","£38.98");
        GetTotal getTotal3=new GetTotal("Class 2 National Insurance","£38.98");
        GetTotal getTotal4=new GetTotal("Class 4 National Insurance","£38.98");
        GetTotal getTotal5=new GetTotal("Tax Due","£38.98");

        arrayList.add(getTotal);
        arrayList.add(getTotal1);
        arrayList.add(getTotal2);
        arrayList.add(getTotal3);
        arrayList.add(getTotal4);
        arrayList.add(getTotal5);

        total.setAdapter(new FinancialTotalAdapter(arrayList,getContext()));

        return v;
    }

}
