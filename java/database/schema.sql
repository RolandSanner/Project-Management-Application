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

CREATE TABLE contacts (
	contact_id SERIAL,
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	phoneNumber varchar(25) NOT NULL,
	email varchar(50) NOT NULL,
	municipality varchar(50),
	contact_role varchar(50) NOT NULL,
	companyName varchar(50),
	industry varchar(50),
	contact_street varchar(100),
	contact_city varchar(50),
	contact_state varchar(50),
	contact_zip varchar(15),
	CONSTRAINT PK_contact PRIMARY KEY (contact_id)
-- 	CONSTRAINT FK_contact_user FOREIGN KEY (contact_id) REFERENCES users(user_id)
);

CREATE TABLE groups (
	group_id serial,
	group_name varchar(50) NOT NULL,
	program_manager_id int NOT NULL,
	CONSTRAINT PK_group PRIMARY KEY (group_id),
	CONSTRAINT FK_group_manager FOREIGN KEY (program_manager_id) REFERENCES contacts(contact_id)
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
	contractName varchar(50),
	fundingSource varchar (50),
	CONSTRAINT PK_project PRIMARY KEY (project_id),
	CONSTRAINT FK_project_manager FOREIGN KEY (project_manager_id) REFERENCES contacts(contact_id),
	CONSTRAINT FK_group_projects FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE project_contractors (
	contractor_id int NOT NULL,
	project_id varchar(50) NOT NULL,
	CONSTRAINT PK_project_contractor PRIMARY KEY (contractor_id, project_id),
	CONSTRAINT FK_project_contractor_contractors FOREIGN KEY (contractor_id) REFERENCES contacts(contact_id),
	CONSTRAINT FK_project_contractor_project FOREIGN KEY (project_id) REFERENCES projects(project_id)
);

CREATE TABLE group_contacts (
	contact_id int NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_group_contacts PRIMARY KEY (contact_id, group_id),
	CONSTRAINT FK_group_contacts_contacts FOREIGN KEY (contact_id) REFERENCES contacts(contact_id),
	CONSTRAINT FK_group_contacts_group FOREIGN KEY (group_id) REFERENCES groups(group_id)
);




INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
-- INSERT INTO contacts (contact_id, firstName, lastName, phoneNumber, email, municipality, contact_role) VALUES ('1', 'Roland', 'Sanner', '1234567890', '123@abc.com', 'a', 'Project Manager');
-- INSERT INTO contacts (contact_id, firstName, lastName, phoneNumber, email, municipality, contact_role) VALUES ('2', 'Jack', 'Khodr', '1234567890', '12@abcd.com', 'a', 'Program Manager');
-- INSERT INTO groups (group_name, program_manager_id) VALUES ('Bridges','2');
-- INSERT INTO projects (project_id, project_name, project_description, project_location, precinct, municipality, project_manager_id, group_id) VALUES ('One','The First Bridge', 'Bridge in Austin','Austin', '1', 'a', '1', '1');

COMMIT TRANSACTION;
