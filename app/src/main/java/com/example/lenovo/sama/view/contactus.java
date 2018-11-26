package com.example.lenovo.sama.view;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.sama.R;
import com.example.lenovo.sama.expand;
import com.example.lenovo.sama.expandAdpter;
import com.example.lenovo.sama.favourite;
import com.example.lenovo.sama.languagelist;
import com.example.lenovo.sama.mapactivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class contactus extends AppCompatActivity {
    ActionBarDrawerToggle drawerToggle;
    android.support.v7.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    public static String ContactUsurl="http://coderg.org/samawebservice/Contactus/SendMessageForm/";
    String language,fullName,emailAddress,mobile,textMsgg;
    EditText name,phone,Email,textMsg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        getexpandableData();
        navigationselect();
        menu();
        getLanguage();
        elements();
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });
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
        RecyclerView.Adapter adapterr=new expandAdpter(mylsits,contactus.this);

        recyclerViewexpand.setAdapter(adapterr);
    }

    public void navigationselect()
    {
       TextView nearest=(TextView)findViewById(R.id.nearest);
        nearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contactus.this,mapactivity.class));
            }
        });
       TextView flight=(TextView)findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contactus.this,samatrips.class));

            }
        });

        LinearLayout   contactus=(LinearLayout)findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contactus.this,contactus.class));
            }
        });
       TextView favouritee=(TextView)findViewById(R.id.favnav);
        favouritee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contactus.this,favourite.class));

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
    public String getLanguage()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
         language=sharedPreferences.getString("getLanguage","");
        return language;

    }
    public void elements()
    {
        name=(EditText)findViewById(R.id.fullname);
        Email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.mobile);
        textMsg=(EditText)findViewById(R.id.textmsg);

        fullName=name.getText().toString();
        emailAddress = Email.getText().toString();
        mobile=phone.getText().toString();
        textMsgg=textMsg.getText().toString();
    }

public void setData() {
elements();
    String url = "http://coderg.org/samawebservice/Contactus/SendMessageForm/"+"samaapi"+"/"+"123456"+"/"+getLanguage()+"/"+"addsentmessagedata"+"/"+fullName+"/"+mobile+"/"+emailAddress+"/"+textMsgg;
    StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            JSONObject jsonObject = null;

            try {
                jsonObject = new JSONObject(response);
                if(jsonObject.getString("status").equals("1")) {
                    Toast.makeText(contactus.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                }
                else  if(jsonObject.getString("status").equals("2")) {
                    Toast.makeText(contactus.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(contactus.this, "Cant send ", Toast.LENGTH_SHORT).show();
        }
    }) {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<String, String>();
            params.put("name", fullName);
            params.put("email", emailAddress);
            params.put("mobile", mobile);
            params.put("notes", textMsgg);
            return params;
        }
    };
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(request);
}



}
