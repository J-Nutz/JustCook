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
import src.main.java.com.jnutz.jooq.public_.tables.records.IngredientsRecord;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(value = {"http://www.jooq.org", "jOOQ version:3.12.3"}, comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Ingredients extends TableImpl<IngredientsRecord>
{
    
    private static final long serialVersionUID = -154111573;
    
    /**
     * The reference instance of <code>PUBLIC.Ingredients</code>
     */
    public static final Ingredients INGREDIENTS = new Ingredients();
    
    /**
     * The class holding records for this type
     */
    @Override
    public Class<IngredientsRecord> getRecordType()
    {
        return IngredientsRecord.class;
    }
    
    /**
     * The column <code>PUBLIC.Ingredients.Id</code>.
     */
    public final TableField<IngredientsRecord, Short> ID = createField(DSL.name("Id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");
    
    /**
     * The column <code>PUBLIC.Ingredients.Name</code>.
     */
    public final TableField<IngredientsRecord, String> NAME = createField(DSL.name("Name"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");
    
    /**
     * The column <code>PUBLIC.Ingredients.Type</code>.
     */
    public final TableField<IngredientsRecord, String> TYPE = createField(DSL.name("Type"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * The column <code>PUBLIC.Ingredients.Measurement</code>.
     */
    public final TableField<IngredientsRecord, String> MEASUREMENT = createField(DSL.name("Measurement"), org.jooq.impl.SQLDataType.VARCHAR(8), this, "");
    
    /**
     * Create a <code>PUBLIC.Ingredients</code> table reference
     */
    public Ingredients()
    {
        this(DSL.name("Ingredients"), null);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Ingredients</code> table reference
     */
    public Ingredients(String alias)
    {
        this(DSL.name(alias), INGREDIENTS);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Ingredients</code> table reference
     */
    public Ingredients(Name alias)
    {
        this(alias, INGREDIENTS);
    }
    
    private Ingredients(Name alias, Table<IngredientsRecord> aliased)
    {
        this(alias, aliased, null);
    }
    
    private Ingredients(Name alias, Table<IngredientsRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }
    
    public <O extends Record> Ingredients(Table<O> child, ForeignKey<O, IngredientsRecord> key)
    {
        super(child, key, INGREDIENTS);
    }
    
    @Override
    public Schema getSchema()
    {
        return Public.PUBLIC;
    }
    
    @Override
    public List<Index> getIndexes()
    {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_E);
    }
    
    @Override
    public Identity<IngredientsRecord, Short> getIdentity()
    {
        return Keys.IDENTITY_INGREDIENTS;
    }
    
    @Override
    public UniqueKey<IngredientsRecord> getPrimaryKey()
    {
        return Keys.CONSTRAINT_E;
    }
    
    @Override
    public List<UniqueKey<IngredientsRecord>> getKeys()
    {
        return Arrays.<UniqueKey<IngredientsRecord>>asList(Keys.CONSTRAINT_E);
    }
    
    @Override
    public Ingredients as(String alias)
    {
        return new Ingredients(DSL.name(alias), this);
    }
    
    @Override
    public Ingredients as(Name alias)
    {
        return new Ingredients(alias, this);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Ingredients rename(String name)
    {
        return new Ingredients(DSL.name(name), null);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Ingredients rename(Name name)
    {
        return new Ingredients(name, null);
    }
    
    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    
    @Override
    public Row4<Short, String, String, String> fieldsRow()
    {
        return (Row4) super.fieldsRow();
    }
}
