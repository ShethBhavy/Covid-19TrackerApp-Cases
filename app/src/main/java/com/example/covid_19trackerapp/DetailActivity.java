package com.example.covid_19trackerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvContry, tvTotalCases, tvTodayCases, tvTotalDeaths, tvTodayDeaths, tvRecover, tvCritical, tvActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Details of " + AffectedCountries.cModelList.get(positionCountry).getContryName()  );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvContry = findViewById(R.id.countryName);
        tvTotalCases = findViewById(R.id.totalCases);
        tvTodayCases = findViewById(R.id.todayCases);
        tvTotalDeaths = findViewById(R.id.totalDeaths);
        tvTodayDeaths = findViewById(R.id.todayDeaths);
        tvActive = findViewById(R.id.activeCases);
        tvCritical = findViewById(R.id.criticalCases);
        tvRecover = findViewById(R.id.recoverdCases);

        tvContry.setText(AffectedCountries.cModelList.get(positionCountry).getContryName());
        tvTotalCases.setText(AffectedCountries.cModelList.get(positionCountry).getTotalCases());
        tvTodayCases.setText(AffectedCountries.cModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.cModelList.get(positionCountry).getTotalDeaths());
        tvTodayDeaths.setText(AffectedCountries.cModelList.get(positionCountry).getTodayDeaths());
        tvActive.setText(AffectedCountries.cModelList.get(positionCountry).getActiveCases());
        tvRecover.setText(AffectedCountries.cModelList.get(positionCountry).getRecoverdCases());
        tvCritical.setText(AffectedCountries.cModelList.get(positionCountry).getCriticalCases());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}