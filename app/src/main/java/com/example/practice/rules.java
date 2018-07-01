package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    public void RHomeClick(View view) {
        Intent intent10;
        intent10 = new Intent(rules.this, MainMenu.class);
        startActivity(intent10);
    }
}
