package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.Teacher;
import com.foxminded.repository.TeacherRepository;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/showallteachers", method = RequestMethod.GET)
    public ModelAndView showAllTeacher() {
        return new ModelAndView("/teacher/teacherpage", "teacherslist", teacherRepository.findAll());
    }

    @RequestMapping(value = "/teacheradd", method = RequestMethod.GET)
    public ModelAndView showAddTeacher() {
        return new ModelAndView("/teacher/teacheradd", "teacherAttribute", new Teacher());
    }

    @RequestMapping(value = "/teacheradd", method = RequestMethod.POST)
    public ModelAndView addTeacher(@ModelAttribute("teacherAttribute") Teacher teacher) {
        teacherRepository.saveAndFlush(teacher);
        return new ModelAndView("redirect:/showallteachers");
    }

    @RequestMapping(value = "/teacherdelete", method = RequestMethod.GET)
    public ModelAndView deleteTeacher(@RequestParam(value = "id", required = true
    )
                                              Integer id) {
        teacherRepository.delete(id);
        return new ModelAndView("redirect:/showallteachers", "id", id);
    }

    @RequestMapping(value = "/teacheredit", method = RequestMethod.POST)
    public ModelAndView editTeacher(@ModelAttribute("teacherAttribute") Teacher teacher,
                                    @RequestParam(value = "id", required = true) Integer id) {
        teacher.setId(id);
        teacherRepository.saveAndFlush(teacher);
        return new ModelAndView("redirect:/showallteachers");
    }

    @RequestMapping(value = "/teacheredit", method = RequestMethod.GET)
    public ModelAndView viewEditTeacher(@RequestParam(value = "id", required = true) Integer id) {
        return new ModelAndView("/teacher/teacheredit", "teacherAttribute", teacherRepository.findOne(id));
    }
}
