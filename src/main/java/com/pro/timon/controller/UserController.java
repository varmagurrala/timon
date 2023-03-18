package com.pro.timon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.timon.payload.UseerDto;
import com.pro.timon.service.UserService;

@RestController
@RequestMapping("/api/v")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UseerDto> createuser(@RequestBody UseerDto useerDto){
		return new ResponseEntity<>(userService.createUser(useerDto),HttpStatus.CREATED);
	}

}
