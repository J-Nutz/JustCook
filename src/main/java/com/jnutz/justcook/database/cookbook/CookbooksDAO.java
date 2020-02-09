package com.jnutz.justcook.database.cookbook;

import org.jooq.*;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.records.CookbooksRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class CookbooksDAO
{
    private static final src.main.java.com.jnutz.jooq.public_.tables.Cookbooks COOKBOOKS = src.main.java.com.jnutz.jooq.public_.tables.Cookbooks.COOKBOOKS;
    
    public static boolean addCookbookEntry(com.jnutz.justcook.database.cookbook.Cookbook cookbook)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(COOKBOOKS, COOKBOOKS.ID, COOKBOOKS.NAME, COOKBOOKS.RECIPES_ID)
                           .values(cookbook.getId(), cookbook.getName(), cookbook.getRecipeId())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public static Cookbook getCookbookEntry(short id)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            
            Result<Record> fetchedRecipe = database.select()
                                                   .from(COOKBOOKS)
                                                   .where(COOKBOOKS.ID.equal(id))
                                                   .fetch();
            
            Cookbook cookbook = new Cookbook();
            
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
                
                cookbook.setId(record.get(COOKBOOKS.ID));
                cookbook.setName(record.get(COOKBOOKS.NAME));
                cookbook.setRecipeId(record.get(COOKBOOKS.RECIPES_ID));
            }
            
            return cookbook;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Cookbook getCookbookEntry(String name)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            
            Result<Record> fetchedRecipe = database.select()
                                                   .from(COOKBOOKS)
                                                   .where(COOKBOOKS.NAME.equal(name))
                                                   .fetch();
            
            Cookbook cookbook = new Cookbook();
            
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
                
                cookbook.setId(record.get(COOKBOOKS.ID));
                cookbook.setName(record.get(COOKBOOKS.NAME));
                cookbook.setRecipeId(record.get(COOKBOOKS.RECIPES_ID));
            }
    
            return cookbook;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<String> getCookbookNames()
    {
        List<String> cookbookNames = new ArrayList<>();
        
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            
            Result<Record1<String>> fetchedNames = database.selectDistinct(COOKBOOKS.NAME)
                                                           .from(COOKBOOKS)
                                                           .fetch();
            
            if(fetchedNames.isNotEmpty())
            {
                for(Record1<String> record : fetchedNames)
                {
                    System.out.println("Getting tables");
                    cookbookNames.add(record.get(COOKBOOKS.NAME));
                }
            }
            
            return cookbookNames;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return cookbookNames;
    }
    
    public static List<Cookbook> getAllCookbooks()
    {
        List<Cookbook> cookbooks = new ArrayList<>();
        
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            List<String> cookbookNames = getCookbookNames();
            
            if(!cookbookNames.isEmpty())
            {
                for(String name : cookbookNames)
                {
                    Result<CookbooksRecord> fetchedCookbookRecipes = database.selectFrom(COOKBOOKS)
                                                                             .where(COOKBOOKS.NAME.equal(name))
                                                                             .fetch();
                    
                    Cookbook cookbook = new Cookbook(name);
                    
                    for(CookbooksRecord record : fetchedCookbookRecipes)
                    {
                        cookbook.setId(record.getId());
                        cookbook.addRecipeId(record.getRecipesId());
                    }
                    
                    cookbooks.add(cookbook);
                }
                
                return cookbooks;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return cookbooks;
    }
}