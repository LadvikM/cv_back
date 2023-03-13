INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'visitor');

INSERT INTO public."user" (id, role_id, username, password, picture, description, github, linkedin, telephone, email, firstname, lastname) VALUES (DEFAULT, 1, 'mihkel', '123', null, 'Welcome to CV. I started studying programming in January 2023 and now looking for internship position where I could put my skills into use and improve myself. I have made this website to introduce myself and to show my current knowledge. I am updating this as I learn new things. To see the code, click on github icon. If you have any internship positions to offer, feel free to contact me by any means below.', 'LadvikM', 'Ladvik', '+372 53 417 899', 'Ladvik@gmail.com', 'Mihkel', 'Ladvik');

INSERT INTO public.position (id, name, start, "end", description) VALUES (DEFAULT, 'Aircraft Mechanic', '2020-04-20', '2022-12-31', 'Fixing planes');
INSERT INTO public.position (id, name, start, "end", description) VALUES (DEFAULT, 'Navigation Officer', '2017-10-01', '2020-02-01', 'Sailing Ships');

INSERT INTO public.location (id, city, country) VALUES (1, 'Tallinn', 'Estonia');

INSERT INTO public.workplace (id, name, location_id, position_id) VALUES (DEFAULT, 'Magnetic MRO AS', 1, 1);
INSERT INTO public.workplace (id, name, location_id, position_id) VALUES (DEFAULT, 'Zodiac Maritime Ltd', 1, 2);

INSERT INTO public.subject (id, name, start, "end", description) VALUES (DEFAULT, 'Aircraft Mechanic', '2020-04-01', '2022-01-17', 'Aircraft Mechanic. Vocational education.');

INSERT INTO public.education (id, location_id, school_name, subject_id) VALUES (DEFAULT, 1, 'Estonian Aviation Academy', 1);

INSERT INTO public.cv (id, user_id, status, workplace_id, education_id, hobbies_id) VALUES (DEFAULT, 1, 'A', 1, 1, 1)
