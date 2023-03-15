-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-15 12:17:16.07

-- tables
-- Table: additional_information
CREATE TABLE additional_information (
    id serial  NOT NULL,
    information_name varchar(255)  NULL,
    information_description varchar(5000)  NULL,
    user_id int  NOT NULL,
    CONSTRAINT additional_information_pk PRIMARY KEY (id)
);

-- Table: hobbies
CREATE TABLE hobbies (
    id serial  NOT NULL,
    name varchar(255)  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    user_id int  NOT NULL,
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
    name varchar(255)  NULL DEFAULT null,
    start date  NULL DEFAULT null,
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
    school_name varchar(255)  NOT NULL DEFAULT null,
    location_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT education_pk PRIMARY KEY (id)
);

-- Table: school_subject
CREATE TABLE school_subject (
    id serial  NOT NULL,
    school_id int  NOT NULL,
    subject_id int  NOT NULL,
    CONSTRAINT school_subject_pk PRIMARY KEY (id)
);

-- Table: subject
CREATE TABLE subject (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NOT NULL DEFAULT null,
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
    github varchar(255)  NULL,
    linkedin varchar(255)  NULL,
    telephone varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    firstname varchar(255)  NOT NULL,
    lastname varchar(255)  NOT NULL,
    CONSTRAINT username UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: workplace
CREATE TABLE workplace (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL DEFAULT null,
    location_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT workplace_pk PRIMARY KEY (id)
);

-- Table: workplace_position
CREATE TABLE workplace_position (
    id serial  NOT NULL,
    workplace_id int  NOT NULL,
    position_id int  NOT NULL,
    CONSTRAINT workplace_position_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_12_school (table: school_subject)
ALTER TABLE school_subject ADD CONSTRAINT Table_12_school
    FOREIGN KEY (school_id)
    REFERENCES school (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Table_12_subject (table: school_subject)
ALTER TABLE school_subject ADD CONSTRAINT Table_12_subject
    FOREIGN KEY (subject_id)
    REFERENCES subject (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: additional_information_user (table: additional_information)
ALTER TABLE additional_information ADD CONSTRAINT additional_information_user
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

-- Reference: workplace_location (table: workplace)
ALTER TABLE workplace ADD CONSTRAINT workplace_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: workplace_position_position (table: workplace_position)
ALTER TABLE workplace_position ADD CONSTRAINT workplace_position_position
    FOREIGN KEY (position_id)
    REFERENCES position (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: workplace_position_workplace (table: workplace_position)
ALTER TABLE workplace_position ADD CONSTRAINT workplace_position_workplace
    FOREIGN KEY (workplace_id)
    REFERENCES workplace (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: workplace_user (table: workplace)
ALTER TABLE workplace ADD CONSTRAINT workplace_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

