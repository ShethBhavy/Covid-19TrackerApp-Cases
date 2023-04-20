package com.example.covid_19trackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView totalCase, activeCase, recoverdCase, criticalCase, todayCase, todayDeath, totalDeath, affCountry;
    ScrollView scrollView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCase = findViewById(R.id.totalCases);
        activeCase = findViewById(R.id.activeCases);
        recoverdCase = findViewById(R.id.recoverdCases);
        criticalCase = findViewById(R.id.criticalCases);
        todayCase = findViewById(R.id.todayCases);
        todayDeath = findViewById(R.id.todayDeaths);
        totalDeath = findViewById(R.id.totalDeaths);
        affCountry = findViewById(R.id.affectedCountries);

        scrollView = findViewById(R.id.scrollStatus);

        pieChart = findViewById(R.id.piechart);

        fetchData();
    }

    private void fetchData() {

        String url = "https://disease.sh/v3/covid-19/all/";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            totalCase.setText(jsonObject.getString("cases"));
                            activeCase.setText(jsonObject.getString("active"));
                            recoverdCase.setText(jsonObject.getString("recovered"));
                            criticalCase.setText(jsonObject.getString("critical"));
                            todayCase.setText(jsonObject.getString("todayCases"));
                            todayDeath.setText(jsonObject.getString("todayDeaths"));
                            totalDeath.setText(jsonObject.getString("deaths"));
                            affCountry.setText(jsonObject.getString("affectedCountries"));


                            pieChart.addPieSlice(new PieModel("Total Cases", Integer.parseInt(totalCase.getText().toString()), Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(new PieModel("Recovered Cases", Integer.parseInt(recoverdCase.getText().toString()), Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(new PieModel("Active Cases", Integer.parseInt(activeCase.getText().toString()), Color.parseColor("#29B6F6")));
                            pieChart.addPieSlice(new PieModel("Deaths", Integer.parseInt(totalDeath.getText().toString()), Color.parseColor("#EF5350")));

                            pieChart.startAnimation();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void goTrackCountry(View view) {
        startActivity(new Intent(getApplicationContext(), AffectedCountries.class));
    }

}