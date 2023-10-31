package ir.oraclej.springbootproject_studentcourse.repo;

import ir.oraclej.springbootproject_studentcourse.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {
}
