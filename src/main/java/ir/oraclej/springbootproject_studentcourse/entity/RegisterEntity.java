package ir.oraclej.springbootproject_studentcourse.entity;

import ir.oraclej.springbootproject_studentcourse.UniversityException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity(name = "reg")
@Table(name = "TBL_REGISTER")
@IdClass(RegisterPK.class)
@Data
@NoArgsConstructor @AllArgsConstructor
public class RegisterEntity extends JPAEntity{
    @Id
    @Column(name = "FK_SID", columnDefinition = "NUMBER", insertable = false, updatable = false)
    private int sid;

    @Id
    @Column(name = "FK_CID", columnDefinition = "NUMBER", insertable = false, updatable = false)
    private int cid;

    @Column(name = "TERM", columnDefinition = "CHAR(3)")
    @Id
    private String term;


    @Column(name = "GRADE", columnDefinition = "NUMBER(4,2)")
    @Max(20) @Min(0)
    private double grade;

    @ManyToOne(targetEntity = StudentEntity.class)
    @JoinColumn(name = "FK_SID", referencedColumnName = "SID")
    private StudentEntity studentEntity;

    @ManyToOne(targetEntity = CourseEntity.class)
    @JoinColumn(name = "FK_CID", referencedColumnName = "CID")
    private CourseEntity courseEntity;

    public void setTerm(String term) throws UniversityException{

        if(term.length() != 3)
            throw new UniversityException("Term should be 3 digits");
        char d1 = term.charAt(0);
        if(!(d1 == '0' || d1 == '9'))
            throw new UniversityException("Term should start with 0 or 9");
        char d2 = term.charAt(1);
        if(!(d2 >= '0' && d2 <= '9'))
            throw new UniversityException("Invalid Term number");
        char d3 = term.charAt(2);
        if(!(d3 >= '1' && d3 <= '3'))
            throw new UniversityException("Term number can be 1,2,3");

        this.term = term;
    }
}
