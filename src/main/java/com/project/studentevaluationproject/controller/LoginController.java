package com.project.studentevaluationproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.studentevaluationproject.dao.LoginDAO;
import com.project.studentevaluationproject.model.Login;

@RestController 
@RequestMapping("school")
public class LoginController {

	@Autowired
	LoginDAO loginDAO;
	
	//save a Login
	@PostMapping("/login")
	public Login createLogin(@Valid @RequestBody Login log){
		return loginDAO.save(log);
	}

}
