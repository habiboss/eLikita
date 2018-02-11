/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import schemas.public_.tables.Institution;
import schemas.public_.tables.records.InstitutionRecord;


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
public class InstitutionDao extends DAOImpl<InstitutionRecord, schemas.public_.tables.pojos.Institution, Long> {

    /**
     * Create a new InstitutionDao without any configuration
     */
    public InstitutionDao() {
        super(Institution.INSTITUTION, schemas.public_.tables.pojos.Institution.class);
    }

    /**
     * Create a new InstitutionDao with an attached configuration
     */
    public InstitutionDao(Configuration configuration) {
        super(Institution.INSTITUTION, schemas.public_.tables.pojos.Institution.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(schemas.public_.tables.pojos.Institution object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchById(Long... values) {
        return fetch(Institution.INSTITUTION.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public schemas.public_.tables.pojos.Institution fetchOneById(Long value) {
        return fetchOne(Institution.INSTITUTION.ID, value);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByCreated(Timestamp... values) {
        return fetch(Institution.INSTITUTION.CREATED, values);
    }

    /**
     * Fetch records that have <code>industry IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByIndustry(String... values) {
        return fetch(Institution.INSTITUTION.INDUSTRY, values);
    }

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByAddress(String... values) {
        return fetch(Institution.INSTITUTION.ADDRESS, values);
    }

    /**
     * Fetch records that have <code>city IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByCity(String... values) {
        return fetch(Institution.INSTITUTION.CITY, values);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByCode(String... values) {
        return fetch(Institution.INSTITUTION.CODE, values);
    }

    /**
     * Fetch records that have <code>country IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByCountry(String... values) {
        return fetch(Institution.INSTITUTION.COUNTRY, values);
    }

    /**
     * Fetch records that have <code>currency IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByCurrency(String... values) {
        return fetch(Institution.INSTITUTION.CURRENCY, values);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByEmail(String... values) {
        return fetch(Institution.INSTITUTION.EMAIL, values);
    }

    /**
     * Fetch records that have <code>fax IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByFax(String... values) {
        return fetch(Institution.INSTITUTION.FAX, values);
    }

    /**
     * Fetch records that have <code>language IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByLanguage(String... values) {
        return fetch(Institution.INSTITUTION.LANGUAGE, values);
    }

    /**
     * Fetch records that have <code>logo IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByLogo(String... values) {
        return fetch(Institution.INSTITUTION.LOGO, values);
    }

    /**
     * Fetch records that have <code>mobile IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByMobile(String... values) {
        return fetch(Institution.INSTITUTION.MOBILE, values);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByName(String... values) {
        return fetch(Institution.INSTITUTION.NAME, values);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByPhone(String... values) {
        return fetch(Institution.INSTITUTION.PHONE, values);
    }

    /**
     * Fetch records that have <code>postcode IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByPostcode(String... values) {
        return fetch(Institution.INSTITUTION.POSTCODE, values);
    }

    /**
     * Fetch records that have <code>region IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByRegion(String... values) {
        return fetch(Institution.INSTITUTION.REGION, values);
    }

    /**
     * Fetch records that have <code>timezone IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByTimezone(String... values) {
        return fetch(Institution.INSTITUTION.TIMEZONE, values);
    }

    /**
     * Fetch records that have <code>website IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByWebsite(String... values) {
        return fetch(Institution.INSTITUTION.WEBSITE, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<schemas.public_.tables.pojos.Institution> fetchByStatus(String... values) {
        return fetch(Institution.INSTITUTION.STATUS, values);
    }
}
