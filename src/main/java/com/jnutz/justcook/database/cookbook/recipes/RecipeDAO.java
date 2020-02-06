package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipeDAO
{
    private static final src.main.java.com.jnutz.jooq.public_.tables.Recipes RECIPE = src.main.java.com.jnutz.jooq.public_.tables.Recipes.RECIPES;
    
    public static boolean addRecipe(Recipe recipe)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPE, RECIPE.ID, RECIPE.TYPE, RECIPE.INGREDIENTS_ID, RECIPE.STEPS_ID)
                           .values(recipe.getId(), recipe.getType(), recipe.getRecipeIngredientsId(),
                                   recipe.getRecipeStepsId())
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
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
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
                recipe.setType(record.get(RECIPE.TYPE));
                recipe.setRecipeIngredientsId(record.get(RECIPE.INGREDIENTS_ID));
                recipe.setRecipeStepsId(record.get(RECIPE.STEPS_ID));
                
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