package com.example.practice;

public class normalBrain extends Brain
{
    normalBrain(String s)
    {
        super(s);
    }
    public void newNormBrain()
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

    public void changeDevel (String choice, String hemisphere)
    {
        energy-=5;
        if ("yes".equals(choice))
        {
            if("left".equals(hemisphere))
                left_dev+=5;
            if("right".equals(hemisphere))
                right_dev+=5;
        }
        if ("no".equals(choice))
        {
            health--;
        }
    }
}

