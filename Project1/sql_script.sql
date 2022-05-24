DROP TABLE IF EXISTS ers_users CASCADE;
DROP TABLE IF EXISTS ers_reimbursements CASCADE;

CREATE TYPE ROLE AS ENUM ('Employee', 'Manager');
CREATE TYPE ROLE AS ENUM ('Lodging', 'Travel', 'Food', 'Other');
CREATE TYPE status AS enum('Pending', 'Approved', 'Denied');

CREATE TABLE ers_users (

id serial PRIMARY KEY,

username varchar (250) UNIQUE NOT NULL,
password varchar (250) NOT NULL,
role varchar (250) NOT NULL
);

CREATE TABLE ers_reimbursements(

id serial PRIMARY KEY,

author int NOT NULL,
resolver int,

description TEXT NOT NULL,

TYPE varchar (250) NOT NULL,
status varchar (250) NOT NULL,
amount float NOT NULL, 
CONSTRAINT fk_author
	FOREIGN KEY (author)
		REFERENCES ers_users(id),
CONSTRAINT fk_resolver
	FOREIGN KEY (resolver)
		REFERENCES ers_users(id)
);


INSERT INTO ers_users (username,PASSWORD,role)
VALUES ('default', 'guest', 'Employee',),('admin', 'admin', 'Manager');