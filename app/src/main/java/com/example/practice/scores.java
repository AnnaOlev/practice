package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
    }

    public void OneMoreReturnCLick(View view) {
        Intent intent11;
        intent11 = new Intent (scores.this, MainMenu.class);
        startActivity(intent11);
    }
}
