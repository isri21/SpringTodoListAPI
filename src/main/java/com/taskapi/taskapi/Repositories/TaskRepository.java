package com.taskapi.taskapi.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapi.taskapi.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	
}
