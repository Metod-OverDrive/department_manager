package com.practice.departmentManager.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.departmentManager.domain.task.Status;
import com.practice.departmentManager.web.dto.validation.OnCreate;
import com.practice.departmentManager.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TaskDto {

    private Long id;

    @NotNull(message = "Title must be not null.",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255,
            message = "Title length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Length(max = 255,
            message = "Description length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

}
