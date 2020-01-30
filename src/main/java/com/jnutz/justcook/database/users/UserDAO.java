package com.jnutz.justcook.database.users;

import org.jooq.DSLContext;
import org.jooq.InsertValuesStep3;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Users;
import src.main.java.com.jnutz.jooq.public_.tables.records.UsersRecord;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class UserDAO
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
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection))
        {
            Result<Record> fetchedUser = database.select()
                                                 .from(USERS)
                                                 .where(USERS.EMAIL.equal(username))
                                                 .fetch();

            if(fetchedUser.isNotEmpty())
            {
                User user = new User();

                for (Record record : fetchedUser)
                {
                    user.setID(record.get(USERS.USERID));
                    user.setUsername(record.get(USERS.USERNAME));
                    user.setSalt(record.get(USERS.SALT));
                    user.setPassword(record.get(USERS.PASSWORD));
                }

                return user;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return new User();
    }

    public static boolean addUser(User user)
    {
        try(Connection tempConnection =  database.getConnection();
            DSLContext tempDatabaseConnection = H2DSL.using(tempConnection))
        {
            InsertValuesStep3<UsersRecord, String, byte[], byte[]> addUserStep =
                    tempDatabaseConnection.insertInto(USERS, USERS.USERNAME, USERS.SALT, USERS.PASSWORD)
                                          .values(user.getUsername(), user.getSalt(), user.getPassword());

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