package com.example.lenovo.sama.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.sama.interfaces.MVP;
import com.example.lenovo.sama.library.language;
import com.example.lenovo.sama.list.tripsitem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class tripsModel implements MVP.interfaces.Model {
    language language=new language();
    Context context;
    public tripsModel(Context context)
    {
        this.context=context;
    }
    @Override
    public ArrayList<tripsitem> getdata() {
         final String tripsUrl ="http://coderg.org/samawebservice/trips/index/samaapi/123456/"+language.getLanguage(context);
        final ArrayList<tripsitem>tripList=new ArrayList<tripsitem>();

        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, tripsUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray trip=response.getJSONArray("trip");
                    JSONArray city=response.getJSONArray("cityName");
                    for(int index=0;index<trip.length();index++)
                    {
                        JSONObject object=trip.getJSONObject(index);
                        JSONObject objectCity=city.getJSONObject(index);

                        Toast.makeText(context, trip.toString(), Toast.LENGTH_LONG).show();
                        Log.d("sss", "onResponse: " + trip.toString());
                   //arraylist
                        tripList.add(new tripsitem(object.getInt("id"),objectCity.getInt("id_city"),objectCity.getString("name"),object.getString("trip_number"),object.getString("tripdate"),object.getString("adultseatcost"),object.getString("departure_hour"),object.getString("departure_min"),object.getString("arrival_houre"),object.getString("arrival_min")));
                    }
                    } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(request);
        Toast.makeText(context, ""+tripList, Toast.LENGTH_SHORT).show();
        return tripList;
    }
}
