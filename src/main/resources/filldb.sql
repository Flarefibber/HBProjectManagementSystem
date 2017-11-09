INSERT INTO developers (first_name, second_name, salary) VALUES ("Ivan","Ivanov", 1000.00);
INSERT INTO developers (first_name, second_name, salary) VALUES ("Petro", "Petrov", 1200.00);
INSERT INTO developers (first_name, second_name, salary) VALUES ("Taras", "Tarasov", 1500.00);

INSERT INTO skills (skill_name) VALUES ("Java");
INSERT INTO skills (skill_name) VALUES ("C++");
INSERT INTO skills (skill_name) VALUES ("MySQL");

INSERT INTO projects (project_name) VALUES ("Homework");

INSERT INTO companies (company_name) VALUES ("GoIT");

INSERT INTO customers (customer_name) VALUES ("Homework Java Developer");

INSERT INTO developer_skill (developer_id, skill_id) VALUES (1,3);
INSERT INTO developer_skill (developer_id, skill_id) VALUES (2,1);
INSERT INTO developer_skill (developer_id, skill_id) VALUES (3,2);
INSERT INTO developer_skill (developer_id, skill_id) VALUES (3,3);

INSERT INTO developer_project (developer_id, project_id) VALUES (2,1);

INSERT INTO company_project (company_id, project_id) VALUES (1,1);

INSERT INTO customer_project (customer_id, project_id) VALUES (1,1);