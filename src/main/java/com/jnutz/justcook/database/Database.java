package com.jnutz.justcook.database;

import com.jnutz.justcook.database.employees.EmployeesTable;
import com.jnutz.justcook.database.users.UsersTable;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.*;

public class Database
{
    private final JdbcConnectionPool connectionPool;

    public Database(String user, String password)
    {
        //Set up connection pool
        connectionPool = JdbcConnectionPool.create("jdbc:h2:tcp:localhost/~/JustCookTest;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO", user, password);
        connectionPool.setMaxConnections(15);
        connectionPool.setLoginTimeout(15);

        //Try to load database driver
        try
        {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Unable To Load Database Driver");
            e.printStackTrace();
        }
    }

    public void initTables()
    {
        //TODO: Initialize all tables here?
        UsersTable.initUsersTable();
        EmployeesTable.initEmployeesTable();
    }

    public Connection getConnection() throws SQLException
    {
        return connectionPool.getConnection();
    }

    public int getNumberOfActiveConnections()
    {
        return connectionPool.getActiveConnections();
    }

    public int getMaxNumberOfConnections()
    {
        return connectionPool.getMaxConnections();
    }

    // This statement type is used for any arbitrary type of SQL statement
    // It is particularly useful with inlined parameters
    public boolean runStatement(Statement statement)
    {
        return false;
    }

    // This statement type is used for any arbitrary type of SQL statement
    // It is particularly useful with indexed parameters (JDBC does not support named parameters)
    public boolean runPreparedStatement(PreparedStatement statement)
    {
        return false;
    }

    // This statement type is used for SQL statements that are "called" rather than "executed"
    // In particular, this includes calls to stored procedures
    // Callable statements can register OUT parameters
    public boolean runCallableStatement(CallableStatement statement)
    {
        return false;
    }

    public void closeDatabase()
    {
        connectionPool.dispose();
        System.out.println("Database Closed");
    }
}