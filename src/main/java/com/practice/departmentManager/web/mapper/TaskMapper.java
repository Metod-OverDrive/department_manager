package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.task.Task;
import com.practice.departmentManager.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto>{

    List<TaskDto> toDto(List<Task> tasks);
}
