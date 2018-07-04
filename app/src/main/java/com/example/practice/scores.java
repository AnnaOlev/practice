package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scores extends AppCompatActivity {
    public String stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        stat=getIntent().getStringExtra("status");
        if (stat.equals("end")){}
        if(stat.equals("continue")){}
}

    public void OneMoreReturnCLick(View view) {
        Intent intent11;
        intent11 = new Intent (scores.this, MainMenu.class);
        intent11.putExtra("novelty",stat);
        startActivity(intent11);
    }
}
