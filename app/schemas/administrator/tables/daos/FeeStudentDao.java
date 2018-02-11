/*
 * This file is generated by jOOQ.
*/
package schemas.administrator.tables.daos;


import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import schemas.administrator.tables.FeeStudent;
import schemas.administrator.tables.records.FeeStudentRecord;


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
public class FeeStudentDao extends DAOImpl<FeeStudentRecord, schemas.administrator.tables.pojos.FeeStudent, Long> {

    /**
     * Create a new FeeStudentDao without any configuration
     */
    public FeeStudentDao() {
        super(FeeStudent.FEE_STUDENT, schemas.administrator.tables.pojos.FeeStudent.class);
    }

    /**
     * Create a new FeeStudentDao with an attached configuration
     */
    public FeeStudentDao(Configuration configuration) {
        super(FeeStudent.FEE_STUDENT, schemas.administrator.tables.pojos.FeeStudent.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(schemas.administrator.tables.pojos.FeeStudent object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchById(Long... values) {
        return fetch(FeeStudent.FEE_STUDENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public schemas.administrator.tables.pojos.FeeStudent fetchOneById(Long value) {
        return fetchOne(FeeStudent.FEE_STUDENT.ID, value);
    }

    /**
     * Fetch records that have <code>fee_fk IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByFeeFk(String... values) {
        return fetch(FeeStudent.FEE_STUDENT.FEE_FK, values);
    }

    /**
     * Fetch records that have <code>student_fk IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByStudentFk(String... values) {
        return fetch(FeeStudent.FEE_STUDENT.STUDENT_FK, values);
    }

    /**
     * Fetch records that have <code>effective_from IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByEffectiveFrom(Time... values) {
        return fetch(FeeStudent.FEE_STUDENT.EFFECTIVE_FROM, values);
    }

    /**
     * Fetch records that have <code>amount IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByAmount(BigDecimal... values) {
        return fetch(FeeStudent.FEE_STUDENT.AMOUNT, values);
    }

    /**
     * Fetch records that have <code>discount_fk IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByDiscountFk(String... values) {
        return fetch(FeeStudent.FEE_STUDENT.DISCOUNT_FK, values);
    }

    /**
     * Fetch records that have <code>status_fk IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.FeeStudent> fetchByStatusFk(String... values) {
        return fetch(FeeStudent.FEE_STUDENT.STATUS_FK, values);
    }
}
