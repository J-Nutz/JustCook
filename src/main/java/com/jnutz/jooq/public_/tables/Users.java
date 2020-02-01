/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.public_.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import src.main.java.com.jnutz.jooq.public_.Indexes;
import src.main.java.com.jnutz.jooq.public_.Keys;
import src.main.java.com.jnutz.jooq.public_.Public;
import src.main.java.com.jnutz.jooq.public_.tables.records.UsersRecord;


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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = -2046431322;

    /**
     * The reference instance of <code>PUBLIC.Users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>PUBLIC.Users.UserID</code>.
     */
    public final TableField<UsersRecord, Short> USERID = createField(DSL.name("UserID"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.Users.Username</code>.
     */
    public final TableField<UsersRecord, String> USERNAME = createField(DSL.name("Username"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>PUBLIC.Users.Salt</code>.
     */
    public final TableField<UsersRecord, byte[]> SALT = createField(DSL.name("Salt"), org.jooq.impl.SQLDataType.VARBINARY, this, "");

    /**
     * The column <code>PUBLIC.Users.Password</code>.
     */
    public final TableField<UsersRecord, byte[]> PASSWORD = createField(DSL.name("Password"), org.jooq.impl.SQLDataType.VARBINARY, this, "");

    /**
     * The column <code>PUBLIC.Users.AccessLevel</code>.
     */
    public final TableField<UsersRecord, String> ACCESSLEVEL = createField(DSL.name("AccessLevel"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * Create a <code>PUBLIC.Users</code> table reference
     */
    public Users() {
        this(DSL.name("Users"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.Users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>PUBLIC.Users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Users(Table<O> child, ForeignKey<O, UsersRecord> key) {
        super(child, key, USERS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_4);
    }

    @Override
    public Identity<UsersRecord, Short> getIdentity() {
        return Keys.IDENTITY_USERS;
    }

    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_4;
    }

    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(Keys.CONSTRAINT_4);
    }

    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Short, String, byte[], byte[], String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
