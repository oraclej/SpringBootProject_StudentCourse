package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.UniversityException;
import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @RequestMapping("/studentList")
    public ModelAndView getAll() {
        ModelAndView mv = new ModelAndView("studentList.html");
        mv.addObject("list", studentService.getAll());
        return mv;
    }

    @PostMapping("/studentAdd")
    public String add(StudentEntity studentEntity) {
        boolean added = studentService.addOne(studentEntity);
        return "redirect:/admin/studentList?msg="+(added?"ok":"nok");
    }

    @GetMapping("/studentAdd")
    public String add() {
        return "/studentAdd.html";
    }

    @GetMapping("/studentEdit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Optional<StudentEntity> one = studentService.getOne(id);
        if (!one.isPresent())
            throw new UniversityException("Invalid Student ID");
        ModelAndView mv = new ModelAndView("studentEdit.html");
        mv.addObject("student", one.get());
        return mv;
    }
    @GetMapping("/studentDelete/{id}")
    public String delete(@PathVariable int id) {
        boolean deleted = studentService.deleteOne(id);
        return "redirect:/admin/studentList?msg="+(deleted?"ok":"nok");
    }

    @PostMapping("/studentEdit")
    public String edit(StudentEntity studentEntity) {
        boolean edited = studentService.editOne(studentEntity);
        return "redirect:/admin/studentList?msg="+(edited?"ok":"nok");
    }

}