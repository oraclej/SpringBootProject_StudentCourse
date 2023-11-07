package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.entity.RegisterEntity;
import ir.oraclej.springbootproject_studentcourse.entity.RegisterPK;
import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.service.CourseService;
import ir.oraclej.springbootproject_studentcourse.service.RegisterService;
import ir.oraclej.springbootproject_studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin")

public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/showCourseList/{sid}")
    @ResponseBody
    public ModelAndView list(@PathVariable int sid) {
        ModelAndView mv = new ModelAndView("registerList.html");
        Optional<StudentEntity> one = studentService.getOne(sid);
        mv.addObject("std", one.get());
        mv.addObject("reglist", studentService.listRegisters(sid));
        return mv;
    }

    @GetMapping("/registerAdd/{sid}")
    public ModelAndView add(@PathVariable String sid){
        ModelAndView mv = new ModelAndView("registerAdd");
        mv.addObject("courseList", courseService.getAll());
        mv.addObject("terms", registerService.getListOfTerms());
        mv.addObject("sid", sid);
        return mv;
    }

    @PostMapping("/registerAdd")
    public String add(RegisterEntity registerEntity){
        registerService.add(registerEntity);
        return "redirect:/admin/showCourseList/" + registerEntity.getSid();
    }

    @GetMapping("/registerDelete/{sid}-{cid}-{term}")
    public String add(@PathVariable int sid, @PathVariable int cid, @PathVariable String term){
        registerService.delete(new RegisterPK(sid, cid, term));
        return "redirect:/admin/showCourseList/" + sid;
    }

}
