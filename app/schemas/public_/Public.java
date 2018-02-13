/*
 * This file is generated by jOOQ.
*/
package schemas.public_;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import schemas.DefaultCatalog;
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
import schemas.public_.tables.UploadDocument;
import schemas.public_.tables.VisaDetail;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1710278816;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.about_institution</code>.
     */
    public final AboutInstitution ABOUT_INSTITUTION = schemas.public_.tables.AboutInstitution.ABOUT_INSTITUTION;

    /**
     * The table <code>public.academic_qualification</code>.
     */
    public final AcademicQualification ACADEMIC_QUALIFICATION = schemas.public_.tables.AcademicQualification.ACADEMIC_QUALIFICATION;

    /**
     * The table <code>public.account_profile</code>.
     */
    public final AccountProfile ACCOUNT_PROFILE = schemas.public_.tables.AccountProfile.ACCOUNT_PROFILE;

    /**
     * The table <code>public.additional_info</code>.
     */
    public final AdditionalInfo ADDITIONAL_INFO = schemas.public_.tables.AdditionalInfo.ADDITIONAL_INFO;

    /**
     * The table <code>public.address_detail</code>.
     */
    public final AddressDetail ADDRESS_DETAIL = schemas.public_.tables.AddressDetail.ADDRESS_DETAIL;

    /**
     * The table <code>public.annoucement</code>.
     */
    public final Annoucement ANNOUCEMENT = schemas.public_.tables.Annoucement.ANNOUCEMENT;

    /**
     * The table <code>public.application</code>.
     */
    public final Application APPLICATION = schemas.public_.tables.Application.APPLICATION;

    /**
     * The table <code>public.application_detail</code>.
     */
    public final ApplicationDetail APPLICATION_DETAIL = schemas.public_.tables.ApplicationDetail.APPLICATION_DETAIL;

    /**
     * The table <code>public.assignment</code>.
     */
    public final Assignment ASSIGNMENT = schemas.public_.tables.Assignment.ASSIGNMENT;

    /**
     * The table <code>public.bank_account</code>.
     */
    public final BankAccount BANK_ACCOUNT = schemas.public_.tables.BankAccount.BANK_ACCOUNT;

    /**
     * The table <code>public.batch</code>.
     */
    public final Batch BATCH = schemas.public_.tables.Batch.BATCH;

    /**
     * The table <code>public.classe</code>.
     */
    public final Classe CLASSE = schemas.public_.tables.Classe.CLASSE;

    /**
     * The table <code>public.contact_detail</code>.
     */
    public final ContactDetail CONTACT_DETAIL = schemas.public_.tables.ContactDetail.CONTACT_DETAIL;

    /**
     * The table <code>public.course</code>.
     */
    public final Course COURSE = schemas.public_.tables.Course.COURSE;

    /**
     * The table <code>public.department</code>.
     */
    public final Department DEPARTMENT = schemas.public_.tables.Department.DEPARTMENT;

    /**
     * The table <code>public.dw_dimensions</code>.
     */
    public final DwDimensions DW_DIMENSIONS = schemas.public_.tables.DwDimensions.DW_DIMENSIONS;

    /**
     * The table <code>public.educational_detail</code>.
     */
    public final EducationalDetail EDUCATIONAL_DETAIL = schemas.public_.tables.EducationalDetail.EDUCATIONAL_DETAIL;

    /**
     * The table <code>public.emergency_contact</code>.
     */
    public final EmergencyContact EMERGENCY_CONTACT = schemas.public_.tables.EmergencyContact.EMERGENCY_CONTACT;

    /**
     * The table <code>public.equality_data</code>.
     */
    public final EqualityData EQUALITY_DATA = schemas.public_.tables.EqualityData.EQUALITY_DATA;

    /**
     * The table <code>public.event</code>.
     */
    public final Event EVENT = schemas.public_.tables.Event.EVENT;

    /**
     * The table <code>public.experience</code>.
     */
    public final Experience EXPERIENCE = schemas.public_.tables.Experience.EXPERIENCE;

    /**
     * The table <code>public.finance</code>.
     */
    public final Finance FINANCE = schemas.public_.tables.Finance.FINANCE;

    /**
     * The table <code>public.home_address</code>.
     */
    public final HomeAddress HOME_ADDRESS = schemas.public_.tables.HomeAddress.HOME_ADDRESS;

    /**
     * The table <code>public.information_statistic</code>.
     */
    public final InformationStatistic INFORMATION_STATISTIC = schemas.public_.tables.InformationStatistic.INFORMATION_STATISTIC;

    /**
     * The table <code>public.institution</code>.
     */
    public final Institution INSTITUTION = schemas.public_.tables.Institution.INSTITUTION;

    /**
     * The table <code>public.institutionregistration</code>.
     */
    public final Institutionregistration INSTITUTIONREGISTRATION = schemas.public_.tables.Institutionregistration.INSTITUTIONREGISTRATION;

    /**
     * The table <code>public.lecturer</code>.
     */
    public final Lecturer LECTURER = schemas.public_.tables.Lecturer.LECTURER;

    /**
     * The table <code>public.module</code>.
     */
    public final Module MODULE = schemas.public_.tables.Module.MODULE;

    /**
     * The table <code>public.nationality</code>.
     */
    public final Nationality NATIONALITY = schemas.public_.tables.Nationality.NATIONALITY;

    /**
     * The table <code>public.nationality_detail</code>.
     */
    public final NationalityDetail NATIONALITY_DETAIL = schemas.public_.tables.NationalityDetail.NATIONALITY_DETAIL;

    /**
     * The table <code>public.note</code>.
     */
    public final Note NOTE = schemas.public_.tables.Note.NOTE;

    /**
     * The table <code>public.parent_info</code>.
     */
    public final ParentInfo PARENT_INFO = schemas.public_.tables.ParentInfo.PARENT_INFO;

    /**
     * The table <code>public.passport_detail</code>.
     */
    public final PassportDetail PASSPORT_DETAIL = schemas.public_.tables.PassportDetail.PASSPORT_DETAIL;

    /**
     * The table <code>public.personal_detail</code>.
     */
    public final PersonalDetail PERSONAL_DETAIL = schemas.public_.tables.PersonalDetail.PERSONAL_DETAIL;

    /**
     * The table <code>public.profile_info</code>.
     */
    public final ProfileInfo PROFILE_INFO = schemas.public_.tables.ProfileInfo.PROFILE_INFO;

    /**
     * The table <code>public.reference_detail</code>.
     */
    public final ReferenceDetail REFERENCE_DETAIL = schemas.public_.tables.ReferenceDetail.REFERENCE_DETAIL;

    /**
     * The table <code>public.student_detail</code>.
     */
    public final StudentDetail STUDENT_DETAIL = schemas.public_.tables.StudentDetail.STUDENT_DETAIL;

    /**
     * The table <code>public.syllabus</code>.
     */
    public final Syllabus SYLLABUS = schemas.public_.tables.Syllabus.SYLLABUS;

    /**
     * The table <code>public.upload_document</code>.
     */
    public final UploadDocument UPLOAD_DOCUMENT = schemas.public_.tables.UploadDocument.UPLOAD_DOCUMENT;

    /**
     * The table <code>public.visa_detail</code>.
     */
    public final VisaDetail VISA_DETAIL = schemas.public_.tables.VisaDetail.VISA_DETAIL;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.ABOUT_INSTITUTION_ID_SEQ,
            Sequences.ADDITIONAL_INFO_ID_SEQ,
            Sequences.ADDRESS_DETAIL_ID_SEQ,
            Sequences.ASSIGNMENT_ID_SEQ,
            Sequences.BATCH_ID_SEQ,
            Sequences.CLASSE_ID_SEQ,
            Sequences.CONTACT_DETAIL_ID_SEQ,
            Sequences.COURSE_ID_SEQ,
            Sequences.EDUCATIONAL_DETAIL_ID_SEQ,
            Sequences.EMERGENCY_CONTACT_ID_SEQ,
            Sequences.HIBERNATE_SEQUENCE,
            Sequences.NATIONALITY_DETAIL_ID_SEQ,
            Sequences.PASSPORT_DETAIL_ID_SEQ,
            Sequences.STUDENT_DETAIL_ID_SEQ,
            Sequences.STUDENT_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            AboutInstitution.ABOUT_INSTITUTION,
            AcademicQualification.ACADEMIC_QUALIFICATION,
            AccountProfile.ACCOUNT_PROFILE,
            AdditionalInfo.ADDITIONAL_INFO,
            AddressDetail.ADDRESS_DETAIL,
            Annoucement.ANNOUCEMENT,
            Application.APPLICATION,
            ApplicationDetail.APPLICATION_DETAIL,
            Assignment.ASSIGNMENT,
            BankAccount.BANK_ACCOUNT,
            Batch.BATCH,
            Classe.CLASSE,
            ContactDetail.CONTACT_DETAIL,
            Course.COURSE,
            Department.DEPARTMENT,
            DwDimensions.DW_DIMENSIONS,
            EducationalDetail.EDUCATIONAL_DETAIL,
            EmergencyContact.EMERGENCY_CONTACT,
            EqualityData.EQUALITY_DATA,
            Event.EVENT,
            Experience.EXPERIENCE,
            Finance.FINANCE,
            HomeAddress.HOME_ADDRESS,
            InformationStatistic.INFORMATION_STATISTIC,
            Institution.INSTITUTION,
            Institutionregistration.INSTITUTIONREGISTRATION,
            Lecturer.LECTURER,
            Module.MODULE,
            Nationality.NATIONALITY,
            NationalityDetail.NATIONALITY_DETAIL,
            Note.NOTE,
            ParentInfo.PARENT_INFO,
            PassportDetail.PASSPORT_DETAIL,
            PersonalDetail.PERSONAL_DETAIL,
            ProfileInfo.PROFILE_INFO,
            ReferenceDetail.REFERENCE_DETAIL,
            StudentDetail.STUDENT_DETAIL,
            Syllabus.SYLLABUS,
            UploadDocument.UPLOAD_DOCUMENT,
            VisaDetail.VISA_DETAIL);
    }
}
