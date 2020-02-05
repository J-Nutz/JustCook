package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import com.jnutz.justcook.database.inventory.ItemGroup;
import com.jnutz.justcook.database.inventory.Measurement;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Ingredients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

import static com.jnutz.justcook.Launcher.database;

public class IngredientDAO
{
    private static final Ingredients INGREDIENTS = Ingredients.INGREDIENTS;
    
    public static boolean addIngredient(Ingredient ingredient)
    {
        try(Connection connection = database.getConnection(); DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(INGREDIENTS, INGREDIENTS.NAME, INGREDIENTS.TYPE, INGREDIENTS.MEASUREMENT).values(ingredient.getName(), ingredient.getItemGroup().name(), ingredient.getMeasurement().name()).execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public static Ingredient getIngredient(short id)
    {
        try(Connection connection = database.getConnection(); DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedIngredient = database.select().from(INGREDIENTS).where(INGREDIENTS.ID.equal(id)).limit(1).fetch();
            
            if(fetchedIngredient.isNotEmpty())
            {
                Ingredient ingredient = new Ingredient();
                
                Record record = fetchedIngredient.get(0);
                
                ingredient.setId(record.get(INGREDIENTS.ID));
                ingredient.setName(record.get(INGREDIENTS.NAME));
                ingredient.setItemGroup(ItemGroup.valueOf(record.get(INGREDIENTS.TYPE)));
                ingredient.setMeasurement(Measurement.valueOf(record.get(INGREDIENTS.MEASUREMENT)));
                
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
            try(Connection connection = database.getConnection(); DSLContext database = H2DSL.using(connection, SQLDialect.H2))
            {
                Result<Record> fetchedIngredient = database.select().from(INGREDIENTS).where(INGREDIENTS.ID.equal(id)).limit(1).fetch();
                
                if(fetchedIngredient.isNotEmpty())
                {
                    Record record = fetchedIngredient.get(0);
    
                    ingredient.set(new Ingredient(record.get(INGREDIENTS.ID), record.get(INGREDIENTS.NAME), ItemGroup.valueOf(record.get(INGREDIENTS.TYPE)), Measurement.valueOf(record.get(INGREDIENTS.MEASUREMENT))));
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
}
