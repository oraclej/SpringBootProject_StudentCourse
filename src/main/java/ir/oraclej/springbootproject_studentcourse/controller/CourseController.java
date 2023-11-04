package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.entity.CourseEntity;
import ir.oraclej.springbootproject_studentcourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courseList")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("courseList.html");
        mv.addObject("courseList", courseService.getAll());
        return mv;
    }

    @PostMapping("/courseAdd")
    public String add(CourseEntity courseEntity) {
        courseService.addOne(courseEntity);
        return "redirect:/courseList?msg=ok";
    }

    @GetMapping("/courseAdd")
    public String add() {
        return "courseAdd.html";
    }
}
