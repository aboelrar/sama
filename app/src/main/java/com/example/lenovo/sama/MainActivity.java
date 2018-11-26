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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.sama.view.samatrips;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView tasnneflist;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter expandAdapter;
    RecyclerView.LayoutManager expandManager;
    RecyclerView recyclerView,recyclerView1;
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;
    LinearLayout linearLayout;
    DrawerLayout drawerLayout;
    ImageView nav;
    TextView nearest,flight;
    Button reserve;
    LinearLayout contactus;
    TextView favouritee;
    ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading=(ProgressBar)findViewById(R.id.loading);
        loading.getIndeterminateDrawable().setColorFilter(0xFFcc0000,
                android.graphics.PorterDuff.Mode.MULTIPLY);
        toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setLayoutDirection(toolbar, ViewCompat.LAYOUT_DIRECTION_RTL);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        GetAllData();
        getexpandableData();
        navigationselect();

        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.drawer_open,R.string.drawer_close)
        {

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
    public void  GetAllData()
    {
        loading.setVisibility(View.INVISIBLE);

        tasnneflist=(RecyclerView)findViewById(R.id.tasneeflist);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        tasnneflist.setLayoutManager(layoutManager);
        ArrayList<tasneefitem>mylist=new ArrayList<tasneefitem>();
        mylist.add(new tasneefitem("معبد فيلا",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        mylist.add(new tasneefitem("قلعه قايتباى",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        mylist.add(new tasneefitem("قلعه قايتباى",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        mylist.add(new tasneefitem("قلعه قايتباى",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        mylist.add(new tasneefitem("قلعه قايتباى",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        mylist.add(new tasneefitem("قلعه قايتباى",R.drawable.dd,"يعد من اهم المعالم السياحيه فى تاريخ الشرق الاوسط لانه يعتبر اهميه استراتيجيه فى تاريخ مصر الحديثه"));
        adapter=new tasneefAdapter(MainActivity.this,mylist);
        tasnneflist.setAdapter(adapter);
    }
    public void getexpandableData()
    {
        RecyclerView recyclerViewexpand=(RecyclerView)findViewById(R.id.rexycle);
        ArrayList<languagelist>about=new ArrayList(20);
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
        RecyclerView.Adapter adapterr=new expandAdpter(mylsits,MainActivity.this);

        recyclerViewexpand.setAdapter(adapterr);
    }

public void navigationselect()
{
    nearest=(TextView)findViewById(R.id.nearest);
    nearest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,mapactivity.class));
        }
    });
    flight=(TextView)findViewById(R.id.flight);
    flight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,samatrips.class));

        }
    });

    contactus=(LinearLayout)findViewById(R.id.contactus);
    contactus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, com.example.lenovo.sama.view.contactus.class));
        }
    });
    favouritee=(TextView)findViewById(R.id.favnav);
    favouritee.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,favourite.class));

        }
    });
    TextView editData=(TextView)findViewById(R.id.editdata);
    editData.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,EditData.class));

        }
    });
}

}
