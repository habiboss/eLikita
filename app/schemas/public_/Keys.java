/*
 * This file is generated by jOOQ.
*/
package schemas.public_;


import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import schemas.public_.tables.AddressDetail;
import schemas.public_.tables.Address_;
import schemas.public_.tables.ApplicationUser;
import schemas.public_.tables.ContactDetail;
import schemas.public_.tables.Doctor_;
import schemas.public_.tables.MedicalCenter_;
import schemas.public_.tables.Patient_;
import schemas.public_.tables.RoUsers;
import schemas.public_.tables.records.AddressDetailRecord;
import schemas.public_.tables.records.Address_Record;
import schemas.public_.tables.records.ApplicationUserRecord;
import schemas.public_.tables.records.ContactDetailRecord;
import schemas.public_.tables.records.Doctor_Record;
import schemas.public_.tables.records.MedicalCenter_Record;
import schemas.public_.tables.records.Patient_Record;
import schemas.public_.tables.records.RoUsersRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>public</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<Address_Record, Long> IDENTITY_ADDRESS_ = Identities0.IDENTITY_ADDRESS_;
    public static final Identity<ApplicationUserRecord, Long> IDENTITY_APPLICATION_USER = Identities0.IDENTITY_APPLICATION_USER;
    public static final Identity<Doctor_Record, Long> IDENTITY_DOCTOR_ = Identities0.IDENTITY_DOCTOR_;
    public static final Identity<MedicalCenter_Record, Long> IDENTITY_MEDICAL_CENTER_ = Identities0.IDENTITY_MEDICAL_CENTER_;
    public static final Identity<Patient_Record, Long> IDENTITY_PATIENT_ = Identities0.IDENTITY_PATIENT_;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<Address_Record> ADDRESS__PKEY = UniqueKeys0.ADDRESS__PKEY;
    public static final UniqueKey<AddressDetailRecord> ADDRESS_PK = UniqueKeys0.ADDRESS_PK;
    public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_UQ = UniqueKeys0.APPLICATION_USER_UQ;
    public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_ID_PK = UniqueKeys0.APPLICATION_USER_ID_PK;
    public static final UniqueKey<ContactDetailRecord> CONTACT_DETAIL_PK = UniqueKeys0.CONTACT_DETAIL_PK;
    public static final UniqueKey<Doctor_Record> DOCTOR_PK = UniqueKeys0.DOCTOR_PK;
    public static final UniqueKey<MedicalCenter_Record> MEDICAL_CENTER_ID = UniqueKeys0.MEDICAL_CENTER_ID;
    public static final UniqueKey<Patient_Record> PATIENT__PKEY = UniqueKeys0.PATIENT__PKEY;
    public static final UniqueKey<RoUsersRecord> RO_USERS_PK = UniqueKeys0.RO_USERS_PK;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<Address_Record, Long> IDENTITY_ADDRESS_ = createIdentity(Address_.ADDRESS_, Address_.ADDRESS_.ID);
        public static Identity<ApplicationUserRecord, Long> IDENTITY_APPLICATION_USER = createIdentity(ApplicationUser.APPLICATION_USER, ApplicationUser.APPLICATION_USER.ID);
        public static Identity<Doctor_Record, Long> IDENTITY_DOCTOR_ = createIdentity(Doctor_.DOCTOR_, Doctor_.DOCTOR_.ID);
        public static Identity<MedicalCenter_Record, Long> IDENTITY_MEDICAL_CENTER_ = createIdentity(MedicalCenter_.MEDICAL_CENTER_, MedicalCenter_.MEDICAL_CENTER_.ID);
        public static Identity<Patient_Record, Long> IDENTITY_PATIENT_ = createIdentity(Patient_.PATIENT_, Patient_.PATIENT_.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<Address_Record> ADDRESS__PKEY = createUniqueKey(Address_.ADDRESS_, "address__pkey", Address_.ADDRESS_.ID);
        public static final UniqueKey<AddressDetailRecord> ADDRESS_PK = createUniqueKey(AddressDetail.ADDRESS_DETAIL, "address_pk", AddressDetail.ADDRESS_DETAIL.ID);
        public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_UQ = createUniqueKey(ApplicationUser.APPLICATION_USER, "application_user_uq", ApplicationUser.APPLICATION_USER.EMAIL);
        public static final UniqueKey<ApplicationUserRecord> APPLICATION_USER_ID_PK = createUniqueKey(ApplicationUser.APPLICATION_USER, "application_user_id_pk", ApplicationUser.APPLICATION_USER.ID);
        public static final UniqueKey<ContactDetailRecord> CONTACT_DETAIL_PK = createUniqueKey(ContactDetail.CONTACT_DETAIL, "contact_detail_pk", ContactDetail.CONTACT_DETAIL.ID);
        public static final UniqueKey<Doctor_Record> DOCTOR_PK = createUniqueKey(Doctor_.DOCTOR_, "doctor_pk", Doctor_.DOCTOR_.ID);
        public static final UniqueKey<MedicalCenter_Record> MEDICAL_CENTER_ID = createUniqueKey(MedicalCenter_.MEDICAL_CENTER_, "medical_center_id", MedicalCenter_.MEDICAL_CENTER_.ID);
        public static final UniqueKey<Patient_Record> PATIENT__PKEY = createUniqueKey(Patient_.PATIENT_, "patient__pkey", Patient_.PATIENT_.ID);
        public static final UniqueKey<RoUsersRecord> RO_USERS_PK = createUniqueKey(RoUsers.RO_USERS, "ro_users_pk", RoUsers.RO_USERS.ID);
    }
}
