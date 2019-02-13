package com.foxminded.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxminded.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
