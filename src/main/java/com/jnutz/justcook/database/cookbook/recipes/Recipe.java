package com.jnutz.justcook.database.cookbook.recipes;

import com.jnutz.justcook.database.cookbook.recipes.ingredients.Ingredient;
import com.jnutz.justcook.database.cookbook.recipes.steps.Step;

import java.util.List;

public class Recipe
{
    private short id;
    private short index;
    private String name;
    private String category;
    private short recipeIngredientsIndex;
    private short recipeStepsIndex;
    
    private List<Ingredient> ingredients;
    private List<Step> steps;
    
    public Recipe()
    {
    }
    
    public Recipe(short index, String name, String category, short recipeIngredientsIndex, short recipeStepsIndex)
    {
        this.index = index;
        this.name = name;
        this.category = category;
        this.recipeIngredientsIndex = recipeIngredientsIndex;
        this.recipeStepsIndex = recipeStepsIndex;
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public short getRecipeIngredientsIndex()
    {
        return recipeIngredientsIndex;
    }
    
    public void setRecipeIngredientsIndex(short recipeIngredientsIndex)
    {
        this.recipeIngredientsIndex = recipeIngredientsIndex;
    }
    
    public short getRecipeStepsIndex()
    {
        return recipeStepsIndex;
    }
    
    public void setRecipeStepsIndex(short recipeStepsIndex)
    {
        this.recipeStepsIndex = recipeStepsIndex;
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
        this.ingredients.add(ingredient);
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
        this.steps.add(step);
    }
}