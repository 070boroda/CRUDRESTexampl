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
@RequestMapping(value ="/group")
public class GroupRESTController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping
    @RequestMapping
    public ResponseEntity<List<Group>> findAll(){
        List<Group> groups = groupRepository.findAll();
        if(groups.isEmpty()){
            return new ResponseEntity<>(groups, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(groups,HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findOneGroup(@PathVariable(name = "id")Integer id){
        Group group = groupRepository.findOne(id);
        if(group == null){
            return new ResponseEntity<>(new NotFoundException("id" + id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(group,HttpStatus.OK);
    }




}
