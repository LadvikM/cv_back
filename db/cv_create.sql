-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-15 14:25:55.109

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
                          company_id int  NOT NULL,
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

-- Table: subject
CREATE TABLE subject (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL DEFAULT null,
                         start date  NOT NULL DEFAULT null,
                         "end" date  NULL DEFAULT null,
                         description varchar(5000)  NULL DEFAULT null,
                         school_id int  NOT NULL,
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
                        cvstatus varchar(1) NOT NULL,
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

-- Reference: position_company (table: position)
ALTER TABLE position ADD CONSTRAINT position_company
    FOREIGN KEY (company_id)
        REFERENCES company (id)
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

-- Reference: subject_school (table: subject)
ALTER TABLE subject ADD CONSTRAINT subject_school
    FOREIGN KEY (school_id)
        REFERENCES school (id)
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

