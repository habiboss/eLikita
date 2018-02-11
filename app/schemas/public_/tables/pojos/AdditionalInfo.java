/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.Size;


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
public class AdditionalInfo implements Serializable {

    private static final long serialVersionUID = 1811113217;

    private Long   id;
    private String studentFk;
    private Long   disabilityFk;
    private Long   ethnicityFk;
    private Long   motherTongueFk;
    private Long   religionFk;
    private String criminalConviction;
    private String bringPartner;
    private String disability;
    private String ethnicity;

    public AdditionalInfo() {}

    public AdditionalInfo(AdditionalInfo value) {
        this.id = value.id;
        this.studentFk = value.studentFk;
        this.disabilityFk = value.disabilityFk;
        this.ethnicityFk = value.ethnicityFk;
        this.motherTongueFk = value.motherTongueFk;
        this.religionFk = value.religionFk;
        this.criminalConviction = value.criminalConviction;
        this.bringPartner = value.bringPartner;
        this.disability = value.disability;
        this.ethnicity = value.ethnicity;
    }

    public AdditionalInfo(
        Long   id,
        String studentFk,
        Long   disabilityFk,
        Long   ethnicityFk,
        Long   motherTongueFk,
        Long   religionFk,
        String criminalConviction,
        String bringPartner,
        String disability,
        String ethnicity
    ) {
        this.id = id;
        this.studentFk = studentFk;
        this.disabilityFk = disabilityFk;
        this.ethnicityFk = ethnicityFk;
        this.motherTongueFk = motherTongueFk;
        this.religionFk = religionFk;
        this.criminalConviction = criminalConviction;
        this.bringPartner = bringPartner;
        this.disability = disability;
        this.ethnicity = ethnicity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 50)
    public String getStudentFk() {
        return this.studentFk;
    }

    public void setStudentFk(String studentFk) {
        this.studentFk = studentFk;
    }

    public Long getDisabilityFk() {
        return this.disabilityFk;
    }

    public void setDisabilityFk(Long disabilityFk) {
        this.disabilityFk = disabilityFk;
    }

    public Long getEthnicityFk() {
        return this.ethnicityFk;
    }

    public void setEthnicityFk(Long ethnicityFk) {
        this.ethnicityFk = ethnicityFk;
    }

    public Long getMotherTongueFk() {
        return this.motherTongueFk;
    }

    public void setMotherTongueFk(Long motherTongueFk) {
        this.motherTongueFk = motherTongueFk;
    }

    public Long getReligionFk() {
        return this.religionFk;
    }

    public void setReligionFk(Long religionFk) {
        this.religionFk = religionFk;
    }

    @Size(max = 50)
    public String getCriminalConviction() {
        return this.criminalConviction;
    }

    public void setCriminalConviction(String criminalConviction) {
        this.criminalConviction = criminalConviction;
    }

    @Size(max = 255)
    public String getBringPartner() {
        return this.bringPartner;
    }

    public void setBringPartner(String bringPartner) {
        this.bringPartner = bringPartner;
    }

    @Size(max = 255)
    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    @Size(max = 255)
    public String getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AdditionalInfo (");

        sb.append(id);
        sb.append(", ").append(studentFk);
        sb.append(", ").append(disabilityFk);
        sb.append(", ").append(ethnicityFk);
        sb.append(", ").append(motherTongueFk);
        sb.append(", ").append(religionFk);
        sb.append(", ").append(criminalConviction);
        sb.append(", ").append(bringPartner);
        sb.append(", ").append(disability);
        sb.append(", ").append(ethnicity);

        sb.append(")");
        return sb.toString();
    }
}
