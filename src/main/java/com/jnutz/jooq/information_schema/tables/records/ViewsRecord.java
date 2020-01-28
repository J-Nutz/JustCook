/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.information_schema.tables.records;


import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.TableRecordImpl;

import src.main.java.com.jnutz.jooq.information_schema.tables.Views;


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
public class ViewsRecord extends TableRecordImpl<ViewsRecord> implements Record9<String, String, String, String, String, String, String, String, Integer> {

    private static final long serialVersionUID = -936910882;

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_CATALOG</code>.
     */
    public String getTableCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_SCHEMA</code>.
     */
    public String getTableSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.TABLE_NAME</code>.
     */
    public String getTableName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.VIEW_DEFINITION</code>.
     */
    public void setViewDefinition(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.VIEW_DEFINITION</code>.
     */
    public String getViewDefinition() {
        return (String) get(3);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.CHECK_OPTION</code>.
     */
    public void setCheckOption(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.CHECK_OPTION</code>.
     */
    public String getCheckOption() {
        return (String) get(4);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.IS_UPDATABLE</code>.
     */
    public void setIsUpdatable(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.IS_UPDATABLE</code>.
     */
    public String getIsUpdatable() {
        return (String) get(5);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.STATUS</code>.
     */
    public void setStatus(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.STATUS</code>.
     */
    public String getStatus() {
        return (String) get(6);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.REMARKS</code>.
     */
    public void setRemarks(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.REMARKS</code>.
     */
    public String getRemarks() {
        return (String) get(7);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.VIEWS.ID</code>.
     */
    public void setId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.VIEWS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<String, String, String, String, String, String, String, String, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Views.VIEWS.TABLE_CATALOG;
    }

    @Override
    public Field<String> field2() {
        return Views.VIEWS.TABLE_SCHEMA;
    }

    @Override
    public Field<String> field3() {
        return Views.VIEWS.TABLE_NAME;
    }

    @Override
    public Field<String> field4() {
        return Views.VIEWS.VIEW_DEFINITION;
    }

    @Override
    public Field<String> field5() {
        return Views.VIEWS.CHECK_OPTION;
    }

    @Override
    public Field<String> field6() {
        return Views.VIEWS.IS_UPDATABLE;
    }

    @Override
    public Field<String> field7() {
        return Views.VIEWS.STATUS;
    }

    @Override
    public Field<String> field8() {
        return Views.VIEWS.REMARKS;
    }

    @Override
    public Field<Integer> field9() {
        return Views.VIEWS.ID;
    }

    @Override
    public String component1() {
        return getTableCatalog();
    }

    @Override
    public String component2() {
        return getTableSchema();
    }

    @Override
    public String component3() {
        return getTableName();
    }

    @Override
    public String component4() {
        return getViewDefinition();
    }

    @Override
    public String component5() {
        return getCheckOption();
    }

    @Override
    public String component6() {
        return getIsUpdatable();
    }

    @Override
    public String component7() {
        return getStatus();
    }

    @Override
    public String component8() {
        return getRemarks();
    }

    @Override
    public Integer component9() {
        return getId();
    }

    @Override
    public String value1() {
        return getTableCatalog();
    }

    @Override
    public String value2() {
        return getTableSchema();
    }

    @Override
    public String value3() {
        return getTableName();
    }

    @Override
    public String value4() {
        return getViewDefinition();
    }

    @Override
    public String value5() {
        return getCheckOption();
    }

    @Override
    public String value6() {
        return getIsUpdatable();
    }

    @Override
    public String value7() {
        return getStatus();
    }

    @Override
    public String value8() {
        return getRemarks();
    }

    @Override
    public Integer value9() {
        return getId();
    }

    @Override
    public ViewsRecord value1(String value) {
        setTableCatalog(value);
        return this;
    }

    @Override
    public ViewsRecord value2(String value) {
        setTableSchema(value);
        return this;
    }

    @Override
    public ViewsRecord value3(String value) {
        setTableName(value);
        return this;
    }

    @Override
    public ViewsRecord value4(String value) {
        setViewDefinition(value);
        return this;
    }

    @Override
    public ViewsRecord value5(String value) {
        setCheckOption(value);
        return this;
    }

    @Override
    public ViewsRecord value6(String value) {
        setIsUpdatable(value);
        return this;
    }

    @Override
    public ViewsRecord value7(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ViewsRecord value8(String value) {
        setRemarks(value);
        return this;
    }

    @Override
    public ViewsRecord value9(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ViewsRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewsRecord
     */
    public ViewsRecord() {
        super(Views.VIEWS);
    }

    /**
     * Create a detached, initialised ViewsRecord
     */
    public ViewsRecord(String tableCatalog, String tableSchema, String tableName, String viewDefinition, String checkOption, String isUpdatable, String status, String remarks, Integer id) {
        super(Views.VIEWS);

        set(0, tableCatalog);
        set(1, tableSchema);
        set(2, tableName);
        set(3, viewDefinition);
        set(4, checkOption);
        set(5, isUpdatable);
        set(6, status);
        set(7, remarks);
        set(8, id);
    }
}
