package com.hashgo.room.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.hashgo.room.entities.User;

@Component
public interface UserRepo extends JpaRepository<User, Integer>{

	@Query("select p from User p where p.email=?1")
	User findByUserEmail(String email);

	@Query("select p from User p where p.email=?1 or p.phoneNo=?2")
	User findByEmailOrPhone(String email, String phone);

	@Query("Select p from User p where (p.email=?1or p.phoneNo=?1) and p.password=?2")
	User loginUser(String emailOrphone, String password);
}
