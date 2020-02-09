package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Recipes;

import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipesDAO
{
    private static final Recipes RECIPE = Recipes.RECIPES;
    
    public static boolean addRecipe(Recipe recipe)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPE, RECIPE.ID, RECIPE.NAME, RECIPE.RECIPE_INGREDIENTS_INDEX, RECIPE.RECIPE_STEPS_INDEX)
                           .values(recipe.getId(), recipe.getName(), recipe.getRecipeIngredientsIndex(), recipe.getRecipeStepsIndex())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static Recipe getRecipe(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipe = database.select()
                                                   .from(RECIPE)
                                                   .where(RECIPE.ID.equal(id))
                                                   .fetch();
        
            Recipe recipe = new Recipe();
        
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
    
                recipe.setId(record.get(RECIPE.ID));
                recipe.setName(record.get(RECIPE.NAME));
                recipe.setCategory(record.get(RECIPE.CATEGORY));
                recipe.setRecipeIngredientsIndex(record.get(RECIPE.RECIPE_INGREDIENTS_INDEX));
                recipe.setRecipeStepsIndex(record.get(RECIPE.RECIPE_STEPS_INDEX));
            }
            
            return recipe;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}