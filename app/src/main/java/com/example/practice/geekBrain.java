package com.example.practice;

public class geekBrain extends Brain
{
    geekBrain(String s)
    {
        super(s);
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
