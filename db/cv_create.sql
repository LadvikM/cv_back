-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-15 15:44:47.152

-- tables
-- Table: additional_information
CREATE TABLE additional_information (
    id serial  NOT NULL,
    information_name varchar(255)  NULL DEFAULT null,
    information_description varchar(5000)  NULL DEFAULT null,
    user_id int  NOT NULL DEFAULT null,
    CONSTRAINT additional_information_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    location_id int  NOT NULL DEFAULT null,
    user_id int  NOT NULL,
    CONSTRAINT workplace_pk PRIMARY KEY (id)
);

-- Table: company_position
CREATE TABLE company_position (
    id serial  NOT NULL,
    company_id int  NOT NULL,
    position_id int  NOT NULL,
    CONSTRAINT company_position_pk PRIMARY KEY (id)
);

-- Table: hobbies
CREATE TABLE hobbies (
    id serial  NOT NULL,
    name varchar(255)  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    user_id int  NOT NULL DEFAULT null,
    CONSTRAINT hobbies_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    city varchar(255)  NULL DEFAULT null,
    country varchar(255)  NULL DEFAULT null,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: position
CREATE TABLE position (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT position_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    type varchar(255)  NOT NULL DEFAULT null,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: school
CREATE TABLE school (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    location_id int  NOT NULL DEFAULT null,
    user_id int  NOT NULL,
    CONSTRAINT education_pk PRIMARY KEY (id)
);

-- Table: school_subject
CREATE TABLE school_subject (
    id serial  NOT NULL,
    subject_id int  NOT NULL,
    school_id int  NOT NULL,
    CONSTRAINT school_subject_pk PRIMARY KEY (id)
);

-- Table: subject
CREATE TABLE subject (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT subject_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL DEFAULT null,
    username varchar(255)  NOT NULL DEFAULT null,
    password varchar(255)  NOT NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    github varchar(255)  NULL DEFAULT null,
    linkedin varchar(255)  NULL DEFAULT null,
    telephone varchar(255)  NOT NULL DEFAULT null,
    email varchar(255)  NOT NULL DEFAULT null,
    firstname varchar(255)  NOT NULL DEFAULT null,
    lastname varchar(255)  NOT NULL DEFAULT null,
    CONSTRAINT username UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: additional_information_user (table: additional_information)
ALTER TABLE additional_information ADD CONSTRAINT additional_information_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_position_company (table: company_position)
ALTER TABLE company_position ADD CONSTRAINT company_position_company
    FOREIGN KEY (company_id)
    REFERENCES company (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_position_position (table: company_position)
ALTER TABLE company_position ADD CONSTRAINT company_position_position
    FOREIGN KEY (position_id)
    REFERENCES position (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_user (table: company)
ALTER TABLE company ADD CONSTRAINT company_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: hobbies_user (table: hobbies)
ALTER TABLE hobbies ADD CONSTRAINT hobbies_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_location (table: school)
ALTER TABLE school ADD CONSTRAINT school_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_subject_school (table: school_subject)
ALTER TABLE school_subject ADD CONSTRAINT school_subject_school
    FOREIGN KEY (school_id)
    REFERENCES school (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_subject_subject (table: school_subject)
ALTER TABLE school_subject ADD CONSTRAINT school_subject_subject
    FOREIGN KEY (subject_id)
    REFERENCES subject (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_user (table: school)
ALTER TABLE school ADD CONSTRAINT school_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: workplace_location (table: company)
ALTER TABLE company ADD CONSTRAINT workplace_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

