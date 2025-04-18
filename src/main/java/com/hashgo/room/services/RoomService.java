package com.hashgo.room.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hashgo.room.dao.RoomDao;
import com.hashgo.room.dto.RoomDto;
import com.hashgo.room.dto.RoomDtoMapper;
import com.hashgo.room.entities.Room;
import com.hashgo.room.repositories.ExpenseRepo;

@Service
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private RoomDtoMapper roomDtoMapper;
	
	public ResponseEntity<?> getRoomById(int id){
		Map<String, Object> response=new HashMap<String, Object>();
		try {
			Room room=roomDao.getRoomById(id);
			if(room!=null) {
				response.put("data", roomDtoMapper.toRoomDto(room));
				response.put("status", "200"); 
				response.put("message","Room Found");
				return ResponseEntity.ok(response);
			}else {
				response.put("status", "409"); 
				response.put("message","Room Not Found");
				return ResponseEntity.ok(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			
		}
		
		
	}
	
	public ResponseEntity<?> createRoom(RoomDto roomDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        roomDao.createRoom(roomDtoMapper.toRoom(roomDto));
	        response.put("status", "201");
	        response.put("message", "Room Created Successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Creating Room");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> updateRoom(int id, RoomDto roomDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (roomDao.getRoomById(id)!=null) {
	            roomDao.updateRoom(roomDtoMapper.toRoom(roomDto));
	            response.put("status", "200");
	            response.put("message", "Room Updated Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Room Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Updating Room");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> deleteRoom(int id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (roomDao.getRoomById(id)!=null) {
	            roomDao.deleteById(id);
	            response.put("status", "200");
	            response.put("message", "Room Deleted Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Room Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Deleting Room");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> getAllRooms() {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        List<Room> rooms = roomDao.findAllRoom();
	        response.put("data", rooms);
	        response.put("status", "200");
	        response.put("message", "Rooms Retrieved Successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Fetching Rooms");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}