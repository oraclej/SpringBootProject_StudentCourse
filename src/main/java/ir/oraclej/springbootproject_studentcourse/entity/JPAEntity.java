package ir.oraclej.springbootproject_studentcourse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class JPAEntity {
    @Column(name = "CREATE_DATE", columnDefinition = "DATE")
    private Date createDate;
    @Column(name = "MODIFIED_DATE", columnDefinition = "DATE")
    private Date modifiedDate;
    @Column(name = "DELETED_DATE", columnDefinition = "DATE")
    private Date deletedDate;
    @Column(name = "WHO_CREATE", columnDefinition = "VARCHAR2(30)")
    private String whoCreated;
    @Column(name = "WHO_UPDATED", columnDefinition = "VARCHAR2(30)")
    private String whoUpdated;
    @Column(name = "WHO_DELETED", columnDefinition = "VARCHAR2(30)")
    private String whoDeleted;
}
