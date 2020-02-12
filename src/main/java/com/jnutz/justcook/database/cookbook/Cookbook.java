package com.jnutz.justcook.database.cookbook;

import com.jnutz.justcook.database.cookbook.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Cookbook
{
    private short id;
    private String name;
    private short recipeIndex;
    
    private List<Short> recipeIndices = new ArrayList<>();
    
    private List<Recipe> recipes = new ArrayList<>();
    
    public Cookbook()
    {
    
    }
    
    public Cookbook(String name)
    {
        this.name = name;
    }
    
    public Cookbook(short id, String name, short recipeIndex)
    {
        this.id = id;
        this.name = name;
        this.recipeIndex = recipeIndex;
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
    
    public Short getRecipeIndex()
    {
        return recipeIndex;
    }
    
    public void setRecipeIndex(Short recipeIndex)
    {
        this.recipeIndex = recipeIndex;
    }
    
    public List<Short> getRecipeIndices()
    {
        return recipeIndices;
    }
    
    public void setRecipeIndices(List<Short> recipeIndices)
    {
        this.recipeIndices = recipeIndices;
    }
    
    public void addRecipeIndex(short recipeIndex)
    {
        this.recipeIndices.add(recipeIndex);
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