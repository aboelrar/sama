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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    EditText name,phone,Email,password,repassword;
    Button send;
    String fullName,emailAddress,mobile,passwordd,repasswordd;
    contactus contactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        contactus=new contactus();
       send=(Button)findViewById(R.id.send);
       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setData();

           }
       });

    }

    public void elements()
    {
        name=(EditText)findViewById(R.id.fullname);
        Email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.mobile);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repasswprd);

        fullName=name.getText().toString();
        emailAddress = Email.getText().toString();
        mobile=phone.getText().toString();
        passwordd=password.getText().toString();
        repasswordd=repassword.getText().toString();
    }

    public void setData() {
        elements();
        String url ="http://coderg.org/samawebservice/User/registration/samaapi/123456/"+getLanguage()+"/register/"+fullName+"/"+mobile+"/"+emailAddress+"/"+passwordd+"/"+repasswordd;
        StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(response);
                    if(jsonObject.getString("status").equals("1")) {
                        Toast.makeText(signup.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        final ProgressDialog pd = new ProgressDialog(signup.this);
                        pd.setMessage("Loading...");
                        pd.show();
                    }
                    else  if(jsonObject.getString("status").equals("2")) {
                        Toast.makeText(signup.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(signup.this, "Cant send ", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", fullName);
                params.put("email", emailAddress);
                params.put("mobile", mobile);
                params.put("password", passwordd);
                params.put("repassword", repasswordd);

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
