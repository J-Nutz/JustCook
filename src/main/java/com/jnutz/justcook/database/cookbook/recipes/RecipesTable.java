package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipesTable
{
    public static void initRecipesTable()
    {
        try(Connection connection = database.getConnection();
            DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Recipes")
                       .execute();
            
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Recipes")
                       .column("Id", SQLDataType.SMALLINT.identity(true))
                       .column("Type", SQLDataType
                               .VARCHAR(32)) //TODO: Would make for better sorting, ex. Salads, Desserts, etc.
                       .column("Ingredients_Id", SQLDataType.SMALLINT)
                       .column("Steps_Id", SQLDataType.SMALLINT)
                       .constraints(DSL.constraint().primaryKey("Id"))
                       //DSL.constraint().foreignKey("Ingredients_Id").references("Recipe_Ingredients"),
                       //DSL.constraint().foreignKey("Steps_Id").references("Recipe_Steps"))
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}