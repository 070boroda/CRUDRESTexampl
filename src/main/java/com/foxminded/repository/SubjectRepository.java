package com.foxminded.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxminded.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
