package com.jnutz.justcook.database.cookbook.recipes.ingredients;

public class Ingredient
{
    private short id;
    private String name;
    private short itemId;
    
    public Ingredient()
    {
    }
    
    public Ingredient(short itemId)
    {
        this.itemId = itemId;
    }
    
    public Ingredient(short id, String name, short itemId)
    {
        this.id = id;
        this.name = name;
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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