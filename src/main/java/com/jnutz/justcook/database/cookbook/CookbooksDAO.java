package com.jnutz.justcook.database.cookbook;

public class CookbooksDAO
{
    /*private static final com.jnutz.jooq.public_.tables.Cookbooks COOKBOOKS = Cookbooks.COOKBOOKS;
    
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
    }*/
}