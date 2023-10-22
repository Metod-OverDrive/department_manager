package com.practice.departmentManager.domain.task;

import com.practice.departmentManager.domain.department.Department;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "expiration_data")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

}