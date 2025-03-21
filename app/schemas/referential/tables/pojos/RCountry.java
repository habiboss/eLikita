/*
 * This file is generated by jOOQ.
*/
package schemas.referential.tables.pojos;


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
public class RCountry implements Serializable {

    private static final long serialVersionUID = -881156623;

    private String iso;
    private String name_;
    private String nicename;
    private String iso3;
    private Long   numcode;
    private Long   phonecode;
    private Long   id;

    public RCountry() {}

    public RCountry(RCountry value) {
        this.iso = value.iso;
        this.name_ = value.name_;
        this.nicename = value.nicename;
        this.iso3 = value.iso3;
        this.numcode = value.numcode;
        this.phonecode = value.phonecode;
        this.id = value.id;
    }

    public RCountry(
        String iso,
        String name_,
        String nicename,
        String iso3,
        Long   numcode,
        Long   phonecode,
        Long   id
    ) {
        this.iso = iso;
        this.name_ = name_;
        this.nicename = nicename;
        this.iso3 = iso3;
        this.numcode = numcode;
        this.phonecode = phonecode;
        this.id = id;
    }

    @NotNull
    @Size(max = 2)
    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @NotNull
    @Size(max = 80)
    public String getName_() {
        return this.name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    @NotNull
    @Size(max = 80)
    public String getNicename() {
        return this.nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    @Size(max = 3)
    public String getIso3() {
        return this.iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Long getNumcode() {
        return this.numcode;
    }

    public void setNumcode(Long numcode) {
        this.numcode = numcode;
    }

    @NotNull
    public Long getPhonecode() {
        return this.phonecode;
    }

    public void setPhonecode(Long phonecode) {
        this.phonecode = phonecode;
    }

    @NotNull
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RCountry (");

        sb.append(iso);
        sb.append(", ").append(name_);
        sb.append(", ").append(nicename);
        sb.append(", ").append(iso3);
        sb.append(", ").append(numcode);
        sb.append(", ").append(phonecode);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}
