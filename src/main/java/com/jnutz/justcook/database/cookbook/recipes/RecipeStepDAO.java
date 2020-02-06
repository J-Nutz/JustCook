package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.RecipeSteps;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipeStepDAO
{
    private static final src.main.java.com.jnutz.jooq.public_.tables.RecipeSteps RECIPE_STEPS = RecipeSteps.RECIPE_STEPS;
    
    public static boolean addRecipeStep(Recipe recipe)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPE_STEPS, RECIPE_STEPS.ID, RECIPE_STEPS.STEP_ID)
                           .values(recipe.getId(), recipe.getRecipeStepsId())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            
            return false;
        }
    }
    
    
/*    public static List<Step> getRecipeSteps(short id)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipe = database.select()
                                                   .from(RECIPE_STEPS)
                                                   .where(RECIPE_STEPS.ID.equal(id))
                                                   .fetch();
            
            List<Step> steps =
            
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
                
                recipe.setId(record.get(RECIPE_STEPS.ID));
                recipe.setType(record.get(RECIPE_STEPS.TYPE));
            }
            
            return recipe;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
}