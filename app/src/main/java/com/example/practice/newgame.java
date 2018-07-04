package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newgame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);
    }

    public void GameClick2 (View view) {
        Intent intent5;
        EditText EditName = findViewById(R.id.editName);
        intent5 = new Intent (newgame.this, game.class);
        intent5.putExtra("name", EditName.getText().toString());
        intent5.putExtra("stat", "new");
        startActivity(intent5);
    }
}
