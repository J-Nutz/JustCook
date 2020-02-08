package com.jnutz.justcook.database.cookbook.recipes.steps;

public class RecipeStep
{
    private short id;
    private short index;
    private short stepId;
    
    public short getId()
    {
        return id;
    }
    
    public void setId(short id)
    {
        this.id = id;
    }
    
    public short getIndex()
    {
        return index;
    }
    
    public void setIndex(short index)
    {
        this.index = index;
    }
    
    public short getStepId()
    {
        return stepId;
    }
    
    public void setStepId(short stepId)
    {
        this.stepId = stepId;
    }
}