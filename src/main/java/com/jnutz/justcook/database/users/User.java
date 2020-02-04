package com.jnutz.justcook.database.users;

import com.jnutz.justcook.client.gui.container.AccessLevel;

public class User
{
    private short id; //Primary Key
    private String username; //Foreign key???
    private byte[] salt;
    private byte[] password;
    private AccessLevel accessLevel;

    public User() {}

    //Used when adding a new user to database
    public User(String username, byte[] salt, byte[] password, AccessLevel accessLevel)
    {
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.accessLevel = accessLevel;
    }
    
    //Used when getting a user from database
    public User(short id, String username, byte[] salt, byte[] password, AccessLevel accessLevel)
    {
        this.id = id;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public short getID()
    {
        return id;
    }

    public void setID(short id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public byte[] getSalt()
    {
        return salt;
    }

    public void setSalt(byte[] salt)
    {
        this.salt = salt;
    }

    public byte[] getPassword()
    {
        return password;
    }

    public void setPassword(byte[] password)
    {
        this.password = password;
    }

    public AccessLevel getAccessLevel()
    {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel)
    {
        this.accessLevel = accessLevel;
    }

    public void setAccessLevel(String accessLevel)
    {
        this.accessLevel = AccessLevel.valueOf(accessLevel);
    }
}