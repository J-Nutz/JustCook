package com.jnutz.justcook.database.employees;

import java.sql.Date;

public class Employee
{
    private short id;
    private String email;
    private String firstName;
    private String lastName;
    private Byte age;
    private Date dateOfBirth;

    public Employee() {}

    //Used when adding a new employee to database
    public Employee(String firstName, String lastName, Byte age, Date dateOfBirth, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    //Used when getting a employee from database
    public Employee(short id, String firstName, String lastName, Byte age, Date dateOfBirth, String email)
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
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
}