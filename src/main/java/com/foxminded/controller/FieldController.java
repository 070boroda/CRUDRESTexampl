package com.foxminded.controller;

import com.foxminded.entity.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.DayOfWeek;
import com.foxminded.entity.Field;
import com.foxminded.repository.FieldRepository;
import com.foxminded.repository.GroupRepository;
import com.foxminded.repository.SubjectRepository;

@Slf4j
@Controller
public class FieldController {

	public static final DayOfWeek[] WEEK_DAY = DayOfWeek.values();

	@Autowired
	private FieldRepository fieldRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@RequestMapping(value = "/showschedule", method = RequestMethod.GET)
	public ModelAndView showChooseView() {
		ModelAndView modelAndView = new ModelAndView("/schedule/choose");
		modelAndView.addObject("grouplist", groupRepository.findAll());
		modelAndView.addObject("daylist", WEEK_DAY);
		modelAndView.addObject("scheduleAttribute", new Field());
		return modelAndView;
	}

	@RequestMapping(value = "/schedulechoose", method = RequestMethod.POST)
	public ModelAndView showScheduleByDayAndGroup(@ModelAttribute("scheduleAttribute") Field field) {
		ModelAndView modelAndView = new ModelAndView("/schedule/showfield");
		Group group = groupRepository.findOne(field.getGroup().getId());
		field.setGroup(group);
		modelAndView.addObject("fieldlist", fieldRepository.findByDayAndGroup(field.getDay(),
				group));
		modelAndView.addObject("scheduleAttribute", field);
		return modelAndView;
	}

	@RequestMapping(value = "/fieldadd", method = RequestMethod.GET)
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

	@RequestMapping(value = "/scheduleadd", method = RequestMethod.POST)
	public ModelAndView addSchedule(@ModelAttribute("scheduleAttribute") Field field) {
		fieldRepository.saveAndFlush(field);
		return new ModelAndView("redirect:/showschedule");
	}

	@RequestMapping(value = "/fielddelete", method = RequestMethod.GET)
	public ModelAndView deleteField(@RequestParam(value = "id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/showschedule");
		Field field = fieldRepository.findOne(id);
		field.setGroup(null);
		field.setSubject(null);
		fieldRepository.saveAndFlush(field);
		fieldRepository.delete(id);
		return modelAndView;
	}

	@RequestMapping(value = "/fieldedit", method = RequestMethod.GET)
	public ModelAndView showEditView(@RequestParam(value = "id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/schedule/addschedule");
		modelAndView.addObject("scheduleAttribute", fieldRepository.findOne(id));
		modelAndView.addObject("subjectlist", subjectRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/scheduleedit", method = RequestMethod.POST)
	public ModelAndView EditView(@ModelAttribute("scheduleAttribute") Field field) {
		ModelAndView modelAndView = new ModelAndView("/schedule/addschedule");
		System.out.println("I here");
		return modelAndView;
	}

}
