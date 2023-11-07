package ir.oraclej.springbootproject_studentcourse.service;

import ir.oraclej.springbootproject_studentcourse.entity.RegisterEntity;
import ir.oraclej.springbootproject_studentcourse.entity.RegisterPK;
import ir.oraclej.springbootproject_studentcourse.repo.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepo registerRepo;

    public boolean add(RegisterEntity registerEntity){
        try {
            registerRepo.save(registerEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(RegisterPK registerPK){
        try {
            Optional<RegisterEntity> byId = registerRepo.findById(registerPK);
            registerRepo.delete(byId.get());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getListOfTerms(){
        return List.of("991","992","993","001","002","003","011","012","013","021","022","023");
    }
}
