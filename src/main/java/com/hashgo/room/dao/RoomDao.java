package com.hashgo.room.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hashgo.room.entities.Room;
import com.hashgo.room.repositories.RoomRepo;

public class RoomDao {
	
	@Autowired
	private RoomRepo repo;

	public Room getRoomById(int id) {
		// TODO Auto-generated method stub
		Optional<Room> room=repo.findById(id);
		if(room.isPresent()) {
			return room.get();
		}else {
			return null;
		}
	}

	public void createRoom(Room room) {
		// TODO Auto-generated method stub
		repo.save(room);
	}

	public List<Room> findAllRoom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Room> room=repo.findById(id);
		if(room.isPresent()) {
			repo.delete(room.get());
		}
		
	}

	public void updateRoom(Room room) {
		// TODO Auto-generated method stub
		Optional<Room> optionalRoom=repo.findById(room.getId());
		if(optionalRoom.isPresent()) {
			Room updateRoom=optionalRoom.get();
			repo.save(updateRoom);
		}
		
	}

}
