package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Ingredients;

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
            return database.insertInto(INGREDIENTS, INGREDIENTS.ID, INGREDIENTS.ITEM_ID)
                           .values(ingredient.getId(), ingredient.getItemId())
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
            Result<Record> fetchedIngredient = database.select()
                                                       .from(INGREDIENTS)
                                                       .where(INGREDIENTS.ID.equal(id))
                                                       .limit(1)
                                                       .fetch();
        
            if(fetchedIngredient.isNotEmpty())
            {
                Ingredient ingredient = new Ingredient();
            
                Record record = fetchedIngredient.get(0);
    
                ingredient.setId(record.get(INGREDIENTS.ID));
                ingredient.setItemId(record.get(INGREDIENTS.ITEM_ID));
                
                return ingredient;
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
                Result<Record> fetchedIngredient = database.select()
                                                           .from(INGREDIENTS)
                                                           .where(INGREDIENTS.ID.equal(id))
                                                           .limit(1)
                                                           .fetch();
        
                if(fetchedIngredient.isNotEmpty())
                {
                    Record record = fetchedIngredient.get(0);
    
                    ingredient.set(new Ingredient(record.get(INGREDIENTS.ID),
                                                  record.get(INGREDIENTS.ITEM_ID)));
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
                Result<Record> fetchedIngredient = database.select()
                                                           .from(INGREDIENTS)
                                                           .where(INGREDIENTS.ID.equal(id))
                                                           .limit(1)
                                                           .fetch();
                
                if(fetchedIngredient.isNotEmpty())
                {
                    Ingredient ingredient = new Ingredient();
                    
                    Record record = fetchedIngredient.get(0);
    
                    ingredient.setId(record.get(INGREDIENTS.ID));
                    ingredient.setItemId(record.get(INGREDIENTS.ITEM_ID));
                    
                    ingredients.add(ingredient);
                }
                else
                {
                    return null;
                }
            }
            
            return ingredients;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}