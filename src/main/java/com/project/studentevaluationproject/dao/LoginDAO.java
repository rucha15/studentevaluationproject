package com.project.studentevaluationproject.dao;

import org.springframework.stereotype.Service;

import com.project.studentevaluationproject.model.Login;
import com.project.studentevaluationproject.repository.LoginRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginDAO {
	
	@Autowired
	public LoginRepository loginRepository;
	
	public Login save(Login login){
		return loginRepository.save(login);
	}
	
	public List<Login> findAll(){
		return loginRepository.findAll();
	}
	
	public Login findOneByUsername(String username){
		return loginRepository.findByUsername(username);		
	}
	
	public Login deleteByUsername(String username){
		return loginRepository.deleteByUsername(username);
	}
}
