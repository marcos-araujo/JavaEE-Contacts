CREATE DATABASE PROJECTS;

USE PROJECTS;

--MYSQL

CREATE TABLE CONTACT(
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(80) DEFAULT NULL,
  EMAIL varchar(80) DEFAULT NULL,
  ADDRESS varchar(100) DEFAULT NULL,
  BIRTHDATE date DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--POSTGREESQL
CREATE TABLE CONTACT(
  ID SERIAL PRIMARY KEY,
  NAME varchar(80) DEFAULT NULL,
  EMAIL varchar(80) DEFAULT NULL,
  ADDRESS varchar(100) DEFAULT NULL,
  BIRTHDATE date DEFAULT NULL
);