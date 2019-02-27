package com.foxminded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
