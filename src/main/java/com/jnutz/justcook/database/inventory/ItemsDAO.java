package com.jnutz.justcook.database.inventory;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Items;

import java.sql.SQLException;

import static com.jnutz.justcook.Launcher.database;

public class ItemsDAO
{
    private static final Items ITEMS = Items.ITEMS;
    
    public static boolean addItem(Item item)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(ITEMS, ITEMS.NAME, ITEMS.GROUP, ITEMS.MEASUREMENT)
                           .values(item.getName(), item.getGroup()
                                                       .name(), item.getMeasurement()
                                                                    .name())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static Item getItem(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedIngredient = database.select()
                                                       .from(ITEMS)
                                                       .where(ITEMS.ID.equal(id))
                                                       .limit(1)
                                                       .fetch();
        
            if(fetchedIngredient.isNotEmpty())
            {
                Record record = fetchedIngredient.get(0);
            
                Item item = new Item();
                item.setId(record.get(ITEMS.ID));
                item.setName(record.get(ITEMS.NAME));
                item.setGroup(ItemGroup.valueOf(record.get(ITEMS.GROUP)));
                item.setPrice(record.get(ITEMS.PRICE));
                item.setAvailableAmount(record.get(ITEMS.AVAILABLEAMOUNT));
                item.setMeasurement(Measurement.valueOf(record.get(ITEMS.MEASUREMENT)));
            
                return item;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}