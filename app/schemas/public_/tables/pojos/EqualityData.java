/*
 * This file is generated by jOOQ.
*/
package schemas.public_.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
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
public class EqualityData implements Serializable {

    private static final long serialVersionUID = 695490782;

    private Long   id;
    private String countryBirth;
    private String ethnicOrigin;
    private String learningDisabilities;
    private String occupation;
    private String originalGender;
    private String religion;
    private String sexualOrientation;
    private String socioEconomicClassification;

    public EqualityData() {}

    public EqualityData(EqualityData value) {
        this.id = value.id;
        this.countryBirth = value.countryBirth;
        this.ethnicOrigin = value.ethnicOrigin;
        this.learningDisabilities = value.learningDisabilities;
        this.occupation = value.occupation;
        this.originalGender = value.originalGender;
        this.religion = value.religion;
        this.sexualOrientation = value.sexualOrientation;
        this.socioEconomicClassification = value.socioEconomicClassification;
    }

    public EqualityData(
        Long   id,
        String countryBirth,
        String ethnicOrigin,
        String learningDisabilities,
        String occupation,
        String originalGender,
        String religion,
        String sexualOrientation,
        String socioEconomicClassification
    ) {
        this.id = id;
        this.countryBirth = countryBirth;
        this.ethnicOrigin = ethnicOrigin;
        this.learningDisabilities = learningDisabilities;
        this.occupation = occupation;
        this.originalGender = originalGender;
        this.religion = religion;
        this.sexualOrientation = sexualOrientation;
        this.socioEconomicClassification = socioEconomicClassification;
    }

    @NotNull
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 255)
    public String getCountryBirth() {
        return this.countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    @Size(max = 255)
    public String getEthnicOrigin() {
        return this.ethnicOrigin;
    }

    public void setEthnicOrigin(String ethnicOrigin) {
        this.ethnicOrigin = ethnicOrigin;
    }

    @Size(max = 255)
    public String getLearningDisabilities() {
        return this.learningDisabilities;
    }

    public void setLearningDisabilities(String learningDisabilities) {
        this.learningDisabilities = learningDisabilities;
    }

    @Size(max = 255)
    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Size(max = 255)
    public String getOriginalGender() {
        return this.originalGender;
    }

    public void setOriginalGender(String originalGender) {
        this.originalGender = originalGender;
    }

    @Size(max = 255)
    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Size(max = 255)
    public String getSexualOrientation() {
        return this.sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    @Size(max = 255)
    public String getSocioEconomicClassification() {
        return this.socioEconomicClassification;
    }

    public void setSocioEconomicClassification(String socioEconomicClassification) {
        this.socioEconomicClassification = socioEconomicClassification;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EqualityData (");

        sb.append(id);
        sb.append(", ").append(countryBirth);
        sb.append(", ").append(ethnicOrigin);
        sb.append(", ").append(learningDisabilities);
        sb.append(", ").append(occupation);
        sb.append(", ").append(originalGender);
        sb.append(", ").append(religion);
        sb.append(", ").append(sexualOrientation);
        sb.append(", ").append(socioEconomicClassification);

        sb.append(")");
        return sb.toString();
    }
}
