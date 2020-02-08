package com.jnutz.justcook.database.cookbook;

import com.jnutz.justcook.database.cookbook.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Cookbook
{
    private short id;
    private String name;
    private Short recipeId;
    
    private List<Short> recipeIds;
    
    private List<Recipe> recipes = new ArrayList<>();
    
    public Cookbook()
    {
    
    }
    
    public Cookbook(short id, String name, short recipeId)
    {
        this.id = id;
        this.name = name;
        this.recipeId = recipeId;
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
    
    public Short getRecipeId()
    {
        return recipeId;
    }
    
    public void setRecipeId(Short recipeId)
    {
        this.recipeId = recipeId;
    }
    
    public List<Short> getRecipeIds()
    {
        return recipeIds;
    }
    
    public void setRecipeIds(List<Short> recipeIds)
    {
        this.recipeIds = recipeIds;
    }
    
    public void addRecipeId(short recipeId)
    {
        this.recipeIds.add(recipeId);
    }
    
    public List<Recipe> getRecipes()
    {
        return recipes;
    }
    
    public void setRecipes(List<Recipe> recipes)
    {
        this.recipes = recipes;
    }
    
    public void addRecipe(Recipe recipe)
    {
        this.recipes.add(recipe);
    }
    
    public void getRecipe(short recipeId)
    {
        //TODO: Actually implement this
        this.recipes.get(recipeId);
    }
}