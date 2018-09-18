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
@Table(name="Marks")
@EntityListeners(AuditingEntityListener.class)
public class Marks {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private int grade;
	
	private String semester;
	
	private String subject_name;
	
	private float marks_obtained;
	
	private float out_of_marks;
	
	@OneToOne
    @JoinColumn(name = "student_id")
	private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public float getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(float marks_obtained) {
		this.marks_obtained = marks_obtained;
	}

	public float getOut_of_marks() {
		return out_of_marks;
	}

	public void setOut_of_marks(float out_of_marks) {
		this.out_of_marks = out_of_marks;
	}	
}
