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
public class RUserType implements Serializable {

    private static final long serialVersionUID = -2035194060;

    private Long   id;
    private String code;
    private String userType;
    private String description;

    public RUserType() {}

    public RUserType(RUserType value) {
        this.id = value.id;
        this.code = value.code;
        this.userType = value.userType;
        this.description = value.description;
    }

    public RUserType(
        Long   id,
        String code,
        String userType,
        String description
    ) {
        this.id = id;
        this.code = code;
        this.userType = userType;
        this.description = description;
    }

    @NotNull
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 20)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Size(max = 50)
    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Size(max = 50)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RUserType (");

        sb.append(id);
        sb.append(", ").append(code);
        sb.append(", ").append(userType);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}
