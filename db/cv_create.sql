-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-09 21:10:05.429

-- tables
-- Table: cv
CREATE TABLE cv (
    id serial  NOT NULL DEFAULT null,
    user_id int  NOT NULL DEFAULT null,
    status char(1)  NOT NULL DEFAULT null,
    CONSTRAINT cv_pk PRIMARY KEY (id)
);

-- Table: education
CREATE TABLE education (
    id serial  NOT NULL DEFAULT null,
    cv_id int  NOT NULL DEFAULT null,
    location_id int  NOT NULL DEFAULT null,
    school_name varchar(100)  NOT NULL DEFAULT null,
    CONSTRAINT education_pk PRIMARY KEY (id)
);

-- Table: hobbies
CREATE TABLE hobbies (
    id serial  NOT NULL DEFAULT null,
    cv_id int  NOT NULL DEFAULT null,
    name varchar(100)  NOT NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    CONSTRAINT hobbies_pk PRIMARY KEY (id)
);

-- Table: knowledge
CREATE TABLE knowledge (
    id serial  NOT NULL DEFAULT null,
    cv_id int  NOT NULL DEFAULT null,
    skill varchar(100)  NOT NULL DEFAULT null,
    description varchar(5000)  NOT NULL DEFAULT null,
    CONSTRAINT knowledge_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL DEFAULT null,
    city varchar(100)  NULL DEFAULT null,
    country varchar(100)  NULL DEFAULT null,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: position
CREATE TABLE position (
    id serial  NOT NULL DEFAULT null,
    workplace_id int  NOT NULL DEFAULT null,
    name varchar(100)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT position_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL DEFAULT null,
    type varchar(20)  NOT NULL DEFAULT null,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: subject
CREATE TABLE subject (
    id serial  NOT NULL DEFAULT null,
    school_id int  NOT NULL DEFAULT null,
    name varchar(100)  NOT NULL DEFAULT null,
    start date  NOT NULL DEFAULT null,
    "end" date  NULL DEFAULT null,
    description varchar(5000)  NULL DEFAULT null,
    CONSTRAINT subject_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL DEFAULT null,
    role_id int  NOT NULL DEFAULT null,
    username varchar(50)  NOT NULL DEFAULT null,
    password varchar(50)  NOT NULL DEFAULT null,
    picture bytea  NULL DEFAULT null,
    description varchar(5000)  NOT NULL DEFAULT null,
    github varchar(100)  NULL,
    linkedin varchar(100)  NULL,
    telephone varchar(100)  NULL,
    email varchar(100)  NULL,
    CONSTRAINT username UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: workplace
CREATE TABLE workplace (
    id serial  NOT NULL DEFAULT null,
    cv_id int  NOT NULL DEFAULT null,
    location_id int  NOT NULL DEFAULT null,
    name varchar(100)  NOT NULL DEFAULT null,
    CONSTRAINT workplace_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: cv_user (table: cv)
ALTER TABLE cv ADD CONSTRAINT cv_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: hobbies_cv (table: hobbies)
ALTER TABLE hobbies ADD CONSTRAINT hobbies_cv
    FOREIGN KEY (cv_id)
    REFERENCES cv (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: position_workplace (table: position)
ALTER TABLE position ADD CONSTRAINT position_workplace
    FOREIGN KEY (workplace_id)
    REFERENCES workplace (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: school_cv (table: education)
ALTER TABLE education ADD CONSTRAINT school_cv
    FOREIGN KEY (cv_id)
    REFERENCES cv (id)  
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

-- Reference: skills_cv (table: knowledge)
ALTER TABLE knowledge ADD CONSTRAINT skills_cv
    FOREIGN KEY (cv_id)
    REFERENCES cv (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: subject_school (table: subject)
ALTER TABLE subject ADD CONSTRAINT subject_school
    FOREIGN KEY (school_id)
    REFERENCES education (id)  
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

-- Reference: workplace_cv (table: workplace)
ALTER TABLE workplace ADD CONSTRAINT workplace_cv
    FOREIGN KEY (cv_id)
    REFERENCES cv (id)  
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

-- End of file.

