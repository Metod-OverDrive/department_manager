package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.task.Status;
import com.practice.departmentManager.domain.task.Task;
import com.practice.departmentManager.repository.TaskRepository;
import com.practice.departmentManager.service.TaskService;
import com.practice.departmentManager.web.exception.ResourceNotFindException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() ->
                new ResourceNotFindException("Task not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByDepartmentId(Long id) {
        return taskRepository.findAllByDepartmentId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllSoonTasks(Duration duration) {
        LocalDateTime now = LocalDateTime.now();
        return taskRepository.findAllSoonTasks(Timestamp.valueOf(now),
                Timestamp.valueOf(now.plus(duration)));
    }

    @Override
    @Transactional
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task create(Task task, Long departmentId) {
        task.setStatus(Status.TODO);
        Task updateTask = taskRepository.save(task);
        taskRepository.assignTask(departmentId, updateTask.getId());
        return updateTask;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
