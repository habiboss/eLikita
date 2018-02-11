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
import org.jooq.Record21;
import org.jooq.Row21;
import org.jooq.impl.UpdatableRecordImpl;

import schemas.public_.tables.Institutionregistration;


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
public class InstitutionregistrationRecord extends UpdatableRecordImpl<InstitutionregistrationRecord> implements Record21<Long, String, String, String, String, String, String, String, String, String, Timestamp, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 684138983;

    /**
     * Setter for <code>public.institutionregistration.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.institutionregistration.id</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.institutionregistration.abn</code>.
     */
    public void setAbn(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.institutionregistration.abn</code>.
     */
    @Size(max = 255)
    public String getAbn() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.institutionregistration.address</code>.
     */
    public void setAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.institutionregistration.address</code>.
     */
    @Size(max = 255)
    public String getAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.institutionregistration.business_email</code>.
     */
    public void setBusinessEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.institutionregistration.business_email</code>.
     */
    @Size(max = 255)
    public String getBusinessEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.institutionregistration.business_name</code>.
     */
    public void setBusinessName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.institutionregistration.business_name</code>.
     */
    @Size(max = 255)
    public String getBusinessName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.institutionregistration.business_phone</code>.
     */
    public void setBusinessPhone(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.institutionregistration.business_phone</code>.
     */
    @Size(max = 255)
    public String getBusinessPhone() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.institutionregistration.business_size</code>.
     */
    public void setBusinessSize(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.institutionregistration.business_size</code>.
     */
    @Size(max = 255)
    public String getBusinessSize() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.institutionregistration.business_website</code>.
     */
    public void setBusinessWebsite(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.institutionregistration.business_website</code>.
     */
    @Size(max = 255)
    public String getBusinessWebsite() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.institutionregistration.city</code>.
     */
    public void setCity(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.institutionregistration.city</code>.
     */
    @Size(max = 255)
    public String getCity() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.institutionregistration.country</code>.
     */
    public void setCountry(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.institutionregistration.country</code>.
     */
    @Size(max = 255)
    public String getCountry() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.institutionregistration.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.institutionregistration.created</code>.
     */
    public Timestamp getCreated() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>public.institutionregistration.current_advertisement</code>.
     */
    public void setCurrentAdvertisement(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.institutionregistration.current_advertisement</code>.
     */
    @Size(max = 255)
    public String getCurrentAdvertisement() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.institutionregistration.email</code>.
     */
    public void setEmail(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.institutionregistration.email</code>.
     */
    @Size(max = 255)
    public String getEmail() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.institutionregistration.fax</code>.
     */
    public void setFax(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.institutionregistration.fax</code>.
     */
    @Size(max = 255)
    public String getFax() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.institutionregistration.first_name</code>.
     */
    public void setFirstName(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.institutionregistration.first_name</code>.
     */
    @Size(max = 255)
    public String getFirstName() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.institutionregistration.industry</code>.
     */
    public void setIndustry(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.institutionregistration.industry</code>.
     */
    @Size(max = 255)
    public String getIndustry() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.institutionregistration.last_name</code>.
     */
    public void setLastName(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.institutionregistration.last_name</code>.
     */
    @Size(max = 255)
    public String getLastName() {
        return (String) get(16);
    }

    /**
     * Setter for <code>public.institutionregistration.phone</code>.
     */
    public void setPhone(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.institutionregistration.phone</code>.
     */
    @Size(max = 255)
    public String getPhone() {
        return (String) get(17);
    }

    /**
     * Setter for <code>public.institutionregistration.postcode</code>.
     */
    public void setPostcode(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.institutionregistration.postcode</code>.
     */
    @Size(max = 255)
    public String getPostcode() {
        return (String) get(18);
    }

    /**
     * Setter for <code>public.institutionregistration.state</code>.
     */
    public void setState(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>public.institutionregistration.state</code>.
     */
    @Size(max = 255)
    public String getState() {
        return (String) get(19);
    }

    /**
     * Setter for <code>public.institutionregistration.status</code>.
     */
    public void setStatus(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>public.institutionregistration.status</code>.
     */
    @Size(max = 255)
    public String getStatus() {
        return (String) get(20);
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
    // Record21 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<Long, String, String, String, String, String, String, String, String, String, Timestamp, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row21) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row21<Long, String, String, String, String, String, String, String, String, String, Timestamp, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row21) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Institutionregistration.INSTITUTIONREGISTRATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Institutionregistration.INSTITUTIONREGISTRATION.ABN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Institutionregistration.INSTITUTIONREGISTRATION.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Institutionregistration.INSTITUTIONREGISTRATION.BUSINESS_EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Institutionregistration.INSTITUTIONREGISTRATION.BUSINESS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Institutionregistration.INSTITUTIONREGISTRATION.BUSINESS_PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Institutionregistration.INSTITUTIONREGISTRATION.BUSINESS_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Institutionregistration.INSTITUTIONREGISTRATION.BUSINESS_WEBSITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Institutionregistration.INSTITUTIONREGISTRATION.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Institutionregistration.INSTITUTIONREGISTRATION.COUNTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Institutionregistration.INSTITUTIONREGISTRATION.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Institutionregistration.INSTITUTIONREGISTRATION.CURRENT_ADVERTISEMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Institutionregistration.INSTITUTIONREGISTRATION.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Institutionregistration.INSTITUTIONREGISTRATION.FAX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return Institutionregistration.INSTITUTIONREGISTRATION.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return Institutionregistration.INSTITUTIONREGISTRATION.INDUSTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return Institutionregistration.INSTITUTIONREGISTRATION.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return Institutionregistration.INSTITUTIONREGISTRATION.PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field19() {
        return Institutionregistration.INSTITUTIONREGISTRATION.POSTCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field20() {
        return Institutionregistration.INSTITUTIONREGISTRATION.STATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field21() {
        return Institutionregistration.INSTITUTIONREGISTRATION.STATUS;
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
        return getAbn();
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
        return getBusinessEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBusinessName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getBusinessPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getBusinessSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getBusinessWebsite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getCurrentAdvertisement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getFax();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getIndustry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value19() {
        return getPostcode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value20() {
        return getState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value21() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value2(String value) {
        setAbn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value3(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value4(String value) {
        setBusinessEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value5(String value) {
        setBusinessName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value6(String value) {
        setBusinessPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value7(String value) {
        setBusinessSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value8(String value) {
        setBusinessWebsite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value9(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value10(String value) {
        setCountry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value11(Timestamp value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value12(String value) {
        setCurrentAdvertisement(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value13(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value14(String value) {
        setFax(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value15(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value16(String value) {
        setIndustry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value17(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value18(String value) {
        setPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value19(String value) {
        setPostcode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value20(String value) {
        setState(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord value21(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstitutionregistrationRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, Timestamp value11, String value12, String value13, String value14, String value15, String value16, String value17, String value18, String value19, String value20, String value21) {
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
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InstitutionregistrationRecord
     */
    public InstitutionregistrationRecord() {
        super(Institutionregistration.INSTITUTIONREGISTRATION);
    }

    /**
     * Create a detached, initialised InstitutionregistrationRecord
     */
    public InstitutionregistrationRecord(Long id, String abn, String address, String businessEmail, String businessName, String businessPhone, String businessSize, String businessWebsite, String city, String country, Timestamp created, String currentAdvertisement, String email, String fax, String firstName, String industry, String lastName, String phone, String postcode, String state, String status) {
        super(Institutionregistration.INSTITUTIONREGISTRATION);

        set(0, id);
        set(1, abn);
        set(2, address);
        set(3, businessEmail);
        set(4, businessName);
        set(5, businessPhone);
        set(6, businessSize);
        set(7, businessWebsite);
        set(8, city);
        set(9, country);
        set(10, created);
        set(11, currentAdvertisement);
        set(12, email);
        set(13, fax);
        set(14, firstName);
        set(15, industry);
        set(16, lastName);
        set(17, phone);
        set(18, postcode);
        set(19, state);
        set(20, status);
    }
}
