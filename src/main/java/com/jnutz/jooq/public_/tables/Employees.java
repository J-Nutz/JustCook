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
import src.main.java.com.jnutz.jooq.public_.tables.records.EmployeesRecord;

import javax.annotation.processing.Generated;
import java.sql.Date;
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
public class Employees extends TableImpl<EmployeesRecord>
{
    
    private static final long serialVersionUID = 1615402098;
    
    /**
     * The reference instance of <code>PUBLIC.Employees</code>
     */
    public static final Employees EMPLOYEES = new Employees();
    
    /**
     * The class holding records for this type
     */
    @Override
    public Class<EmployeesRecord> getRecordType()
    {
        return EmployeesRecord.class;
    }
    
    /**
     * The column <code>PUBLIC.Employees.UserId</code>.
     */
    public final TableField<EmployeesRecord, Short> USERID = createField(DSL.name("UserId"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false)
                                                                                                                               .identity(true), this, "");
    
    /**
     * The column <code>PUBLIC.Employees.FirstName</code>.
     */
    public final TableField<EmployeesRecord, String> FIRSTNAME = createField(DSL.name("FirstName"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    
    /**
     * The column <code>PUBLIC.Employees.LastName</code>.
     */
    public final TableField<EmployeesRecord, String> LASTNAME = createField(DSL.name("LastName"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>PUBLIC.Employees.Age</code>.
     */
    public final TableField<EmployeesRecord, Byte> AGE = createField(DSL.name("Age"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>PUBLIC.Employees.DateOfBirth</code>.
     */
    public final TableField<EmployeesRecord, Date> DATEOFBIRTH = createField(DSL.name("DateOfBirth"), org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>PUBLIC.Employees.Email</code>.
     */
    public final TableField<EmployeesRecord, String> EMAIL = createField(DSL.name("Email"), org.jooq.impl.SQLDataType.VARCHAR(254), this, "");
    
    /**
     * Create a <code>PUBLIC.Employees</code> table reference
     */
    public Employees()
    {
        this(DSL.name("Employees"), null);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Employees</code> table reference
     */
    public Employees(String alias)
    {
        this(DSL.name(alias), EMPLOYEES);
    }
    
    /**
     * Create an aliased <code>PUBLIC.Employees</code> table reference
     */
    public Employees(Name alias)
    {
        this(alias, EMPLOYEES);
    }
    
    private Employees(Name alias, Table<EmployeesRecord> aliased)
    {
        this(alias, aliased, null);
    }
    
    private Employees(Name alias, Table<EmployeesRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }
    
    public <O extends Record> Employees(Table<O> child, ForeignKey<O, EmployeesRecord> key)
    {
        super(child, key, EMPLOYEES);
    }
    
    @Override
    public Schema getSchema()
    {
        return Public.PUBLIC;
    }
    
    @Override
    public List<Index> getIndexes()
    {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_1);
    }
    
    @Override
    public Identity<EmployeesRecord, Short> getIdentity()
    {
        return Keys.IDENTITY_EMPLOYEES;
    }
    
    @Override
    public UniqueKey<EmployeesRecord> getPrimaryKey()
    {
        return Keys.CONSTRAINT_1;
    }
    
    @Override
    public List<UniqueKey<EmployeesRecord>> getKeys()
    {
        return Arrays.<UniqueKey<EmployeesRecord>>asList(Keys.CONSTRAINT_1);
    }
    
    @Override
    public Employees as(String alias)
    {
        return new Employees(DSL.name(alias), this);
    }
    
    @Override
    public Employees as(Name alias)
    {
        return new Employees(alias, this);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Employees rename(String name)
    {
        return new Employees(DSL.name(name), null);
    }
    
    /**
     * Rename this table
     */
    @Override
    public Employees rename(Name name)
    {
        return new Employees(name, null);
    }
    
    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    
    @Override
    public Row6<Short, String, String, Byte, Date, String> fieldsRow()
    {
        return (Row6) super.fieldsRow();
    }
}
