BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE visitors (
	visitor_id int NOT NULL,
	firstName varchar(50),
	lastName varchar(50),
	company_position varchar(25),
	CONSTRAINT PK_visitor PRIMARY KEY (visitor_id)
);

CREATE TABLE managers (
	manager_id int NOT NULL,
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	phoneNumber varchar(25) NOT NULL,
	email varchar(50) NOT NULL,
	municipality varchar(50) NOT NULL,
	manager_role varchar(50) NOT NULL,
	CONSTRAINT PK_manager PRIMARY KEY (manager_id),
	CONSTRAINT FK_manager_user FOREIGN KEY (manager_id) REFERENCES users(user_id)
);

CREATE TABLE groups (
	group_id serial,
	group_name varchar(50) NOT NULL,
	program_manager_id int NOT NULL,
	CONSTRAINT PK_group PRIMARY KEY (group_id),
	CONSTRAINT FK_group_manager FOREIGN KEY (program_manager_id) REFERENCES managers(manager_id)
);

CREATE TABLE projects (
	project_id varchar(50) NOT NULL,
	project_name varchar(50) NOT NULL,
	project_description varchar(250) NOT NULL,
	project_location varchar(100) NOT NULL,
	precinct varchar(50) NOT NULL,
	municipality varchar(50) NOT NULL,
	project_manager_id int NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_project PRIMARY KEY (project_id),
	CONSTRAINT FK_project_manager FOREIGN KEY (project_manager_id) REFERENCES managers(manager_id),
	CONSTRAINT FK_group_projects FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE contractors (
	contractor_id int NOT NULL,
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	phoneNumber varchar(25) NOT NULL,
	email varchar(50) NOT NULL,
	companyName varchar(50) NOT NULL,
	industry varchar(25) NOT NULL,
	contractor_address varchar(100) NOT NULL,
	CONSTRAINT PK_contractor PRIMARY KEY (contractor_id),
	CONSTRAINT FK_contractor_user FOREIGN KEY (contractor_id) REFERENCES users(user_id)
);

CREATE TABLE project_contractors (
	contractor_id int NOT NULL,
	project_id varchar(50) NOT NULL,
	CONSTRAINT PK_project_contractor PRIMARY KEY (contractor_id, project_id),
	CONSTRAINT FK_project_contractor_contractors FOREIGN KEY (contractor_id) REFERENCES contractors(contractor_id),
	CONSTRAINT FK_project_contractor_project FOREIGN KEY (project_id) REFERENCES projects(project_id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
