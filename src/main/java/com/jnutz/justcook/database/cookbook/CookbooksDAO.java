package com.jnutz.justcook.database.cookbook;

import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Cookbooks;
import src.main.java.com.jnutz.jooq.public_.tables.records.CookbooksRecord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class CookbooksDAO
{
    private static final Cookbooks COOKBOOKS = Cookbooks.COOKBOOKS;
    
    public static boolean addCookbookEntry(Cookbook cookbook)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(COOKBOOKS, COOKBOOKS.ID, COOKBOOKS.NAME, COOKBOOKS.RECIPES_INDEX)
                           .values(cookbook.getId(), cookbook.getName(), cookbook.getRecipeIndex())
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
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
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
                cookbook.setRecipeIndex(record.get(COOKBOOKS.RECIPES_INDEX));
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
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
        
            Result<Record> fetchedRecipe = database.select()
                                                   .from(COOKBOOKS)
                                                   .where(COOKBOOKS.NAME.equal(name))
                                                   .fetch();
        
            Cookbook cookbook = new Cookbook();
        
            if(fetchedRecipe.isNotEmpty())
            {
                Record record = fetchedRecipe.get(0);
    
                cookbook.setName(record.get(COOKBOOKS.NAME));
                cookbook.setRecipeIndex(record.get(COOKBOOKS.RECIPES_INDEX));
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
    
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
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
    
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<CookbooksRecord> cookbooksRecords = database.selectFrom(COOKBOOKS)
                                                               .fetch();
    
            if(cookbooksRecords.isNotEmpty())
            {
                for(CookbooksRecord cookbooksRecord : cookbooksRecords)
                {
                    Cookbook cookbook = new Cookbook();
            
                    cookbook.setId(cookbooksRecord.getId());
                    cookbook.setName(cookbooksRecord.getName());
                    //cookbook.setCategory(cookbooksRecord.getCategory());
                    cookbook.setRecipeIndex(cookbooksRecord.getRecipesIndex());
            
                    cookbooks.add(cookbook);
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return cookbooks;
    }
}