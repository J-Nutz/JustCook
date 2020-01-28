/*
 * This file is generated by jOOQ.
 */
package src.main.java.com.jnutz.jooq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import src.main.java.com.jnutz.jooq.information_schema.InformationSchema;
import src.main.java.com.jnutz.jooq.public_.Public;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = -1518180268;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>INFORMATION_SCHEMA</code>.
     */
    public final InformationSchema INFORMATION_SCHEMA = src.main.java.com.jnutz.jooq.information_schema.InformationSchema.INFORMATION_SCHEMA;

    /**
     * The schema <code>PUBLIC</code>.
     */
    public final Public PUBLIC = src.main.java.com.jnutz.jooq.public_.Public.PUBLIC;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        List result = new ArrayList();
        result.addAll(getSchemas0());
        return result;
    }

    private final List<Schema> getSchemas0() {
        return Arrays.<Schema>asList(
            InformationSchema.INFORMATION_SCHEMA,
            Public.PUBLIC);
    }
}
