package com.example.tinytoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class ViewStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);
        getSupportActionBar().hide();

    }

}