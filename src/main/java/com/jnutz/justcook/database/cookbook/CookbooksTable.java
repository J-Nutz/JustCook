package com.jnutz.justcook.database.cookbook;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class CookbooksTable
{
    public static void initCookbooksTable()
    {
        try(Connection connection = database.getConnection();
            DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            //This creates problems testing due to back end handling of AccessLevels and view switching
/*            databaseDSL.dropTableIfExists("Cookbooks")
                       .execute();*/
    
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Cookbooks")
                       .column("Id", SQLDataType.SMALLINT.identity(true))
                       .column("Name", SQLDataType.VARCHAR(32))
                       .column("Recipes_Id", SQLDataType.SMALLINT)
                       .constraints(DSL.constraint().primaryKey("Id"))
                       //DSL.constraint().foreignKey("Recipes_Id").references("Recipes.Id"),
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}