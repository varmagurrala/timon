package com.pro.timon.controller;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.timon.payload.TasksDto;
import com.pro.timon.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class TasksController {
	  private static final Logger logger =  LoggerFactory.getLogger(TasksController.class);

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/createtask/{userid}")
	public ResponseEntity<TasksDto> createTask(@PathVariable(name="userid") Long userid,
			@RequestBody TasksDto dto) {
		 logger.info("#############Hello World!");
		return new ResponseEntity<>(taskService.createTask(userid, dto),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/tasks/{userid}")
	public ResponseEntity<List<TasksDto>> getAllTasks(@PathVariable(name="userid") Long userid){
		return new ResponseEntity<>(taskService.getAllTasks(userid),HttpStatus.OK);
	}
	
	@GetMapping("/tasks/{userid}/{taskid}")
	public ResponseEntity<TasksDto> getByTaskId(@PathVariable(name="userid") Long userid,
			@PathVariable(name="taskid") Long taskid){
		return new ResponseEntity<>(taskService.getTaskByid(userid, taskid),HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks/{userid}/{taskid}")
	public ResponseEntity<String> deleteByTaskId(@PathVariable(name="userid") Long userid,
			@PathVariable(name="taskid") Long taskid){
		
		taskService.deletetaskByid(userid, taskid);
		return new ResponseEntity<>("deleted sucessfully",HttpStatus.OK);
	}

}
