
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'user');

INSERT INTO public.location (id, city, country) VALUES (DEFAULT, 'Tallinn', 'Estonia');
INSERT INTO public.location (id, city, country) VALUES (DEFAULT, 'London', 'UK');

INSERT INTO public."user" (id, role_id, username, password, picture, description, github, linkedin, telephone, email, firstname,lastname, cvstatus) VALUES (DEFAULT, 1, 'mihkel', '123', null, 'Tere otsin tööd!', 'LadvikM', 'Ladvik', '+37253417899', 'Ladvik@gmail.com', 'Mihkel', 'Ladvik', 'A');
INSERT INTO public."user" (id, role_id, username, password, picture, description, github, linkedin, telephone, email, firstname, lastname, cvstatus) VALUES (DEFAULT, 2, 'norri', '123', null, 'Ei otsi tööd!', null, null, 'Ei ole', 'Ei ole', ' Norri', 'Bird', 'A');

INSERT INTO public.hobbies (id, name, description, picture, user_id) VALUES (DEFAULT, 'Photography', 'Taking pictures', null, 1);
INSERT INTO public.hobbies (id, name, description, picture, user_id) VALUES (DEFAULT, 'Singing', 'Singing bird songs', null, 2);

INSERT INTO public.company (id, name, location_id, user_id) VALUES (DEFAULT, 'Magnetic MRO', 1, 1);
INSERT INTO public.company (id, name, location_id, user_id) VALUES (DEFAULT, 'Zodiac Maritime', 2, 1);

INSERT INTO public.school (id, name, location_id, user_id) VALUES (DEFAULT, 'Estonian Aviation Academy', 1, 1);
INSERT INTO public.school (id, name, location_id, user_id) VALUES (DEFAULT, 'Estonian Maritime Academy', 1, 2);

INSERT INTO public.subject (id, name, start, "end", description, school_id) VALUES (DEFAULT, 'Aircraft Mechanic', '2020-04-01', '2022-01-17', 'Learning how to fix planes.', 1);
INSERT INTO public.subject (id, name, start, "end", description, school_id) VALUES (DEFAULT, 'Navigation', '2010-09-01', '2017-06-16', 'Leaning how to drive ships.', 2);

INSERT INTO public.position (id, name, start, "end", description, company_id) VALUES (DEFAULT, 'Aircraft Mechanic', '2022-09-01', null, 'Fixing planes', 1);
INSERT INTO public.position (id, name, start, "end", description, company_id) VALUES (DEFAULT, 'Aircraft Mechanic Apprentice', '2020-04-01', '2022-08-31', 'Learning how to fix planes.', 1);
INSERT INTO public.position (id, name, start, "end", description, company_id) VALUES (DEFAULT, 'Navigation Officer', '2017-07-27', '2020-02-01', 'Sailing ships', 2);

INSERT INTO public.additional_information (id, information_name, information_description, user_id) VALUES (DEFAULT, 'Driving licence', 'B - category', 1);
INSERT INTO public.additional_information (id, information_name, information_description, user_id) VALUES (DEFAULT, 'Food', 'I like seeds', 2);