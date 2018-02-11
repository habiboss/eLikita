/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import schemas.public_.tables.NationalityDetail;


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
public class NationalityDetailRecord extends UpdatableRecordImpl<NationalityDetailRecord> implements Record11<Long, Long, Long, Long, String, String, Timestamp, Timestamp, String, String, Long> {

    private static final long serialVersionUID = -412339956;

    /**
     * Setter for <code>public.nationality_detail.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.nationality_detail.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.nationality_detail.nationality_fk</code>.
     */
    public void setNationalityFk(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.nationality_detail.nationality_fk</code>.
     */
    public Long getNationalityFk() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.nationality_detail.permanent_residence_fk</code>.
     */
    public void setPermanentResidenceFk(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.nationality_detail.permanent_residence_fk</code>.
     */
    public Long getPermanentResidenceFk() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.nationality_detail.residential_status_fk</code>.
     */
    public void setResidentialStatusFk(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.nationality_detail.residential_status_fk</code>.
     */
    public Long getResidentialStatusFk() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.nationality_detail.student_fk</code>.
     */
    public void setStudentFk(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.nationality_detail.student_fk</code>.
     */
    @Size(max = 50)
    public String getStudentFk() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.nationality_detail.passport_no</code>.
     */
    public void setPassportNo(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.nationality_detail.passport_no</code>.
     */
    @Size(max = 50)
    public String getPassportNo() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.nationality_detail.issue_date</code>.
     */
    public void setIssueDate(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.nationality_detail.issue_date</code>.
     */
    public Timestamp getIssueDate() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>public.nationality_detail.expiry_date</code>.
     */
    public void setExpiryDate(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.nationality_detail.expiry_date</code>.
     */
    public Timestamp getExpiryDate() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>public.nationality_detail.issue_place</code>.
     */
    public void setIssuePlace(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.nationality_detail.issue_place</code>.
     */
    @Size(max = 50)
    public String getIssuePlace() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.nationality_detail.name_on_passport</code>.
     */
    public void setNameOnPassport(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.nationality_detail.name_on_passport</code>.
     */
    @Size(max = 50)
    public String getNameOnPassport() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.nationality_detail.identification_type_fk</code>.
     */
    public void setIdentificationTypeFk(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.nationality_detail.identification_type_fk</code>.
     */
    public Long getIdentificationTypeFk() {
        return (Long) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, Long, Long, Long, String, String, Timestamp, Timestamp, String, String, Long> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, Long, Long, Long, String, String, Timestamp, Timestamp, String, String, Long> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return NationalityDetail.NATIONALITY_DETAIL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return NationalityDetail.NATIONALITY_DETAIL.NATIONALITY_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return NationalityDetail.NATIONALITY_DETAIL.PERMANENT_RESIDENCE_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return NationalityDetail.NATIONALITY_DETAIL.RESIDENTIAL_STATUS_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return NationalityDetail.NATIONALITY_DETAIL.STUDENT_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return NationalityDetail.NATIONALITY_DETAIL.PASSPORT_NO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return NationalityDetail.NATIONALITY_DETAIL.ISSUE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return NationalityDetail.NATIONALITY_DETAIL.EXPIRY_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return NationalityDetail.NATIONALITY_DETAIL.ISSUE_PLACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return NationalityDetail.NATIONALITY_DETAIL.NAME_ON_PASSPORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return NationalityDetail.NATIONALITY_DETAIL.IDENTIFICATION_TYPE_FK;
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
    public Long value2() {
        return getNationalityFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getPermanentResidenceFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getResidentialStatusFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStudentFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPassportNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getIssueDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getExpiryDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getIssuePlace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getNameOnPassport();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getIdentificationTypeFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value2(Long value) {
        setNationalityFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value3(Long value) {
        setPermanentResidenceFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value4(Long value) {
        setResidentialStatusFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value5(String value) {
        setStudentFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value6(String value) {
        setPassportNo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value7(Timestamp value) {
        setIssueDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value8(Timestamp value) {
        setExpiryDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value9(String value) {
        setIssuePlace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value10(String value) {
        setNameOnPassport(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord value11(Long value) {
        setIdentificationTypeFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NationalityDetailRecord values(Long value1, Long value2, Long value3, Long value4, String value5, String value6, Timestamp value7, Timestamp value8, String value9, String value10, Long value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NationalityDetailRecord
     */
    public NationalityDetailRecord() {
        super(NationalityDetail.NATIONALITY_DETAIL);
    }

    /**
     * Create a detached, initialised NationalityDetailRecord
     */
    public NationalityDetailRecord(Long id, Long nationalityFk, Long permanentResidenceFk, Long residentialStatusFk, String studentFk, String passportNo, Timestamp issueDate, Timestamp expiryDate, String issuePlace, String nameOnPassport, Long identificationTypeFk) {
        super(NationalityDetail.NATIONALITY_DETAIL);

        set(0, id);
        set(1, nationalityFk);
        set(2, permanentResidenceFk);
        set(3, residentialStatusFk);
        set(4, studentFk);
        set(5, passportNo);
        set(6, issueDate);
        set(7, expiryDate);
        set(8, issuePlace);
        set(9, nameOnPassport);
        set(10, identificationTypeFk);
    }
}
