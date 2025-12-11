DROP DATABASE IF EXISTS lognadb;
CREATE DATABASE lognadb CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE lognadb;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE roles (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO roles (id, role_name) VALUES
                                      (1, 'user'),
                                      (2, 'admin');

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,          -- AJOUTÉ pour ton AuthController
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       roles_id INT NOT NULL DEFAULT 1,
                       xp INT NOT NULL DEFAULT 0,
                       created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                       niveau VARCHAR(20)
                           GENERATED ALWAYS AS (
                               CASE
                                   WHEN xp < 100 THEN 'débutant'
                                   WHEN xp < 500 THEN 'confirmé'
                                   ELSE 'expert'
                                   END
                               ) STORED,
                       CONSTRAINT fk_user_role FOREIGN KEY (roles_id) REFERENCES roles(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE categories (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            description TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE books (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       book_url VARCHAR(500) DEFAULT NULL,
                       created_by INT NOT NULL,
                       created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                       book_type ENUM('audio','ecrit') NOT NULL DEFAULT 'ecrit',
                       category_id INT DEFAULT NULL,
                       description TEXT,
                       CONSTRAINT fk_books_user FOREIGN KEY (created_by) REFERENCES users(id),
                       CONSTRAINT fk_books_category FOREIGN KEY (category_id) REFERENCES categories(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

