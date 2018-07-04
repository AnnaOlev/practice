package com.example.practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        context = this;
    }


    public void RuleCLick(View view) {
        Intent intent1;
        intent1 = new Intent(MainMenu.this, rules.class);
        startActivity(intent1);
    }

    public void ScoreClick(View view) {
        Intent intent2;
        intent2 = new Intent (MainMenu.this, scores.class);
        startActivity(intent2);
    }

    public void NewClick(View view) {
        Intent intent3;
        intent3 = new Intent(MainMenu.this, newgame.class);
        startActivity(intent3);

    }

    public void GameClick1(View view) {
        Intent intent4;
        intent4 = new Intent (MainMenu.this, game.class);
        intent4.putExtra("stat", "prod");
        startActivity(intent4);
    }


}
