package com.txy.meet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.txy.meet.entity.User;
import com.txy.meet.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return userMapper.findUserAll();
	}
	
	
	
}
