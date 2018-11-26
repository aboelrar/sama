package com.example.lenovo.sama;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class favAdapter  extends RecyclerView.Adapter<favAdapter.favHolder> {
    Context context;
    ArrayList<favitem> mylist;

    public favAdapter(Context context, ArrayList<favitem> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public favHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.favouriteitem,viewGroup,false);
        favHolder favHolder=new favHolder(view);
        return favHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull favHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class favHolder extends RecyclerView.ViewHolder {
        TextView name,address,price;
        public favHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            address=(TextView)itemView.findViewById(R.id.address);
            price=(TextView)itemView.findViewById(R.id.price);
        }
    }

}
