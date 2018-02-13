/*
 * This file is generated by jOOQ.
*/
package schemas.public_;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import schemas.public_.tables.AboutInstitution;
import schemas.public_.tables.AcademicQualification;
import schemas.public_.tables.AccountProfile;
import schemas.public_.tables.AdditionalInfo;
import schemas.public_.tables.AddressDetail;
import schemas.public_.tables.Annoucement;
import schemas.public_.tables.Application;
import schemas.public_.tables.ApplicationDetail;
import schemas.public_.tables.Assignment;
import schemas.public_.tables.BankAccount;
import schemas.public_.tables.Batch;
import schemas.public_.tables.Classe;
import schemas.public_.tables.ContactDetail;
import schemas.public_.tables.Course;
import schemas.public_.tables.Department;
import schemas.public_.tables.DwDimensions;
import schemas.public_.tables.EducationalDetail;
import schemas.public_.tables.EmergencyContact;
import schemas.public_.tables.EqualityData;
import schemas.public_.tables.Event;
import schemas.public_.tables.Experience;
import schemas.public_.tables.Finance;
import schemas.public_.tables.HomeAddress;
import schemas.public_.tables.InformationStatistic;
import schemas.public_.tables.Institution;
import schemas.public_.tables.Institutionregistration;
import schemas.public_.tables.Lecturer;
import schemas.public_.tables.Module;
import schemas.public_.tables.Nationality;
import schemas.public_.tables.NationalityDetail;
import schemas.public_.tables.Note;
import schemas.public_.tables.ParentInfo;
import schemas.public_.tables.PassportDetail;
import schemas.public_.tables.PersonalDetail;
import schemas.public_.tables.ProfileInfo;
import schemas.public_.tables.ReferenceDetail;
import schemas.public_.tables.StudentDetail;
import schemas.public_.tables.Syllabus;
import schemas.public_.tables.VisaDetail;
import schemas.public_.tables.records.AboutInstitutionRecord;
import schemas.public_.tables.records.AcademicQualificationRecord;
import schemas.public_.tables.records.AccountProfileRecord;
import schemas.public_.tables.records.AdditionalInfoRecord;
import schemas.public_.tables.records.AddressDetailRecord;
import schemas.public_.tables.records.AnnoucementRecord;
import schemas.public_.tables.records.ApplicationDetailRecord;
import schemas.public_.tables.records.ApplicationRecord;
import schemas.public_.tables.records.AssignmentRecord;
import schemas.public_.tables.records.BankAccountRecord;
import schemas.public_.tables.records.BatchRecord;
import schemas.public_.tables.records.ClasseRecord;
import schemas.public_.tables.records.ContactDetailRecord;
import schemas.public_.tables.records.CourseRecord;
import schemas.public_.tables.records.DepartmentRecord;
import schemas.public_.tables.records.DwDimensionsRecord;
import schemas.public_.tables.records.EducationalDetailRecord;
import schemas.public_.tables.records.EmergencyContactRecord;
import schemas.public_.tables.records.EqualityDataRecord;
import schemas.public_.tables.records.EventRecord;
import schemas.public_.tables.records.ExperienceRecord;
import schemas.public_.tables.records.FinanceRecord;
import schemas.public_.tables.records.HomeAddressRecord;
import schemas.public_.tables.records.InformationStatisticRecord;
import schemas.public_.tables.records.InstitutionRecord;
import schemas.public_.tables.records.InstitutionregistrationRecord;
import schemas.public_.tables.records.LecturerRecord;
import schemas.public_.tables.records.ModuleRecord;
import schemas.public_.tables.records.NationalityDetailRecord;
import schemas.public_.tables.records.NationalityRecord;
import schemas.public_.tables.records.NoteRecord;
import schemas.public_.tables.records.ParentInfoRecord;
import schemas.public_.tables.records.PassportDetailRecord;
import schemas.public_.tables.records.PersonalDetailRecord;
import schemas.public_.tables.records.ProfileInfoRecord;
import schemas.public_.tables.records.ReferenceDetailRecord;
import schemas.public_.tables.records.StudentDetailRecord;
import schemas.public_.tables.records.SyllabusRecord;
import schemas.public_.tables.records.VisaDetailRecord;


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

    public static final Identity<AboutInstitutionRecord, Long> IDENTITY_ABOUT_INSTITUTION = Identities0.IDENTITY_ABOUT_INSTITUTION;
    public static final Identity<AdditionalInfoRecord, Long> IDENTITY_ADDITIONAL_INFO = Identities0.IDENTITY_ADDITIONAL_INFO;
    public static final Identity<AddressDetailRecord, Long> IDENTITY_ADDRESS_DETAIL = Identities0.IDENTITY_ADDRESS_DETAIL;
    public static final Identity<AssignmentRecord, Long> IDENTITY_ASSIGNMENT = Identities0.IDENTITY_ASSIGNMENT;
    public static final Identity<BatchRecord, Long> IDENTITY_BATCH = Identities0.IDENTITY_BATCH;
    public static final Identity<ClasseRecord, Long> IDENTITY_CLASSE = Identities0.IDENTITY_CLASSE;
    public static final Identity<ContactDetailRecord, Long> IDENTITY_CONTACT_DETAIL = Identities0.IDENTITY_CONTACT_DETAIL;
    public static final Identity<CourseRecord, Long> IDENTITY_COURSE = Identities0.IDENTITY_COURSE;
    public static final Identity<EducationalDetailRecord, Long> IDENTITY_EDUCATIONAL_DETAIL = Identities0.IDENTITY_EDUCATIONAL_DETAIL;
    public static final Identity<EmergencyContactRecord, Long> IDENTITY_EMERGENCY_CONTACT = Identities0.IDENTITY_EMERGENCY_CONTACT;
    public static final Identity<NationalityDetailRecord, Long> IDENTITY_NATIONALITY_DETAIL = Identities0.IDENTITY_NATIONALITY_DETAIL;
    public static final Identity<PassportDetailRecord, Long> IDENTITY_PASSPORT_DETAIL = Identities0.IDENTITY_PASSPORT_DETAIL;
    public static final Identity<StudentDetailRecord, Long> IDENTITY_STUDENT_DETAIL = Identities0.IDENTITY_STUDENT_DETAIL;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AboutInstitutionRecord> ABOUT_INSTITUTION_PK_ID = UniqueKeys0.ABOUT_INSTITUTION_PK_ID;
    public static final UniqueKey<AcademicQualificationRecord> ACADEMIC_QUALIFICATION_PKEY = UniqueKeys0.ACADEMIC_QUALIFICATION_PKEY;
    public static final UniqueKey<AccountProfileRecord> ACCOUNT_PROFILE_PKEY = UniqueKeys0.ACCOUNT_PROFILE_PKEY;
    public static final UniqueKey<AdditionalInfoRecord> ADDTIONAL_INFO_PK = UniqueKeys0.ADDTIONAL_INFO_PK;
    public static final UniqueKey<AddressDetailRecord> ADDRESS_PK = UniqueKeys0.ADDRESS_PK;
    public static final UniqueKey<AnnoucementRecord> ANNOUCEMENT_PKEY = UniqueKeys0.ANNOUCEMENT_PKEY;
    public static final UniqueKey<ApplicationRecord> APPLICATION_PKEY = UniqueKeys0.APPLICATION_PKEY;
    public static final UniqueKey<ApplicationDetailRecord> APPLICATION_DETAIL_PKEY = UniqueKeys0.APPLICATION_DETAIL_PKEY;
    public static final UniqueKey<AssignmentRecord> ASSIGNMENT_PK = UniqueKeys0.ASSIGNMENT_PK;
    public static final UniqueKey<BankAccountRecord> BANK_ACCOUNT_PKEY = UniqueKeys0.BANK_ACCOUNT_PKEY;
    public static final UniqueKey<BatchRecord> BATCH_PK = UniqueKeys0.BATCH_PK;
    public static final UniqueKey<ClasseRecord> CLASSE_PK = UniqueKeys0.CLASSE_PK;
    public static final UniqueKey<ContactDetailRecord> CONTACT_DETAIL_PK = UniqueKeys0.CONTACT_DETAIL_PK;
    public static final UniqueKey<CourseRecord> COURSE_PK = UniqueKeys0.COURSE_PK;
    public static final UniqueKey<DepartmentRecord> DEPARTMENT_PKEY = UniqueKeys0.DEPARTMENT_PKEY;
    public static final UniqueKey<DwDimensionsRecord> DW_DIMENSIONS_PKEY = UniqueKeys0.DW_DIMENSIONS_PKEY;
    public static final UniqueKey<EducationalDetailRecord> EDUCATIONAL_DETAIL_PK = UniqueKeys0.EDUCATIONAL_DETAIL_PK;
    public static final UniqueKey<EmergencyContactRecord> EMERGENCY_CONTACT_PK = UniqueKeys0.EMERGENCY_CONTACT_PK;
    public static final UniqueKey<EqualityDataRecord> EQUALITY_DATA_PKEY = UniqueKeys0.EQUALITY_DATA_PKEY;
    public static final UniqueKey<EventRecord> EVENT_PKEY = UniqueKeys0.EVENT_PKEY;
    public static final UniqueKey<ExperienceRecord> EXPERIENCE_PKEY = UniqueKeys0.EXPERIENCE_PKEY;
    public static final UniqueKey<FinanceRecord> FINANCE_PKEY = UniqueKeys0.FINANCE_PKEY;
    public static final UniqueKey<HomeAddressRecord> HOME_ADDRESS_PKEY = UniqueKeys0.HOME_ADDRESS_PKEY;
    public static final UniqueKey<InformationStatisticRecord> INFORMATION_STATISTIC_PKEY = UniqueKeys0.INFORMATION_STATISTIC_PKEY;
    public static final UniqueKey<InstitutionRecord> INSTITUTION_PKEY = UniqueKeys0.INSTITUTION_PKEY;
    public static final UniqueKey<InstitutionregistrationRecord> INSTITUTIONREGISTRATION_PKEY = UniqueKeys0.INSTITUTIONREGISTRATION_PKEY;
    public static final UniqueKey<LecturerRecord> LECTURER_PKEY = UniqueKeys0.LECTURER_PKEY;
    public static final UniqueKey<ModuleRecord> MODULE_PKEY = UniqueKeys0.MODULE_PKEY;
    public static final UniqueKey<NationalityRecord> NATIONALITY_PKEY = UniqueKeys0.NATIONALITY_PKEY;
    public static final UniqueKey<NationalityDetailRecord> NATIONALITY_DETAIL_PK = UniqueKeys0.NATIONALITY_DETAIL_PK;
    public static final UniqueKey<NoteRecord> NOTE_PKEY = UniqueKeys0.NOTE_PKEY;
    public static final UniqueKey<ParentInfoRecord> PARENT_INFO_PKEY = UniqueKeys0.PARENT_INFO_PKEY;
    public static final UniqueKey<PassportDetailRecord> PASSPORT_DETAIL_PK = UniqueKeys0.PASSPORT_DETAIL_PK;
    public static final UniqueKey<PersonalDetailRecord> PERSONAL_DETAIL_PKEY = UniqueKeys0.PERSONAL_DETAIL_PKEY;
    public static final UniqueKey<ProfileInfoRecord> PROFILE_INFO_PKEY = UniqueKeys0.PROFILE_INFO_PKEY;
    public static final UniqueKey<ReferenceDetailRecord> REFERENCE_DETAIL_PKEY = UniqueKeys0.REFERENCE_DETAIL_PKEY;
    public static final UniqueKey<StudentDetailRecord> STUDENT_PK = UniqueKeys0.STUDENT_PK;
    public static final UniqueKey<SyllabusRecord> SYLLABUS_PKEY = UniqueKeys0.SYLLABUS_PKEY;
    public static final UniqueKey<VisaDetailRecord> VISA_DETAIL_PKEY = UniqueKeys0.VISA_DETAIL_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ApplicationRecord, CourseRecord> APPLICATION__FKRK3CWVBYTQ5JOFLCGGYWT626H = ForeignKeys0.APPLICATION__FKRK3CWVBYTQ5JOFLCGGYWT626H;
    public static final ForeignKey<ApplicationRecord, StudentDetailRecord> APPLICATION__FKCVV4YY9T46FTI1B0QVP70OD0H = ForeignKeys0.APPLICATION__FKCVV4YY9T46FTI1B0QVP70OD0H;
    public static final ForeignKey<BankAccountRecord, StudentDetailRecord> BANK_ACCOUNT__FK70TBNLF24EOLTV2UGSWCOAYDF = ForeignKeys0.BANK_ACCOUNT__FK70TBNLF24EOLTV2UGSWCOAYDF;
    public static final ForeignKey<ParentInfoRecord, StudentDetailRecord> PARENT_INFO__FK30EM3QY0X7NF6AFKDTJGGO0JT = ForeignKeys0.PARENT_INFO__FK30EM3QY0X7NF6AFKDTJGGO0JT;
    public static final ForeignKey<ProfileInfoRecord, StudentDetailRecord> PROFILE_INFO__FKQA2S3NWBQ3LLRF3GFQ328IAIQ = ForeignKeys0.PROFILE_INFO__FKQA2S3NWBQ3LLRF3GFQ328IAIQ;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<AboutInstitutionRecord, Long> IDENTITY_ABOUT_INSTITUTION = createIdentity(AboutInstitution.ABOUT_INSTITUTION, AboutInstitution.ABOUT_INSTITUTION.ID);
        public static Identity<AdditionalInfoRecord, Long> IDENTITY_ADDITIONAL_INFO = createIdentity(AdditionalInfo.ADDITIONAL_INFO, AdditionalInfo.ADDITIONAL_INFO.ID);
        public static Identity<AddressDetailRecord, Long> IDENTITY_ADDRESS_DETAIL = createIdentity(AddressDetail.ADDRESS_DETAIL, AddressDetail.ADDRESS_DETAIL.ID);
        public static Identity<AssignmentRecord, Long> IDENTITY_ASSIGNMENT = createIdentity(Assignment.ASSIGNMENT, Assignment.ASSIGNMENT.ID);
        public static Identity<BatchRecord, Long> IDENTITY_BATCH = createIdentity(Batch.BATCH, Batch.BATCH.ID);
        public static Identity<ClasseRecord, Long> IDENTITY_CLASSE = createIdentity(Classe.CLASSE, Classe.CLASSE.ID);
        public static Identity<ContactDetailRecord, Long> IDENTITY_CONTACT_DETAIL = createIdentity(ContactDetail.CONTACT_DETAIL, ContactDetail.CONTACT_DETAIL.ID);
        public static Identity<CourseRecord, Long> IDENTITY_COURSE = createIdentity(Course.COURSE, Course.COURSE.ID);
        public static Identity<EducationalDetailRecord, Long> IDENTITY_EDUCATIONAL_DETAIL = createIdentity(EducationalDetail.EDUCATIONAL_DETAIL, EducationalDetail.EDUCATIONAL_DETAIL.ID);
        public static Identity<EmergencyContactRecord, Long> IDENTITY_EMERGENCY_CONTACT = createIdentity(EmergencyContact.EMERGENCY_CONTACT, EmergencyContact.EMERGENCY_CONTACT.ID);
        public static Identity<NationalityDetailRecord, Long> IDENTITY_NATIONALITY_DETAIL = createIdentity(NationalityDetail.NATIONALITY_DETAIL, NationalityDetail.NATIONALITY_DETAIL.ID);
        public static Identity<PassportDetailRecord, Long> IDENTITY_PASSPORT_DETAIL = createIdentity(PassportDetail.PASSPORT_DETAIL, PassportDetail.PASSPORT_DETAIL.ID);
        public static Identity<StudentDetailRecord, Long> IDENTITY_STUDENT_DETAIL = createIdentity(StudentDetail.STUDENT_DETAIL, StudentDetail.STUDENT_DETAIL.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AboutInstitutionRecord> ABOUT_INSTITUTION_PK_ID = createUniqueKey(AboutInstitution.ABOUT_INSTITUTION, "about_institution_pk_id", AboutInstitution.ABOUT_INSTITUTION.ID);
        public static final UniqueKey<AcademicQualificationRecord> ACADEMIC_QUALIFICATION_PKEY = createUniqueKey(AcademicQualification.ACADEMIC_QUALIFICATION, "academic_qualification_pkey", AcademicQualification.ACADEMIC_QUALIFICATION.ID);
        public static final UniqueKey<AccountProfileRecord> ACCOUNT_PROFILE_PKEY = createUniqueKey(AccountProfile.ACCOUNT_PROFILE, "account_profile_pkey", AccountProfile.ACCOUNT_PROFILE.ID);
        public static final UniqueKey<AdditionalInfoRecord> ADDTIONAL_INFO_PK = createUniqueKey(AdditionalInfo.ADDITIONAL_INFO, "addtional_info_pk", AdditionalInfo.ADDITIONAL_INFO.ID);
        public static final UniqueKey<AddressDetailRecord> ADDRESS_PK = createUniqueKey(AddressDetail.ADDRESS_DETAIL, "address_pk", AddressDetail.ADDRESS_DETAIL.ID);
        public static final UniqueKey<AnnoucementRecord> ANNOUCEMENT_PKEY = createUniqueKey(Annoucement.ANNOUCEMENT, "annoucement_pkey", Annoucement.ANNOUCEMENT.ID);
        public static final UniqueKey<ApplicationRecord> APPLICATION_PKEY = createUniqueKey(Application.APPLICATION, "application_pkey", Application.APPLICATION.ID);
        public static final UniqueKey<ApplicationDetailRecord> APPLICATION_DETAIL_PKEY = createUniqueKey(ApplicationDetail.APPLICATION_DETAIL, "application_detail_pkey", ApplicationDetail.APPLICATION_DETAIL.ID);
        public static final UniqueKey<AssignmentRecord> ASSIGNMENT_PK = createUniqueKey(Assignment.ASSIGNMENT, "assignment_pk", Assignment.ASSIGNMENT.ID);
        public static final UniqueKey<BankAccountRecord> BANK_ACCOUNT_PKEY = createUniqueKey(BankAccount.BANK_ACCOUNT, "bank_account_pkey", BankAccount.BANK_ACCOUNT.ID);
        public static final UniqueKey<BatchRecord> BATCH_PK = createUniqueKey(Batch.BATCH, "batch_pk", Batch.BATCH.ID);
        public static final UniqueKey<ClasseRecord> CLASSE_PK = createUniqueKey(Classe.CLASSE, "classe_pk", Classe.CLASSE.ID);
        public static final UniqueKey<ContactDetailRecord> CONTACT_DETAIL_PK = createUniqueKey(ContactDetail.CONTACT_DETAIL, "contact_detail_pk", ContactDetail.CONTACT_DETAIL.ID);
        public static final UniqueKey<CourseRecord> COURSE_PK = createUniqueKey(Course.COURSE, "course_pk", Course.COURSE.ID);
        public static final UniqueKey<DepartmentRecord> DEPARTMENT_PKEY = createUniqueKey(Department.DEPARTMENT, "department_pkey", Department.DEPARTMENT.ID);
        public static final UniqueKey<DwDimensionsRecord> DW_DIMENSIONS_PKEY = createUniqueKey(DwDimensions.DW_DIMENSIONS, "dw_dimensions_pkey", DwDimensions.DW_DIMENSIONS.ID);
        public static final UniqueKey<EducationalDetailRecord> EDUCATIONAL_DETAIL_PK = createUniqueKey(EducationalDetail.EDUCATIONAL_DETAIL, "educational_detail_pk", EducationalDetail.EDUCATIONAL_DETAIL.ID);
        public static final UniqueKey<EmergencyContactRecord> EMERGENCY_CONTACT_PK = createUniqueKey(EmergencyContact.EMERGENCY_CONTACT, "emergency_contact_pk", EmergencyContact.EMERGENCY_CONTACT.ID);
        public static final UniqueKey<EqualityDataRecord> EQUALITY_DATA_PKEY = createUniqueKey(EqualityData.EQUALITY_DATA, "equality_data_pkey", EqualityData.EQUALITY_DATA.ID);
        public static final UniqueKey<EventRecord> EVENT_PKEY = createUniqueKey(Event.EVENT, "event_pkey", Event.EVENT.ID);
        public static final UniqueKey<ExperienceRecord> EXPERIENCE_PKEY = createUniqueKey(Experience.EXPERIENCE, "experience_pkey", Experience.EXPERIENCE.ID);
        public static final UniqueKey<FinanceRecord> FINANCE_PKEY = createUniqueKey(Finance.FINANCE, "finance_pkey", Finance.FINANCE.ID);
        public static final UniqueKey<HomeAddressRecord> HOME_ADDRESS_PKEY = createUniqueKey(HomeAddress.HOME_ADDRESS, "home_address_pkey", HomeAddress.HOME_ADDRESS.ID);
        public static final UniqueKey<InformationStatisticRecord> INFORMATION_STATISTIC_PKEY = createUniqueKey(InformationStatistic.INFORMATION_STATISTIC, "information_statistic_pkey", InformationStatistic.INFORMATION_STATISTIC.ID);
        public static final UniqueKey<InstitutionRecord> INSTITUTION_PKEY = createUniqueKey(Institution.INSTITUTION, "institution_pkey", Institution.INSTITUTION.ID);
        public static final UniqueKey<InstitutionregistrationRecord> INSTITUTIONREGISTRATION_PKEY = createUniqueKey(Institutionregistration.INSTITUTIONREGISTRATION, "institutionregistration_pkey", Institutionregistration.INSTITUTIONREGISTRATION.ID);
        public static final UniqueKey<LecturerRecord> LECTURER_PKEY = createUniqueKey(Lecturer.LECTURER, "lecturer_pkey", Lecturer.LECTURER.ID);
        public static final UniqueKey<ModuleRecord> MODULE_PKEY = createUniqueKey(Module.MODULE, "module_pkey", Module.MODULE.ID);
        public static final UniqueKey<NationalityRecord> NATIONALITY_PKEY = createUniqueKey(Nationality.NATIONALITY, "nationality_pkey", Nationality.NATIONALITY.ID);
        public static final UniqueKey<NationalityDetailRecord> NATIONALITY_DETAIL_PK = createUniqueKey(NationalityDetail.NATIONALITY_DETAIL, "nationality_detail_pk", NationalityDetail.NATIONALITY_DETAIL.ID);
        public static final UniqueKey<NoteRecord> NOTE_PKEY = createUniqueKey(Note.NOTE, "note_pkey", Note.NOTE.ID);
        public static final UniqueKey<ParentInfoRecord> PARENT_INFO_PKEY = createUniqueKey(ParentInfo.PARENT_INFO, "parent_info_pkey", ParentInfo.PARENT_INFO.ID);
        public static final UniqueKey<PassportDetailRecord> PASSPORT_DETAIL_PK = createUniqueKey(PassportDetail.PASSPORT_DETAIL, "passport_detail_pk", PassportDetail.PASSPORT_DETAIL.ID);
        public static final UniqueKey<PersonalDetailRecord> PERSONAL_DETAIL_PKEY = createUniqueKey(PersonalDetail.PERSONAL_DETAIL, "personal_detail_pkey", PersonalDetail.PERSONAL_DETAIL.ID);
        public static final UniqueKey<ProfileInfoRecord> PROFILE_INFO_PKEY = createUniqueKey(ProfileInfo.PROFILE_INFO, "profile_info_pkey", ProfileInfo.PROFILE_INFO.ID);
        public static final UniqueKey<ReferenceDetailRecord> REFERENCE_DETAIL_PKEY = createUniqueKey(ReferenceDetail.REFERENCE_DETAIL, "reference_detail_pkey", ReferenceDetail.REFERENCE_DETAIL.ID);
        public static final UniqueKey<StudentDetailRecord> STUDENT_PK = createUniqueKey(StudentDetail.STUDENT_DETAIL, "student_pk", StudentDetail.STUDENT_DETAIL.ID);
        public static final UniqueKey<SyllabusRecord> SYLLABUS_PKEY = createUniqueKey(Syllabus.SYLLABUS, "syllabus_pkey", Syllabus.SYLLABUS.ID);
        public static final UniqueKey<VisaDetailRecord> VISA_DETAIL_PKEY = createUniqueKey(VisaDetail.VISA_DETAIL, "visa_detail_pkey", VisaDetail.VISA_DETAIL.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<ApplicationRecord, CourseRecord> APPLICATION__FKRK3CWVBYTQ5JOFLCGGYWT626H = createForeignKey(schemas.public_.Keys.COURSE_PK, Application.APPLICATION, "application__fkrk3cwvbytq5joflcggywt626h", Application.APPLICATION.COURSE_FK);
        public static final ForeignKey<ApplicationRecord, StudentDetailRecord> APPLICATION__FKCVV4YY9T46FTI1B0QVP70OD0H = createForeignKey(schemas.public_.Keys.STUDENT_PK, Application.APPLICATION, "application__fkcvv4yy9t46fti1b0qvp70od0h", Application.APPLICATION.STUDENT_FK);
        public static final ForeignKey<BankAccountRecord, StudentDetailRecord> BANK_ACCOUNT__FK70TBNLF24EOLTV2UGSWCOAYDF = createForeignKey(schemas.public_.Keys.STUDENT_PK, BankAccount.BANK_ACCOUNT, "bank_account__fk70tbnlf24eoltv2ugswcoaydf", BankAccount.BANK_ACCOUNT.STUDENT_ID);
        public static final ForeignKey<ParentInfoRecord, StudentDetailRecord> PARENT_INFO__FK30EM3QY0X7NF6AFKDTJGGO0JT = createForeignKey(schemas.public_.Keys.STUDENT_PK, ParentInfo.PARENT_INFO, "parent_info__fk30em3qy0x7nf6afkdtjggo0jt", ParentInfo.PARENT_INFO.STUDENT_FK);
        public static final ForeignKey<ProfileInfoRecord, StudentDetailRecord> PROFILE_INFO__FKQA2S3NWBQ3LLRF3GFQ328IAIQ = createForeignKey(schemas.public_.Keys.STUDENT_PK, ProfileInfo.PROFILE_INFO, "profile_info__fkqa2s3nwbq3llrf3gfq328iaiq", ProfileInfo.PROFILE_INFO.STUDENT_FK);
    }
}
