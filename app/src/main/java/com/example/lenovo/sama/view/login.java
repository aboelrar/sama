package com.example.lenovo.sama.view;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.sama.R;
import com.example.lenovo.sama.library.language;
import com.example.lenovo.sama.library.progressdialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    EditText email,password;
    Button Login;
    String emailAddress,passwordd;
    language language;
    progressdialog progressdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        language=new language();
        progressdialog=new progressdialog();
        Login=(Button)findViewById(R.id.send);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });
    }

    public void element()
    {
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        emailAddress = email.getText().toString();
        passwordd=password.getText().toString();

    }

    public void setData() {
        element();
        String url ="http://coderg.org/samawebservice/Home/do_login/samaapi/123456/"+language.getLanguage(login.this)+"/login/"+emailAddress+"/"+passwordd;
        StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(response);
                    if(jsonObject.getString("status").equals("1")) {
                        Toast.makeText(login.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        progressdialog.progressDialog(login.this);

                    }
                    else  if(jsonObject.getString("status").equals("2")) {
                        Toast.makeText(login.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        email.setError("Error");


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login.this, "Cant send ", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", emailAddress);
                params.put("password", passwordd);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    public String getLanguage()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        String language=sharedPreferences.getString("getLanguage","");
        return language;

    }
}
