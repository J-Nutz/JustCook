package com.jnutz.justcook.database.users;

import com.jnutz.justcook.client.gui.container.AccessLevel;
import org.jooq.*;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;
import static org.jooq.impl.DSL.val;

public class UsersDAO
{
    private static final src.main.java.com.jnutz.jooq.public_.tables.Users USERS = src.main.java.com.jnutz.jooq.public_.tables.Users.USERS;
    
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

    public static List<User> getUsersByAccessLevel(AccessLevel accessLevel)
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
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedUser =
                    database.select().from(USERS).where(USERS.USERNAME.eq(username))
                            .limit(1) //TODO: Is this necessary as there will be logic enforcing unique username's?
                            .fetch();

            if(fetchedUser.isNotEmpty())
            {
                User user = new User();
    
                Record record = fetchedUser.get(0);
    
                user.setID(record.get(USERS.ID));
                user.setUsername(record.get(USERS.USERNAME));
                user.setSalt(record.get(USERS.SALT));
                user.setPassword(record.get(USERS.PASSWORD));
                user.setAccessLevel(record.get(USERS.ACCESSLEVEL));
    
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
            return null;
        }
    }

    public static byte[] getUserPassword(String username)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record1<byte[]>> fetchedPassword =
                    database.select(USERS.PASSWORD)
                            .from(USERS)
                            .where(USERS.USERNAME.equal(val(username)))
                            .limit(1) //TODO: Is this necessary as there will be logic enforcing unique username's?
                            .fetch();

            if(fetchedPassword.isNotEmpty())
            {
                return fetchedPassword.get(0).get(USERS.PASSWORD);
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addUser(User user)
    {
        try(Connection connection =  database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            InsertValuesStep4<src.main.java.com.jnutz.jooq.public_.tables.records.UsersRecord, String, byte[], byte[], String> addUser =
                    database.insertInto(USERS, USERS.USERNAME, USERS.SALT, USERS.PASSWORD, USERS.ACCESSLEVEL)
                            .values(user.getUsername(), user.getSalt(), user.getPassword(),
                                    user.getAccessLevel().name());

            return addUser.execute() == 1;
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