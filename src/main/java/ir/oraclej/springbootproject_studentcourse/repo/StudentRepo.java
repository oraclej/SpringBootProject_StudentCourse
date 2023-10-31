package ir.oraclej.springbootproject_studentcourse.repo;


import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
}
