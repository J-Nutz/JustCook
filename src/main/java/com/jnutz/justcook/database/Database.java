package com.jnutz.justcook.database;

import com.jnutz.justcook.database.cookbook.recipes.RecipeIngredientsTable;
import com.jnutz.justcook.database.cookbook.recipes.RecipeStepsTable;
import com.jnutz.justcook.database.cookbook.recipes.RecipesTable;
import com.jnutz.justcook.database.cookbook.recipes.ingredients.IngredientsTable;
import com.jnutz.justcook.database.cookbook.recipes.steps.StepsTable;
import com.jnutz.justcook.database.employees.EmployeesTable;
import com.jnutz.justcook.database.inventory.ItemsTable;
import com.jnutz.justcook.database.users.UsersTable;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class Database
{
    private final JdbcConnectionPool connectionPool;

    public Database(String user, String password)
    {
        //Set up connection pool
        //connectionPool = JdbcConnectionPool.create("jdbc:h2:tcp:localhost/~/JustCookTest;DB_CLOSE_ON_EXIT=TRUE;", user, password);
        connectionPool = JdbcConnectionPool.create("jdbc:h2:~/JustCookTest", user, password);
        connectionPool.setMaxConnections(15); //TODO: Base this on the client using the software
        connectionPool.setLoginTimeout(15); //TODO: More testing on this
    
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
    
        //initTables();
    }

    public void initTables()
    {
        UsersTable.initUsersTable();
        EmployeesTable.initEmployeesTable();
        ItemsTable.initItemsTable();
        IngredientsTable.initIngredientsTable();
        StepsTable.initStepsTable();
        RecipeIngredientsTable.initRecipeIngredientsTable();
        RecipeStepsTable.initRecipeStepsTable();
        RecipesTable.initRecipesTable();
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

    public void closeDatabase()
    {
        connectionPool.dispose();
    }
}