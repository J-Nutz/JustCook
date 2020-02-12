package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Recipes;
import src.main.java.com.jnutz.jooq.public_.tables.records.RecipesRecord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class RecipesDAO
{
    private static final Recipes RECIPES = Recipes.RECIPES;
    
    public static boolean addRecipe(Recipe recipe)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(RECIPES, RECIPES.INDEX, RECIPES.NAME, RECIPES.CATEGORY, RECIPES.RECIPE_INGREDIENTS_INDEX, RECIPES.RECIPE_STEPS_INDEX)
                           .values(recipe.getIndex(), recipe.getName(), recipe.getCategory(), recipe.getRecipeIngredientsIndex(), recipe.getRecipeStepsIndex())
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
                                                   .from(RECIPES)
                                                   .where(RECIPES.ID.equal(id))
                                                   .fetch();
        
            Recipe recipe = new Recipe();
        
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
    
                recipe.setId(record.get(RECIPES.ID));
                recipe.setIndex(record.get(RECIPES.INDEX));
                recipe.setName(record.get(RECIPES.NAME));
                recipe.setCategory(record.get(RECIPES.CATEGORY));
                recipe.setRecipeIngredientsIndex(record.get(RECIPES.RECIPE_INGREDIENTS_INDEX));
                recipe.setRecipeStepsIndex(record.get(RECIPES.RECIPE_STEPS_INDEX));
            }
    
            return recipe;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Recipe> getRecipes(short index)
    {
        List<Recipe> recipes = new ArrayList<>();
        
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<RecipesRecord> fetchedRecipes = database.selectFrom(RECIPES)
                                                           .where(RECIPES.INDEX.equal(index))
                                                           .fetch();
            
            if(fetchedRecipes.isNotEmpty())
            {
                for(RecipesRecord recipesRecord : fetchedRecipes)
                {
                    Recipe recipe = new Recipe();
                    
                    recipe.setId(recipesRecord.getId());
                    recipe.setIndex(recipesRecord.getIndex());
                    recipe.setName(recipesRecord.getName());
                    recipe.setCategory(recipesRecord.getCategory());
                    recipe.setRecipeIngredientsIndex(recipesRecord.getRecipeIngredientsIndex());
                    recipe.setRecipeStepsIndex(recipesRecord.getRecipeStepsIndex());
                    
                    recipes.add(recipe);
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return recipes;
    }
    
    public static int getRecipeCount(short index)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.fetchCount(RECIPES, RECIPES.INDEX.equal(index));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}