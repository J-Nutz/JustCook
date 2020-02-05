package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import com.jnutz.justcook.database.inventory.ItemGroup;
import com.jnutz.justcook.database.inventory.Measurement;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class IngredientsTable
{
    public static void initIngredientsTable()
    {
        try(Connection connection = database.getConnection(); DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Ingredients").execute();
    
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Ingredients")
                       .column("Id", SQLDataType.SMALLINT
                               .identity(true)) //This would be the Id of the actual 'Item' in 'Inventory'
                       .column("Name", SQLDataType.VARCHAR(32)) //TODO: Length
                       .column("Group", SQLDataType.VARCHAR(16)) //TODO: Length
                       .column("Measurement", SQLDataType.VARCHAR(8)) //TODO: Length
                       //.column("Stock_Amount", SQLDataType.SMALLINT) //Should get the actual amount using Id at view time
                       .constraints(DSL.constraint().primaryKey("Id")).execute();
    
            IngredientDAO.addIngredient(new Ingredient("Potato", ItemGroup.VEGETABLE, Measurement.LB));
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}