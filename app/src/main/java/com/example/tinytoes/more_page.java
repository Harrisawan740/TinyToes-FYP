package com.example.tinytoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class more_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_page);
        getSupportActionBar().hide();
    }
    public void HomeButtonPressed(View v){

        Intent i = new Intent(more_page.this, MainMenu.class);
        startActivity(i);
    }
    public void LogoutButtonPressed(View v){

        Intent i = new Intent(more_page.this, LogIn.class);
        startActivity(i);
    }
}