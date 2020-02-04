package com.jnutz.justcook.database.cookbook.recipes.ingredients;

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
    
    public static void addIngredient(Ingredient ingredient)
    {
        try(Connection connection = database.getConnection(); DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            //InsertValuesStep4<IngredientsRecord, String, String, String, Short> addIngredient =
            database.insertInto(INGREDIENTS, INGREDIENTS.NAME, INGREDIENTS.TYPE, INGREDIENTS.MEASUREMENT, INGREDIENTS.STOCK_AMOUNT).values(ingredient.getName(), ingredient.getIngredientType().name(), ingredient.getMeasurement().name(), ingredient.getInStockAmount()).execute();
            
            //return addIngredient.execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            
            //return false;
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
                ingredient.setIngredientType(IngredientType.valueOf(record.get(INGREDIENTS.TYPE)));
                ingredient.setMeasurement(Measurement.valueOf(record.get(INGREDIENTS.MEASUREMENT)));
                ingredient.setInStockAmount(record.get(INGREDIENTS.STOCK_AMOUNT));
                
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
                    ingredient.set(new Ingredient());
                    
                    Record record = fetchedIngredient.get(0);
                    
                    ingredient.get().setId(record.get(INGREDIENTS.ID));
                    ingredient.get().setName(record.get(INGREDIENTS.NAME));
                    ingredient.get().setIngredientType(IngredientType.valueOf(record.get(INGREDIENTS.TYPE)));
                    ingredient.get().setMeasurement(Measurement.valueOf(record.get(INGREDIENTS.MEASUREMENT)));
                    ingredient.get().setInStockAmount(record.get(INGREDIENTS.STOCK_AMOUNT));
                }
                else
                {
                    //ingredient.set(null);
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                //ingredient.set(null);
            }
        });
        
        newThread.start();
        
        return ingredient.get();
    }
}
