package com.foxminded.controller;

import com.foxminded.Exception.NotFoundException;
import com.foxminded.entity.Group;
import com.foxminded.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
public class GroupRESTController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/group")
    public ResponseEntity<List<Group>> findAllGroup(){
        List<Group> groups = groupRepository.findAll();
        if(groups.isEmpty()){
            return new ResponseEntity<>(groups, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups,HttpStatus.OK);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        Group group = groupRepository.findOne(id);
        if(group == null){
            return new ResponseEntity<>(new NotFoundException(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(group,HttpStatus.OK);
    }

    @PostMapping("/group")
    public ResponseEntity<Group> newGroup(@RequestBody Group group) {
        groupRepository.save(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<?> updateGroupe(@PathVariable Integer id,@RequestBody Group group){
        Group groupFromDb = groupRepository.findOne(id);
        if(groupFromDb == null){
            return new ResponseEntity<>(new NotFoundException(id), HttpStatus.NOT_FOUND);
        }
        groupFromDb.setGroupName(group.getGroupName());
        groupRepository.save(groupFromDb);
        return new ResponseEntity<>(groupFromDb, HttpStatus.OK);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id){
        Group group = groupRepository.findOne(id);
        if(group == null){
            return new ResponseEntity<>(new NotFoundException(id), HttpStatus.NOT_FOUND);
        }
        groupRepository.delete(id);
        return new ResponseEntity<Group>(HttpStatus.NO_CONTENT);
    }
}
