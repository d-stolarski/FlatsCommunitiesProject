INSERT INTO community (id, name, adress) VALUES (1, 'Miła', 'Sportowa 1');
INSERT INTO community (id, name, adress) VALUES (2, '500+', 'Grecka 22');
INSERT INTO community (id, name, adress) VALUES (3, 'Rodzina na swoim', 'Zimowa 45');
INSERT INTO community (id, name, adress) VALUES (4, 'Sąsiedzi', 'Krótka 24');
INSERT INTO community (id, name, adress) VALUES (5, 'Zwycięska', 'Zwycięska 2');
INSERT INTO community (id, name, adress) VALUES (6, 'Radosna', 'Sportowa 3');
INSERT INTO community (id, name, adress) VALUES (7, 'Czekoladowa', 'Zielon 23');
INSERT INTO community (id, name, adress) VALUES (8, 'Sąsiadowo', 'Wiosenna 46');
INSERT INTO community (id, name, adress) VALUES (9, 'Sami swoi', 'Długa 8');
INSERT INTO community (id, name, adress) VALUES (10, 'Młodzi w domu', 'Czerwona 4');

INSERT INTO flat (id, number, area, community_id) VALUES (1, 2, 23.4, 1);
INSERT INTO flat (id, number, area, community_id) VALUES (2, 5, 65.2, 1);
INSERT INTO flat (id, number, area, community_id) VALUES (3, 8, 55, 3);
INSERT INTO flat (id, number, area, community_id) VALUES (4, 12, 34.3, 2);
INSERT INTO flat (id, number, area, community_id) VALUES (5, 2, 45, 2);

INSERT INTO dweller (id, first_name, last_name, gender, flat_id) VALUES (1, 'Jan', 'Kowalski', 'Mężczyzna', 2);
INSERT INTO dweller (id, first_name, last_name, gender, flat_id) VALUES (2, 'Paweł', 'Kwiatek', 'Mężczyzna', 3);
INSERT INTO dweller (id, first_name, last_name, gender, flat_id) VALUES (3, 'Janina', 'Rogacka', 'Kobieta', 1);
INSERT INTO dweller (id, first_name, last_name, gender, flat_id) VALUES (4, 'Anna', 'Iglicka', 'Kobieta', 2);
INSERT INTO dweller (id, first_name, last_name, gender, flat_id) VALUES (5, 'Grzegorz', 'Jankowski', 'Mężczyzna', 2);