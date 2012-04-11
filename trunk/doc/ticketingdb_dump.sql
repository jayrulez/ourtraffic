-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 11, 2012 at 05:17 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ticketingdb`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `sp_addOffense`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addOffense`(offenseName varchar(50), offenseDescription TEXT,OUT result int)
BEGIN
	SET result = 0;
	START TRANSACTION;
    if exists(select * from offense where `offense`.name=offenseName) THEN
        set result = -2;
    else
        INSERT INTO `offense`(id,name,description) values(default, offenseName,offenseDescription);
        IF ROW_COUNT()=1 THEN
        SET result = last_insert_id();
        commit;
        ELSE
            SET result = -1;
        END IF;
    end if;
END$$

DROP PROCEDURE IF EXISTS `sp_addPolice`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addPolice`(badgeId varchar(16),divId int(11), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
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
END$$

DROP PROCEDURE IF EXISTS `sp_addTaxOfficer`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_addTaxOfficer`(officerId varchar(16), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
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
END$$

DROP PROCEDURE IF EXISTS `sp_getAllOffenses`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllOffenses`()
BEGIN
	select * from `offense`;
END$$

DROP PROCEDURE IF EXISTS `sp_getOffender`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getOffender`(offenderTrn int)
BEGIN
	select * from `offender` where `offender`.trn = offenderTrn;
END$$

DROP PROCEDURE IF EXISTS `sp_getTicket`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getTicket`(ticketNumber int(11))
BEGIN
    select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where `ticket`.id = ticketNumber;
END$$

DROP PROCEDURE IF EXISTS `sp_getUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getUser`(userHandle varchar(16))
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
END$$

DROP PROCEDURE IF EXISTS `sp_getUserLogin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getUserLogin`(userHandle varchar(16), password varchar(32))
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
END$$

DROP PROCEDURE IF EXISTS `sp_issueTicket`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_issueTicket`(policeId varchar(16), offenderTrn int(11), offenseId int(11), offenseDate date, street varchar(50), city varchar(50), parish varchar(30), description text , fine float, points int(11),OUT result int)
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
END$$

DROP PROCEDURE IF EXISTS `sp_issueTicketNewOffender`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_issueTicketNewOffender`(offenderTrn int(11), firstName varchar(30), lastName varchar(30), middleInitial varchar(1),street varchar(50), city varchar(30), parish varchar(30), dob date,licenseType varchar(20),licensePoints int(11), expiryDate Date ,policeId varchar(16), offenseId int(11), offenseDate date, ticketStreet varchar(50), ticketCity varchar(50), ticketParish varchar(30), description text, fine float, ticketPoints int(11),OUT result int)
BEGIN
	SET result = 0;
	START TRANSACTION;
	INSERT INTO `offender`(trn,firstName,lastName,middleInitial,DOB,street,city,parish,licenseType,points,expiryDate) values(offenderTrn,firstName,lastName,middleInitial,dob,street,city,parish,licenseType,licensePoints-ticketPoints,expiryDate);
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
END$$

DROP PROCEDURE IF EXISTS `sp_payTicket`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_payTicket`(ticketNumber int(11),officerId varchar(16),amount float,out result int(11))
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
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
CREATE TABLE IF NOT EXISTS `division` (
  `id` int(11) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`id`, `street`, `city`, `parish`, `phoneNumber`) VALUES
(101, '18 clover road', 'Kingtson 7', 'Kingston', '988-2001');

-- --------------------------------------------------------

--
-- Table structure for table `offender`
--

DROP TABLE IF EXISTS `offender`;
CREATE TABLE IF NOT EXISTS `offender` (
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

--
-- Dumping data for table `offender`
--

INSERT INTO `offender` (`trn`, `firstName`, `lastName`, `middleInitial`, `DOB`, `street`, `city`, `parish`, `licenseType`, `points`, `expiryDate`) VALUES
(1000003, 'sync', 'mcfarlane', 'b', '2008-07-22', '17 blue dale street', 'portmore', 'Saint Catherine', 'General', 213, '2013-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `offense`
--

DROP TABLE IF EXISTS `offense`;
CREATE TABLE IF NOT EXISTS `offense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `offense`
--

INSERT INTO `offense` (`id`, `name`, `description`) VALUES
(1, 'Speeding', ''),
(2, 'Double Park', ''),
(3, 'Traffic Light', ''),
(4, 'Overload', ''),
(5, 'No parking', ''),
(9, 'No Seat Belt', 'Passanger not wearing seat belt'),
(10, 'Talking on cell Phone', 'Talking on cell phone while driving'),
(12, 'Malfunctioning Break Light', 'Break light is not fucntioning correctly.');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `officerId` varchar(16) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `paymentDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_ticket` (`ticket_id`),
  KEY `fk_payment_officer` (`officerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `officerId`, `ticket_id`, `amount`, `paymentDate`) VALUES
(1, '1005', 1, 5000, '2012-04-03 00:01:05'),
(2, '1005', 2, 2030, '2012-04-03 01:19:06'),
(3, '1005', 2, 2030, '2012-04-03 01:20:26');

-- --------------------------------------------------------

--
-- Table structure for table `police`
--

DROP TABLE IF EXISTS `police`;
CREATE TABLE IF NOT EXISTS `police` (
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
  KEY `fk_police_division` (`divisionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `police`
--

INSERT INTO `police` (`badgeId`, `divisionId`, `firstName`, `lastName`, `middleInitial`, `DOB`, `street`, `city`, `parish`) VALUES
('K1001', 101, 'Dale', 'McFarlane', 'M', '2012-03-16', '1872 killl road', 'Kingston 10', 'Kingston');

-- --------------------------------------------------------

--
-- Table structure for table `taxofficer`
--

DROP TABLE IF EXISTS `taxofficer`;
CREATE TABLE IF NOT EXISTS `taxofficer` (
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

--
-- Dumping data for table `taxofficer`
--

INSERT INTO `taxofficer` (`officerId`, `firstName`, `lastName`, `middleInitial`, `DOB`, `street`, `city`, `parish`) VALUES
('1004', 'Robert', 'Campbell', 'C', '1983-04-08', '17 Somewhere Street', 'Kingston 10', 'Kingston'),
('1005', 'Robert', 'Campbell', 'C', '1983-04-08', '17 Somewhere Street', 'Kingston 10', 'Kingston');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
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
  KEY `fk_ticekt_offense` (`offenseId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `policeId`, `offenderTrn`, `offenseId`, `offenseDate`, `street`, `city`, `parish`, `description`, `fine`, `points`, `paymentStatus`) VALUES
(1, 'K1001', 1000003, 1, '2012-03-08 00:00:00', 'sddsdsd', 'ssdsdsds', 'Saint Catherine', 'sddsdsd', 5000, 15, 1),
(2, 'K1001', 1000003, 1, '2012-03-01 00:00:00', 'qwqwqw', 'qwqwq', 'Select a Parish', 'qwqwqw', 2030, 5, 1),
(3, 'K1001', 1000003, 1, '2012-03-02 00:00:00', 'sass', 'asasa', 'Saint Catherine', 'sass', 5000, 10, 0),
(4, 'K1001', 1000003, 2, '2012-04-05 00:00:00', 'qwq', 'qwqqw', 'Saint Catherine', 'qwq', 4500, 2, 0),
(6, 'K1001', 1000003, 1, '2012-04-18 00:00:00', '2223wwww', '332323wewe', 'Kingston', '2223wwww', 3230, 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `handle` varchar(32) NOT NULL,
  `pin` varchar(32) NOT NULL,
  `accountType` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `handle` (`handle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `handle`, `pin`, `accountType`) VALUES
(1, 'K1001', 'password', 2),
(2, '1004', 'password', 2),
(3, '1005', 'password', 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_payment_officer` FOREIGN KEY (`officerId`) REFERENCES `taxofficer` (`officerId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payment_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `police`
--
ALTER TABLE `police`
  ADD CONSTRAINT `fk_police_division` FOREIGN KEY (`divisionId`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticekt_offender` FOREIGN KEY (`offenderTrn`) REFERENCES `offender` (`trn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_offense` FOREIGN KEY (`offenseId`) REFERENCES `offense` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_police` FOREIGN KEY (`policeId`) REFERENCES `police` (`badgeId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
