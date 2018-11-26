package com.example.lenovo.sama.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.sama.MainActivity;
import com.example.lenovo.sama.R;
import com.example.lenovo.sama.countryAdapter;
import com.example.lenovo.sama.countrylist;

import java.util.ArrayList;

public class splashScreen extends AppCompatActivity {
Spinner countries;
TextView arabic,english,turkish;
String language;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        countries=(Spinner)findViewById(R.id.country);
        GetCountryData();
        textcolor();
        language();

    }
    public void GetCountryData()
    {
        ArrayList<countrylist> countrylists =new ArrayList<countrylist>();
        countrylists.add(new countrylist(1,"القاهره"));
        countrylists.add(new countrylist(2,"باريس"));
        countrylists.add(new countrylist(3,"لندن"));
        countrylists.add(new countrylist(3,"اسطنبول"));

        countryAdapter countryAdapter=new countryAdapter(this,R.layout.countryitem,countrylists);
        countries.setAdapter(countryAdapter);
    }
    public void textcolor()
    {
        arabic=(TextView)findViewById(R.id.arabix);
        english=(TextView)findViewById(R.id.english);
        turkish=(TextView)findViewById(R.id.turkish);
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arabic.setTextColor(Color.parseColor("#ff0000"));
                english.setTextColor(Color.parseColor("#4CA7A7"));
                turkish.setTextColor(Color.parseColor("#4CA7A7"));
                language="1";
                language();
                intent();

            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                english.setTextColor(Color.parseColor("#ff0000"));
                arabic.setTextColor(Color.parseColor("#4CA7A7"));
                turkish.setTextColor(Color.parseColor("#4CA7A7"));
                language="2";
                language();
                intent();
            }
        });
        turkish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turkish.setTextColor(Color.parseColor("#ff0000"));
                arabic.setTextColor(Color.parseColor("#4CA7A7"));
                english.setTextColor(Color.parseColor("#4CA7A7"));
                language="3";
                language();
                intent();
            }
        });
    }
    public void intent()
    {
     startActivity(new Intent(splashScreen.this,samatrips.class));
    }



    public void language()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("getLanguage", language);
        editor.commit();
    }
}
