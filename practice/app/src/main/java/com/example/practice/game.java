package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void QuestClickLeft(View view) {
        Intent intent6;
        intent6 = new Intent (game.this, question.class);
        startActivity(intent6);
    }

    public void GoHomeClick(View view) {
        Intent intent8;
        intent8 = new Intent (game.this, MainMenu.class);
        startActivity(intent8);
    }

    public void QuestClickRight(View view) {
        Intent intent9;
        intent9 = new Intent (game.this, question.class);
        startActivity(intent9);
    }
}
