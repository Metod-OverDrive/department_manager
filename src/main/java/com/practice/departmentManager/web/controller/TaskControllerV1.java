package com.practice.departmentManager.web.controller;

import com.practice.departmentManager.domain.task.Task;
import com.practice.departmentManager.service.KafkaDataService;
import com.practice.departmentManager.service.ReminderService;
import com.practice.departmentManager.service.TaskService;
import com.practice.departmentManager.service.impl.ReminderServiceImpl;
import com.practice.departmentManager.web.dto.task.TaskDto;
import com.practice.departmentManager.web.dto.validation.OnUpdate;
import com.practice.departmentManager.web.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskControllerV1 {

    private final TaskService taskService;
    private final ReminderServiceImpl reminderService;
    private final TaskMapper taskMapper;

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class)
                          @RequestBody  TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

    @GetMapping("/kafka")
    public void kafkaTest() {
        reminderService.testRemindTask();
    }
}
