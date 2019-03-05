package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.DayOfWeek;
import com.foxminded.entity.Field;
import com.foxminded.repository.FieldRepository;
import com.foxminded.repository.GroupRepository;
import com.foxminded.repository.SubjectRepository;

@Controller
public class FieldController {
	
	@Autowired
	private FieldRepository fieldRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	@RequestMapping(value = "/showschedule", method=RequestMethod.GET)
	public ModelAndView showChooseView(){
		ModelAndView modelAndView = new ModelAndView("/schedule/choose");
		modelAndView.addObject("grouplist", groupRepository.findAll());
		modelAndView.addObject("daylist", DayOfWeek.values());
		modelAndView.addObject("scheduleAttribute", new Field());
		return modelAndView;
	}
	
	@RequestMapping(value = "/schedulechoose", method = RequestMethod.POST)
	public ModelAndView showScheduleByDayAndGroup(@ModelAttribute ("scheduleAttribute") Field field) {
		ModelAndView modelAndView = new ModelAndView("/schedule/showfield");
		field.setGroup(groupRepository.findOne(field.getGroup().getId()));
		modelAndView.addObject("fieldlist",fieldRepository.findByDayAndGroup(field.getDay(),
				groupRepository.findOne(field.getGroup().getId())));
		modelAndView.addObject("scheduleAttribute", field);
		return modelAndView;
	}
	@RequestMapping(value="/fieldadd", method = RequestMethod.GET)
	public ModelAndView showAddSchedule(@RequestParam(value = "day", required = true) DayOfWeek day,
			@RequestParam(value = "group", required = true) String groupName) {
		ModelAndView modelAndView = new ModelAndView("/schedule/addschedule");
		Field field = new Field();
		field.setDay(day);
		field.setGroup(groupRepository.findOneByName(groupName));
		modelAndView.addObject("subjectlist", subjectRepository.findAll());
		modelAndView.addObject("scheduleAttribute", field);
		return modelAndView;
		
	}
}
