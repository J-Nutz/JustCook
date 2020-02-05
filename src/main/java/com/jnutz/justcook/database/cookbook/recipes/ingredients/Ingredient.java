package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import com.jnutz.justcook.database.inventory.ItemGroup;
import com.jnutz.justcook.database.inventory.Measurement;

public class Ingredient
{
    private short id; //TODO: Should be itemId
    private String name;
    private ItemGroup itemGroup; //TODO: Rethink this class
    private Measurement measurement;
    
    public Ingredient()
    {
    }
    
    public Ingredient(String name, ItemGroup itemGroup, Measurement measurement)
    {
        this.name = name;
        this.itemGroup = itemGroup;
        this.measurement = measurement;
    }
    
    public Ingredient(short id, String name, ItemGroup itemGroup, Measurement measurement)
    {
        this.id = id;
        this.name = name;
        this.itemGroup = itemGroup;
        this.measurement = measurement;
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
    
    public ItemGroup getItemGroup()
    {
        return itemGroup;
    }
    
    public void setItemGroup(ItemGroup itemGroup)
    {
        this.itemGroup = itemGroup;
    }
    
    public Measurement getMeasurement()
    {
        return measurement;
    }
    
    public void setMeasurement(Measurement measurement)
    {
        this.measurement = measurement;
    }
}