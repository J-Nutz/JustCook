package com.jnutz.justcook.database.cookbook.recipes.steps;

import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class StepsTable
{
    public static void initStepsTable()
    {
        try(var connection = database.getConnection();
            var databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            //Can't do this when other tables use primary key as foreign key
            /*databaseDSL.dropTableIfExists("Steps")
                       .execute();*/
    
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Steps")
                       .column("Id", SQLDataType.SMALLINT)
                       .column("Number", SQLDataType.SMALLINT)
                       .column("Text", SQLDataType.VARCHAR(256)) //TODO: Length
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