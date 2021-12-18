package com.example.reto2.ui.get;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto2.FormActivity;
import com.example.reto2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getOracle extends AppCompatActivity {
    Button botonGET;
    TextView mostrarJSON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_oracle);


        botonGET = (Button) findViewById(R.id.botonGET);
        mostrarJSON = (TextView) findViewById(R.id.mostrarJSON);


        botonGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleyGET();
            }
        });
    }

    private void volleyGET() {
        String url = "https://gf91bd0a0f696c5-db202112132041.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        mostrarJSON.setText(jsonObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);


    }

}