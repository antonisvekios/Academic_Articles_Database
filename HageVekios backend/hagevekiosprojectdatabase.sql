SET SQL_SAFE_UPDATES = 0;

/* CREATE SCRIPTS*/
DROP DATABASE IF EXISTS HageVekiosProject;
CREATE DATABASE HageVekiosProject;
USE HageVekiosProject;

CREATE TABLE Institution
(
institution_ID 		INT,
institution_name 	VARCHAR(40),
PRIMARY KEY (institution_ID)
);

CREATE TABLE Academic
(
academic_name VARCHAR(40),
academic_ID   INT,
PRIMARY KEY (academic_ID)
);


CREATE TABLE Affiliation
(
institution_ID INT NOT NULL,
academic_ID    INT,
update_date    DATE,
PRIMARY KEY (institution_ID, academic_ID),
FOREIGN KEY (institution_ID) REFERENCES Institution(institution_ID)
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (academic_ID) REFERENCES Academic(academic_ID)
ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Article
(
article_ID 		  		INT,
published_article 		VARCHAR(100) ,
number_of_pages 		NUMERIC,
number_of_references 	NUMERIC,
submission_dates 		DATE,
PRIMARY KEY (article_ID)
);

CREATE TABLE Review
(
article_ID 			INT,
academic_ID 		INT,
review_dates 		DATE,
PRIMARY KEY (article_ID, academic_ID),
FOREIGN KEY (article_ID) REFERENCES Article(article_ID),
FOREIGN KEY (academic_ID) REFERENCES Academic(academic_ID)
);

CREATE TABLE Authoring
(
academic_ID			INT,
article_ID 			INT,
PRIMARY KEY (academic_ID, article_ID),
FOREIGN KEY (article_ID) REFERENCES Article(article_ID)
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (academic_ID) REFERENCES Academic(academic_ID)
ON UPDATE CASCADE ON DELETE CASCADE
);

COMMIT;

/* INSERT SCRIPTS*/

INSERT INTO Academic (academic_name, academic_ID) VALUES ('Fabian Leonard', 90124);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Stan Firth', 32497);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Frank Chaney', 54353);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Ajwa Cameron', 83247);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Ayisha Brooks', 43589);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Issac Paul', 43534);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Tiah Stott', 75434);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Azra Knight', 74232);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Gertrude Harper', 97685);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Haaris Hutchinson', 34657);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Malachy Montoya', 63534);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Rabia Merritt', 76544);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Jaskaran Bain', 23546);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Haya Currie', 70483);
INSERT INTO Academic (academic_name, academic_ID) VALUES ('Sheila Mccall', 19432);


INSERT INTO Institution (institution_name, institution_ID) VALUES ('Chicago University', 1342);
INSERT INTO Institution (institution_name, institution_ID) VALUES ('Notre Dame', 6452);
INSERT INTO Institution (institution_name, institution_ID) VALUES ('Harvard University', 5753);
INSERT INTO Institution (institution_name, institution_ID) VALUES ('Cambridge University', 7865);
INSERT INTO Institution (institution_name, institution_ID) VALUES ('Oxford University', 5342);

INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('90124', '6452','2015-12-17');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('32497', '1342','2017-5-16');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('83247', '5753','2015-2-8');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('43589', '5342','2018-6-7');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('43534', '5342','2014-7-27');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('97685', '6452','2012-8-30');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('34657', '7865','2018-10-10');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('63534', '7865','2015-8-15');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('76544', '1342','2018-3-1');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('23546', '5753','2012-4-10');
INSERT INTO Affiliation (academic_ID, institution_ID, update_date) VALUES ('19432', '6452','2015-1-14');


INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (1,'The Ultimate Guide To Maths', 10, 50,'2015-12-17');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (2,'Your Key To Success: Maths', 43, 23,'2016-7-15');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (3,'Science Is Bound To Make An Impact In Your Business', 12, 42,'2017-1-6');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (4,'This Study Will Perfect Your Science: Read Or Miss Out', 42, 66,'2014-11-30');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (5,'Being A Star In Your Industry Is A Matter Of Sports', 65, 22,'2018-3-13');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (6,'10 Best Practices For Sports', 32, 10,'2016-5-1');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (7,'5 Brilliant Ways To Teach Your Audience About Computer', 65, 15,'2016-9-13');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (8,'5 Ways Computer Will Help You Get More Business', 54, 75,'2015-4-19');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (9,'Using 7 University Strategies Like The Pros', 123, 23,'2016-6-6');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (10,'Get The Most Out of University and Facebook', 22, 13,'2016-10-29');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (11,'Proof That Business Is Exactly What You Are Looking For', 42, 54,'2015-1-19');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (12,'The Philosophy Of Business', 8, 23,'2015-2-12');  
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (13,'The Secrets To Finding World Class Tools For Your Physics Quickly', 43, 54,'2017-9-7');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (14,'Why Ignoring Physics Will Cost You Time and Sales', 87, 56,'2016-10-10');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (15,'How I Improved My Database In One Day', 54, 52,'2016-11-1');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (16,'Four Ways Teachers Can Reduce Implicit Bias', 56, 76,'2016-4-12');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (17,'Why We Should Teach Empathy to Preschoolers', 64, 76,'2016-6-23');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (18,'Why Dont Students Take Social-Emotional Learning Home?', 132, 52,'2016-8-31');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (19,'What if Schools Taught Kindness?', 65, 76,'2016-2-21');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (20,'Seven Ways to Help High Schoolers Find Purpose', 123, 4,'2016-10-13');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (21,'Five Ways to Help Misbehaving Kids', 121, 13,'2016-9-7');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (22,'How Humility Will Make You the Greatest Person Ever', 57, 30,'2016-3-3');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (23,'Sports Can Change Your Life', 40, 23,'2016-5-13');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (24,'Biology Of Humans', 76, 25,'2016-2-28');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (25,'Physics On The Moon', 87, 76,'2016-12-30');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (26,'Art Of Painting', 98, 52,'2016-11-26');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (27,'Computer Fundamentals', 165, 54,'2016-7-14');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (28,'Principles of Programming', 87, 12,'2016-1-2');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (29,'Security In Businesses', 76, 87,'2016-1-12');
INSERT INTO Article (article_ID,published_article, number_of_pages, number_of_references, submission_dates) VALUES (30,'I Run Out Of Names', 23, 65,'2016-4-11');

INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (1, 90124);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (1,74232);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (1,54353);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (2,54353);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (2,34657);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (2,23546);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (3, 32497); 
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (3, 74232);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (3, 70483);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (4, 34657);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (4, 83247);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (4, 70483);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (5, 43534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (5, 75434);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (6, 75434);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (6, 97685);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (6, 19432);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (7, 74232);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (7, 34657);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (7, 76544);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (8,97685);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (8,23546);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (8,43534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (9,90124);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (9,54353);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (9,63534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (10, 34657);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (10, 19432);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (10, 43589);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (11, 63534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (11, 76544);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (12, 76544);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (12, 19432);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (12, 32497);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (13, 32497);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (13, 83247);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (13, 74232);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (14, 97685);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (14, 54353);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (14, 43534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (14, 63534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (15, 43589);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (15, 75434);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (15, 90124);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (15, 23546);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (16, 90124);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (17, 32497);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (18, 54353);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (19, 83247);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (20, 43589);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (21, 43534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (22, 75434);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (23, 74232);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (24, 97685);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (25, 34657);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (26, 63534);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (27, 76544);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (28, 23546);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (29, 70483);
INSERT INTO AUTHORING (article_ID, academic_ID) VALUES (30, 19432);



INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (1,83247,'2016-1-17');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (1,43589,'2016-1-20');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (1,43534,'2016-2-25');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (2,90124,'2017-7-15');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (2,75434,'2017-8-15');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (2,83247,'2017-9-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (3,97685,'2018-1-6');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (3,54353,'2018-5-2');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (3,23546,'2018-7-16');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (4,54353,'2015-11-30');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (4,34657,'2015-12-31');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (4,32497,'2015-5-20');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (5,63534,'2018-5-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (5,70483,'2018-6-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (5,90124,'2018-7-19');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (6,19432,'2017-5-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (6,43534,'2017-5-16');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (6,54353,'2017-7-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (7,19432,'2017-9-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (7,97685,'2017-9-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (8,32497,'2016-4-19');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (8,19432,'2016-5-9');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (8,76544,'2016-8-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (9,43589,'2017-6-6');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (9,97685,'2017-6-26');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (9,19432,'2017-2-16');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (10,83247,'2017-10-29');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (10,75434,'2017-1-9');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (11,63534,'2016-1-19');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (11,54353,'2016-8-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (11,74232,'2016-12-16');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (12,34657,'2016-2-12');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (12,83247,'2016-5-2');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (12,43534,'2016-12-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (13,43589,'2018-9-7');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (13,23546,'2018-10-17');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (14,70483,'2017-10-10');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (14,90124,'2017-11-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (14,97685,'2017-8-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (15,76544,'2017-11-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (15,19432,'2017-5-18');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (16,54353,'2017-6-23');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (16,32497,'2017-8-29');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (17,70483,'2017-2-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (17,34657,'2017-6-23');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (17,75434,'2017-9-2');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (18,63534,'2017-8-31');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (18,43534,'2017-11-12');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (18,19432,'2017-7-12');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (19,83247,'2017-2-21');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (19,74232,'2017-5-25');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (20,19432,'2017-10-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (20,43589,'2017-4-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (20,34657,'2017-7-23');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (21,34657,'2017-9-7');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (21,32497,'2017-8-17');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (22,90124,'2017-3-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (22,43534,'2017-7-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (22,34657,'2017-6-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (23,54353,'2017-5-13');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (23,43534,'2017-9-3');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (23,63534,'2017-11-30');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (24,32497,'2017-2-28');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (24,70483,'2017-1-8');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (25,75434,'2017-12-30');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (25,97685,'2017-10-20');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (25,83247,'2017-6-10');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (26,43589,'2017-11-26');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (26,70483,'2017-6-16');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (27,32497,'2017-7-14');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (27,23546,'2017-4-4');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (27,43534,'2017-1-1');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (28,76544,'2017-1-2');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (28,54353,'2017-1-6');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (28,34657,'2017-1-19');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (29,83247,'2017-2-12');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (29,23546,'2017-7-2');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (29,32497,'2017-8-22');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (30,43589,'2017-4-11');
INSERT INTO Review (article_ID, academic_ID, review_dates) VALUES (30,54353,'2017-8-1');

COMMIT;

 
/*DROP TABLE SCRIPTS

DROP TABLE Affiliation;
DROP TABLE Review;
DROP TABLE Authoring;
DROP TABLE Article;
DROP TABLE Institution;
DROP TABLE Academic; 

COMMIT; */ 

-- SELECT SCRIPTS 

SELECT * FROM Academic;

-- Tracks the published articles when given an academic name
DROP PROCEDURE IF EXISTS track_published_articles;
DELIMITER //
CREATE PROCEDURE track_published_articles(academicname VARCHAR(64))
BEGIN
SELECT Academic.academic_name, Institution.institution_name, published_article
FROM  Affiliation
NATURAL JOIN Academic NATURAL JOIN Institution NATURAL JOIN Authoring NATURAL JOIN Article 
WHERE academicname = academic_name;
END // 
DELIMITER ;

-- Test statements
CALL track_published_articles('Issac Paul');
CALL track_published_articles('Fabian Leonard');


-- tracks the number of academics within a given institution name
DROP PROCEDURE IF EXISTS track_num_academics;
DELIMITER //
CREATE PROCEDURE track_num_academics (institutionname VARCHAR(64))
BEGIN
SELECT institution_name, COUNT(academic_ID) AS count_academics
FROM Affiliation
INNER JOIN Institution ON Institution.institution_ID = Affiliation.institution_ID WHERE institutionname = institution_name
GROUP BY institution_name
ORDER BY count_academics DESC;
END //
DELIMITER ;

-- Test Statements
CALL track_num_academics('Chicago University');
CALL track_num_academics('Cambridge University');

-- Given an article name, determines how many times it has been reviewed
DROP FUNCTION IF EXISTS times_reviewed;
DELIMITER // 
CREATE FUNCTION times_reviewed(article VARCHAR(100))
RETURNS INT DETERMINISTIC
BEGIN
DECLARE x INT;
SET x = (
SELECT COUNT(article_id) FROM article NATURAL JOIN review WHERE article = published_article GROUP BY article_id);
RETURN x;
END //
DELIMITER ;

-- Test statements
SELECT times_reviewed('The ultimate guide to maths');
SELECT times_reviewed('5 ways computer will help you get more business');