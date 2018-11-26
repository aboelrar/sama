package com.example.lenovo.sama;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.sama.view.samatrips;

import java.util.ArrayList;

public class favourite extends AppCompatActivity {
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
RecyclerView favList;
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        GetAllData();

    }
    public void GetAllData()
    {
        favList=(RecyclerView)findViewById(R.id.favlist);
        layoutManager=new LinearLayoutManager(favourite.this);
        favList.setLayoutManager(layoutManager);
        ArrayList<favitem>favitemArrayList=new ArrayList<favitem>();
        favitemArrayList.add(new favitem("باريس","50$","شارع شلتوت"));
        favitemArrayList.add(new favitem("باريس","50$","شارع شلتوت"));
        favitemArrayList.add(new favitem("باريس","50$","شارع شلتوت"));
        favitemArrayList.add(new favitem("باريس","50$","شارع شلتوت"));
        favitemArrayList.add(new favitem("باريس","50$","شارع شلتوت"));

        adapter=new favAdapter(favourite.this,favitemArrayList);
        favList.setAdapter(adapter);
    }
    public void getexpandableData()
    {
        RecyclerView recyclerViewexpand=(RecyclerView)findViewById(R.id.rexycle);
        ArrayList<languagelist> about=new ArrayList(20);
        ArrayList<expand>mylsits=new ArrayList(1);



        mylsits.add(new expand("التصنيفات",about,R.drawable.syaha));
        about.add(new languagelist(1,"مناطق سياحيه"));
        about.add(new languagelist(2,"فنادق واجنحه فندقيه"));
        about.add(new languagelist(3, "مطاعم"));
        about.add(new languagelist(4, "مقاهى"));
        about.add(new languagelist(5, "تاجير سيارات"));
        about.add(new languagelist(6, "عروض سياحيه"));
        about.add(new languagelist(7, "شركات سياحيه"));
        about.add(new languagelist(8, "عقارات"));
        about.add(new languagelist(9, "صرافه وبنوك"));
        about.add(new languagelist(10, "مستشفيات وصيدليات"));
        about.add(new languagelist(11, "اماكن ترفيهيه"));
        about.add(new languagelist(12, "اسواق ومولات"));
        about.add(new languagelist(13, "سوبر ماركت"));
        about.add(new languagelist(14, "درجه الحراره المتوقعه"));
        about.add(new languagelist(15, "اسعار الصرف"));
        about.add(new languagelist(16, "اتصالات وجولات"));
        about.add(new languagelist(17, "صيانه سيارات"));
        about.add(new languagelist(18, "لحوم"));


        RecyclerView.LayoutManager layoutManagerr=new LinearLayoutManager(this);
        recyclerViewexpand.setLayoutManager(layoutManagerr);
        RecyclerView.Adapter adapterr=new expandAdpter(mylsits,favourite.this);

        recyclerViewexpand.setAdapter(adapterr);
    }

    public void navigationselect()
    {
        TextView nearest=(TextView)findViewById(R.id.nearest);
        nearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(favourite.this,mapactivity.class));
            }
        });
        TextView flight=(TextView)findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(favourite.this,samatrips.class));

            }
        });

        LinearLayout contactus=(LinearLayout)findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(favourite.this, com.example.lenovo.sama.view.contactus.class));
            }
        });


        TextView editData=(TextView)findViewById(R.id.editdata);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(favourite.this,EditData.class));

            }
        });
    }
    public void menu() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setLayoutDirection(toolbar, ViewCompat.LAYOUT_DIRECTION_RTL);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        }; // Drawer Toggle Object Made
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);

                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);

                }
            }
        });
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.color1));
    }
}
