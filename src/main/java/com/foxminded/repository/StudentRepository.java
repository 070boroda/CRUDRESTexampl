package com.foxminded.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxminded.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
