package com.pro.timon.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.timon.entity.Tasks;
import com.pro.timon.entity.User;
import com.pro.timon.exception.DataMissMatch;
import com.pro.timon.exception.TaskNotFound;
import com.pro.timon.exception.UserNotFound;
import com.pro.timon.payload.TasksDto;
import com.pro.timon.repository.TaskRepository;
import com.pro.timon.repository.UserRepsotory;
import com.pro.timon.service.TaskService;

import ch.qos.logback.core.model.Model;

@Service
public class TasksServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired 
	private UserRepsotory userRepsotory;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TasksDto createTask(Long userid, TasksDto tasksDto) {
		
	User user=	userRepsotory.findById(userid).orElseThrow(()-> new UserNotFound(String.format("user id %d not found", userid)));
		
		Tasks tasks = modelMapper.map(tasksDto,Tasks.class);
		
		tasks.setUser(user);
		
		Tasks newTask=taskRepository.save(tasks);
		
		return modelMapper.map(newTask, TasksDto.class);
		
		
		
		

	}

	@Override
	public List<TasksDto> getAllTasks(Long userId) {

		User user = userRepsotory.findById(userId).orElseThrow(()-> new UserNotFound(String.format("user id %d not found", userId)));
		
		List<Tasks> tasks = taskRepository.findAll();
		return tasks.stream().map(task -> modelMapper.map(task, TasksDto.class)).collect(Collectors.toList());
	}

	@Override
	public TasksDto getTaskByid(Long userid, Long taskid) {
		User user = userRepsotory.findById(userid).orElseThrow(()-> new UserNotFound(String.format("user id %d not found", userid)));

		Tasks tasks = taskRepository.findById(taskid).orElseThrow(()-> new TaskNotFound(String.format("task id %d not found", taskid)));
		
		if (user.getId() != tasks.getUser().getId()) {
			
			throw new DataMissMatch(String.format("user id %d and taskid %d not match", userid,taskid));
		}
		return modelMapper.map(tasks, TasksDto.class);
	}

	@Override
	public void deletetaskByid(Long userid, Long taskid) {
		User user = userRepsotory.findById(userid).orElseThrow(()-> new UserNotFound(String.format("user id %d not found", userid)));

		Tasks tasks = taskRepository.findById(taskid).orElseThrow(()-> new TaskNotFound(String.format("task id %d not found", taskid)));
		
		if (user.getId() != tasks.getUser().getId()) {
			
			throw new DataMissMatch(String.format("user id %d and taskid %d not match", userid,taskid));
		}
	         taskRepository.deleteById(taskid);
		
	}
	
	

}
