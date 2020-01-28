package com.jnutz.justcook.database.users;

import java.sql.Date;
import java.util.List;

public interface IUserDAO
{
    //TODO: Should all DAO Interfaces have a default implementation?

    List<User> getAllUsers();
    List<User> getUsersByFirstName(String firstName);
    List<User> getUsersByLastName(String lastName);
    List<User> getUsersByAge(Byte age);
    List<User> getUsersByDOB(Date dob);

    User getUser(int id);

    boolean addUser(User user);
    boolean updateUser(User oldUser, User newUser);
    boolean deleteUser(User userToDelete);
}