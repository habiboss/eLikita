/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import schemas.public_.tables.ParentInfo;


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
public class ParentInfoRecord extends UpdatableRecordImpl<ParentInfoRecord> implements Record7<Long, Timestamp, String, String, String, Timestamp, Long> {

    private static final long serialVersionUID = -1142463713;

    /**
     * Setter for <code>public.parent_info.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.parent_info.id</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.parent_info.date_of_birth</code>.
     */
    public void setDateOfBirth(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.parent_info.date_of_birth</code>.
     */
    public Timestamp getDateOfBirth() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>public.parent_info.first_name</code>.
     */
    public void setFirstName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.parent_info.first_name</code>.
     */
    @Size(max = 255)
    public String getFirstName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.parent_info.gender</code>.
     */
    public void setGender(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.parent_info.gender</code>.
     */
    @Size(max = 255)
    public String getGender() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.parent_info.last_name</code>.
     */
    public void setLastName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.parent_info.last_name</code>.
     */
    @Size(max = 255)
    public String getLastName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.parent_info.other_info</code>.
     */
    public void setOtherInfo(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.parent_info.other_info</code>.
     */
    public Timestamp getOtherInfo() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>public.parent_info.student_fk</code>.
     */
    public void setStudentFk(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.parent_info.student_fk</code>.
     */
    public Long getStudentFk() {
        return (Long) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, Timestamp, String, String, String, Timestamp, Long> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, Timestamp, String, String, String, Timestamp, Long> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ParentInfo.PARENT_INFO.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return ParentInfo.PARENT_INFO.DATE_OF_BIRTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ParentInfo.PARENT_INFO.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ParentInfo.PARENT_INFO.GENDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return ParentInfo.PARENT_INFO.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return ParentInfo.PARENT_INFO.OTHER_INFO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return ParentInfo.PARENT_INFO.STUDENT_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getDateOfBirth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getGender();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getOtherInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getStudentFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value2(Timestamp value) {
        setDateOfBirth(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value3(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value4(String value) {
        setGender(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value5(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value6(Timestamp value) {
        setOtherInfo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord value7(Long value) {
        setStudentFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParentInfoRecord values(Long value1, Timestamp value2, String value3, String value4, String value5, Timestamp value6, Long value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ParentInfoRecord
     */
    public ParentInfoRecord() {
        super(ParentInfo.PARENT_INFO);
    }

    /**
     * Create a detached, initialised ParentInfoRecord
     */
    public ParentInfoRecord(Long id, Timestamp dateOfBirth, String firstName, String gender, String lastName, Timestamp otherInfo, Long studentFk) {
        super(ParentInfo.PARENT_INFO);

        set(0, id);
        set(1, dateOfBirth);
        set(2, firstName);
        set(3, gender);
        set(4, lastName);
        set(5, otherInfo);
        set(6, studentFk);
    }
}
