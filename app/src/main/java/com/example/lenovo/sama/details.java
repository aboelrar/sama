package com.example.lenovo.sama;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
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
import android.widget.TextView;

import com.example.lenovo.sama.view.samatrips;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class details extends AppCompatActivity {
    TabLayout tab;
    int count = -2;
    ViewPager viewPager;
    ImageView search;
    viewimage viewimage;
    CircleIndicator circleIndicator;
    TextView tripname, details;
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;
    LinearLayout linearLayout;
    DrawerLayout drawerLayout;
    RecyclerView.Adapter expandAdapter;
    RecyclerView.LayoutManager expandManager;
    RecyclerView recyclerView,recyclerView1;
    Button reserve;
    LinearLayout contactus;
    TextView nearest, flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tab = (TabLayout) findViewById(R.id.bottomnav);
        search = (ImageView) findViewById(R.id.search);

        navigationselect();
        search.setImageResource(0);
        tab1();
        viewPager();
        goToComments();
        menu();
        tripname();
        getexpandableData();
    }

    public void tab1() {
        tab.addTab(tab.newTab().setText("التعليقات"));
        tab.addTab(tab.newTab().setText("الخريطه"));
        tab.addTab(tab.newTab().setText("اوقات العمل"));
        tab.addTab(tab.newTab().setText("عنوان المكان"));
        tab.addTab(tab.newTab().setText("جهات الاتصال"));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    goToComments();
                } else if (position == 1) {
                    Intent intent = new Intent(details.this, mapsforitem.class);
                    startActivity(intent);
                } else if (position == 2) {
                    prices prices = new prices();
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.items, prices).commit();
                }else if(position == 3)
                {
                    address address = new address();
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.items, address).commit();
                }else if(position == 4)
                {
                    phone phone = new phone();
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.items, phone).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void viewPager() {
        String[] image = {"https://jlmod.net/upload/items/34141509075847.jpg", "http://weziwezi.com/wp-content/uploads/2017/10/%D8%A3%D9%83%D8%AB%D8%B1-%D8%A7%D9%84%D8%AF%D9%88%D9%84-%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D8%B9%D8%A7%D9%84%D9%85.jpg"
                , "https://modo3.com/thumbs/fit630x300/9855/1434966631/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9_%D9%81%D9%8A_%D8%AF%D9%88%D9%84%D8%A9_%D8%AA%D8%B1%D9%83%D9%8A%D8%A7.jpg", "https://cdn.mosoah.com/wp-content/uploads/2018/02/%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%AA%D8%A7%D9%8A%D9%84%D8%A7%D9%86%D8%AF.jpg"};
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewimage = new viewimage(details.this, image);
        viewPager.setAdapter(viewimage);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            public void run() {

                if (count++ <3){
                    viewPager.setCurrentItem(count+ 1);
                }
               else if(count-->0){
                    viewPager.setCurrentItem(count-1);

                }
                handler.postDelayed(this, 5000);

            }
        };

        // trigger first time
        handler.post(runnable);
    }

    private void goToComments() {
        comments comments = new comments();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.items, comments).commit();
    }

    public void tripname() {
        Bundle b = getIntent().getExtras();
        final String receivingdata = b.getString("tripname");
        final String receivingdetails = b.getString("tripdetails");

        tripname = (TextView) findViewById(R.id.name);
        details = (TextView) findViewById(R.id.details);
        tripname.setText(receivingdata);
        details.setText(receivingdetails);
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

    public void navigationselect() {
        nearest = (TextView) findViewById(R.id.nearest);
        nearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(details.this, mapactivity.class));
            }
        });
        flight = (TextView) findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(details.this, samatrips.class));

            }
        });

        contactus=(LinearLayout)findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(details.this, com.example.lenovo.sama.view.contactus.class));
            }
        });
        TextView favouritee=(TextView)findViewById(R.id.favnav);
        favouritee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(details.this,favourite.class));

            }
        });
    }
    public void getexpandableData()
    {
        RecyclerView recyclerViewexpand=(RecyclerView)findViewById(R.id.rexycle);
        ArrayList<languagelist> mylsit=new ArrayList(5);
        ArrayList<languagelist>about=new ArrayList(18);
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
        RecyclerView.Adapter adapterr=new expandAdpter(mylsits,details.this);

        recyclerViewexpand.setAdapter(adapterr);
    }
}