/*
 * This file is generated by jOOQ.
*/
package schemas.referential.tables.daos;


import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import schemas.referential.tables.RUserType;
import schemas.referential.tables.records.RUserTypeRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RUserTypeDao extends DAOImpl<RUserTypeRecord, schemas.referential.tables.pojos.RUserType, Long> {

    /**
     * Create a new RUserTypeDao without any configuration
     */
    public RUserTypeDao() {
        super(RUserType.R_USER_TYPE, schemas.referential.tables.pojos.RUserType.class);
    }

    /**
     * Create a new RUserTypeDao with an attached configuration
     */
    public RUserTypeDao(Configuration configuration) {
        super(RUserType.R_USER_TYPE, schemas.referential.tables.pojos.RUserType.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(schemas.referential.tables.pojos.RUserType object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<schemas.referential.tables.pojos.RUserType> fetchById(Long... values) {
        return fetch(RUserType.R_USER_TYPE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public schemas.referential.tables.pojos.RUserType fetchOneById(Long value) {
        return fetchOne(RUserType.R_USER_TYPE.ID, value);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<schemas.referential.tables.pojos.RUserType> fetchByCode(String... values) {
        return fetch(RUserType.R_USER_TYPE.CODE, values);
    }

    /**
     * Fetch records that have <code>user_type IN (values)</code>
     */
    public List<schemas.referential.tables.pojos.RUserType> fetchByUserType(String... values) {
        return fetch(RUserType.R_USER_TYPE.USER_TYPE, values);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<schemas.referential.tables.pojos.RUserType> fetchByDescription(String... values) {
        return fetch(RUserType.R_USER_TYPE.DESCRIPTION, values);
    }
}
