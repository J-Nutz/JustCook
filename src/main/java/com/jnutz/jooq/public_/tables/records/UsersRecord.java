/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.public_.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import src.main.java.com.jnutz.jooq.public_.tables.Users;

import javax.annotation.processing.Generated;


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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<Short, String, byte[], byte[], String>
{
    
    private static final long serialVersionUID = 2074653124;
    
    /**
     * Setter for <code>PUBLIC.Users.Id</code>.
     */
    public void setId(Short value)
    {
        set(0, value);
    }
    
    /**
     * Getter for <code>PUBLIC.Users.Id</code>.
     */
    public Short getId()
    {
        return (Short) get(0);
    }

    /**
     * Setter for <code>PUBLIC.Users.Username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.Users.Username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.Users.Salt</code>.
     */
    public void setSalt(byte... value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.Users.Salt</code>.
     */
    public byte[] getSalt() {
        return (byte[]) get(2);
    }

    /**
     * Setter for <code>PUBLIC.Users.Password</code>.
     */
    public void setPassword(byte... value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.Users.Password</code>.
     */
    public byte[] getPassword() {
        return (byte[]) get(3);
    }

    /**
     * Setter for <code>PUBLIC.Users.AccessLevel</code>.
     */
    public void setAccesslevel(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.Users.AccessLevel</code>.
     */
    public String getAccesslevel() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Short> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Short, String, byte[], byte[], String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Short, String, byte[], byte[], String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Short> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.USERNAME;
    }

    @Override
    public Field<byte[]> field3() {
        return Users.USERS.SALT;
    }

    @Override
    public Field<byte[]> field4() {
        return Users.USERS.PASSWORD;
    }

    @Override
    public Field<String> field5() {
        return Users.USERS.ACCESSLEVEL;
    }

    @Override
    public Short component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public byte[] component3() {
        return getSalt();
    }

    @Override
    public byte[] component4() {
        return getPassword();
    }

    @Override
    public String component5() {
        return getAccesslevel();
    }

    @Override
    public Short value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public byte[] value3() {
        return getSalt();
    }

    @Override
    public byte[] value4() {
        return getPassword();
    }

    @Override
    public String value5() {
        return getAccesslevel();
    }

    @Override
    public UsersRecord value1(Short value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UsersRecord value3(byte... value) {
        setSalt(value);
        return this;
    }

    @Override
    public UsersRecord value4(byte... value) {
        setPassword(value);
        return this;
    }

    @Override
    public UsersRecord value5(String value) {
        setAccesslevel(value);
        return this;
    }

    @Override
    public UsersRecord values(Short value1, String value2, byte[] value3, byte[] value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }
    
    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Short id, String username, byte[] salt, byte[] password, String accesslevel)
    {
        super(Users.USERS);
        
        set(0, id);
        set(1, username);
        set(2, salt);
        set(3, password);
        set(4, accesslevel);
    }
}
