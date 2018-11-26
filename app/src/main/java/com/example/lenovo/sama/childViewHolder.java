package com.example.lenovo.sama;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class childViewHolder extends ChildViewHolder {
    TextView title;
    LinearLayout linearLayout;

    public childViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.child);
        linearLayout=(LinearLayout)itemView.findViewById(R.id.clickon);

    }


    public void setArtistName(String name) {
        title.setText(name);
    }
}