package com.example.practice;

public class normalBrain extends Brain
{
    normalBrain(String s)
    {
        super(s);
    }

    public void сhangeHeal()
    {
        energy-=10;
        health++;
    }

    public void changeDevel (boolean choice, String hemisphere)
    {
        energy-=5;
        if(choice)
        {
            if("left".equals(hemisphere))
                left_dev+=5;
            if("right".equals(hemisphere))
                right_dev+=5;
        }
        else
        {
            health--;
        }
    }
}

