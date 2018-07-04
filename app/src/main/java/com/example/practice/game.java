package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class game extends AppCompatActivity {
    public String tip;
    public String stat="";
    public String hemisphere;
    TextView name;
    TextView options;
    public normalBrain brain;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Name = getIntent().getStringExtra("name");
        stat= getIntent().getStringExtra("stat");
        brain = new normalBrain(Name);


        if (stat.equals("new"))
        {
            brain.name=Name;
            brain.newNormBrain();
            brain.saveData();

        }
       if (stat.equals("prod"))
        {
            brain.loadData();
        }

        options = findViewById(R.id.options);
        String him = getIntent().getStringExtra("hemisphere");
        String answer= getIntent().getStringExtra("right");
        brain.changeDevel(answer, him);
        brain.saveData();
        printName();
        printDann();
    }

    public void QuestClickLeft(View view) {
        hemisphere="left";
        Intent intent6;
        intent6 = new Intent (game.this, question.class);
        intent6.putExtra("hemisphere",hemisphere);
        startActivity(intent6);
    }
    public void QuestClickRight(View view) {
        hemisphere="right";
        Intent intent9;
        intent9 = new Intent (game.this, question.class);
        intent9.putExtra("hemisphere",hemisphere);
        startActivity(intent9);
    }
    public void GoHomeClick(View view) {
        Intent intent8;
        intent8 = new Intent (game.this, MainMenu.class);
        startActivity(intent8);
    }
    public void QuestClickHP(View view)
    {
        brain.сhangeHeal();
        brain.saveData();
        printDann();
    }
    public void printDann()
    {
    options.setText("Жизней "+ brain.health +"/9"+"                      "+"БЭ "+brain.energy+"\n"+"Развитие левого полушария  "+brain.left_dev+"/100"+"\n"+"Развитие правого полушария  "+brain.right_dev+"/100");
    }
    public void printName()
    {
        name = findViewById(R.id.name);
        name.setText(brain.name);
    }
}
