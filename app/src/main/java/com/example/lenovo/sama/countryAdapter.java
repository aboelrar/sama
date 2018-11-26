package com.example.lenovo.sama;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class countryAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<countrylist> mylist;
    int resources;
    public countryAdapter(@NonNull Context context, int resource, @NonNull ArrayList mylist) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.mylist=mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(resource,parent,false);
        TextView language=(TextView)convertView.findViewById(R.id.language );
        language.setText(mylist.get(position).getName().toString());
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }
}


