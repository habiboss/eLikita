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
public class RDropAttendanceReason implements Serializable {

    private static final long serialVersionUID = 1765579950;

    private Long   id;
    private String reason;

    public RDropAttendanceReason() {}

    public RDropAttendanceReason(RDropAttendanceReason value) {
        this.id = value.id;
        this.reason = value.reason;
    }

    public RDropAttendanceReason(
        Long   id,
        String reason
    ) {
        this.id = id;
        this.reason = reason;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 50)
    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RDropAttendanceReason (");

        sb.append(id);
        sb.append(", ").append(reason);

        sb.append(")");
        return sb.toString();
    }
}
