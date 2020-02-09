package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.RecipeIngredients;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class RecipeIngredientsDAO
{
    private static RecipeIngredients RECIPE_INGREDIENTS = RecipeIngredients.RECIPE_INGREDIENTS;
    
    public static boolean addRecipeIngredient(RecipeIngredient recipeIngredient)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPE_INGREDIENTS, RECIPE_INGREDIENTS.ID, RECIPE_INGREDIENTS.INDEX, RECIPE_INGREDIENTS.INGREDIENT_ID, RECIPE_INGREDIENTS.AMOUNT_NEEDED)
                           .values(recipeIngredient.getId(), recipeIngredient.getIndex(), recipeIngredient.getIngredientId(), recipeIngredient.getAmountNeeded())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static List<RecipeIngredient> getRecipeIngredients(short index)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipeIngredient = database.select()
                                                             .from(RECIPE_INGREDIENTS)
                                                             .where(RECIPE_INGREDIENTS.INDEX.equal(index))
                                                             .fetch();
        
            List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        
            if(fetchedRecipeIngredient.isNotEmpty())
            {
                for(Record record : fetchedRecipeIngredient)
                {
                    RecipeIngredient recipeIngredient = new RecipeIngredient();
                    
                    recipeIngredient.setId(record.get(RECIPE_INGREDIENTS.ID));
                    recipeIngredient.setIndex(record.get(RECIPE_INGREDIENTS.INDEX));
                    recipeIngredient.setIngredientId(record.get(RECIPE_INGREDIENTS.INGREDIENT_ID));
                    recipeIngredient.setAmountNeeded(record.get(RECIPE_INGREDIENTS.AMOUNT_NEEDED));
                    
                    recipeIngredients.add(recipeIngredient);
                }
            }
            
            return recipeIngredients;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static RecipeIngredient getRecipeIngredient(short id, short index)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedRecipeIngredient = database.select()
                                                             .from(RECIPE_INGREDIENTS)
                                                             .where(RECIPE_INGREDIENTS.ID.equal(id)
                                                                                         .and(RECIPE_INGREDIENTS.INDEX.equal(index)))
                                                             .fetch();
        
            RecipeIngredient recipeIngredient = new RecipeIngredient();
        
            if(fetchedRecipeIngredient.isNotEmpty())
            {
                Record record = fetchedRecipeIngredient.get(0);
                
                recipeIngredient.setId(record.get(RECIPE_INGREDIENTS.ID));
                recipeIngredient.setIndex(record.get(RECIPE_INGREDIENTS.INDEX));
                recipeIngredient.setIngredientId(record.get(RECIPE_INGREDIENTS.INGREDIENT_ID));
                recipeIngredient.setAmountNeeded(record.get(RECIPE_INGREDIENTS.AMOUNT_NEEDED));
            }
            
            return recipeIngredient;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}