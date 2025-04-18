package com.hashgo.room.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hashgo.room.dao.UserDao;
import com.hashgo.room.dto.LoginDto;
import com.hashgo.room.dto.UserDto;
import com.hashgo.room.dto.UserDtoMapper;
import com.hashgo.room.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserDtoMapper userDtoMapper;
	
	@Autowired
	private UserDao userDao;

	public ResponseEntity<?> registerUser(UserDto userDto) {
		// TODO Auto-generated method stub
		Map<String, Object> response=new HashMap<String, Object>();
		try {
			if(userDao.getUserByPhoneOrEmail(userDto.getEmail(), userDto.getPhoneNo())==null) {
				User user=userDao.registerUser(userDtoMapper.toUser(userDto));
				response.put("data", userDtoMapper.toUserDto(user));
				response.put("status", "200"); 
				response.put("message","Successfully Registered User");
				return ResponseEntity.ok(response);
			}else {
				response.put("status", "409"); 
				if(userDto.getEmail()!=null)
				response.put("message","Email is already taken");
				if(userDto.getPhoneNo()!=null)
				response.put("message","Phone is already taken");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
	}

	public ResponseEntity<?> loginUser(UserDto user) {
		// TODO Auto-generated method stub
		Map<String, Object> response=new HashMap<String, Object>();
		try {
			
			User loggedUser=userDao.loginUser(user.getEmail()!=null && !user.getEmail().isEmpty()?user.getEmail():user.getPhoneNo(),user.getPassword());
			if(loggedUser!=null) {
				response.put("data", userDtoMapper.toUserDto(loggedUser));
				response.put("statuss", "200"); 
				response.put("message","Successfully logged in");
				return ResponseEntity.ok(response);
				
			}else {
				response.put("status", "200"); 
				response.put("message","Email or Phone not registered or Incorrect password");
				return ResponseEntity.ok(response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);	
		}
		
	}

}
