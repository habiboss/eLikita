/*
 * This file is generated by jOOQ.
*/
package schemas.administrator.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import schemas.administrator.tables.ClassSchedule;
import schemas.administrator.tables.records.ClassScheduleRecord;


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
public class ClassScheduleDao extends DAOImpl<ClassScheduleRecord, schemas.administrator.tables.pojos.ClassSchedule, Long> {

    /**
     * Create a new ClassScheduleDao without any configuration
     */
    public ClassScheduleDao() {
        super(ClassSchedule.CLASS_SCHEDULE, schemas.administrator.tables.pojos.ClassSchedule.class);
    }

    /**
     * Create a new ClassScheduleDao with an attached configuration
     */
    public ClassScheduleDao(Configuration configuration) {
        super(ClassSchedule.CLASS_SCHEDULE, schemas.administrator.tables.pojos.ClassSchedule.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(schemas.administrator.tables.pojos.ClassSchedule object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.ClassSchedule> fetchById(Long... values) {
        return fetch(ClassSchedule.CLASS_SCHEDULE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public schemas.administrator.tables.pojos.ClassSchedule fetchOneById(Long value) {
        return fetchOne(ClassSchedule.CLASS_SCHEDULE.ID, value);
    }

    /**
     * Fetch records that have <code>class_fk IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.ClassSchedule> fetchByClassFk(String... values) {
        return fetch(ClassSchedule.CLASS_SCHEDULE.CLASS_FK, values);
    }

    /**
     * Fetch records that have <code>start_time IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.ClassSchedule> fetchByStartTime(Timestamp... values) {
        return fetch(ClassSchedule.CLASS_SCHEDULE.START_TIME, values);
    }

    /**
     * Fetch records that have <code>end_time IN (values)</code>
     */
    public List<schemas.administrator.tables.pojos.ClassSchedule> fetchByEndTime(Timestamp... values) {
        return fetch(ClassSchedule.CLASS_SCHEDULE.END_TIME, values);
    }
}
