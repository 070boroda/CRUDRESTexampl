package com.foxminded.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="group_name")
	private String groupName;
	
	@OneToMany(mappedBy="group", fetch=FetchType.LAZY)
	private Set<Student> students = new HashSet<Student>();
		
}
