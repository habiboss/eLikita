/*
 * This file is generated by jOOQ.
*/
package schemas.referential.tables.pojos;


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
public class RContactPersonType implements Serializable {

    private static final long serialVersionUID = -1868023795;

    private Long   id;
    private String typeName;

    public RContactPersonType() {}

    public RContactPersonType(RContactPersonType value) {
        this.id = value.id;
        this.typeName = value.typeName;
    }

    public RContactPersonType(
        Long   id,
        String typeName
    ) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 50)
    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RContactPersonType (");

        sb.append(id);
        sb.append(", ").append(typeName);

        sb.append(")");
        return sb.toString();
    }
}
