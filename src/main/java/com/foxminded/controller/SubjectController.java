package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.Subject;
import com.foxminded.repository.SubjectRepository;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	

	@RequestMapping(value = "/showallsubjects", method = RequestMethod.GET)
	public ModelAndView showAllSubject() {
		return new ModelAndView("/subject/subjectpage", "subjectslist", subjectRepository.findAll());
	}
	
	@RequestMapping(value = "/subjectadd", method = RequestMethod.GET)
	public ModelAndView showAddGroup() {		
		return new ModelAndView("/subject/subjectadd", "subjectAttribute", new Subject());		
	}
	
	@RequestMapping(value = "/subjectadd", method = RequestMethod.POST)
	public ModelAndView addSubject(@ModelAttribute ("subjectAttribute") Subject subject) {
		subjectRepository.saveAndFlush(subject);		
		return new ModelAndView("redirect:/showallsubjects");
	}
	
	@RequestMapping(value = "/subjectdelete", method = RequestMethod.GET)
	public ModelAndView deleteSubject(@RequestParam(value = "id", required = true
	) 
	Integer id) {			
		subjectRepository.delete(id);	
	    return new ModelAndView("redirect:/showallsubjects");
	}
	
	@RequestMapping(value = "/subjectedit", method = RequestMethod.POST)
	public ModelAndView editSubject(@ModelAttribute("subjectAttribute") Subject subject,
			@RequestParam(value = "id", required = true) Integer id) {
		subject.setId(id);
		subjectRepository.saveAndFlush(subject);
		return new ModelAndView("redirect:/showallsubjects");
	}

	@RequestMapping(value = "/subjectedit", method = RequestMethod.GET)
	public ModelAndView viewEditSubject(@RequestParam(value = "id", required = true) Integer id) {
		return new ModelAndView("/subject/subjectedit", "subjectAttribute", subjectRepository.findOne(id));
	}
}

