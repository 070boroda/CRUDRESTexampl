package com.foxminded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table (name = "subject")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject implements Serializable {
	@Id
	@Column(name="id")
    private int id;
    private String name;
    
    @Override
    public String toString() {
        return name;
    }

	public Subject(int id) {
		super();
		this.id = id;
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	
}
