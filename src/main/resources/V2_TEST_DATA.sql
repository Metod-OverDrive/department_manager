INSERT INTO department_manager.departments (name) VALUES ('Department 1');

INSERT INTO department_manager.employees (name, username, phone_number, password, salary, is_active) VALUES ('Employee 1', 'employee1', '1234567890', 'password1', 1000, true);

INSERT INTO department_manager.employees (name, username, phone_number, password, salary, is_active) VALUES ('Employee 2', 'employee2', '9876543210', 'password2', 1500, true);

INSERT INTO department_manager.employees (name, username, phone_number, password, salary, is_active) VALUES ('Employee 3', 'employee3', '5678901234', 'password3', 2000, true);

INSERT INTO department_manager.tasks (title, description, status, expiration_data) VALUES ('Task 1', 'Description 1', 'Pending', '2022-12-31');

INSERT INTO department_manager.departments_tasks (department_id, task_id) VALUES (1, 1);

INSERT INTO department_manager.roles (name) VALUES ('User');

INSERT INTO department_manager.employees_roles (employee_id, role_id) VALUES (1, 1);

INSERT INTO department_manager.employees_roles (employee_id, role_id) VALUES (2, 1);

INSERT INTO department_manager.employees_roles (employee_id, role_id) VALUES (3, 1);

INSERT INTO department_manager.departments_employees (department_id, employee_id) VALUES (1, 1);

INSERT INTO department_manager.departments_employees (department_id, employee_id) VALUES (1, 2);

INSERT INTO department_manager.departments_employees (department_id, employee_id) VALUES (1, 3);