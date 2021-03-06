package com.jnutz.justcook.database.cookbook.recipes.steps;

import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.RecipeSteps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class RecipeStepsDAO
{
    private static final RecipeSteps RECIPE_STEPS = RecipeSteps.RECIPE_STEPS;
    
    public static boolean addRecipeStep(RecipeStep recipeStep)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPE_STEPS, RECIPE_STEPS.ID, RECIPE_STEPS.INDEX, RECIPE_STEPS.STEP_ID)
                           .values(recipeStep.getId(), recipeStep.getIndex(), recipeStep.getStepId())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static RecipeStep getRecipeStep(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipeStep = database.select()
                                                       .from(RECIPE_STEPS)
                                                       .where(RECIPE_STEPS.ID.equal(id))
                                                       .fetch();
        
            RecipeStep recipeStep = null;
        
            if(fetchedRecipeStep.isNotEmpty())
            {
                Record record = fetchedRecipeStep.get(0);
                
                recipeStep = new RecipeStep();
                
                recipeStep.setId(record.get(RECIPE_STEPS.ID));
                recipeStep.setIndex(record.get(RECIPE_STEPS.INDEX));
                recipeStep.setStepId(record.get(RECIPE_STEPS.STEP_ID));
            }
    
            return recipeStep;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Short> getRecipeStepIds(short index)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record1<Short>> fetchedRecipeSteps = database.select(RECIPE_STEPS.STEP_ID)
                                                                .from(RECIPE_STEPS)
                                                                .where(RECIPE_STEPS.INDEX.equal(index))
                                                                .fetch();
            
            if(fetchedRecipeSteps.isNotEmpty())
            {
                List<Short> recipeSteps = new ArrayList<>();
                
                for(Record1<Short> stepId : fetchedRecipeSteps)
                {
                    recipeSteps.add(stepId.value1());
                }
                
                return recipeSteps;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<RecipeStep> getRecipeSteps(short index)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipeStep = database.select()
                                                       .from(RECIPE_STEPS)
                                                       .where(RECIPE_STEPS.INDEX.equal(index))
                                                       .fetch();
        
            List<RecipeStep> recipeSteps = new ArrayList<>();
        
            if(fetchedRecipeStep.isNotEmpty())
            {
                for(Record record : fetchedRecipeStep)
                {
                    RecipeStep recipeStep = new RecipeStep();
                    
                    recipeStep.setId(record.get(RECIPE_STEPS.ID));
                    recipeStep.setIndex(record.get(RECIPE_STEPS.INDEX));
                    recipeStep.setStepId(record.get(RECIPE_STEPS.STEP_ID));
                    
                    recipeSteps.add(recipeStep);
                }
            }
            
            return recipeSteps;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}