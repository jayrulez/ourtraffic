CREATE DATABASE  IF NOT EXISTS `ticketingdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ticketingdb`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: ticketingdb
-- ------------------------------------------------------
-- Server version	5.5.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `id` int(11) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (101,'18 clover road','Kingtson 7','Kingston','988-2001');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `police`
--

DROP TABLE IF EXISTS `police`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `police` (
  `badgeId` varchar(16) NOT NULL,
  `divisionId` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `middleInitial` varchar(1) DEFAULT NULL,
  `DOB` date NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  PRIMARY KEY (`badgeId`),
  KEY `fk_police_division` (`divisionId`),
  CONSTRAINT `fk_police_division` FOREIGN KEY (`divisionId`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `police`
--

LOCK TABLES `police` WRITE;
/*!40000 ALTER TABLE `police` DISABLE KEYS */;
INSERT INTO `police` VALUES ('K1001',101,'Dale','McFarlane','M','2012-03-16','1872 killl road','Kingston 10','Kingston');
/*!40000 ALTER TABLE `police` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxofficer`
--

DROP TABLE IF EXISTS `taxofficer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxofficer` (
  `officerId` varchar(16) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `middleInitial` varchar(1) DEFAULT NULL,
  `DOB` date NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  PRIMARY KEY (`officerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxofficer`
--

LOCK TABLES `taxofficer` WRITE;
/*!40000 ALTER TABLE `taxofficer` DISABLE KEYS */;
INSERT INTO `taxofficer` VALUES ('1004','Robert','Campbell','C','1983-04-08','17 Somewhere Street','Kingston 10','Kingston'),('1005','Robert','Campbell','C','1983-04-08','17 Somewhere Street','Kingston 10','Kingston');
/*!40000 ALTER TABLE `taxofficer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offender`
--

DROP TABLE IF EXISTS `offender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offender` (
  `trn` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `middleInitial` varchar(1) DEFAULT NULL,
  `DOB` date NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `licenseType` varchar(20) NOT NULL,
  `points` int(11) NOT NULL,
  `expiryDate` date NOT NULL,
  PRIMARY KEY (`trn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offender`
--

LOCK TABLES `offender` WRITE;
/*!40000 ALTER TABLE `offender` DISABLE KEYS */;
INSERT INTO `offender` VALUES (1000003,'sync','mcfarlane','b','2008-07-22','17 blue dale street','portmore','Saint Catherine','General',223,'2013-12-01'),(1000005,'Kemar','Wint','K','0000-00-00','Portmore','Saint Catherine','2012-04-12','General',95,'2012-04-26');
/*!40000 ALTER TABLE `offender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `handle` varchar(32) NOT NULL,
  `pin` varchar(32) NOT NULL,
  `accountType` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `handle` (`handle`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'K1001','password',2),(2,'1004','password',2),(3,'1005','password',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offense`
--

DROP TABLE IF EXISTS `offense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offense`
--

LOCK TABLES `offense` WRITE;
/*!40000 ALTER TABLE `offense` DISABLE KEYS */;
INSERT INTO `offense` VALUES (1,'Speeding',''),(2,'Double Park',''),(3,'Traffic Light',''),(4,'Overload',''),(5,'No parking',''),(8,'',''),(9,'No Seat Belt','Passanger not wearing seat belt'),(10,'Talking on cell Phone','Talking on cell phone while driving'),(11,'Talking on cell Phone','Talking on cell phone while driving');
/*!40000 ALTER TABLE `offense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policeId` varchar(16) NOT NULL,
  `offenderTrn` int(11) NOT NULL,
  `offenseId` int(11) NOT NULL,
  `offenseDate` datetime NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `description` text,
  `fine` float NOT NULL,
  `points` int(11) NOT NULL,
  `paymentStatus` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_ticekt_police` (`policeId`),
  KEY `fk_ticekt_offender` (`offenderTrn`),
  KEY `fk_ticekt_offense` (`offenseId`),
  CONSTRAINT `fk_ticekt_offender` FOREIGN KEY (`offenderTrn`) REFERENCES `offender` (`trn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ticekt_offense` FOREIGN KEY (`offenseId`) REFERENCES `offense` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ticekt_police` FOREIGN KEY (`policeId`) REFERENCES `police` (`badgeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'K1001',1000003,1,'2012-03-08 00:00:00','sddsdsd','ssdsdsds','Saint Catherine','sddsdsd',5000,15,1),(2,'K1001',1000003,1,'2012-03-01 00:00:00','qwqwqw','qwqwq','Select a Parish','qwqwqw',2030,5,1),(3,'K1001',1000003,1,'2012-03-02 00:00:00','sass','asasa','Saint Catherine','sass',5000,10,0),(4,'K1001',1000003,2,'2012-04-05 00:00:00','qwq','qwqqw','Saint Catherine','qwq',4500,2,0),(5,'K1001',1000005,5,'2012-04-10 00:00:00','19 killborn road','ppotmore','Saint Catherine','19 killborn road',6000,5,0);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `officerId` varchar(16) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `paymentDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_ticket` (`ticket_id`),
  KEY `fk_payment_officer` (`officerId`),
  CONSTRAINT `fk_payment_officer` FOREIGN KEY (`officerId`) REFERENCES `taxofficer` (`officerId`) ON UPDATE CASCADE,
  CONSTRAINT `fk_payment_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'1005',1,5000,'2012-04-03 00:01:05'),(2,'1005',2,2030,'2012-04-03 01:19:06'),(3,'1005',2,2030,'2012-04-03 01:20:26');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ticketingdb'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_addOffense` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_addOffense`(offenseName varchar(50), offenseDescription TEXT,OUT result int)
BEGIN
	SET result = 0;
	START TRANSACTION;
	INSERT INTO `offense`(id,name,description) values(default, offenseName,offenseDescription);
	IF ROW_COUNT()=1 THEN
    SET result = last_insert_id();
    commit;
	ELSE
		SET result = -1;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_addPolice` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_addPolice`(badgeId varchar(16),divId int(11), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
BEGIN
    SET result = 0;
    IF NOT EXISTS (SELECT * FROM `user` where `user`.handle = badgeId) AND NOT EXISTS(SELECT * FROM police WHERE police.badgeId = badgeId) THEN
        START TRANSACTION;
        INSERT INTO `police`(badgeId,divisionId,firstName,middleInitial,lastName,DOB,street,city,parish) VALUES(badgeId,divId,fName,mInitial,lName,dob,address1, address2, parish);
			IF ROW_COUNT() = 1 THEN
				INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,badgeId,password,2);
				IF ROW_COUNT() = 1 THEN
					SET result = 1;
					commit;
				ELSE
					rollback;
				END IF;
			ELSE
				rollback;
			END IF;
    ELSE
        SET result = -1;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_addTaxOfficer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_addTaxOfficer`(officerId varchar(16), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
BEGIN
	SET result = 0;
    IF NOT EXISTS (SELECT * FROM `user` where `user`.handle = officerId) AND NOT EXISTS(SELECT * FROM taxofficer WHERE taxofficer.officerId = officerId)  THEN
        START TRANSACTION;
			INSERT INTO `taxofficer`(officerId,firstName,middleInitial,lastName,DOB,street,city,parish) VALUES(officerId,fName,mInitial,lName,dob,address1, address2, parish);
			IF ROW_COUNT() = 1 THEN
				INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,officerId,password,3);
				IF ROW_COUNT() = 1 THEN
					SET result = 1;
					commit;
				ELSE
					rollback;
				END IF;
			ELSE
				rollback;
			END IF;
    ELSE
        SET result = -1;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllOffenses` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_getAllOffenses`()
BEGIN
	select * from `offense`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getOffender` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_getOffender`(offenderTrn int)
BEGIN
	select * from `offender` where `offender`.trn = offenderTrn;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getTicket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_getTicket`(ticketNumber int(11))
BEGIN
    select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where `ticket`.id = ticketNumber;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_getUser`(userHandle varchar(16))
BEGIN
    DECLARE userType tinyint(1) DEFAULT 0;
    IF EXISTS(SELECT `user`.accountType from `user` WHERE `user`.handle = userHandle) THEN
        SELECT `user`.accountType INTO userType from `user` WHERE `user`.handle = userHandle;
        IF userType = 2 THEN
            SELECT `police`.*, `user`.* FROM `user` INNER JOIN `police` ON `police`.badgeId = `user`.handle WHERE `user`.handle = userHandle;
        ELSE 
            IF userType = 3 THEN
                SELECT `taxofficer`.*, `user`.* FROM `user` INNER JOIN `taxofficer` ON `taxofficer`.officerId = `user`.handle WHERE `user`.handle = userHandle;
            END IF;
        END IF;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getUserLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_getUserLogin`(userHandle varchar(16), password varchar(32))
BEGIN
    DECLARE userType tinyint(1) DEFAULT 0;
    IF EXISTS(SELECT `user`.accountType from `user` WHERE `user`.handle = userHandle AND `user`.pin = password) THEN
        SELECT `user`.accountType INTO userType from `user` WHERE `user`.handle = userHandle and `user`.pin = password;
        IF userType = 2 THEN
            SELECT `police`.*, `user`.* FROM `user` INNER JOIN `police` ON `police`.badgeId = `user`.handle WHERE `user`.handle = userHandle;
        ELSE 
            IF userType = 3 THEN
                SELECT `taxofficer`.*, `user`.* FROM `user` INNER JOIN `taxofficer` ON `taxofficer`.officerId = `user`.handle WHERE `user`.handle = userHandle;
            END IF;
        END IF;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_issueTicket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_issueTicket`(policeId varchar(16), offenderTrn int(11), offenseId int(11), offenseDate date, street varchar(50), city varchar(50), parish varchar(30), description text , fine float, points int(11),OUT result int)
BEGIN
    declare currentPoints int;
    SET result = 0;
    start transaction;
    update `offender` set `offender`.points = `offender`.points - points where `offender`.trn = offenderTrn;
    if row_count() = 1 then
        INSERT INTO `ticket`(id,policeId,offenderTrn,offenseId,offenseDate,street,city,parish,description,fine,points) values(default,policeId,offenderTrn,offenseId,offenseDate,street,city,parish,description,fine,points); 
        if row_count() = 1 then
            SET result = 1;
            commit;
        else
            rollback;
            set result = -2;
        end if;
    else
        set result = -1;
    end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_issueTicketNewOffender` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_issueTicketNewOffender`(offenderTrn int(11), firstName varchar(30), lastName varchar(30), middleInitial varchar(1),street varchar(50), city varchar(30), parish varchar(30), dob date,licenseType varchar(20),licensePoints int(11), expiryDate Date ,policeId varchar(16), offenseId int(11), offenseDate date, ticketStreet varchar(50), ticketCity varchar(50), ticketParish varchar(30), description text, fine float, ticketPoints int(11),OUT result int)
BEGIN
	SET result = 0;
	START TRANSACTION;
	INSERT INTO `offender`(trn,firstName,lastName,middleInitial,DOB,street,city,parish,licenseType,points,expiryDate) values(offenderTrn,firstName,lastName,middleInitial,street,city,parish,dob,licenseType,licensePoints-ticketPoints,expiryDate);
	IF ROW_COUNT()=1 THEN
		INSERT INTO `ticket`(id,policeId,offenderTrn,offenseId,offenseDate,street,city,parish,description,fine,points) values(default,policeId,offenderTrn,offenseId,offenseDate,ticketStreet,ticketCity,ticketParish,description,fine,ticketPoints);
		IF ROW_COUNT()=1 THEN
			commit;
        SET result = 1;
		ELSE
			SET result = -2;
			rollback;
		END IF;
	ELSE
		SET result = -1;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_payTicket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_payTicket`(ticketNumber int(11),officerId varchar(16),amount float,out result int(11))
BEGIN
    set result = 0;
    
    start transaction;
    
    update `ticket` set `ticket`.paymentStatus = 1 where `ticket`.id = ticketNumber;
    if row_count() = 1 then
        insert into `payment` (id,officerId,ticket_id,amount,paymentDate) values(default,officerId,ticketNumber,amount, now());
        if row_count() = 1 then
            set result = 1;
            commit;
        else
            set result = -2;
            rollback;
        end if;
    else
        set result = -1;
   end if;
END */;;
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

-- Dump completed on 2012-04-09 13:26:47
