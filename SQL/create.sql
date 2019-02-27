
CREATE TABLE IF NOT EXISTS groups (
id SERIAL PRIMARY KEY,  
group_name varchar(15));

CREATE TABLE IF NOT EXISTS students (
id SERIAL PRIMARY KEY,  
first_name varchar(15), 
second_name varchar(15),
group_id INT REFERENCES groups (id));

CREATE TABLE IF NOT EXISTS teachers (
id SERIAL PRIMARY KEY,  
first_name varchar(15),
second_name varchar(15));

CREATE TABLE IF NOT EXISTS subjects (
id SERIAL PRIMARY KEY,  
subject_name varchar(15));
