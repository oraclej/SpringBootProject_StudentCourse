package ir.oraclej.springbootproject_studentcourse.service;

import ir.oraclej.springbootproject_studentcourse.UniversityException;
import ir.oraclej.springbootproject_studentcourse.entity.CourseEntity;
import ir.oraclej.springbootproject_studentcourse.entity.RegisterEntity;
import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean editOne(StudentEntity studentEntity) {
        try {
            studentRepo.save(studentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<StudentEntity> getAll(){
        return studentRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<StudentEntity> getOne(int id){
        return studentRepo.findById(id);
    }

    public List<RegisterEntity> listRegisters(int sid){
        Optional<StudentEntity> one = studentRepo.findById(sid);
        if (!one.isPresent())
            throw new UniversityException("Invalid Student ID");
        StudentEntity studentEntity = one.get();
        List<RegisterEntity> registers = studentEntity.getRegisters();
        return registers;
    }

    public boolean delete(String whod, int id) {
        try {
//            studentRepo.delete(studentEntity);
            studentRepo.softDelete(whod, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
