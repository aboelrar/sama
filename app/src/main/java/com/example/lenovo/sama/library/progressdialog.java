package com.example.lenovo.sama.library;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.lenovo.sama.view.login;

public class progressdialog {

    public void progressDialog(Context context)
    {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Loading...");
        pd.show();
    }
}
