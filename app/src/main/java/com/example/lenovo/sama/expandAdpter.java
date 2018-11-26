package com.example.lenovo.sama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class expandAdpter extends ExpandableRecyclerViewAdapter<parentViewHolder,childViewHolder> {

    ArrayList<expand>mylist;
    Context context;
    public expandAdpter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context=context;
    }

    @Override
    public parentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.expanditem,parent,false);
        return new parentViewHolder(view);
    }

    @Override
    public childViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false);
        return new childViewHolder(view);    }

    @Override
    public void onBindChildViewHolder(childViewHolder holder, int flatPosition, ExpandableGroup group, final int childIndex) {
        languagelist datas=(languagelist)group.getItems().get(childIndex);
        holder.setArtistName(datas.getName());
        final int id=datas.getId();
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==1)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                    context.startActivity(intent);                 }

                else if(id==2)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/"));
                    context.startActivity(intent);
                }
                else if(id==3)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/"));
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onBindGroupViewHolder(parentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreName(group.getTitle());
    }


}
