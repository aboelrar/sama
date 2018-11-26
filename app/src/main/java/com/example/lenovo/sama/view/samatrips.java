package com.example.lenovo.sama.view;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.sama.R;
import com.example.lenovo.sama.expand;
import com.example.lenovo.sama.expandAdpter;
import com.example.lenovo.sama.favourite;
import com.example.lenovo.sama.interfaces.MVP;
import com.example.lenovo.sama.languagelist;
import com.example.lenovo.sama.library.language;
import com.example.lenovo.sama.mapactivity;
import com.example.lenovo.sama.adapter.tripAdapter;
import com.example.lenovo.sama.list.tripsitem;
import com.example.lenovo.sama.presenter.tripPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class samatrips extends AppCompatActivity implements MVP.interfaces.View{
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView trips;
    ActionBarDrawerToggle drawerToggle;
    TextView favouritee;
    android.support.v7.widget.Toolbar toolbar;
    LinearLayout linearLayout;
    DrawerLayout drawerLayout;
    ImageView search;
    Button reserve;
    TextView nearest, flight;
    RecyclerView.Adapter expandAdapter;
    RecyclerView.LayoutManager expandManager;
    RecyclerView recyclerView, recyclerView1;
    LinearLayout contactus;
    tripPresenter tripPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samatrips);

        menu();
        search = (ImageView) findViewById(R.id.search);
        search.setImageResource(0);
        navigationselect();
        getexpandableData();
        tripPresenter=new tripPresenter(this,samatrips.this);
        tripPresenter.getData();
        //getAllData();
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
                startActivity(new Intent(samatrips.this, mapactivity.class));
            }
        });
        flight = (TextView) findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(samatrips.this, samatrips.class));

            }
        });

        contactus = (LinearLayout) findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(samatrips.this, com.example.lenovo.sama.view.contactus.class));
            }
        });
        favouritee=(TextView)findViewById(R.id.favnav);
        favouritee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(samatrips.this,favourite.class));

            }
        });
    }

    public void getexpandableData() {
        RecyclerView recyclerViewexpand = (RecyclerView) findViewById(R.id.rexycle);
        ArrayList<languagelist> mylsit = new ArrayList(5);
        ArrayList<languagelist> about = new ArrayList(18);
        ArrayList<expand> mylsits = new ArrayList(1);


        mylsits.add(new expand("التصنيفات", about, R.drawable.syaha));
        about.add(new languagelist(1, "مناطق سياحيه"));
        about.add(new languagelist(2, "فنادق واجنحه فندقيه"));
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

        RecyclerView.LayoutManager layoutManagerr = new LinearLayoutManager(this);
        recyclerViewexpand.setLayoutManager(layoutManagerr);
        RecyclerView.Adapter adapterr = new expandAdpter(mylsits, samatrips.this);

        recyclerViewexpand.setAdapter(adapterr);
    }

    @Override
    public void element() {
        trips =(RecyclerView)findViewById(R.id.triplist);
        }

    @Override
    public void setviewdata(ArrayList data) {

        layoutManager = new LinearLayoutManager(samatrips.this);
        trips.setHasFixedSize(true);
        trips.setLayoutManager(layoutManager);
        adapter = new tripAdapter(samatrips.this, data);
        trips.setAdapter(adapter);
    }

public void getAllData()
{
    String tripsUrl ="http://coderg.org/samawebservice/trips/index/samaapi/123456/2";
    final ArrayList<tripsitem>arrayList=new ArrayList<tripsitem>();
    JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, tripsUrl, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {

                JSONArray trip=response.getJSONArray("trip");
                JSONArray city=response.getJSONArray("cityName");
                for(int index=0;index<trip.length();index++)
                {
                    JSONObject object=trip.getJSONObject(index);
                    JSONObject objectCity=city.getJSONObject(index);
                    arrayList.add(new tripsitem(object.getInt("id"),objectCity.getInt("id_city"),objectCity.getString("name"),object.getString("trip_number"),object.getString("tripdate"),object.getString("adultseatcost"),object.getString("departure_hour"),object.getString("departure_min"),object.getString("arrival_houre"),object.getString("arrival_min")));

                }
                Toast.makeText(samatrips.this, ""+arrayList, Toast.LENGTH_LONG).show();
                Log.d("array",""+arrayList);
                layoutManager = new LinearLayoutManager(samatrips.this);
                trips.setLayoutManager(layoutManager);
                adapter = new tripAdapter(samatrips.this, arrayList);
                trips.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(samatrips.this, "error", Toast.LENGTH_SHORT).show();
        }
    });
    RequestQueue requestQueue= Volley.newRequestQueue(samatrips.this);
    requestQueue.add(request);
}
}