CREATE DATABASE  IF NOT EXISTS `hagevekiosproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hagevekiosproject`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: hagevekiosproject
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic`
--

DROP TABLE IF EXISTS `academic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `academic` (
  `academic_name` varchar(40) DEFAULT NULL,
  `academic_ID` int(11) NOT NULL,
  PRIMARY KEY (`academic_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic`
--

LOCK TABLES `academic` WRITE;
/*!40000 ALTER TABLE `academic` DISABLE KEYS */;
INSERT INTO `academic` VALUES ('Sheila Mccall',19432),('Jaskaran Bain',23546),('Stan Firth',32497),('Haaris Hutchinson',34657),('Issac Paul',43534),('Ayisha Brooks',43589),('Frank Chaney',54353),('Malachy Montoya',63534),('Haya Currie',70483),('Azra Knight',74232),('Tiah Stott',75434),('Rabia Merritt',76544),('Ajwa Cameron',83247),('Fabian Leonard',90124),('Gertrude Harper',97685);
/*!40000 ALTER TABLE `academic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affiliation`
--

DROP TABLE IF EXISTS `affiliation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affiliation` (
  `institution_ID` int(11) NOT NULL,
  `academic_ID` int(11) NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`institution_ID`,`academic_ID`),
  KEY `academic_ID` (`academic_ID`),
  CONSTRAINT `affiliation_ibfk_1` FOREIGN KEY (`institution_ID`) REFERENCES `institution` (`institution_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `affiliation_ibfk_2` FOREIGN KEY (`academic_ID`) REFERENCES `academic` (`academic_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affiliation`
--

LOCK TABLES `affiliation` WRITE;
/*!40000 ALTER TABLE `affiliation` DISABLE KEYS */;
INSERT INTO `affiliation` VALUES (1342,32497,'2017-05-16'),(1342,76544,'2018-03-01'),(5342,43534,'2014-07-27'),(5342,43589,'2018-06-07'),(5753,23546,'2012-04-10'),(5753,83247,'2015-02-08'),(6452,19432,'2015-01-14'),(6452,90124,'2015-12-17'),(6452,97685,'2012-08-30'),(7865,34657,'2018-10-10'),(7865,63534,'2015-08-15');
/*!40000 ALTER TABLE `affiliation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `article_ID` int(11) NOT NULL,
  `published_article` varchar(100) DEFAULT NULL,
  `number_of_pages` decimal(10,0) DEFAULT NULL,
  `number_of_references` decimal(10,0) DEFAULT NULL,
  `submission_dates` date DEFAULT NULL,
  PRIMARY KEY (`article_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'The Ultimate Guide To Maths',10,50,'2015-12-17'),(2,'Your Key To Success: Maths',43,23,'2016-07-15'),(3,'Science Is Bound To Make An Impact In Your Business',12,42,'2017-01-06'),(4,'This Study Will Perfect Your Science: Read Or Miss Out',42,66,'2014-11-30'),(5,'Being A Star In Your Industry Is A Matter Of Sports',65,22,'2018-03-13'),(6,'10 Best Practices For Sports',32,10,'2016-05-01'),(7,'5 Brilliant Ways To Teach Your Audience About Computer',65,15,'2016-09-13'),(8,'5 Ways Computer Will Help You Get More Business',54,75,'2015-04-19'),(9,'Using 7 University Strategies Like The Pros',123,23,'2016-06-06'),(10,'Get The Most Out of University and Facebook',22,13,'2016-10-29'),(11,'Proof That Business Is Exactly What You Are Looking For',42,54,'2015-01-19'),(12,'The Philosophy Of Business',8,23,'2015-02-12'),(13,'The Secrets To Finding World Class Tools For Your Physics Quickly',43,54,'2017-09-07'),(14,'Why Ignoring Physics Will Cost You Time and Sales',87,56,'2016-10-10'),(15,'How I Improved My Database In One Day',54,52,'2016-11-01'),(16,'Four Ways Teachers Can Reduce Implicit Bias',56,76,'2016-04-12'),(17,'Why We Should Teach Empathy to Preschoolers',64,76,'2016-06-23'),(18,'Why Dont Students Take Social-Emotional Learning Home?',132,52,'2016-08-31'),(19,'What if Schools Taught Kindness?',65,76,'2016-02-21'),(20,'Seven Ways to Help High Schoolers Find Purpose',123,4,'2016-10-13'),(21,'Five Ways to Help Misbehaving Kids',121,13,'2016-09-07'),(22,'How Humility Will Make You the Greatest Person Ever',57,30,'2016-03-03'),(23,'Sports Can Change Your Life',40,23,'2016-05-13'),(24,'Biology Of Humans',76,25,'2016-02-28'),(25,'Physics On The Moon',87,76,'2016-12-30'),(26,'Art Of Painting',98,52,'2016-11-26'),(27,'Computer Fundamentals',165,54,'2016-07-14'),(28,'Principles of Programming',87,12,'2016-01-02'),(29,'Security In Businesses',76,87,'2016-01-12'),(30,'I Run Out Of Names',23,65,'2016-04-11');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authoring`
--

DROP TABLE IF EXISTS `authoring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `authoring` (
  `academic_ID` int(11) NOT NULL,
  `article_ID` int(11) NOT NULL,
  PRIMARY KEY (`academic_ID`,`article_ID`),
  KEY `article_ID` (`article_ID`),
  CONSTRAINT `authoring_ibfk_1` FOREIGN KEY (`article_ID`) REFERENCES `article` (`article_ID`),
  CONSTRAINT `authoring_ibfk_2` FOREIGN KEY (`academic_ID`) REFERENCES `academic` (`academic_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authoring`
--

LOCK TABLES `authoring` WRITE;
/*!40000 ALTER TABLE `authoring` DISABLE KEYS */;
INSERT INTO `authoring` VALUES (54353,1),(74232,1),(90124,1),(23546,2),(34657,2),(54353,2),(32497,3),(70483,3),(74232,3),(34657,4),(70483,4),(83247,4),(43534,5),(75434,5),(19432,6),(75434,6),(97685,6),(34657,7),(74232,7),(76544,7),(23546,8),(43534,8),(97685,8),(54353,9),(63534,9),(90124,9),(19432,10),(34657,10),(43589,10),(63534,11),(76544,11),(19432,12),(32497,12),(76544,12),(32497,13),(74232,13),(83247,13),(43534,14),(54353,14),(63534,14),(97685,14),(23546,15),(43589,15),(75434,15),(90124,15),(90124,16),(32497,17),(54353,18),(83247,19),(43589,20),(43534,21),(75434,22),(74232,23),(97685,24),(34657,25),(63534,26),(76544,27),(23546,28),(70483,29),(19432,30);
/*!40000 ALTER TABLE `authoring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `institution` (
  `institution_ID` int(11) NOT NULL,
  `institution_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`institution_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES (1342,'Chicago University'),(5342,'Oxford University'),(5753,'Harvard University'),(6452,'Notre Dame'),(7865,'Cambridge University');
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `review` (
  `article_ID` int(11) NOT NULL,
  `academic_ID` int(11) NOT NULL,
  `review_dates` date DEFAULT NULL,
  PRIMARY KEY (`article_ID`,`academic_ID`),
  KEY `academic_ID` (`academic_ID`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`article_ID`) REFERENCES `article` (`article_ID`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`academic_ID`) REFERENCES `academic` (`academic_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,43534,'2016-02-25'),(1,43589,'2016-01-20'),(1,83247,'2016-01-17'),(2,75434,'2017-08-15'),(2,83247,'2017-09-13'),(2,90124,'2017-07-15'),(3,23546,'2018-07-16'),(3,54353,'2018-05-02'),(3,97685,'2018-01-06'),(4,32497,'2015-05-20'),(4,34657,'2015-12-31'),(4,54353,'2015-11-30'),(5,63534,'2018-05-13'),(5,70483,'2018-06-01'),(5,90124,'2018-07-19'),(6,19432,'2017-05-01'),(6,43534,'2017-05-16'),(6,54353,'2017-07-01'),(7,19432,'2017-09-13'),(7,97685,'2017-09-03'),(8,19432,'2016-05-09'),(8,32497,'2016-04-19'),(8,76544,'2016-08-01'),(9,19432,'2017-02-16'),(9,43589,'2017-06-06'),(9,97685,'2017-06-26'),(10,75434,'2017-01-09'),(10,83247,'2017-10-29'),(11,54353,'2016-08-01'),(11,63534,'2016-01-19'),(11,74232,'2016-12-16'),(12,34657,'2016-02-12'),(12,43534,'2016-12-01'),(12,83247,'2016-05-02'),(13,23546,'2018-10-17'),(13,43589,'2018-09-07'),(14,70483,'2017-10-10'),(14,90124,'2017-11-01'),(14,97685,'2017-08-03'),(15,19432,'2017-05-18'),(15,76544,'2017-11-01'),(16,32497,'2017-08-29'),(16,54353,'2017-06-23'),(17,34657,'2017-06-23'),(17,70483,'2017-02-03'),(17,75434,'2017-09-02'),(18,19432,'2017-07-12'),(18,43534,'2017-11-12'),(18,63534,'2017-08-31'),(19,74232,'2017-05-25'),(19,83247,'2017-02-21'),(20,19432,'2017-10-13'),(20,34657,'2017-07-23'),(20,43589,'2017-04-03'),(21,32497,'2017-08-17'),(21,34657,'2017-09-07'),(22,34657,'2017-06-03'),(22,43534,'2017-07-13'),(22,90124,'2017-03-03'),(23,43534,'2017-09-03'),(23,54353,'2017-05-13'),(23,63534,'2017-11-30'),(24,32497,'2017-02-28'),(24,70483,'2017-01-08'),(25,75434,'2017-12-30'),(25,83247,'2017-06-10'),(25,97685,'2017-10-20'),(26,43589,'2017-11-26'),(26,70483,'2017-06-16'),(27,23546,'2017-04-04'),(27,32497,'2017-07-14'),(27,43534,'2017-01-01'),(28,34657,'2017-01-19'),(28,54353,'2017-01-06'),(28,76544,'2017-01-02'),(29,23546,'2017-07-02'),(29,32497,'2017-08-22'),(29,83247,'2017-02-12'),(30,43589,'2017-04-11'),(30,54353,'2017-08-01');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hagevekiosproject'
--

--
-- Dumping routines for database 'hagevekiosproject'
--
/*!50003 DROP FUNCTION IF EXISTS `times_reviewed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `times_reviewed`(article VARCHAR(100)) RETURNS int(11)
    DETERMINISTIC
BEGIN
DECLARE x INT;
SET x = (
SELECT COUNT(article_id) FROM article NATURAL JOIN review WHERE article = published_article GROUP BY article_id);
RETURN x;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `track_num_academics` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `track_num_academics`(institutionname VARCHAR(64))
BEGIN
SELECT institution_name, COUNT(academic_ID) AS count_academics
FROM Affiliation
INNER JOIN Institution ON Institution.institution_ID = Affiliation.institution_ID WHERE institutionname = institution_name
GROUP BY institution_name
ORDER BY count_academics DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `track_published_articles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `track_published_articles`(academicname VARCHAR(64))
BEGIN
SELECT Academic.academic_name, Institution.institution_name, published_article
FROM  Affiliation
NATURAL JOIN Academic NATURAL JOIN Institution NATURAL JOIN Authoring NATURAL JOIN Article 
WHERE academicname = academic_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-20 22:31:09
