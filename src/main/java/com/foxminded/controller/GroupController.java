package com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foxminded.entity.Group;
import com.foxminded.entity.Student;
import com.foxminded.repository.GroupRepository;
import com.foxminded.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/showallgroups", method = RequestMethod.GET)
    public ModelAndView showAllGroup() {
        return new ModelAndView("/group/grouppage", "groupslist", groupRepository.findAll());
    }

    @RequestMapping(value = "/groupadd", method = RequestMethod.GET)
    public ModelAndView showAddGroup() {
        return new ModelAndView("/group/groupadd", "groupAttribute", new Group());
    }

    @RequestMapping(value = "/groupadd", method = RequestMethod.POST)
    public ModelAndView addGroup(@ModelAttribute("groupAttribute") Group group) {
        groupRepository.saveAndFlush(group);
        return new ModelAndView("/group/groupadded");
    }

    @RequestMapping(value = "/groupdelete", method = RequestMethod.GET)
    public ModelAndView deleteGroup(@RequestParam(value = "id", required = true
    )
                                            Integer id) {
        for (Student student : groupRepository.findOne(id).getStudents()) {
            log.debug("" + student.getGroup().getId());
            student.setGroup(null);
            studentRepository.saveAndFlush(student);
        }
        groupRepository.delete(id);
        return new ModelAndView("redirect:/showallgroups", "id", id);
    }

    @RequestMapping(value = "/groupedit", method = RequestMethod.POST)
    public ModelAndView editGroup(@ModelAttribute("groupAttribute") Group group,
                                  @RequestParam(value = "id", required = true) Integer id) {
        group.setId(id);
        groupRepository.saveAndFlush(group);
        return new ModelAndView("redirect:/showallgroups");
    }

    @RequestMapping(value = "/groupedit", method = RequestMethod.GET)
    public ModelAndView viewEditGroup(@RequestParam(value = "id", required = true) Integer id) {
        return new ModelAndView("/group/groupedit", "groupAttribute", groupRepository.findOne(id));
    }
}
