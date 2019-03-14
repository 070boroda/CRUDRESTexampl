package com.foxminded.controller;

import com.foxminded.Exception.NotFoundException;
import com.foxminded.entity.Group;
import com.foxminded.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupRESTController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/group")
    public List<Group> findAll(){
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    public Group findOne(@PathVariable Integer id){
        return groupRepository.findOne(id);
         //.orElseThrow(()-> new NotFoundException(id));
    }

    @PostMapping("/group")
    Group newGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }


}
