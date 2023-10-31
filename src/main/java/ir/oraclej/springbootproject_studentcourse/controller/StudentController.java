package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    @RequestMapping("/studentList")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView("studentList.html");
        mv.addObject("list", studentService.getAll());
        return mv;
    }

    @PostMapping("/studentAdd")
    public ModelAndView add(StudentEntity studentEntity){
        ModelAndView mv = new ModelAndView("studentList");
        studentService.addOne(studentEntity);
        mv.addObject("msg", "One record is added");
        return mv;
    }

    @GetMapping("/studentAdd")
    public String add(){
        return "studentAdd.html";
    }
}
