package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
    }

    public void HomeCLick(View view) {
        Intent intent8;
        intent8 = new Intent (ending.this, MainMenu.class);
        startActivity(intent8);
    }
}
