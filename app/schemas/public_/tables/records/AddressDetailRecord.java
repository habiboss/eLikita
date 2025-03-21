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
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;

import schemas.public_.tables.AddressDetail;


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
public class AddressDetailRecord extends UpdatableRecordImpl<AddressDetailRecord> implements Record12<String, String, String, String, Long, String, Long, Long, String, Long, String, Timestamp> {

    private static final long serialVersionUID = 1685196194;

    /**
     * Setter for <code>public.address_detail.city</code>.
     */
    public void setCity(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.address_detail.city</code>.
     */
    @Size(max = 255)
    public String getCity() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.address_detail.postcode</code>.
     */
    public void setPostcode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.address_detail.postcode</code>.
     */
    @Size(max = 255)
    public String getPostcode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.address_detail.address</code>.
     */
    public void setAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.address_detail.address</code>.
     */
    @Size(max = 255)
    public String getAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.address_detail.region</code>.
     */
    public void setRegion(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.address_detail.region</code>.
     */
    @Size(max = 255)
    public String getRegion() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.address_detail.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.address_detail.id</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.address_detail.permanent_address</code>.
     */
    public void setPermanentAddress(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.address_detail.permanent_address</code>.
     */
    @Size(max = 255)
    public String getPermanentAddress() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.address_detail.primary_number</code>.
     */
    public void setPrimaryNumber(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.address_detail.primary_number</code>.
     */
    public Long getPrimaryNumber() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.address_detail.home_number</code>.
     */
    public void setHomeNumber(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.address_detail.home_number</code>.
     */
    public Long getHomeNumber() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.address_detail.email</code>.
     */
    public void setEmail(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.address_detail.email</code>.
     */
    @Size(max = 50)
    public String getEmail() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.address_detail.country_fk</code>.
     */
    public void setCountryFk(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.address_detail.country_fk</code>.
     */
    public Long getCountryFk() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.address_detail.present_address</code>.
     */
    public void setPresentAddress(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.address_detail.present_address</code>.
     */
    @Size(max = 255)
    public String getPresentAddress() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.address_detail.valid_until</code>.
     */
    public void setValidUntil(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.address_detail.valid_until</code>.
     */
    public Timestamp getValidUntil() {
        return (Timestamp) get(11);
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
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, String, String, Long, String, Long, Long, String, Long, String, Timestamp> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, String, String, Long, String, Long, Long, String, Long, String, Timestamp> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return AddressDetail.ADDRESS_DETAIL.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return AddressDetail.ADDRESS_DETAIL.POSTCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return AddressDetail.ADDRESS_DETAIL.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return AddressDetail.ADDRESS_DETAIL.REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return AddressDetail.ADDRESS_DETAIL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return AddressDetail.ADDRESS_DETAIL.PERMANENT_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return AddressDetail.ADDRESS_DETAIL.PRIMARY_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return AddressDetail.ADDRESS_DETAIL.HOME_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return AddressDetail.ADDRESS_DETAIL.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return AddressDetail.ADDRESS_DETAIL.COUNTRY_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return AddressDetail.ADDRESS_DETAIL.PRESENT_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field12() {
        return AddressDetail.ADDRESS_DETAIL.VALID_UNTIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPostcode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPermanentAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getPrimaryNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getHomeNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getCountryFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getPresentAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value12() {
        return getValidUntil();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value1(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value2(String value) {
        setPostcode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value3(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value4(String value) {
        setRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value6(String value) {
        setPermanentAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value7(Long value) {
        setPrimaryNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value8(Long value) {
        setHomeNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value9(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value10(Long value) {
        setCountryFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value11(String value) {
        setPresentAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord value12(Timestamp value) {
        setValidUntil(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressDetailRecord values(String value1, String value2, String value3, String value4, Long value5, String value6, Long value7, Long value8, String value9, Long value10, String value11, Timestamp value12) {
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
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressDetailRecord
     */
    public AddressDetailRecord() {
        super(AddressDetail.ADDRESS_DETAIL);
    }

    /**
     * Create a detached, initialised AddressDetailRecord
     */
    public AddressDetailRecord(String city, String postcode, String address, String region, Long id, String permanentAddress, Long primaryNumber, Long homeNumber, String email, Long countryFk, String presentAddress, Timestamp validUntil) {
        super(AddressDetail.ADDRESS_DETAIL);

        set(0, city);
        set(1, postcode);
        set(2, address);
        set(3, region);
        set(4, id);
        set(5, permanentAddress);
        set(6, primaryNumber);
        set(7, homeNumber);
        set(8, email);
        set(9, countryFk);
        set(10, presentAddress);
        set(11, validUntil);
    }
}
