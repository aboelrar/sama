package com.example.lenovo.sama;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.commentHolder> {
    Context context;
    ArrayList<commentitem>mylist;

    public commentAdapter(Context context, ArrayList<commentitem> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public commentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.comment,viewGroup,false);
        commentHolder commentHolder=new commentHolder(view);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull commentHolder viewHolder, int i) {
  viewHolder.name.setText(mylist.get(i).getName().toString());
  viewHolder.comment.setText(mylist.get(i).getComment().toString());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class commentHolder extends RecyclerView.ViewHolder {
        TextView name,comment;
        public commentHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            comment=(TextView)itemView.findViewById(R.id.comment);
        }
    }
}
