package com.hashgo.room.dto;

import org.springframework.stereotype.Component;

import com.hashgo.room.entities.User;

@Component
public class UserDtoMapper {
	
	public UserDto toUserDto(User user) {
		return new UserDto(user.getId(),user.getEmail(),user.getPhoneNo(),user.getName(),user.getPassword(),user.getRoomId(),user.getRole());
		
	}
	
	public User toUser(UserDto user) {
		return new User(user.getId(),user.getEmail(),user.getPhoneNo(),user.getName(),user.getPassword(),user.getRoomId(),user.getRole());
		
	}
	

}
