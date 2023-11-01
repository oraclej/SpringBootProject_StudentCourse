package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.entity.CourseEntity;
import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/courseList")
    public ModelAndView list(@PathVariable int sid) {
        ModelAndView mv = new ModelAndView("courseList.html");
        mv.addObject("reglist", studentService.listCourses(sid));
        return mv;
    }


    @PostMapping("/courseAdd")
    public String add(CourseEntity courseEntity) {
        coustudentService.addOne(courseEntity);
        return "redirect:/studentList?msg=ok";
    }

    @GetMapping("/studentAdd")
    public String add() {
        return "studentAdd.html";
    }
}
