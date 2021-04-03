package com.example.petagramm3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class BioDesarrollador extends AppCompatActivity {
    TextView bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_desarrollador);

        Toolbar bar =  findViewById(R.id.myActionBar);
        setSupportActionBar(bar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(false);
            actionbar.setDisplayShowHomeEnabled(false);
            actionbar.setDisplayShowTitleEnabled(false);
            actionbar.setDisplayUseLogoEnabled(false);
        }

         bio = (TextView) findViewById(R.id.tvBio);
    }
}