package com.foxminded.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="fields")
@Setter
@Getter
@NoArgsConstructor
public class Field {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="day")
	@Enumerated(EnumType.STRING)
	private DayOfWeek day;
	
	@Column(name="number_lesson")
	private Integer numberLesson;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="group_id")
	private Group group;

	@Override
	public String toString() {
		return "Field [id=" + id + ", day=" + day + ", numberLesson=" + numberLesson + ", subject=" + subject
				+ ", group=" + group + "]";
	}
	
	
}
