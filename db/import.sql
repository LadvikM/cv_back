INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'visitor');

INSERT INTO public."user" (id, role_id, username, password, picture, description, github, linkedin, telephone, email, firstname, lastname) VALUES (DEFAULT, 1, 'mihkel', '123', null, 'Welcome to CV. I started studying programming in January 2023 and now looking for internship position where I could put my skills into use and improve myself. I have made this website to introduce myself and to show my current knowledge. I am updating this as I learn new things. To see the code, click on github icon. If you have any internship positions to offer, feel free to contact me by any means below.', 'LadvikM', 'Ladvik', '+372 53 417 899', 'Ladvik@gmail.com', 'Mihkel', 'Ladvik')