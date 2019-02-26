package com.foxminded.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxminded.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
