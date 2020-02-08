package com.jnutz.justcook.database.cookbook.recipes.ingredients;

public class Ingredient
{
    private short id; //TODO: Should be itemId
    private short itemId;
    
    public Ingredient()
    {
    }
    
    public Ingredient(short itemId)
    {
        this.itemId = itemId;
    }
    
    public Ingredient(short id, short itemId)
    {
        this.id = id;
        this.itemId = itemId;
    }
    
    public short getId()
    {
        return id;
    }
    
    public void setId(short id)
    {
        this.id = id;
    }
    
    public short getItemId()
    {
        return itemId;
    }
    
    public void setItemId(short itemId)
    {
        this.itemId = itemId;
    }
}