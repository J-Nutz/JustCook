package com.jnutz.justcook.database.users;

import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class UsersTable
{
    public static void initUsersTable()
    {
        try(var connection = database.getConnection();
            var databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Users")
                       .execute();
        
            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Users")
                       .column("Id", SQLDataType.SMALLINT
                               .identity(true)) //Range of -32,768 to 32,767 - TODO: UserID or just ID?
                       .column("Username", SQLDataType.VARCHAR(64))
                       .column("Salt", SQLDataType.BINARY) //TODO: Length
                       .column("Password", SQLDataType.BINARY) //TODO: Length
                       .column("AccessLevel", SQLDataType.VARCHAR(16)) //TODO: Length
                       .constraints(DSL.constraint().primaryKey("Id")).execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}