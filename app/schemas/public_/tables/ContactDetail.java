/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables;


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
import schemas.public_.tables.records.ContactDetailRecord;


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
public class ContactDetail extends TableImpl<ContactDetailRecord> {

    private static final long serialVersionUID = 398851582;

    /**
     * The reference instance of <code>public.contact_detail</code>
     */
    public static final ContactDetail CONTACT_DETAIL = new ContactDetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ContactDetailRecord> getRecordType() {
        return ContactDetailRecord.class;
    }

    /**
     * The column <code>public.contact_detail.email</code>.
     */
    public final TableField<ContactDetailRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.ermergency_address</code>.
     */
    public final TableField<ContactDetailRecord, String> ERMERGENCY_ADDRESS = createField("ermergency_address", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.ermergency_name</code>.
     */
    public final TableField<ContactDetailRecord, String> ERMERGENCY_NAME = createField("ermergency_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.ermergency_relation</code>.
     */
    public final TableField<ContactDetailRecord, String> ERMERGENCY_RELATION = createField("ermergency_relation", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.ermergency_number</code>.
     */
    public final TableField<ContactDetailRecord, String> ERMERGENCY_NUMBER = createField("ermergency_number", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.primary_phoneno</code>.
     */
    public final TableField<ContactDetailRecord, Long> PRIMARY_PHONENO = createField("primary_phoneno", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.contact_detail.secondary_phoneno</code>.
     */
    public final TableField<ContactDetailRecord, Long> SECONDARY_PHONENO = createField("secondary_phoneno", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.contact_detail.skype_address</code>.
     */
    public final TableField<ContactDetailRecord, String> SKYPE_ADDRESS = createField("skype_address", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>public.contact_detail.id</code>.
     */
    public final TableField<ContactDetailRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.contact_detail</code> table reference
     */
    public ContactDetail() {
        this("contact_detail", null);
    }

    /**
     * Create an aliased <code>public.contact_detail</code> table reference
     */
    public ContactDetail(String alias) {
        this(alias, CONTACT_DETAIL);
    }

    private ContactDetail(String alias, Table<ContactDetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private ContactDetail(String alias, Table<ContactDetailRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ContactDetailRecord> getPrimaryKey() {
        return Keys.CONTACT_DETAIL_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ContactDetailRecord>> getKeys() {
        return Arrays.<UniqueKey<ContactDetailRecord>>asList(Keys.CONTACT_DETAIL_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContactDetail as(String alias) {
        return new ContactDetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ContactDetail rename(String name) {
        return new ContactDetail(name, null);
    }
}
