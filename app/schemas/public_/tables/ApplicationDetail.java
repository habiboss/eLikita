/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import schemas.public_.Keys;
import schemas.public_.Public;
import schemas.public_.tables.records.ApplicationDetailRecord;


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
public class ApplicationDetail extends TableImpl<ApplicationDetailRecord> {

    private static final long serialVersionUID = 1660802619;

    /**
     * The reference instance of <code>public.application_detail</code>
     */
    public static final ApplicationDetail APPLICATION_DETAIL = new ApplicationDetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ApplicationDetailRecord> getRecordType() {
        return ApplicationDetailRecord.class;
    }

    /**
     * The column <code>public.application_detail.id</code>.
     */
    public final TableField<ApplicationDetailRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.application_detail.admission_officer</code>.
     */
    public final TableField<ApplicationDetailRecord, String> ADMISSION_OFFICER = createField("admission_officer", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.app_code</code>.
     */
    public final TableField<ApplicationDetailRecord, String> APP_CODE = createField("app_code", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.course_title</code>.
     */
    public final TableField<ApplicationDetailRecord, String> COURSE_TITLE = createField("course_title", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.faculty</code>.
     */
    public final TableField<ApplicationDetailRecord, String> FACULTY = createField("faculty", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.finish_date</code>.
     */
    public final TableField<ApplicationDetailRecord, Timestamp> FINISH_DATE = createField("finish_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.application_detail.location_</code>.
     */
    public final TableField<ApplicationDetailRecord, String> LOCATION_ = createField("location_", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.mode_of_attendance</code>.
     */
    public final TableField<ApplicationDetailRecord, String> MODE_OF_ATTENDANCE = createField("mode_of_attendance", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.application_detail.start_date</code>.
     */
    public final TableField<ApplicationDetailRecord, Timestamp> START_DATE = createField("start_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.application_detail.status</code>.
     */
    public final TableField<ApplicationDetailRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * Create a <code>public.application_detail</code> table reference
     */
    public ApplicationDetail() {
        this("application_detail", null);
    }

    /**
     * Create an aliased <code>public.application_detail</code> table reference
     */
    public ApplicationDetail(String alias) {
        this(alias, APPLICATION_DETAIL);
    }

    private ApplicationDetail(String alias, Table<ApplicationDetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private ApplicationDetail(String alias, Table<ApplicationDetailRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ApplicationDetailRecord> getPrimaryKey() {
        return Keys.APPLICATION_DETAIL_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ApplicationDetailRecord>> getKeys() {
        return Arrays.<UniqueKey<ApplicationDetailRecord>>asList(Keys.APPLICATION_DETAIL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApplicationDetail as(String alias) {
        return new ApplicationDetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ApplicationDetail rename(String name) {
        return new ApplicationDetail(name, null);
    }
}
