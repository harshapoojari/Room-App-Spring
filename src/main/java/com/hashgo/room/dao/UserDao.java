package com.hashgo.room.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.hashgo.room.entities.User;
import com.hashgo.room.repositories.UserRepo;
import com.hashgo.room.util.EncryptionUtil;

@Repository
public class UserDao {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EncryptionUtil aesUtil;
	
	public User getUser(User user) {
		return userRepo.findByUserEmail(user.getEmail());
	}
	
	public User getUserByEmail(String email) {
		return userRepo.findByUserEmail(email);
	}
	
	public User getUserByPhoneOrEmail(String email,String phone) {
		return userRepo.findByEmailOrPhone(email,phone);
	}
	
	public User loginUser(String emailOrphone,String password) throws Exception {
		return userRepo.loginUser(emailOrphone ,password);
	}

	public User registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setEmail(user.getEmail());
		return userRepo.save(user);
	}
}
