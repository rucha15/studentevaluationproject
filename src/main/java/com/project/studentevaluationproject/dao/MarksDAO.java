package com.project.studentevaluationproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.studentevaluationproject.model.Marks;
import com.project.studentevaluationproject.repository.MarksRepository;

@Service
public class MarksDAO {

	@Autowired
	public MarksRepository marksRepository;
	
	public Marks save(Marks mark){
		return marksRepository.save(mark);
	}
	
	public List<Marks> findAll(){
		return marksRepository.findAll();
	}
	
	public List<Marks> findByGrade(String email,int grade){
		return marksRepository.findByGrade(email, grade);
	}
	
	public List<Marks> findByName(String first_name, String last_name){
		return marksRepository.findByName(first_name, last_name);
	}
	
	public List<Marks> findBySubject(String email, String subject_name){
		return marksRepository.findBySubject(email, subject_name);
	}
	
	public List<Marks> findBySemester(String email, String semester){
		return marksRepository.findBySemester(email, semester);
	}
	
	public List<Marks> findByCustom(String email, String subject_name, int grade, String semester){
		return marksRepository.findByCustom(email, subject_name, grade, semester);
	}
	
	public Marks deleteByEmail(String email){
		return marksRepository.deleteByEmail(email);
	}
	
	
	
}
