package com.hashgo.room.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hashgo.room.dao.TaskDao;
import com.hashgo.room.dto.TaskDto;
import com.hashgo.room.dto.TaskDtoMapper;
import com.hashgo.room.entities.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDao taskDao;

	@Autowired
	private TaskDtoMapper taskDtoMapper;

	public ResponseEntity<?> getTaskById(int id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        Task task = taskDao.getTaskById(id);
	        if (task != null) {
	            response.put("data", taskDtoMapper.toTaskDto(task));
	            response.put("status", "200");
	            response.put("message", "Task Found");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "409");
	            response.put("message", "Task Not Found");
	            return ResponseEntity.ok(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	public ResponseEntity<?> createTask(TaskDto taskDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        taskDao.createTask(taskDtoMapper.toTask(taskDto));
	        response.put("status", "201");
	        response.put("message", "Task Created Successfully");
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Creating Task");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> updateTask(int id, TaskDto taskDto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (taskDao.getTaskById(id)!=null) {
	            taskDto.setId(id);
	            taskDao.updateTask(taskDtoMapper.toTask(taskDto));
	            response.put("status", "200");
	            response.put("message", "Task Updated Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Task Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Updating Task");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> deleteTask(int id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        if (taskDao.getTaskById(id)!=null) {
	            taskDao.deleteById(id);
	            response.put("status", "200");
	            response.put("message", "Task Deleted Successfully");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("status", "404");
	            response.put("message", "Task Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Deleting Task");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	public ResponseEntity<?> getAllTasks() {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        List<Task> tasks = taskDao.findAllTask();
	        response.put("data", tasks);
	        response.put("status", "200");
	        response.put("message", "Tasks Retrieved Successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("status", "500");
	        response.put("message", "Error Fetching Tasks");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}