package com.foxminded.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foxminded.entity.Student;
import com.foxminded.repository.StudentRepository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@RestController
@NoArgsConstructor
public class StudentController {
	
	@Autowired
	private StudentRepository repository;


	@RequestMapping(value = "/showallstudents", method = RequestMethod.GET)
	public String showAllStudent(Model model) {
		log.info("Start show all students" + this.getClass().getName());
		model.addAttribute("studentslist", repository.findAll());
		return "studentpage";
	}

	@RequestMapping(value = "/studentadd", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("attributeStudent") Student student) {
		repository.saveAndFlush(student);
		return "studentadded";
	}

	@RequestMapping(value = "/studentadd", method = RequestMethod.GET)
	public String viewAddStudent(Model model) {
		model.addAttribute("attributeStudent", new Student());
		return "studentadd";
	}

	@RequestMapping(value = "/studentdelete", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam(value = "id", required = true) Integer id, Model model) {
		repository.delete(id);
		model.addAttribute("id", id);
		return "studentdelete";
	}

	@RequestMapping(value = "/studentedit", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("studentAttribute") Student student,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		student.setId(id);
		repository.saveAndFlush(student);
		return "redirect:/showallstudents";
	}

	@RequestMapping(value = "/studentedit", method = RequestMethod.GET)
	public String viewEditStudent(@RequestParam(value = "id", required = true) Integer id, Model model) {
		model.addAttribute("studentAttribute", repository.findOne(id));
		return "studentedit";
	}

}
