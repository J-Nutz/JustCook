package com.jnutz.justcook.database.users;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep5;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Users;
import src.main.java.com.jnutz.jooq.public_.tables.records.UsersRecord;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class UserDAO //implements IUserDAO
{
    private static final Users USERS = Users.USERS;

    public static List<User> getAllUsers()
    {
        return null;
    }

    public static List<User> getUsersByFirstName(String firstName)
    {
        return null;
    }

    public static List<User> getUsersByLastName(String lastName)
    {
        return null;
    }

    public static List<User> getUsersByAge(Byte age)
    {
        return null;
    }

    public static List<User> getUsersByDOB(Date dob)
    {
        return null;
    }

    public static User getUser(int id)
    {
        return null;
    }

    public static User getUser(String username)
    {
        return new User();
    }

    public static boolean addUser(@NotNull User user)
    {
        try(Connection tempConnection =  database.getConnection();
            DSLContext tempDatabaseConnection = H2DSL.using(tempConnection))
        {
            InsertValuesStep5<UsersRecord, String, String, Byte, Date, String> addUserStep =
                    tempDatabaseConnection.insertInto(USERS, USERS.FIRSTNAME, USERS.LASTNAME, USERS.AGE, USERS.DOB, USERS.EMAIL)
                                          .values(user.getFirstName(), user.getLastName(), user.getAge(), user.getDateOfBirth(), user.getEmail());

            return addUserStep.execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();

            return false;
        }
    }

    public static boolean updateUser(User oldUser, User newUser)
    {
        return false;
    }

    public static boolean deleteUser(short userIdToDelete)
    {
        return false;
    }

    public static boolean deleteUser(User userToDelete)
    {
        return false;
    }

    public static boolean usernameAvailable(String username)
    {
        return true;
    }
}