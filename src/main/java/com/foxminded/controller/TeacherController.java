package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.Subject;
import com.foxminded.entity.Teacher;
import com.foxminded.repository.SubjectRepository;
import com.foxminded.repository.TeacherRepository;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@RequestMapping(value = "/showallteacher", method = RequestMethod.GET)
	public ModelAndView showAllTeacher() {
		return new ModelAndView("teacherpage", "teacherlist", teacherRepository.findAll());
	}
	
	@RequestMapping(value = "/teacheradd", method = RequestMethod.GET)
	public ModelAndView showAddTeacher() {		
		return new ModelAndView("teacheradd", "teacherAttribute", new Teacher());		
	}
	
	@RequestMapping(value = "/teacheradd", method = RequestMethod.POST)
	public ModelAndView addTeacher(@ModelAttribute ("teacherAttribute") Teacher teacher) {
		teacherRepository.saveAndFlush(teacher);		
		return new ModelAndView("teacheradded");
	}
	
	@RequestMapping(value = "/teacherdelete", method = RequestMethod.GET)
	public ModelAndView deleteTeacher(@RequestParam(value = "id", required = true
	) 
	Integer id) {	
		for(Subject subject : teacherRepository.findOne(id).getSubjects()) {
			subject.setTeacher(null);
			subjectRepository.saveAndFlush(subject);
			}		
		teacherRepository.delete(id);	
	    return new ModelAndView("redirect:/showallteachers", "id",id);
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
		return new ModelAndView("teacheredit", "teacherAttribute", teacherRepository.findOne(id));
	}
}
