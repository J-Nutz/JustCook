package com.jnutz.justcook.database.cookbook.recipes.ingredients;

public class Ingredient
{
    private short id;
    private String name;
    private IngredientType ingredientType;
    private Measurement measurement;
    private short inStockAmount;
    
    public Ingredient()
    {
    }
    
    public Ingredient(String name, IngredientType ingredientType, Measurement measurement, short inStockAmount)
    {
        this.name = name;
        this.ingredientType = ingredientType;
        this.measurement = measurement;
        this.inStockAmount = inStockAmount;
    }
    
    public Ingredient(short id, String name, IngredientType ingredientType, Measurement measurement, short inStockAmount)
    {
        this.id = id;
        this.name = name;
        this.ingredientType = ingredientType;
        this.measurement = measurement;
        this.inStockAmount = inStockAmount;
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
    
    public IngredientType getIngredientType()
    {
        return ingredientType;
    }
    
    public void setIngredientType(IngredientType ingredientType)
    {
        this.ingredientType = ingredientType;
    }
    
    public Measurement getMeasurement()
    {
        return measurement;
    }
    
    public void setMeasurement(Measurement measurement)
    {
        this.measurement = measurement;
    }
    
    public short getInStockAmount()
    {
        return inStockAmount;
    }
    
    public void setInStockAmount(short inStockAmount)
    {
        this.inStockAmount = inStockAmount;
    }
}