/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.information_schema.tables.records;


import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

import src.main.java.com.jnutz.jooq.information_schema.tables.Collations;


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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CollationsRecord extends TableRecordImpl<CollationsRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 93666301;

    /**
     * Setter for <code>INFORMATION_SCHEMA.COLLATIONS.NAME</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.COLLATIONS.NAME</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.COLLATIONS.KEY</code>.
     */
    public void setKey(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.COLLATIONS.KEY</code>.
     */
    public String getKey() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Collations.COLLATIONS.NAME;
    }

    @Override
    public Field<String> field2() {
        return Collations.COLLATIONS.KEY;
    }

    @Override
    public String component1() {
        return getName();
    }

    @Override
    public String component2() {
        return getKey();
    }

    @Override
    public String value1() {
        return getName();
    }

    @Override
    public String value2() {
        return getKey();
    }

    @Override
    public CollationsRecord value1(String value) {
        setName(value);
        return this;
    }

    @Override
    public CollationsRecord value2(String value) {
        setKey(value);
        return this;
    }

    @Override
    public CollationsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CollationsRecord
     */
    public CollationsRecord() {
        super(Collations.COLLATIONS);
    }

    /**
     * Create a detached, initialised CollationsRecord
     */
    public CollationsRecord(String name, String key) {
        super(Collations.COLLATIONS);

        set(0, name);
        set(1, key);
    }
}
