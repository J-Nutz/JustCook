package com.jnutz.justcook.database.cookbook.recipes.steps;

public class Step
{
    //All steps inside 1 recipe should have same Id different stepNumber?
    //So in Cookbook - addStepButton.setOnAction(() -> step.setStepId(x); step.setStepNumber(y++);
    private short id = 0;
    private short number = 0;
    private String text = "";
    
    public short getId()
    {
        return id;
    }
    
    public void setId(short id)
    {
        this.id = id;
    }
    
    public short getNumber()
    {
        return number;
    }
    
    public void setNumber(short number)
    {
        this.number = number;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
}