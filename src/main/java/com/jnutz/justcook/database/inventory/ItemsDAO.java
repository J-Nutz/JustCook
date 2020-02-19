package com.jnutz.justcook.database.inventory;

import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Items;
import src.main.java.com.jnutz.jooq.public_.tables.records.ItemsRecord;

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
            Result<ItemsRecord> fetchedIngredient = database.selectFrom(ITEMS)
                                                            .where(ITEMS.ID.equal(id))
                                                            .limit(1)
                                                            .fetch();
    
            if(fetchedIngredient.isNotEmpty())
            {
                ItemsRecord itemRecord = fetchedIngredient.get(0);
        
                return new Item(itemRecord.getId(),
                                itemRecord.getName(),
                                ItemGroup.valueOf(itemRecord.getGroup()),
                                itemRecord.getPrice(),
                                itemRecord.getAvailableamount(),
                                Measurement.valueOf(itemRecord.getMeasurement()));
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