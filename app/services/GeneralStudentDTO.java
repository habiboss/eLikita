package services;

import java.sql.Timestamp;

public class GeneralStudentDTO {
	private Timestamp dateOfBirth;
    private String    title;
    private String    firstName;
    private String    lastName;
    private Long      personal_detail_id;
    private String    gender;
    private String    codeui;
    private String    status;
    private String    familyName;
    private String    middleName;
    private String    preferedName;
    ////////Address
    private String    city;
    private String    country;
    private String    postcode;
    private String    address_detail;
    private String    region;
    private String    studentFk_addr_detail;
    private String    permanentAddress;
    private String    presentAddress;
    private Timestamp validUntil;
    //////////Contact Address
    private String email_contact_detail;
    private String ermergencyAddress;
    private String ermergencyName;
    private String ermergencyRelation;
    private String ermergencyNumber;
    private Long   primaryPhoneno;
    private Long   secondaryPhoneno;
    private String skypeAddress;
    private String studentFk_contact_detail; 
    ///////////Emergency Contact
    private Long   phone;
    private Long   mobile;
    private String email;
    private Long   emergency_id;
    private String fullName;
    private String address;
    private String relationship;
    private String studentFk_emergency;
    ///////////Additional Info
    private Long   id;
    private String studentFk;
    private Long   disabilityFk;
    private Long   ethnicityFk;
    private Long   motherTongueFk;
    private Long   religionFk;
    private String criminalConviction;
}
