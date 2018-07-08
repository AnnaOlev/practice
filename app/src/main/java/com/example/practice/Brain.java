package com.example.practice;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.example.practice.MainMenu.context;

public abstract class Brain
{
    protected int left_dev, right_dev, health, energy; // the first two - development of hemispheres
    protected int datecons = 0; // day of last enter
    protected int energyconst = 90; // energy day bonus
    public long d1=0; // last enter time
    public long d2; // new enter time
    protected String name;
    Brain(String name)
    {
        this.name=name;
    } // constructor
    abstract public void сhangeHeal();
    abstract public void changeDevel (String choice, String hemisphere); // development changes

    public void saveData()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("left", left_dev);
        ed.putInt("right", right_dev);
        ed.putInt("health", health);
        ed.putInt("energy", energy);
        ed.putString("name", name);
        ed.putInt("datecons", datecons);
        ed.putInt("energyconst", energyconst);
        ed.putLong("d1", d1);
        ed.apply();
    }

    public void loadData()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        left_dev = sPref.getInt("left", left_dev);
        right_dev = sPref.getInt("right", right_dev);
        health = sPref.getInt("health", health);
        energy = sPref.getInt("energy", energy);
        name = sPref.getString("name", name);
        d1 = sPref.getLong("d1", d1);
        datecons = sPref.getInt("datecons", datecons);
        energyconst = sPref.getInt("energyconst", energyconst);
    }

    public void Energy(){
        Calendar c = new GregorianCalendar();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int check = day - datecons;
        if (datecons != 0 && day != datecons) {
            for (int i = 0; i < check; i++) {
                energy += energyconst;
                energyconst -= 5;
            }
        }
        datecons = day;
        saveData();
    }

    public void Development() {
        Date date = new Date();
        d2 = date.getTime();
            if (d1 != 0 && (d2 - d1) / 3600000 >= 1) {
                long kof = (50 * ((d2 - d1) / 3600000)) / (72 - ((left_dev + right_dev) / 10));
                left_dev = (int) (left_dev - kof);
                right_dev = (int) (right_dev - kof);
            }
        d1 = d2;
        saveData();
    }
}
