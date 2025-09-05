package com.taskapi.taskapi.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapi.taskapi.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByTitleIgnoreCaseContaining(String title);
}
