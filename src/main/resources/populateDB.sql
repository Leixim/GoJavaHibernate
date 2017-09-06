DELETE FROM initdb.companies;
INSERT INTO initdb.companies VALUES (1, 'EPAM');
INSERT INTO initdb.companies VALUES (2, 'Luxoft');
INSERT INTO initdb.companies VALUES (3, 'GlobalLogic');
INSERT INTO initdb.companies VALUES (4, 'DataArt');
INSERT INTO initdb.companies VALUES (5, 'SoftServe');
INSERT INTO initdb.companies VALUES (6, 'Ciklum');
INSERT INTO initdb.companies VALUES (7, 'Sigma');
INSERT INTO initdb.companies VALUES (8, 'Netcracker');
INSERT INTO initdb.companies VALUES (9, 'Infopulse');

DELETE FROM initdb.customers;
INSERT INTO initdb.customers VALUES (1, 'PrivatBank');
INSERT INTO initdb.customers VALUES (2, 'DTEK');
INSERT INTO initdb.customers VALUES (3, 'Nova Poshta');
INSERT INTO initdb.customers VALUES (4, 'ATB');
INSERT INTO initdb.customers VALUES (5, 'Novus');
INSERT INTO initdb.customers VALUES (6, 'Metro');
INSERT INTO initdb.customers VALUES (7, 'Silpo');
INSERT INTO initdb.customers VALUES (8, 'Oshadbank');
INSERT INTO initdb.customers VALUES (9, 'WOG');

DELETE FROM initdb.skills;
INSERT INTO initdb.skills VALUES (1, 'Java');
INSERT INTO initdb.skills VALUES (2, 'C++');
INSERT INTO initdb.skills VALUES (3, 'PHP');
INSERT INTO initdb.skills VALUES (4, 'QA');
INSERT INTO initdb.skills VALUES (5, 'JavaScript');
INSERT INTO initdb.skills VALUES (6, 'Python');
INSERT INTO initdb.skills VALUES (7, 'Ruby');
INSERT INTO initdb.skills VALUES (8, 'Android');
INSERT INTO initdb.skills VALUES (9, 'iOS');

DELETE FROM initdb.developers;
INSERT INTO initdb.developers VALUES (1, 'Anton', 1400, 6);
INSERT INTO initdb.developers VALUES (2, 'Igor', 1800, 1);
INSERT INTO initdb.developers VALUES (3, 'Vadim', 1200, 3);
INSERT INTO initdb.developers VALUES (4, 'Artem', 2400, 2);
INSERT INTO initdb.developers VALUES (5, 'Ivan', 1900, 1);
INSERT INTO initdb.developers VALUES (6, 'Denis', 2200, 8);
INSERT INTO initdb.developers VALUES (7, 'Sergey', 1100, 9);
INSERT INTO initdb.developers VALUES (8, 'Egor', 3000, 1);
INSERT INTO initdb.developers VALUES (9, 'Viktor', 1400, 2);

DELETE FROM initdb.dev_skills;
INSERT INTO initdb.dev_skills VALUES (1, 2);
INSERT INTO initdb.dev_skills VALUES (1, 1);
INSERT INTO initdb.dev_skills VALUES (1, 3);
INSERT INTO initdb.dev_skills VALUES (2, 1);
INSERT INTO initdb.dev_skills VALUES (3, 5);
INSERT INTO initdb.dev_skills VALUES (3, 7);
INSERT INTO initdb.dev_skills VALUES (4, 9);
INSERT INTO initdb.dev_skills VALUES (5, 3);
INSERT INTO initdb.dev_skills VALUES (5, 6);
INSERT INTO initdb.dev_skills VALUES (6, 1);
INSERT INTO initdb.dev_skills VALUES (7, 2);
INSERT INTO initdb.dev_skills VALUES (7, 4);
INSERT INTO initdb.dev_skills VALUES (7, 1);
INSERT INTO initdb.dev_skills VALUES (8, 1);
INSERT INTO initdb.dev_skills VALUES (8, 2);
INSERT INTO initdb.dev_skills VALUES (9, 6);
INSERT INTO initdb.dev_skills VALUES (9, 3);
INSERT INTO initdb.dev_skills VALUES (9, 8);

DELETE FROM initdb.projects;
INSERT INTO initdb.projects VALUES (1, 'DataBase', 80000, 1, 2);
INSERT INTO initdb.projects VALUES (2, 'Security', 90000, 1, 1);
INSERT INTO initdb.projects VALUES (3, 'CorpSite', 100000, 1, 1);
INSERT INTO initdb.projects VALUES (4, 'Game', 150000, 2, 3);
INSERT INTO initdb.projects VALUES (5, 'iOS App', 180000, 2, 2);
INSERT INTO initdb.projects VALUES (6, 'Android App', 11000, 2, 4);
INSERT INTO initdb.projects VALUES (7, 'QA ', 60000,3, 2);
INSERT INTO initdb.projects VALUES (8, 'Banking', 200000, 3, 5);
INSERT INTO initdb.projects VALUES (9, 'Server', 70000, 4, 3);
INSERT INTO initdb.projects VALUES (10, 'iOS App', 180000, 7, 8);
INSERT INTO initdb.projects VALUES (11, 'Android App', 11000, 8, 4);
INSERT INTO initdb.projects VALUES (12, 'QA ', 60000,9, 8);
INSERT INTO initdb.projects VALUES (13, 'Banking', 200000, 3, 5);
INSERT INTO initdb.projects VALUES (14, 'Server', 70000, 6, 7);
INSERT INTO initdb.projects VALUES (15, 'DataBase', 80000, 3, 2);
INSERT INTO initdb.projects VALUES (16, 'Security', 90000, 9, 1);
INSERT INTO initdb.projects VALUES (17, 'CorpSite', 100000, 7, 6);
INSERT INTO initdb.projects VALUES (18, 'Game', 150000, 5, 8);
INSERT INTO initdb.projects VALUES (19, 'iOS App', 180000, 2, 6);

DELETE FROM initdb.dev_projects;
INSERT INTO initdb.dev_projects VALUES (1, 2);
INSERT INTO initdb.dev_projects VALUES (1, 3);
INSERT INTO initdb.dev_projects VALUES (1, 14);
INSERT INTO initdb.dev_projects VALUES (1, 5);
INSERT INTO initdb.dev_projects VALUES (2, 2);
INSERT INTO initdb.dev_projects VALUES (2, 7);
INSERT INTO initdb.dev_projects VALUES (3, 18);
INSERT INTO initdb.dev_projects VALUES (4, 5);
INSERT INTO initdb.dev_projects VALUES (4, 17);
INSERT INTO initdb.dev_projects VALUES (5, 3);
INSERT INTO initdb.dev_projects VALUES (6, 8);
INSERT INTO initdb.dev_projects VALUES (6, 12);
INSERT INTO initdb.dev_projects VALUES (7, 13);
INSERT INTO initdb.dev_projects VALUES (7, 14);
INSERT INTO initdb.dev_projects VALUES (8, 15);
INSERT INTO initdb.dev_projects VALUES (5, 1);
INSERT INTO initdb.dev_projects VALUES (9, 16);
INSERT INTO initdb.dev_projects VALUES (9, 4);
INSERT INTO initdb.dev_projects VALUES (9, 9);
INSERT INTO initdb.dev_projects VALUES (7, 10);
INSERT INTO initdb.dev_projects VALUES (8, 16);









