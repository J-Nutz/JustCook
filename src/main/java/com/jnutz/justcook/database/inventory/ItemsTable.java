package com.jnutz.justcook.database.inventory;

import com.jnutz.justcook.database.cookbook.recipes.ingredients.Ingredient;
import com.jnutz.justcook.database.cookbook.recipes.ingredients.IngredientDAO;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class ItemsTable
{
    public static void initItemsTable()
    {
        try(Connection connection = database.getConnection(); DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Items").execute();
            
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Items").column("Id", SQLDataType.SMALLINT.identity(true)).column("Name", SQLDataType.VARCHAR(32)) //TODO: Length
                       .column("Group", SQLDataType.VARCHAR(16)) //TODO: Length
                       .column("Price", SQLDataType.DECIMAL(19, 4)).column("AvailableAmount", SQLDataType.SMALLINT).column("Measurement", SQLDataType.VARCHAR(16)) //TODO: Length
                       .constraints(DSL.constraint().primaryKey("Id")).execute();
            
            IngredientDAO.addIngredient(new Ingredient("Potato", ItemGroup.VEGETABLE, Measurement.LB));
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}