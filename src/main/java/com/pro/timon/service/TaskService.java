package com.pro.timon.service;

import java.util.List;

import com.pro.timon.payload.TasksDto;

public interface TaskService {
	
	public TasksDto createTask(Long userid,TasksDto tasksDto);
	
	public List<TasksDto> getAllTasks(Long userId);
	
	public TasksDto getTaskByid(Long userid,Long taskid);
	
	public void deletetaskByid(Long userid,Long taskid);

}
