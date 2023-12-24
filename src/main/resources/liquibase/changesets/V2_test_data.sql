INSERT INTO departments (name)
VALUES ('Department A'),
       ('Department B'),
       ('Department C');

INSERT INTO employees (name, username, phone_number, password, salary, is_active)
VALUES ('John Doe', 'johndoe', '1234567890', 'password1', 5000.00, true),
       ('Jane Smith', 'janesmith', '9876543210', 'password2', 6000.00, true),
       ('Mike Johnson', 'mikejohnson', '5555555555', 'password3', 4500.00, true);

INSERT INTO roles (name)
VALUES ('MANAGER'),
       ('EMPLOYEE'),
       ('ADMIN');

INSERT INTO departments_employees (department_id, employee_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO employees_roles (employee_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO tasks (title, description, status, expiration_data)
VALUES ('Task 1', 'Description for Task 1', 'DONE', '2023-01-01'),
       ('Task 2', 'Description for Task 2', 'TODO', '2023-03-15'),
       ('Task 3', 'Description for Task 3', 'IN_PROGRESS', '2023-05-30');

INSERT INTO departments_tasks (department_id, task_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);