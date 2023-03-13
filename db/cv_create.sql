-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-13 12:20:40.23

-- tables
-- Table: cv
CREATE TABLE cv (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    status char(1)  NOT NULL,
    workplace_id int  NULL,
    education_id int  NULL,
    hobbies_id int  NULL,
    CONSTRAINT cv_pk PRIMARY KEY (id)
);

-- Table: education
CREATE TABLE education (
    id serial  NOT NULL,
    location_id int  NOT NULL,
    school_name varchar(100)  NOT NULL DEFAULT null,
    subject_id int  NOT NULL,
    CONSTRAINT education_pk PRIMARY KEY (id)
);

-- Table: hobbies
CREATE TABLE hobbies (
    id serial  NOT NULL,
    name varchar(100)  NOT NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    CONSTRAINT hobbies_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    city varchar(100)  NULL DEFAULT null,
    country varchar(100)  NULL DEFAULT null,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: position
CREATE TABLE position (
    id serial  NOT NULL,
    name varchar(100)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT position_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    type varchar(20)  NOT NULL DEFAULT null,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: subject
CREATE TABLE subject (
    id serial  NOT NULL ,
    name varchar(100)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT subject_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(50)  NOT NULL DEFAULT null,
    password varchar(50)  NOT NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    description varchar(5000)  NOT NULL DEFAULT null,
    github varchar(100)  NULL,
    linkedin varchar(100)  NULL,
    telephone varchar(100)  NULL,
    email varchar(100)  NULL,
    firstname varchar(100) NOT NULL,
    lastname varchar(100) NOT NULL,
    CONSTRAINT username UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: workplace
CREATE TABLE workplace (
    id serial  NOT NULL,
    name varchar(100)  NOT NULL DEFAULT null,
    location_id int  NOT NULL,
    position_id int  NOT NULL,
    CONSTRAINT workplace_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: cv_education (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_education
    FOREIGN KEY (education_id)
    REFERENCES education (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: cv_hobbies (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_hobbies
    FOREIGN KEY (hobbies_id)
    REFERENCES hobbies (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: cv_user (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: cv_workplace (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_workplace
    FOREIGN KEY (workplace_id)
    REFERENCES workplace (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: education_subject (table: education)
ALTER TABLE education ADD CONSTRAINT education_subject
    FOREIGN KEY (subject_id)
    REFERENCES subject (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_location (table: education)
ALTER TABLE education ADD CONSTRAINT school_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
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

-- Reference: workplace_position (table: workplace)
ALTER TABLE workplace ADD CONSTRAINT workplace_position
    FOREIGN KEY (position_id)
    REFERENCES position (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

