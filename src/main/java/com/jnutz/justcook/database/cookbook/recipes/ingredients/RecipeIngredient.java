package com.jnutz.justcook.database.cookbook.recipes.ingredients;

public class RecipeIngredient
{
    private short id;
    private short index;
    private short ingredientId;
    private short amountNeeded;
    
    public RecipeIngredient()
    {
    
    }
    
    public RecipeIngredient(short index, short ingredientId, short amountNeeded)
    {
        this.index = index;
        this.ingredientId = ingredientId;
        this.amountNeeded = amountNeeded;
    }
    
    public RecipeIngredient(short id, short index, short ingredientId, short amountNeeded)
    {
        this.id = id;
        this.index = index;
        this.ingredientId = ingredientId;
        this.amountNeeded = amountNeeded;
    }
    
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
    
    public short getIngredientId()
    {
        return ingredientId;
    }
    
    public void setIngredientId(short ingredientId)
    {
        this.ingredientId = ingredientId;
    }
    
    public short getAmountNeeded()
    {
        return amountNeeded;
    }
    
    public void setAmountNeeded(short amountNeeded)
    {
        this.amountNeeded = amountNeeded;
    }
}