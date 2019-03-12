package com.foxminded.controller;

import com.foxminded.entity.Group;
import com.foxminded.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/group")
public class GroupRESTController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Group> findAll (){
        return groupRepository.findAll();
    }



}
