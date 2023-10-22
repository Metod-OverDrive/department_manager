package com.practice.departmentManager.repository;

import com.practice.departmentManager.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query(value = """
        INSERT INTO departments_tasks (department_id, task_id)
        VALUES (:departmentId, :taskId)
        """, nativeQuery = true)
    void assignTask(@Param("departmentId") Long departmentId, @Param("taskId") Long taskId);

    @Query(value = """
        SELECT * FROM tasks t
        Join departments_tasks dt on t.id = dt.task_id
        where dt.department_id = :departmentId
        """, nativeQuery = true)
    List<Task> findAllByDepartmentId(@Param("departmentId") Long departmentId);

    @Query(value = """
        SELECT * FROM tasks
        WHERE expiration_data is not null
        AND expiration_data between :start and :end
        """, nativeQuery = true)
    List<Task> findAllSoonTasks(@Param("start") Timestamp start,
                                @Param("end") Timestamp end);


}
