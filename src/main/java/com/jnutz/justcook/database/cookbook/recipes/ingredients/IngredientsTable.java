package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class IngredientsTable
{
    public static void initIngredientsTable()
    {
        try(var connection = database.getConnection();
            var databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            /*databaseDSL.dropTableIfExists("Ingredients")
                       .execute();*/
    
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Ingredients")
                       .column("Id", SQLDataType.SMALLINT.identity(true))
                       .column("Name", SQLDataType.VARCHAR(32))
                       .column("Item_Id", SQLDataType.SMALLINT) //TODO: Length
                       .constraints(DSL.constraint()
                                       .primaryKey("Id"))
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}