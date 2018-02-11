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

import schemas.public_.tables.HomeAddress;


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
public class HomeAddressRecord extends UpdatableRecordImpl<HomeAddressRecord> implements Record7<Long, String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = -230012739;

    /**
     * Setter for <code>public.home_address.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.home_address.id</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.home_address.city</code>.
     */
    public void setCity(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.home_address.city</code>.
     */
    @Size(max = 255)
    public String getCity() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.home_address.contact_address</code>.
     */
    public void setContactAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.home_address.contact_address</code>.
     */
    @Size(max = 255)
    public String getContactAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.home_address.country</code>.
     */
    public void setCountry(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.home_address.country</code>.
     */
    @Size(max = 255)
    public String getCountry() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.home_address.postcode</code>.
     */
    public void setPostcode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.home_address.postcode</code>.
     */
    @Size(max = 255)
    public String getPostcode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.home_address.region</code>.
     */
    public void setRegion(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.home_address.region</code>.
     */
    @Size(max = 255)
    public String getRegion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.home_address.valid_until</code>.
     */
    public void setValidUntil(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.home_address.valid_until</code>.
     */
    public Timestamp getValidUntil() {
        return (Timestamp) get(6);
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
    public Row7<Long, String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, String, String, String, Timestamp> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return HomeAddress.HOME_ADDRESS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return HomeAddress.HOME_ADDRESS.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return HomeAddress.HOME_ADDRESS.CONTACT_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return HomeAddress.HOME_ADDRESS.COUNTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return HomeAddress.HOME_ADDRESS.POSTCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return HomeAddress.HOME_ADDRESS.REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return HomeAddress.HOME_ADDRESS.VALID_UNTIL;
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
    public String value2() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getContactAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPostcode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getValidUntil();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value2(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value3(String value) {
        setContactAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value4(String value) {
        setCountry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value5(String value) {
        setPostcode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value6(String value) {
        setRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord value7(Timestamp value) {
        setValidUntil(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeAddressRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Timestamp value7) {
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
     * Create a detached HomeAddressRecord
     */
    public HomeAddressRecord() {
        super(HomeAddress.HOME_ADDRESS);
    }

    /**
     * Create a detached, initialised HomeAddressRecord
     */
    public HomeAddressRecord(Long id, String city, String contactAddress, String country, String postcode, String region, Timestamp validUntil) {
        super(HomeAddress.HOME_ADDRESS);

        set(0, id);
        set(1, city);
        set(2, contactAddress);
        set(3, country);
        set(4, postcode);
        set(5, region);
        set(6, validUntil);
    }
}
