package com.jnutz.justcook.database.users;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class User
{
    private short id;
    private String username;
    private byte[] password;
    private String firstName;
    private String lastName;
    private Byte age;
    private Date dateOfBirth;
    private String email;

    public User() {}

    //Used when adding a new user to database
    public User(String firstName, String lastName, Byte age, Date dateOfBirth, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    //Used when getting a user from database
    public User(short id, String firstName, String lastName, Byte age, Date dateOfBirth, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
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

    public byte[] getPassword()
    {
        return password;
    }

    public void setPassword(byte[] password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Byte getAge()
    {
        return age;
    }

    public void setAge(Byte age)
    {
        this.age = age;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}