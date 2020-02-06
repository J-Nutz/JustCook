package com.jnutz.justcook.database.cookbook.recipes;

import com.jnutz.justcook.database.cookbook.recipes.ingredients.Ingredient;
import com.jnutz.justcook.database.cookbook.recipes.steps.Step;

import java.util.ArrayList;
import java.util.List;

public class Recipe
{
    private short id;
    
    private String type;
    
    private List<Ingredient> ingredients = new ArrayList<>();
    private short recipeIngredientsId;
    
    private List<Step> steps = new ArrayList<>();
    private short recipeStepsId;
    
    public short getId()
    {
        return id;
    }
    
    public void setId(short id)
    {
        this.id = id;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }
    
    public void setIngredients(List<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }
    
    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }
    
    public List<Step> getSteps()
    {
        return steps;
    }
    
    public void setSteps(List<Step> steps)
    {
        this.steps = steps;
    }
    
    public void addStep(Step step)
    {
        steps.add(step);
    }
    
    public short getRecipeStepsId()
    {
        return recipeStepsId;
    }
    
    public void setRecipeStepsId(short recipeStepsId)
    {
        this.recipeStepsId = recipeStepsId;
    }
    
    public short getRecipeIngredientsId()
    {
        return recipeIngredientsId;
    }
    
    public void setRecipeIngredientsId(short recipeIngredientsId)
    {
        this.recipeIngredientsId = recipeIngredientsId;
    }
    
}