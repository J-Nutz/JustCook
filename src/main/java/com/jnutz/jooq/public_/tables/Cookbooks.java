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
import src.main.java.com.jnutz.jooq.public_.tables.records.CookbooksRecord;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.3"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Cookbooks extends TableImpl<CookbooksRecord>
{
    
    private static final long serialVersionUID = 1033440655;
    
    /**
     * The reference instance of <code>PUBLIC.Cookbooks</code>
     */
    public static final Cookbooks COOKBOOKS = new Cookbooks();
    
    /**
     * The class holding records for this type
     */
    @Override
    public Class<CookbooksRecord> getRecordType()
    {
        return CookbooksRecord.class;
    }
    
    /**
     * The column <code>PUBLIC.Cookbooks.Id</code>.
     */
    public final TableField<CookbooksRecord, Short> ID = createField(DSL.name("Id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false)
                                                                                                                       .identity(true), this, "");
    
    /**
     * The column <code>PUBLIC.Cookbooks.Name</code>.
     */
    public final TableField<CookbooksRecord, String> NAME = createField(DSL.name("Name"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");
    
    /**
     * The column <code>PUBLIC.Cookbooks.Recipes_Index</code>.
     */
    public final TableField<CookbooksRecord, Short> RECIPES_INDEX = createField(DSL.name("Recipes_Index"), org.jooq.impl.SQLDataType.SMALLINT, this, "");
    
    /**
     * Create a <code>PUBLIC.Cookbooks</code> table reference
     */
    public Cookbooks()
    {
        this(DSL.name("Cookbooks"), null);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Cookbooks</code> table reference
     */
    public Cookbooks(String alias)
    {
        this(DSL.name(alias), COOKBOOKS);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Cookbooks</code> table reference
     */
    public Cookbooks(Name alias)
    {
        this(alias, COOKBOOKS);
    }
    
    private Cookbooks(Name alias, Table<CookbooksRecord> aliased)
    {
        this(alias, aliased, null);
    }
    
    private Cookbooks(Name alias, Table<CookbooksRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }
    
    public <O extends Record> Cookbooks(Table<O> child, ForeignKey<O, CookbooksRecord> key)
    {
        super(child, key, COOKBOOKS);
    }
    
    @Override
    public Schema getSchema()
    {
        return Public.PUBLIC;
    }
    
    @Override
    public List<Index> getIndexes()
    {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_84);
    }
    
    @Override
    public Identity<CookbooksRecord, Short> getIdentity()
    {
        return Keys.IDENTITY_COOKBOOKS;
    }
    
    @Override
    public UniqueKey<CookbooksRecord> getPrimaryKey()
    {
        return Keys.CONSTRAINT_84;
    }
    
    @Override
    public List<UniqueKey<CookbooksRecord>> getKeys()
    {
        return Arrays.<UniqueKey<CookbooksRecord>>asList(Keys.CONSTRAINT_84);
    }
    
    @Override
    public Cookbooks as(String alias)
    {
        return new Cookbooks(DSL.name(alias), this);
    }
    
    @Override
    public Cookbooks as(Name alias)
    {
        return new Cookbooks(alias, this);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Cookbooks rename(String name)
    {
        return new Cookbooks(DSL.name(name), null);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Cookbooks rename(Name name)
    {
        return new Cookbooks(name, null);
    }
    
    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------
    
    @Override
    public Row3<Short, String, Short> fieldsRow()
    {
        return (Row3) super.fieldsRow();
    }
}
