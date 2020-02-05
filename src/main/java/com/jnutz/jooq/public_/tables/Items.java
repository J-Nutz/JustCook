/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.public_.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import src.main.java.com.jnutz.jooq.public_.Indexes;
import src.main.java.com.jnutz.jooq.public_.Keys;
import src.main.java.com.jnutz.jooq.public_.Public;
import src.main.java.com.jnutz.jooq.public_.tables.records.ItemsRecord;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = {"http://www.jooq.org", "jOOQ version:3.12.3"}, comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Items extends TableImpl<ItemsRecord>
{
    
    private static final long serialVersionUID = 421581410;
    
    /**
     * The reference instance of <code>PUBLIC.Items</code>
     */
    public static final Items ITEMS = new Items();
    
    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemsRecord> getRecordType()
    {
        return ItemsRecord.class;
    }
    
    /**
     * The column <code>PUBLIC.Items.Id</code>.
     */
    public final TableField<ItemsRecord, Short> ID = createField(DSL.name("Id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");
    
    /**
     * The column <code>PUBLIC.Items.Name</code>.
     */
    public final TableField<ItemsRecord, String> NAME = createField(DSL.name("Name"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");
    
    /**
     * The column <code>PUBLIC.Items.Group</code>.
     */
    public final TableField<ItemsRecord, String> GROUP = createField(DSL.name("Group"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");
    
    /**
     * The column <code>PUBLIC.Items.Price</code>.
     */
    public final TableField<ItemsRecord, BigDecimal> PRICE = createField(DSL.name("Price"), org.jooq.impl.SQLDataType.DECIMAL(19, 4), this, "");
    
    /**
     * The column <code>PUBLIC.Items.AvailableAmount</code>.
     */
    public final TableField<ItemsRecord, Short> AVAILABLEAMOUNT = createField(DSL.name("AvailableAmount"), org.jooq.impl.SQLDataType.SMALLINT, this, "");
    
    /**
     * The column <code>PUBLIC.Items.Measurement</code>.
     */
    public final TableField<ItemsRecord, String> MEASUREMENT = createField(DSL.name("Measurement"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");
    
    /**
     * Create a <code>PUBLIC.Items</code> table reference
     */
    public Items()
    {
        this(DSL.name("Items"), null);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Items</code> table reference
     */
    public Items(String alias)
    {
        this(DSL.name(alias), ITEMS);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Items</code> table reference
     */
    public Items(Name alias)
    {
        this(alias, ITEMS);
    }
    
    private Items(Name alias, Table<ItemsRecord> aliased)
    {
        this(alias, aliased, null);
    }
    
    private Items(Name alias, Table<ItemsRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }
    
    public <O extends Record> Items(Table<O> child, ForeignKey<O, ItemsRecord> key)
    {
        super(child, key, ITEMS);
    }
    
    @Override
    public Schema getSchema()
    {
        return Public.PUBLIC;
    }
    
    @Override
    public List<Index> getIndexes()
    {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_43);
    }
    
    @Override
    public Identity<ItemsRecord, Short> getIdentity()
    {
        return Keys.IDENTITY_ITEMS;
    }
    
    @Override
    public UniqueKey<ItemsRecord> getPrimaryKey()
    {
        return Keys.CONSTRAINT_43;
    }
    
    @Override
    public List<UniqueKey<ItemsRecord>> getKeys()
    {
        return Arrays.<UniqueKey<ItemsRecord>>asList(Keys.CONSTRAINT_43);
    }
    
    @Override
    public Items as(String alias)
    {
        return new Items(DSL.name(alias), this);
    }
    
    @Override
    public Items as(Name alias)
    {
        return new Items(alias, this);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Items rename(String name)
    {
        return new Items(DSL.name(name), null);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Items rename(Name name)
    {
        return new Items(name, null);
    }
    
    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    
    @Override
    public Row6<Short, String, String, BigDecimal, Short, String> fieldsRow()
    {
        return (Row6) super.fieldsRow();
    }
}
