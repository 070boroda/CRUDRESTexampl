package com.foxminded.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxminded.entity.DayOfWeek;
import com.foxminded.entity.Field;
import com.foxminded.entity.Group;

public interface FieldRepository extends JpaRepository<Field, Integer> {
	public List<Field> findByDayAndGroup(DayOfWeek day, Group group); 
}
