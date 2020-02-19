package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Ingredients;
import src.main.java.com.jnutz.jooq.public_.tables.records.IngredientsRecord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.jnutz.justcook.Launcher.database;

public class IngredientsDAO
{
    private static final Ingredients INGREDIENTS = Ingredients.INGREDIENTS;
    
    public static boolean addIngredient(Ingredient ingredient)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(INGREDIENTS, INGREDIENTS.ID, INGREDIENTS.NAME, INGREDIENTS.ITEM_ID)
                           .values(ingredient.getId(), ingredient.getName(), ingredient.getItemId())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static Ingredient getIngredient(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<IngredientsRecord> fetchedIngredient = database.selectFrom(INGREDIENTS)
                                                                  .where(INGREDIENTS.ID.equal(id))
                                                                  .limit(1)
                                                                  .fetch();
    
            if(fetchedIngredient.isNotEmpty())
            {
                IngredientsRecord record = fetchedIngredient.get(0);
        
                return new Ingredient(record.getId(),
                                      record.getName(),
                                      record.getItemId());
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
    
    public static Ingredient getIngredient(short id, boolean multiThread)
    {
        AtomicReference<Ingredient> ingredient = new AtomicReference<>(null);
        
        Thread newThread = new Thread(() -> {
            try(var connection = database.getConnection();
                var database = H2DSL.using(connection, SQLDialect.H2))
            {
                Result<IngredientsRecord> fetchedIngredient = database.selectFrom(INGREDIENTS)
                                                                      .where(INGREDIENTS.ID.equal(id))
                                                                      .limit(1)
                                                                      .fetch();
    
                if(fetchedIngredient.isNotEmpty())
                {
                    IngredientsRecord record = fetchedIngredient.get(0);
        
                    ingredient.set(new Ingredient(record.getId(),
                                                  record.getName(),
                                                  record.getItemId()));
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });
    
        newThread.start();
    
        return ingredient.get();
    }
    
    public static List<Ingredient> getIngredients(short... ids)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            List<Ingredient> ingredients = new ArrayList<>();
        
            for(short id : ids)
            {
                Result<IngredientsRecord> fetchedIngredient = database.selectFrom(INGREDIENTS)
                                                                      .where(INGREDIENTS.ID.equal(id))
                                                                      .fetch();
    
                if(fetchedIngredient.isNotEmpty())
                {
                    IngredientsRecord ingredientsRecord = fetchedIngredient.get(0);
        
                    Ingredient ingredient = new Ingredient();
        
                    ingredient.setId(ingredientsRecord.getId());
                    ingredient.setName(ingredientsRecord.getName());
                    ingredient.setItemId(ingredientsRecord.getItemId());
        
                    ingredients.add(ingredient);
                }
            }
    
            return ingredients.isEmpty() ? null : ingredients;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}