package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.Student;
import com.foxminded.repository.StudentRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RestController
@NoArgsConstructor
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping(value = "/showallstudents", method = RequestMethod.GET)
	public ModelAndView showAllStudent() {
		ModelAndView modelAndView = new ModelAndView("studentpage");
		modelAndView.addObject("studentslist", repository.findAll());		
		return modelAndView;
	}
	
	@RequestMapping(value = "/studentadd", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("attributeStudent") Student student) {
		repository.saveAndFlush(student);
		return new ModelAndView("studentadded");
	}

	@RequestMapping(value = "/studentadd", method = RequestMethod.GET)
	public ModelAndView viewAddStudent() {		
		return new ModelAndView("studentadd", "attributeStudent", new Student());		
	}

	@RequestMapping(value = "/studentdelete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam(value = "id", required = true) Integer id) {
		repository.delete(id);
		return new ModelAndView("studentdelete", "id", id);
	}

	@RequestMapping(value = "/studentedit", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute("studentAttribute") Student student,
			@RequestParam(value = "id", required = true) Integer id) {
		student.setId(id);
		repository.saveAndFlush(student);
		return new ModelAndView("redirect:/showallstudents");
	}

	@RequestMapping(value = "/studentedit", method = RequestMethod.GET)
	public ModelAndView viewEditStudent(@RequestParam(value = "id", required = true) Integer id) {
		return new ModelAndView("studentedit", "studentAttribute", repository.findOne(id));
	}
}
