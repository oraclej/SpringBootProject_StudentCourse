package ir.oraclej.springbootproject_studentcourse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity(name = "std")
@Table(name = "TBL_STUDENT")
@Data
@NoArgsConstructor
@EntityListeners(WhoEntities.class)
public class StudentEntity extends JPAEntity{
    @Id
    @Column(name = "SID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STD_SEQ")
    @SequenceGenerator(name = "STD_SEQ", allocationSize = 1, sequenceName = "SEQ_STUDENT")
    private int id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(30)")
    private String name;
    @Column(name = "BIRTH_DATE", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date birthDate;

    @OneToMany(targetEntity = RegisterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SID", referencedColumnName = "SID")
    private List<RegisterEntity> registers;

    public StudentEntity(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
