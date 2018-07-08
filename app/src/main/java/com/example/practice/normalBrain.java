package com.example.practice;

public class normalBrain extends Brain
{
    normalBrain(String s) // constructor
    {
        super(s);
    }
    public void newNormBrain() // data for normal brain
    {
        left_dev=50;
        right_dev=50;
        health=9;
        energy=100;
    }
    public void сhangeHeal()
    {
        energy-=10;
        health++;
    }

    public void changeDevel (String choice, String hemisphere) // change development
    {

        if ("yes".equals(choice))
        {
            energy-=5;
            if("left".equals(hemisphere))
                left_dev+=5;
            if("right".equals(hemisphere))
                right_dev+=5;
        }
        if ("no".equals(choice))
        {
            energy-=5;
            health--;
        }
        saveData();
    }
}

