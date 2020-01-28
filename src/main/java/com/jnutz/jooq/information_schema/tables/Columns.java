/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.information_schema.tables;


import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import src.main.java.com.jnutz.jooq.information_schema.InformationSchema;
import src.main.java.com.jnutz.jooq.information_schema.tables.records.ColumnsRecord;


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
public class Columns extends TableImpl<ColumnsRecord> {

    private static final long serialVersionUID = -845289590;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.COLUMNS</code>
     */
    public static final Columns COLUMNS = new Columns();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ColumnsRecord> getRecordType() {
        return ColumnsRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_CATALOG</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_CATALOG = createField(DSL.name("TABLE_CATALOG"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_SCHEMA = createField(DSL.name("TABLE_SCHEMA"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_NAME = createField(DSL.name("TABLE_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_NAME = createField(DSL.name("COLUMN_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.ORDINAL_POSITION</code>.
     */
    public final TableField<ColumnsRecord, Integer> ORDINAL_POSITION = createField(DSL.name("ORDINAL_POSITION"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DOMAIN_CATALOG</code>.
     */
    public final TableField<ColumnsRecord, String> DOMAIN_CATALOG = createField(DSL.name("DOMAIN_CATALOG"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DOMAIN_SCHEMA</code>.
     */
    public final TableField<ColumnsRecord, String> DOMAIN_SCHEMA = createField(DSL.name("DOMAIN_SCHEMA"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DOMAIN_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> DOMAIN_NAME = createField(DSL.name("DOMAIN_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_DEFAULT</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_DEFAULT = createField(DSL.name("COLUMN_DEFAULT"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE</code>.
     */
    public final TableField<ColumnsRecord, String> IS_NULLABLE = createField(DSL.name("IS_NULLABLE"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DATA_TYPE</code>.
     */
    public final TableField<ColumnsRecord, Integer> DATA_TYPE = createField(DSL.name("DATA_TYPE"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_MAXIMUM_LENGTH</code>.
     */
    public final TableField<ColumnsRecord, Integer> CHARACTER_MAXIMUM_LENGTH = createField(DSL.name("CHARACTER_MAXIMUM_LENGTH"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_OCTET_LENGTH</code>.
     */
    public final TableField<ColumnsRecord, Integer> CHARACTER_OCTET_LENGTH = createField(DSL.name("CHARACTER_OCTET_LENGTH"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_PRECISION = createField(DSL.name("NUMERIC_PRECISION"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION_RADIX</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_PRECISION_RADIX = createField(DSL.name("NUMERIC_PRECISION_RADIX"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_SCALE</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_SCALE = createField(DSL.name("NUMERIC_SCALE"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DATETIME_PRECISION</code>.
     */
    public final TableField<ColumnsRecord, Integer> DATETIME_PRECISION = createField(DSL.name("DATETIME_PRECISION"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.INTERVAL_TYPE</code>.
     */
    public final TableField<ColumnsRecord, String> INTERVAL_TYPE = createField(DSL.name("INTERVAL_TYPE"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.INTERVAL_PRECISION</code>.
     */
    public final TableField<ColumnsRecord, Integer> INTERVAL_PRECISION = createField(DSL.name("INTERVAL_PRECISION"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_SET_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> CHARACTER_SET_NAME = createField(DSL.name("CHARACTER_SET_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLLATION_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> COLLATION_NAME = createField(DSL.name("COLLATION_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TYPE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> TYPE_NAME = createField(DSL.name("TYPE_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NULLABLE</code>.
     */
    public final TableField<ColumnsRecord, Integer> NULLABLE = createField(DSL.name("NULLABLE"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.IS_COMPUTED</code>.
     */
    public final TableField<ColumnsRecord, Boolean> IS_COMPUTED = createField(DSL.name("IS_COMPUTED"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SELECTIVITY</code>.
     */
    public final TableField<ColumnsRecord, Integer> SELECTIVITY = createField(DSL.name("SELECTIVITY"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHECK_CONSTRAINT</code>.
     */
    public final TableField<ColumnsRecord, String> CHECK_CONSTRAINT = createField(DSL.name("CHECK_CONSTRAINT"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SEQUENCE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> SEQUENCE_NAME = createField(DSL.name("SEQUENCE_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.REMARKS</code>.
     */
    public final TableField<ColumnsRecord, String> REMARKS = createField(DSL.name("REMARKS"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SOURCE_DATA_TYPE</code>.
     */
    public final TableField<ColumnsRecord, Short> SOURCE_DATA_TYPE = createField(DSL.name("SOURCE_DATA_TYPE"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_TYPE</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_TYPE = createField(DSL.name("COLUMN_TYPE"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_ON_UPDATE</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_ON_UPDATE = createField(DSL.name("COLUMN_ON_UPDATE"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.IS_VISIBLE</code>.
     */
    public final TableField<ColumnsRecord, String> IS_VISIBLE = createField(DSL.name("IS_VISIBLE"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns() {
        this(DSL.name("COLUMNS"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns(String alias) {
        this(DSL.name(alias), COLUMNS);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns(Name alias) {
        this(alias, COLUMNS);
    }

    private Columns(Name alias, Table<ColumnsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Columns(Name alias, Table<ColumnsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Columns(Table<O> child, ForeignKey<O, ColumnsRecord> key) {
        super(child, key, COLUMNS);
    }

    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    @Override
    public Columns as(String alias) {
        return new Columns(DSL.name(alias), this);
    }

    @Override
    public Columns as(Name alias) {
        return new Columns(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Columns rename(String name) {
        return new Columns(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Columns rename(Name name) {
        return new Columns(name, null);
    }
}
