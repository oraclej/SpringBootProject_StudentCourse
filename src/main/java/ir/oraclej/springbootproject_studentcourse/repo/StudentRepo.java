package ir.oraclej.springbootproject_studentcourse.repo;


import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    @Modifying
    @Query("update std s set s.deleted=true , s.whoDeleted=:whod, s.deletedDate=CURRENT_DATE where s.id = :id")
    int softDelete(@Param("whod") String whod, @Param("id") int id);
}
