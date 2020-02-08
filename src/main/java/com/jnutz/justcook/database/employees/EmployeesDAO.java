package com.jnutz.justcook.database.employees;

import org.jooq.*;
import org.jooq.util.h2.H2DSL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class EmployeesDAO
{
    private static final src.main.java.com.jnutz.jooq.public_.tables.Employees EMPLOYEES = src.main.java.com.jnutz.jooq.public_.tables.Employees.EMPLOYEES;
    
    public static List<Employee> getAllEmployees()
    {
        return null;
    }
    
    public static List<Employee> getEmployeesByFirstName(String firstName)
    {
        return null;
    }

    public static List<Employee> getEmployeesByLastName(String lastName)
    {
        return null;
    }

    public static List<Employee> getEmployeesByAge(Byte age)
    {
        return null;
    }

    public static List<Employee> getEmployeesByDOB(Date dob)
    {
        return null;
    }

    public static Employee getEmployee(short userID)
    {
        try(Connection connection = database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedEmployee =
                    database.select()
                            .from(EMPLOYEES)
                            .where(EMPLOYEES.USERID.eq(userID))
                            .limit(1) //TODO: Is this necessary as there will be logic enforcing unique username's?
                            .fetch();

            if(fetchedEmployee.isNotEmpty())
            {
                Employee employee = new Employee();

                for (Record record : fetchedEmployee)
                {
                    employee.setID(record.get(EMPLOYEES.USERID));
                    employee.setEmail(record.get(EMPLOYEES.EMAIL));
                    employee.setFirstName(record.get(EMPLOYEES.FIRSTNAME));
                    employee.setLastName(record.get(EMPLOYEES.LASTNAME));
                    employee.setAge(record.get(EMPLOYEES.AGE));
                    employee.setDateOfBirth(record.get(EMPLOYEES.DATEOFBIRTH));
                }

                return employee;
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

        return new Employee();
    }

    public static boolean addEmployee(Employee employee)
    {
        try(Connection connection =  database.getConnection();
            DSLContext database = H2DSL.using(connection, SQLDialect.H2))
        {
            InsertValuesStep5<src.main.java.com.jnutz.jooq.public_.tables.records.EmployeesRecord, String, String, String, Byte, Date> addEmployee =
                    database.insertInto(EMPLOYEES, EMPLOYEES.EMAIL, EMPLOYEES.FIRSTNAME, EMPLOYEES.LASTNAME,
                                        EMPLOYEES.AGE, EMPLOYEES.DATEOFBIRTH)
                            .values(employee.getEmail(), employee.getFirstName(), employee.getLastName(),
                                    employee.getAge(), employee.getDateOfBirth());
    
            return addEmployee.execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();

            return false;
        }
    }

    public static boolean updateEmployee(Employee oldEmployee, Employee newEmployee)
    {
        return false;
    }

    public static boolean deleteEmployee(short employeeIdToDelete)
    {
        return false;
    }

    public static boolean deleteEmployee(Employee employeeToDelete)
    {
        return false;
    }
}