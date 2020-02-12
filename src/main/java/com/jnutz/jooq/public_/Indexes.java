/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.public_;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;
import src.main.java.com.jnutz.jooq.public_.tables.*;

import javax.annotation.processing.Generated;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.3"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Indexes
{
    
    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------
    
    public static final Index PRIMARY_KEY_84 = Indexes0.PRIMARY_KEY_84;
    public static final Index PRIMARY_KEY_1 = Indexes0.PRIMARY_KEY_1;
    public static final Index PRIMARY_KEY_E = Indexes0.PRIMARY_KEY_E;
    public static final Index PRIMARY_KEY_43 = Indexes0.PRIMARY_KEY_43;
    public static final Index PRIMARY_KEY_8 = Indexes0.PRIMARY_KEY_8;
    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index PRIMARY_KEY_A = Indexes0.PRIMARY_KEY_A;
    public static final Index PRIMARY_KEY_4C = Indexes0.PRIMARY_KEY_4C;
    public static final Index PRIMARY_KEY_4 = Indexes0.PRIMARY_KEY_4;
    
    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------
    
    private static class Indexes0
    {
        public static Index PRIMARY_KEY_84 = Internal.createIndex("PRIMARY_KEY_84", Cookbooks.COOKBOOKS, new OrderField[] {Cookbooks.COOKBOOKS.ID}, true);
        public static Index PRIMARY_KEY_1 = Internal.createIndex("PRIMARY_KEY_1", Employees.EMPLOYEES, new OrderField[] {Employees.EMPLOYEES.USERID}, true);
        public static Index PRIMARY_KEY_E = Internal.createIndex("PRIMARY_KEY_E", Ingredients.INGREDIENTS, new OrderField[] {Ingredients.INGREDIENTS.ID}, true);
        public static Index PRIMARY_KEY_43 = Internal.createIndex("PRIMARY_KEY_43", Items.ITEMS, new OrderField[] {Items.ITEMS.ID}, true);
        public static Index PRIMARY_KEY_8 = Internal.createIndex("PRIMARY_KEY_8", RecipeIngredients.RECIPE_INGREDIENTS, new OrderField[] {RecipeIngredients.RECIPE_INGREDIENTS.ID}, true);
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", RecipeSteps.RECIPE_STEPS, new OrderField[] {RecipeSteps.RECIPE_STEPS.ID}, true);
        public static Index PRIMARY_KEY_A = Internal.createIndex("PRIMARY_KEY_A", Recipes.RECIPES, new OrderField[] {Recipes.RECIPES.ID}, true);
        public static Index PRIMARY_KEY_4C = Internal.createIndex("PRIMARY_KEY_4C", Steps.STEPS, new OrderField[] {Steps.STEPS.ID}, true);
        public static Index PRIMARY_KEY_4 = Internal.createIndex("PRIMARY_KEY_4", Users.USERS, new OrderField[] {Users.USERS.ID}, true);
    }
}
