package com.example.lenovo.sama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class tasneefAdapter extends RecyclerView.Adapter<tasneefAdapter.tasneefHolder> {
    Context context;
    ArrayList<tasneefitem>mylist;

    public tasneefAdapter(Context context, ArrayList<tasneefitem> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public tasneefHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.tasneefitem,viewGroup,false);
        tasneefHolder tasneefHolder=new tasneefHolder(view);
        return tasneefHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final tasneefHolder viewHolder, int i) {
       viewHolder.title.setText(mylist.get(i).getName());
       viewHolder.details.setText(mylist.get(i).getDetails());
       viewHolder.image.setImageResource(mylist.get(i).getImage());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent intent=new Intent(context,details.class);
                String passingdata = viewHolder.title.getText().toString();
                String passingdetails = viewHolder.details.getText().toString();
                b.putString("tripdetails", passingdetails);
                b.putString("tripname", passingdata);
                intent.putExtras(b);
                v.getContext().startActivity(intent);           }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class tasneefHolder extends RecyclerView.ViewHolder {
        TextView title,details;
        LinearLayout linearLayout;
        ImageView image;
        public tasneefHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.name);
            details=(TextView)itemView.findViewById(R.id.details);
            image=(ImageView)itemView.findViewById(R.id.image);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);

        }
    }
}
