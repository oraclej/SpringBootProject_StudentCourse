package ir.oraclej.springbootproject_studentcourse.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class WhoEntities {
    @PrePersist
    public void prePersist(Object obj){
            JPAEntity jpaEntity = (JPAEntity) obj;
            jpaEntity.setCreateDate(new Date());
        }
    @PreUpdate
    public void preUpdate(Object obj){
            JPAEntity jpaEntity = (JPAEntity) obj;
            jpaEntity.setModifiedDate(new Date());
        }
}
