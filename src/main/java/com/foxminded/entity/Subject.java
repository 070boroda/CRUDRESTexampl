package com.foxminded.entity;

import java.io.Serializable;

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
@Table (name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(name="subject_name")
    private String subjectName;
	
	@OneToMany(mappedBy="subject", fetch=FetchType.EAGER,
			cascade=CascadeType.ALL)

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + "]";
	}
	
}
