package ir.oraclej.springbootproject_studentcourse.repo;

import ir.oraclej.springbootproject_studentcourse.entity.RegisterEntity;
import ir.oraclej.springbootproject_studentcourse.entity.RegisterPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<RegisterEntity, RegisterPK> {
}
