package com.jnutz.justcook.database.cookbook.recipes;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipeStepsTable
{
    public static void initRecipeStepsTable()
    {
        try(Connection connection = database.getConnection();
            DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Recipe_Steps")
                       .execute();
            
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Recipe_Steps")
                       .column("Id", SQLDataType.SMALLINT)
                       .column("Step_Id", SQLDataType.SMALLINT)
                       .constraints(DSL.constraint().primaryKey("Id"))
                       //DSL.constraint().foreignKey("Step_Id").references("Steps"))
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}