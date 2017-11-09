CREATE DATABASE db_developers;

CREATE TABLE IF NOT EXISTS developers (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50),
  second_name VARCHAR(50),
  salary DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS skills(
  id INT NOT NULL AUTO_INCREMENT,
  skill_name VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS projects(
  id INT NOT NULL AUTO_INCREMENT,
  project_name VARCHAR(50),
  cost DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS companies(
  id INT NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customers(
  id INT NOT NULL AUTO_INCREMENT,
  customer_name VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS developer_skill(
  id INT NOT NULL AUTO_INCREMENT,
  developer_id INT,
  skill_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (developer_id) REFERENCES developers(id),
  FOREIGN KEY (skill_id) REFERENCES skills(id)
);

CREATE TABLE IF NOT EXISTS developer_project(
  id INT NOT NULL AUTO_INCREMENT,
  developer_id INT,
  project_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (developer_id) REFERENCES developers(id),
  FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE IF NOT EXISTS company_project(
  id INT NOT NULL AUTO_INCREMENT,
  company_id INT,
  project_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES companies(id),
  FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE IF NOT EXISTS customer_project(
  id INT NOT NULL AUTO_INCREMENT,
  customer_id INT,
  project_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (project_id) REFERENCES projects(id)
);