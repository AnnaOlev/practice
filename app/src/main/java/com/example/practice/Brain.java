package com.example.practice;

import android.content.Context;
import android.content.SharedPreferences;
import static com.example.practice.MainMenu.context;

public abstract class Brain
{
    protected int left_dev, right_dev, health, energy;
    protected String name;
    Brain(String name)
    {
        this.name=name;
    }
    abstract public void сhangeHeal();
    abstract public void changeDevel (String choice, String hemisphere);
    public void saveData()
    {
        SharedPreferences sPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("left", left_dev);
        ed.putInt("right", right_dev);
        ed.putInt("health", health);
        ed.putInt("energy", energy);
        ed.putString("name", name);
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
    }
}
