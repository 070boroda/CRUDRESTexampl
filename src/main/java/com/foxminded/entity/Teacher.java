package com.foxminded.entity;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString(includeFieldNames = false)
public class Teacher {
	
    private int id;
    
    private String firstName;
    
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
