package com.hashgo.room.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hashgo.room.entities.Task;
import com.hashgo.room.repositories.TaskRepo;

public class TaskDao {

	@Autowired
	private TaskRepo repo;

	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		Optional<Task> task=repo.findById(id);
		if(task.isPresent()) {
			return task.get();
		}else {
			return null;
		}
	}

	public void createTask(Task task) {
		// TODO Auto-generated method stub
		repo.save(task);
	}

	public List<Task> findAllTask() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Task> task=repo.findById(id);
		if(task.isPresent()) {
			repo.delete(task.get());
		}
		
	}

	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		Optional<Task> optionalTask=repo.findById(task.getId());
		if(optionalTask.isPresent()) {
			Task updateTask=optionalTask.get();
			repo.save(updateTask);
		}
		
	}
}
