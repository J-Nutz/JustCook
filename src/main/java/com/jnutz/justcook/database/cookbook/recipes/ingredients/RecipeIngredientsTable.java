package com.jnutz.justcook.database.cookbook.recipes.ingredients;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class RecipeIngredientsTable
{
    public static void initRecipeIngredientsTable()
    {
        try(Connection connection = database.getConnection();
            DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Recipe_Ingredients")
                       .execute();
            
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Recipe_Ingredients")
                       .column("Id", SQLDataType.SMALLINT)
                       .column("Index", SQLDataType.SMALLINT)
                       .column("Ingredient_Id", SQLDataType.SMALLINT)
                       .column("Amount_Needed", SQLDataType.SMALLINT)
                       .constraints(DSL.constraint().primaryKey("Id"))
                       //DSL.constraint().foreignKey("Ingredient_Id").references("Ingredients"))
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}