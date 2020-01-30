package com.jnutz.justcook.database.users;

public class User
{
    private short id; //Primary Key
    private String username; //Foreign key???
    private byte[] salt;
    private byte[] password;

    public User() {}

    //Used when adding a new user to database
    public User(String username)
    {
    }

    //Used when getting a user from database
    public User(short id)
    {
        this.id = id;
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
}