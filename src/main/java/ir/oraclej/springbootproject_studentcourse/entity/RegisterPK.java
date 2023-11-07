package ir.oraclej.springbootproject_studentcourse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
//@Data
//@Embeddable
public class RegisterPK implements Serializable {
//    @Column(name = "FK_SID", columnDefinition = "NUMBER", insertable=false, updatable=false)
    private int sid;

//    @Column(name = "FK_CID", columnDefinition = "NUMBER", insertable=false, updatable=false)
    private int cid;

//    @Column(name = "TERM", columnDefinition = "CHAR(3)", insertable=false, updatable=false)
    private String term;

}
