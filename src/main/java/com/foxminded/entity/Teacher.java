package com.foxminded.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Table (name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Teacher implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="second_name")
    private String secondName;
    
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER
		    , cascade = CascadeType.ALL)
			private Set<Subject> subjects = new HashSet<Subject>();
    
	public Teacher(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Teacher(int id) {
		super();
		this.id = id;
	}
    
    

}
