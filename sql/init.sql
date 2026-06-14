CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    teacher VARCHAR(100) NOT NULL,
    duration INT NOT NULL
);

INSERT INTO students (name, email, age) VALUES
('Ahmed', 'ahmed@email.com', 20),
('Sara', 'sara@email.com', 22);

INSERT INTO courses (title, teacher, duration) VALUES
('Java OOP', 'M. Erraji', 12),
('Servlet et JSP', 'M. Erraji', 9);
