package com.jnutz.justcook.database.cookbook.recipes.steps;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.util.h2.H2DSL;
import src.main.java.com.jnutz.jooq.public_.tables.Steps;
import src.main.java.com.jnutz.jooq.public_.tables.records.StepsRecord;

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
    
    public static List<Step> getSteps(short index)
    {
        List<Short> stepIds = RecipeStepsDAO.getRecipeStepIds(index);
    
        if(stepIds != null)
        {
            try(var connection = database.getConnection();
                var database = H2DSL.using(connection, SQLDialect.H2))
            {
                List<Step> steps = new ArrayList<>();
            
                for(Short id : stepIds)
                {
                    Result<StepsRecord> fetchedSteps = database.selectFrom(STEPS)
                                                               .where(STEPS.ID.equal(id))
                                                               .fetch();
                
                    if(fetchedSteps.isNotEmpty())
                    {
                        for(StepsRecord stepsRecord : fetchedSteps)
                        {
                            Step step = new Step();
                        
                            step.setId(stepsRecord.getId());
                            step.setNumber(stepsRecord.getNumber());
                            step.setText(stepsRecord.getText());
                        
                            steps.add(step);
                        }
                    }
                    // TODO: How should this be handled?
                    //  There might still be more Steps that aren't null
                    //  However we have now misplaced a step somehow
                    /*else
                    {
                        return null;
                    }*/
                }
            
                return steps;
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}