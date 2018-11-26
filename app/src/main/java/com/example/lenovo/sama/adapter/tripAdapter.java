package com.example.lenovo.sama.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.sama.R;
import com.example.lenovo.sama.reservationform;
import com.example.lenovo.sama.list.tripsitem;

import java.util.ArrayList;

public class tripAdapter extends RecyclerView.Adapter<tripAdapter.tripHolder> {
    Context context;
    ArrayList<tripsitem>mylist;

    public tripAdapter(Context context, ArrayList<tripsitem> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public tripHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.tripitem,viewGroup,false);
        tripHolder tripHolder=new tripHolder(view);
        return tripHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull tripHolder viewHolder, int i) {
        viewHolder.countryName.setText(mylist.get(i).getCountryName().toString());
        viewHolder.tripCode.setText(mylist.get(i).getTripcode().toString());
        viewHolder.history.setText(mylist.get(i).getHistory().toString());
        viewHolder.price.setText(mylist.get(i).getPrice().toString());
        viewHolder.flightHours.setText(mylist.get(i).getFlightHours().toString());
        viewHolder.arrivalHours.setText(mylist.get(i).getArrivalHours().toString());
        viewHolder.flightMin.setText(mylist.get(i).getFlightMin().toString());
        viewHolder.arrivalMin.setText(mylist.get(i).getArrivalMin().toString());

        if(i%2==0){

            viewHolder.linear.setBackgroundColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.book.setBackgroundColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.book.setTextColor(ContextCompat.getColor(context,R.color.color3));


        }else{
            viewHolder.linear.setBackgroundColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.book.setBackgroundColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.book.setTextColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.countryName.setTextColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.tripCode.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.history.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.price.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.flightHours.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.arrivalHours.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.flightMin.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.arrivalMin.setTextColor(ContextCompat.getColor(context,R.color.color1));




        }
        viewHolder.book.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,reservationform.class);
        v.getContext().startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class tripHolder extends RecyclerView.ViewHolder {
        TextView countryName,tripCode,history,price,flightHours,arrivalHours,flightMin,arrivalMin;
        Button book;
        LinearLayout linear;
        public tripHolder(@NonNull View itemView) {
            super(itemView);
            countryName=(TextView)itemView.findViewById(R.id.countryName);
            tripCode=(TextView)itemView.findViewById(R.id.tripcode);
            history=(TextView)itemView.findViewById(R.id.history);
            price=(TextView)itemView.findViewById(R.id.price);
            flightHours=(TextView)itemView.findViewById(R.id.flight);
            arrivalHours=(TextView)itemView.findViewById(R.id.arrival);
            linear=(LinearLayout)itemView.findViewById(R.id.lineara);
            book=(Button)itemView.findViewById(R.id.book);
            flightMin=(TextView)itemView.findViewById(R.id.flightmin);
            arrivalMin=(TextView)itemView.findViewById(R.id.arrivalmin);
        }
    }
}
