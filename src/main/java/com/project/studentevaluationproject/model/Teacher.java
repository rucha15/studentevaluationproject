package com.project.studentevaluationproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Teacher")
@EntityListeners(AuditingEntityListener.class)
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String skills;
	
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date createdAt;
	
	@OneToOne
    @JoinColumn(name = "person_id")
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
}
