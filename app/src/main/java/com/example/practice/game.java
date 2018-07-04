package com.example.practice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class game extends AppCompatActivity {
    public String tip;
    public String stat="";
    public String hemisphere;
    public int datecons = 0;
    public int energyconst = 90;
    TextView name;
    TextView options;
    public normalBrain brain;
    String Name;
    public long d1=0;
    public long d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Name = getIntent().getStringExtra("name");
        stat = getIntent().getStringExtra("stat");
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
            SharedPreferences sPref1 = getSharedPreferences("MyPref", MODE_PRIVATE);
            d1 = sPref1.getLong("d1", d1);
            datecons = sPref1.getInt("datecons", datecons);
            energyconst = sPref1.getInt("energyconst", energyconst);
            Energy();
            Development();
        }

        options = findViewById(R.id.options);
        String him = getIntent().getStringExtra("hemisphere");
        String answer = getIntent().getStringExtra("right");
        brain.changeDevel(answer, him);
        brain.saveData();
        printName();
        printDann();
    }

    public void QuestClickLeft(View view) {
        hemisphere = "left";
        Intent intent6;
        intent6 = new Intent (game.this, question.class);
        intent6.putExtra("hemisphere", hemisphere);
        startActivity(intent6);
    }

    public void QuestClickRight(View view) {
        hemisphere = "right";
        Intent intent9;
        intent9 = new Intent (game.this, question.class);
        intent9.putExtra("hemisphere", hemisphere);
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

    private void Energy(){
        Calendar c = new GregorianCalendar();
        int day = c.get(Calendar.DAY_OF_MONTH);
        if (datecons != 0 && day != datecons){
            brain.energy+= energyconst;
            energyconst-= 5;
        }
        datecons = day;
        SharedPreferences sPref1 = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref1.edit();
        ed1.putInt("datecons", datecons);
        ed1.putInt("energyconst", energyconst);
        ed1.apply();
        brain.saveData();
    }

    private void Development(){
        Date date = new Date();
        d2 = date.getTime();
        if (d1 != 0 && (d2-d1)/3600000 >= 1){
            long kof = (50*((d2-d1)/3600000))/(72-((brain.left_dev+brain.right_dev)/10));
            brain.left_dev = (int) (brain.left_dev-kof);
            brain.right_dev = (int) (brain.right_dev-kof);
        }
        d1 = d2;
        brain.saveData();
        SharedPreferences sPref1 = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref1.edit();
        ed1.putLong("d1", d1);
        ed1.apply();
    }
}
