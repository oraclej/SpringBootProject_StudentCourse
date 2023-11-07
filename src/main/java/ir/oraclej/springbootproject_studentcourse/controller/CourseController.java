package ir.oraclej.springbootproject_studentcourse.controller;

import ir.oraclej.springbootproject_studentcourse.UniversityException;
import ir.oraclej.springbootproject_studentcourse.entity.CourseEntity;
import ir.oraclej.springbootproject_studentcourse.entity.StudentEntity;
import ir.oraclej.springbootproject_studentcourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin")
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
        boolean added = courseService.addOne(courseEntity);
        return "redirect:/admin/courseList?msg="+(added?"ok":"nok");
    }

    @GetMapping("/courseAdd")
    public String add() {
        return "courseAdd.html";
    }

    @GetMapping("/courseDelete/{id}")
    public String add(@PathVariable int id) {
        boolean deleted = courseService.deleteOne(id);
        return "redirect:/admin/courseList?msg="+(deleted?"ok":"nok");
    }

    @GetMapping("/courseEdit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Optional<CourseEntity> one = courseService.getOne(id);
        if (!one.isPresent())
            throw new UniversityException("Invalid Course ID");
        ModelAndView mv = new ModelAndView("courseEdit.html");
        mv.addObject("course", one.get());
        return mv;
    }

    @PostMapping("/courseEdit")
    public String edit(CourseEntity courseEntity) {
        boolean edited = courseService.editOne(courseEntity);
        return "redirect:/admin/courseList?msg="+(edited?"ok":"nok");
    }

}
