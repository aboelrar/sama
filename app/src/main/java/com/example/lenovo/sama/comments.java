package com.example.lenovo.sama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class comments extends Fragment {
 RecyclerView.Adapter adapter;
 RecyclerView.LayoutManager layoutManager;
 RecyclerView recycler;

    public comments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_comments, container, false);
        recycler=(RecyclerView)view.findViewById(R.id.recycler);
        getData();
        return view;
    }
public void getData()
{
    layoutManager=new LinearLayoutManager(getActivity());
    recycler.setLayoutManager(layoutManager);
    ArrayList<commentitem>arrayList=new ArrayList<commentitem>();
    arrayList.add(new commentitem("احمد محمد","سعر ممتاز جدا"));
    arrayList.add(new commentitem("احمد ابراهيم","سعر ممتاز جدا جدا جدا والخدمه ممتازه جدا"));
    arrayList.add(new commentitem("اسلام محمد","سعر ممتاز جدا "));
    arrayList.add(new commentitem("احمد محمد","سعر ممتاز جدا"));

    adapter=new commentAdapter(getActivity(),arrayList);
    recycler.setAdapter(adapter);
}
}
