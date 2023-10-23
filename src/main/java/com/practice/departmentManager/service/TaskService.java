package com.practice.departmentManager.service;

import com.practice.departmentManager.domain.task.Task;

import java.time.Duration;
import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByDepartmentId(Long id);

    List<Task> getAllSoonTasks(Duration duration);

    Task update(Task task);

    Task create(Task task, Long DepartmentId);

    void delete(Long id);
}
