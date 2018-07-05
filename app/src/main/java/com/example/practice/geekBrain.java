package com.example.practice;

public class geekBrain extends Brain
{
    geekBrain(String s)
    {
        super(s);
    }
    public void сhangeHeal()
    {
        energy-=14;
        health++;
    }
    public void changeDevel (String choice, String hemisphere)
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
    }
    public void newGeekBrain()
    {
        left_dev=77;
        right_dev=77;
        health=3;
        energy=100;
    }
}
