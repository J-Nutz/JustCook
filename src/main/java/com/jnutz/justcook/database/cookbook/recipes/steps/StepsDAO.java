package com.jnutz.justcook.database.cookbook.recipes.steps;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Steps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jnutz.justcook.Launcher.database;

public class StepsDAO
{
    private static final Steps STEPS = Steps.STEPS;
    
    public static boolean addStep(Step step)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            return database.insertInto(STEPS, STEPS.ID, STEPS.NUMBER, STEPS.TEXT)
                           .values(step.getId(), step.getNumber(), step.getText())
                           .execute() == 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        
            return false;
        }
    }
    
    public static Step getStep(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedStep = database.select()
                                                 .from(STEPS)
                                                 .where(STEPS.ID.equal(id))
                                                 .fetch();
        
            Step step = new Step();
        
            if(fetchedStep.isNotEmpty())
            {
                Record record = fetchedStep.get(0);
                
                step.setId(record.get(STEPS.ID));
                step.setNumber(record.get(STEPS.NUMBER));
                step.setText(record.get(STEPS.TEXT));
            }
            
            return step;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Step> getSteps(short id)
    {
        try(var connection = database.getConnection();
            var database = H2DSL.using(connection, SQLDialect.H2))
        {
            Result<Record> fetchedStep = database.select()
                                                 .from(STEPS)
                                                 .where(STEPS.ID.equal(id))
                                                 .fetch();
        
            List<Step> steps = new ArrayList<>();
        
            if(fetchedStep.isNotEmpty())
            {
                for(Record record : fetchedStep)
                {
                    Step step = new Step();
                    
                    step.setId(record.get(STEPS.ID));
                    step.setNumber(record.get(STEPS.NUMBER));
                    step.setText(record.get(STEPS.TEXT));
                    
                    steps.add(step);
                }
            }
            
            return steps;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}