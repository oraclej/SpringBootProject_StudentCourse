package ir.oraclej.springbootproject_studentcourse.service;

import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public boolean addOne(StudentEntity studentEntity) {
        try {
            studentRepo.save(studentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<StudentEntity> getAll(){
        return studentRepo.findAll();
    }
}
