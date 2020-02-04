/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq.public_;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import src.main.java.com.jnutz.jooq.DefaultCatalog;
import src.main.java.com.jnutz.jooq.public_.tables.Employees;
import src.main.java.com.jnutz.jooq.public_.tables.Ingredients;
import src.main.java.com.jnutz.jooq.public_.tables.Users;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = {"http://www.jooq.org", "jOOQ version:3.12.3"},
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {
    
    private static final long serialVersionUID = -1891941791;
    
    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();
    
    /**
     * The table <code>PUBLIC.Employees</code>.
     */
    public final Employees EMPLOYEES = src.main.java.com.jnutz.jooq.public_.tables.Employees.EMPLOYEES;
    
    /**
     * The table <code>PUBLIC.Ingredients</code>.
     */
    public final Ingredients INGREDIENTS = src.main.java.com.jnutz.jooq.public_.tables.Ingredients.INGREDIENTS;
    
    /**
     * The table <code>PUBLIC.Users</code>.
     */
    public final Users USERS = src.main.java.com.jnutz.jooq.public_.tables.Users.USERS;
    
    /**
     * No further instances allowed
     */
    private Public()
    {
        super("PUBLIC", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(Employees.EMPLOYEES, Ingredients.INGREDIENTS, Users.USERS);
    }
}
