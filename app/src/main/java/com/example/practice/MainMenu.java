package com.example.practice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    public static Context context;
    public String novelty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        context = this;
        Intent intent = getIntent();
        novelty= intent.getStringExtra("novelty");
        if (novelty==null)
        {
            loadNovelty();
        }
        saveNovelty();
    }


    public void RuleCLick(View view) { //transition to rules
        Intent intent1;
        intent1 = new Intent(MainMenu.this, rules.class);
        startActivity(intent1);
    }

    public void ScoreClick(View view) { //transition to records
        Intent intent2;
        intent2 = new Intent (MainMenu.this, scores.class);
        intent2.putExtra("status", "continue");
        startActivity(intent2);
    }

    public void NewClick(View view) { //transition to a new game
        novelty="new";
        saveNovelty();
        Intent intent3;
        intent3 = new Intent(MainMenu.this, newgame.class);
        startActivity(intent3);

    }

    public void GameClick1(View view) { //continue the game
        loadNovelty();
        if( novelty!=null && !novelty.equals("end")) //check for the existence of the game
        {
            Intent intent4;
            intent4 = new Intent(MainMenu.this, game.class);
            intent4.putExtra("stat", "continue");
            startActivity(intent4);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Нельзя продолжить то, чего не было!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public void saveNovelty()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("nov",novelty );
        ed.commit();
    }

    public void loadNovelty()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        novelty = sPref.getString("nov", novelty);
    }
}
