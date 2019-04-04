INSERT INTO "user" (id, user_name, password) VALUES (1,'juri.tonisson','$2a$10$Hfogk/bZVD9m1ykTJc.Kqu8p8NVkCqco4U9n8z1TnGEKPKQuuR9tq');
INSERT INTO "user" (id, user_name, password) VALUES (2,'Juhan.Juurikas','$2a$10$6ZBM5TUF1zQOhzdASywnBuGu4BqqYzarvkFyosF1ifw3Jv5RKrCtC');
INSERT INTO "user" (id, user_name, password) VALUES (3,'Mare.Maasikas','$2a$10$t7Z82HgdVFcixiF6BKsAEOkOYxYFRcC00ueVdzC6d8wtyaLOV60I.');
INSERT INTO "user" (id, user_name, password) VALUES (4,'Kristel.Mere','$2a$10$akR9MGftknueknev7fqAw.04tEDcTUdklg3vjalkWmOU0fWsj1C36');

INSERT INTO country (id, name) VALUES (1,'Estonia');
INSERT INTO country (id, name) VALUES (2,'Latvia');
INSERT INTO country (id, name) VALUES (3,'Lithuania');
INSERT INTO country (id, name) VALUES (4,'Finland');
INSERT INTO country (id, name) VALUES (5,'Sweden');

INSERT INTO client (id, first_name, last_name, user_name, email, address, country, user_id) VALUES (1, 'John', 'Smith', 'User1', 'john.smith@gmail.com', 'viru 1', '1', '2');
INSERT INTO client (id, first_name, last_name, user_name, email, address, country, user_id) VALUES (2, 'John', 'Smith', 'User2', 'john.smith@gmail.com', 'viru 1', '2', '3');
INSERT INTO client (id, first_name, last_name, user_name, email, address, country, user_id) VALUES (3, 'John', 'Smith', 'User3', 'john.smith@gmail.com', 'viru 1', '3', '4');