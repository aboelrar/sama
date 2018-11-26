package com.example.lenovo.sama.library;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class language {
    public String getLanguage(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("language",MODE_PRIVATE);
       String language=sharedPreferences.getString("getLanguage","");
        return language;

    }
}
