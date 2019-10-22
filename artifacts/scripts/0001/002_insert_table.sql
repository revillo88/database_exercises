-- insert entries
INSERT INTO game (id,"name",platform,genre,erscheinungsdatum) VALUES 
(1,'Mario','Nintendo','Jump And Run','2019-10-20')
,(2,'God of war','PS4','Action','2019-10-20')
,(3,'Hero','Xbox','Ego Shooter','2019-10-20')
,(4,'metroit','Nintendo','Metroidvania','2019-10-20')
,(5,'Harvest moon','Nintendo','Wirtschaftssimulation','2019-10-20')
,(6,'Halo World','PC','Slasher','2019-10-20')
,(7,'Jumpi','PC','Jump And Run','2019-10-20')
,(8,'Ralf Kann es ','PS4','Simulation','2019-10-20')
,(9,'Crash team Racing','PS4','Racer','2019-10-20')
,(10,'World of Warcraft','PC','MMORPG','2019-10-20')
;
INSERT INTO game (id,"name",platform,genre,erscheinungsdatum) VALUES 
(11,'Zelda','Nintendo','Action','2019-10-20')
;INSERT INTO genre (id,art) VALUES 
(1,'Jump And Run')
,(2,'Action')
,(3,'Metroidvania')
,(4,'Wirtschaftssimulation')
;INSERT INTO platform (id,"name") VALUES 
(1,'PC')
,(2,'PS4')
,(3,'Xbox One')
,(4,'Nintendo Switch')
;