/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.impl.TableImpl;

import schemas.public_.Public;
import schemas.public_.tables.records.UploadDocumentRecord;


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
public class UploadDocument extends TableImpl<UploadDocumentRecord> {

    private static final long serialVersionUID = -886389287;

    /**
     * The reference instance of <code>public.upload_document</code>
     */
    public static final UploadDocument UPLOAD_DOCUMENT = new UploadDocument();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UploadDocumentRecord> getRecordType() {
        return UploadDocumentRecord.class;
    }

    /**
     * Create a <code>public.upload_document</code> table reference
     */
    public UploadDocument() {
        this("upload_document", null);
    }

    /**
     * Create an aliased <code>public.upload_document</code> table reference
     */
    public UploadDocument(String alias) {
        this(alias, UPLOAD_DOCUMENT);
    }

    private UploadDocument(String alias, Table<UploadDocumentRecord> aliased) {
        this(alias, aliased, null);
    }

    private UploadDocument(String alias, Table<UploadDocumentRecord> aliased, Field<?>[] parameters) {
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
    public UploadDocument as(String alias) {
        return new UploadDocument(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UploadDocument rename(String name) {
        return new UploadDocument(name, null);
    }
}
