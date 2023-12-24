package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.domain.mailRemind.Remind;
import com.practice.departmentManager.domain.task.Task;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.service.KafkaDataService;
import com.practice.departmentManager.service.ReminderService;
import com.practice.departmentManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final KafkaDataService kafkaDataService;
    private final Duration DURATION = Duration.ofDays(1);

    @Scheduled(cron = "0 0 0 * * *")
    @Override
    public void remindForTask() {
        List<Task> tasks = taskService.getAllSoonTasks(DURATION);
        tasks.forEach(task -> {
            List<Employee> employees = employeeService.getAllEmployeeByTaskId(task.getId());
            Remind remind = getRemind(task, employees);
            kafkaDataService.send(remind);
        });
    }

    public void testRemindTask() {
        List<Task> tasks = taskService.getAllByDepartmentId(1L);
        tasks.forEach(task -> {
            List<Employee> employees = employeeService.getAllEmployeeByTaskId(task.getId());
            Remind remind = getRemind(task, employees);
            kafkaDataService.send(remind);
        });
    }

    private Remind getRemind(Task task, List<Employee> employees) {
        return Remind.builder()
                .taskTitle(task.getTitle())
                .taskDescription(task.getDescription())
                .expirationDate(task.getExpirationDate())
                .employees(employees)
                .build();
    }
}
