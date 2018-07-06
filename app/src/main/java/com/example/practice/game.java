package com.example.practice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import static com.example.practice.MainMenu.context;

public class game extends AppCompatActivity {
    public String tip;
    public String stat="";
    public String hemisphere;
    public long newDate;
    Date date1;
    String ending;

    TextView name;
    TextView options;
    public normalBrain brain;
    public geekBrain gbrain;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Name = getIntent().getStringExtra("name");
        stat = getIntent().getStringExtra("stat");


        if (stat.equals("new"))
        {
            date1 = new Date();
            newDate=date1.getTime();
            SaveDate();
            tip= getIntent().getStringExtra("type");
            SaveType();

            if(tip.equals("normal"))
            {
                brain = new normalBrain(Name);
                brain.name = Name;
                brain.newNormBrain();
                brain.saveData();
            }
            if(tip.equals("geek"))
            {
                gbrain = new geekBrain(Name);
                gbrain.name = Name;
                gbrain.newGeekBrain();
                gbrain.saveData();
            }
        }
       if (stat.equals("continue"))
        {
            LoadType();
            if(tip.equals("normal"))
            {
                brain = new normalBrain(Name);
                brain.loadData();
                brain.Energy();
                brain.Development();
                brain.saveData();

            }
            if(tip.equals("geek"))
            {
                gbrain = new geekBrain(Name);
                gbrain.loadData();
                gbrain.Energy();
                gbrain.Development();
                gbrain.saveData();
            }

        }

        options = findViewById(R.id.options);
        String him = getIntent().getStringExtra("hemisphere");
        String answer = getIntent().getStringExtra("right");
        if(tip.equals("normal"))
        {
            brain.changeDevel(answer, him);
            brain.saveData();
            printName(brain.name);
            printDann();
            chekForEnd(brain.energy,brain.health,brain.right_dev,brain.left_dev, brain.name);
        }
        if(tip.equals("geek"))
        {
            gbrain.changeDevel(answer, him);
            gbrain.saveData();
            printName(gbrain.name);
            printDann();
            chekForEnd(gbrain.energy,gbrain.health,gbrain.right_dev,gbrain.left_dev,gbrain.name);
        }
    }

    public void QuestClickLeft(View view) {
        hemisphere = "left";
        Intent intent6;
        intent6 = new Intent (game.this, question.class);
        intent6.putExtra("hemisphere", hemisphere);
        intent6.putExtra("tip", tip);
        startActivity(intent6);
    }

    public void QuestClickRight(View view) {
        hemisphere = "right";
        Intent intent9;
        intent9 = new Intent (game.this, question.class);
        intent9.putExtra("hemisphere", hemisphere);
        intent9.putExtra("tip", tip);
        startActivity(intent9);
    }

    public void GoHomeClick(View view) {
        Intent intent8;
        intent8 = new Intent (game.this, MainMenu.class);
        startActivity(intent8);
    }

    public void QuestClickHP(View view)
    {
        if(tip.equals("normal")) {
            brain.сhangeHeal();
            brain.saveData();
            printDann();
            chekForEnd(brain.energy, brain.health, brain.right_dev, brain.left_dev, brain.name);
        }
        if(tip.equals("geek")) {
            gbrain.сhangeHeal();
            gbrain.saveData();
            printDann();
            chekForEnd(gbrain.energy, gbrain.health, gbrain.right_dev, gbrain.left_dev, gbrain.name);
        }
        Toast toast = Toast.makeText(getApplicationContext(),
                "Ты согласился обменять энергию на жизни!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void printDann()
    {

        if(tip.equals("normal")) {
            options.setText("Жизней " + brain.health + "/9" + "                      " + "БЭ " + brain.energy + "\n" + "Развитие левого полушария  " + brain.left_dev + "/100" + "\n" + "Развитие правого полушария  " + brain.right_dev + "/100");
        }
        if(tip.equals("geek")) {
            options.setText("Жизней " + gbrain.health + "/3" + "                      " + "БЭ " + gbrain.energy + "\n" + "Развитие левого полушария  " + gbrain.left_dev + "/100" + "\n" + "Развитие правого полушария  " + gbrain.right_dev + "/100");
    }
    }

    public void printName(String brainName)
    {
        name = findViewById(R.id.name);
        name.setText(brainName);
    }

    public void chekForEnd(int ener, int heal, int right, int left, String n)
    {
        if(ener <= 0 || heal <= 0||left <= 0 || right <= 0)
        {
            LoadDate();
            date1 = new Date();
            long nowDate=date1.getTime();
            if (ener <= 0 || heal <= 0)
            {
                ending = "bank";
            }
            if (left <= 0 || right <= 0)
            {
                ending = "run";
            }
            Intent intent7;
            intent7 = new Intent(game.this, ending.class);
            intent7.putExtra("ending", ending);
            intent7.putExtra("date", (nowDate-newDate)/3600000/24);
            intent7.putExtra("name",n);
            startActivity(intent7);
        }

    }

    public void SaveType()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("type",tip);
        ed.commit();
    }
    public void LoadType()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        tip = sPref.getString("type", tip);
    }
    public void SaveDate()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putLong("newDate",newDate);
        ed.commit();
    }
    public void LoadDate()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        newDate = sPref.getLong("newDate",newDate);
    }
}
