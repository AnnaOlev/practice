package com.example.practice;

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
}
