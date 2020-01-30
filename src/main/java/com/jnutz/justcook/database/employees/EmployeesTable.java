package com.jnutz.justcook.database.employees;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class EmployeesTable
{
    public static void initEmployeesTable()
    {
        try(Connection connection =  database.getConnection();
            DSLContext databaseDSL = H2DSL.using(connection))
        {
            //Instead of having to manually do it each time table is changed
            databaseDSL.dropTableIfExists("Employees")
                       .execute();

            //TODO: What is the overhead of calling this each time the application is launched?
            databaseDSL.createTableIfNotExists("Employees")
                       .column("UserID", SQLDataType.SMALLINT.identity(true)) //Range of -32,768 to 32,767 - TODO: UserID or just ID?
                       .column("FirstName", SQLDataType.VARCHAR(64))
                       .column("LastName", SQLDataType.VARCHAR(64))
                       .column("Age", SQLDataType.TINYINT) //Range of -128 to 127
                       .column("DateOfBirth", SQLDataType.DATE) //Range handled by type
                       .column("Email", SQLDataType.VARCHAR(254)) //Max length of valid email address
                       .constraints(DSL.constraint().primaryKey("UserID"))
                       .execute();
        }
        catch(DataAccessException | SQLException e)
        {
            e.printStackTrace();
        }
    }

}