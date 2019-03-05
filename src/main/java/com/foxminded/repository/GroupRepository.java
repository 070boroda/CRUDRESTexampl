package com.foxminded.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foxminded.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
	@Query("SELECT t FROM Group t WHERE t.groupName = ?1")
	public Group findOneByName(String groupName);
}
