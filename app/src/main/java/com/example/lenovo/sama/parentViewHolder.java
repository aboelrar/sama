package com.example.lenovo.sama;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class parentViewHolder extends GroupViewHolder {
    TextView title;
    ImageView expanded_menu;

    public parentViewHolder(View itemView) {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.contactuss);
        expanded_menu=(ImageView)itemView.findViewById(R.id.expanded_menu);

    }

    public void setGenreName(String name){
        title.setText(name);
    }
    public void setArtistName(int img){
        expanded_menu.setImageResource(img);
    }}