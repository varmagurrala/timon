package com.pro.timon.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.timon.entity.User;
import com.pro.timon.payload.UseerDto;
import com.pro.timon.repository.UserRepsotory;
import com.pro.timon.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepsotory userRepsotory;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UseerDto createUser(UseerDto useerDto) {
		
		User user = modelMapper.map(useerDto, User.class);
		
		User saveduser = userRepsotory.save(user);
		return modelMapper.map(saveduser, UseerDto.class);
	}

}
