-- create database if not exists ticketingdb;

CREATE TABLE IF NOT EXISTS `division` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `offence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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

CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_ticket` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policeId` varchar(16) NOT NULL,
  `offenderTrn` int(11) NOT NULL,
  `offenceId` int(11) NOT NULL,
  `offenceDate` date NOT NULL,
  `offenceLocation` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `fine` float NOT NULL,
  `points` int(11) NOT NULL,
  `paymentStatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticekt_police` (`policeId`),
  KEY `fk_ticekt_offender` (`offenderTrn`),
  KEY `fk_ticekt_offence` (`offenceId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 2 Police, 3 Taxofficer --

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `handle` varchar(32) NOT NULL,
  `pin` varchar(32) NOT NULL,
  `accountType` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `handle` (`handle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


ALTER TABLE `payment`
  ADD CONSTRAINT `fk_payment_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `police`
  ADD CONSTRAINT `fk_police_division` FOREIGN KEY (`divisionId`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticekt_offence` FOREIGN KEY (`offenceId`) REFERENCES `offence` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_offender` FOREIGN KEY (`offenderTrn`) REFERENCES `offender` (`trn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_police` FOREIGN KEY (`policeId`) REFERENCES `police` (`badgeId`) ON DELETE CASCADE ON UPDATE CASCADE;
  
  
DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getUser`$$
CREATE PROCEDURE `sp_getUser` (userHandleString varchar(32))
BEGIN
    DECLARE userType tinyint(1) DEFAULT 0;
    IF EXISTS(SELECT `user`.accountType from `user` WHERE `user`.handle = userHandleString) THEN
        SELECT `user`.accountType INTO userType from `user` WHERE `user`.handle = userHandleString;
        IF userType = 2 THEN
            SELECT `police`.*, `user`.* FROM `user` INNER JOIN `police` ON `police`.badgeId = CAST(`user`.handle AS SIGNED) WHERE `user`.handle = userHandleString;
        ELSE 
            IF userType = 3 THEN
                SELECT `taxofficer`.*, `user`.* FROM `user` INNER JOIN `taxofficer` ON `police`.badgeId = CAST(`user`.handle AS SIGNED) WHERE `user`.handle = userHandleString;
            END IF;
        END IF;
    END IF;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_addPolice`$$
CREATE PROCEDURE `sp_addPolice` (badgeId varchar(16),divId int(11), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
BEGIN
    SET result = 0;
    IF NOT EXISTS (SELECT * FROM `user` where `user`.handle = badgeId) AND NOT EXISTS(SELECT * FROM police WHERE police.badgeId = badgeId) THEN
        START TRANSACTION;
        INSERT INTO `police`(badgeId,divisionId,firstName,middleInitial,lastName,DOB,street,city,parish) VALUES(badgeId,divId,fName,mInitial,lName,dob,address1, address2, parish);
			IF ROW_COUNT() = 1 THEN
				INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,badgeId,MD5(password),2);
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
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_addTaxOfficer`$$
CREATE PROCEDURE `sp_addTaxOfficer` (officerId varchar(16), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
BEGIN
	SET result = 0;
    IF NOT EXISTS (SELECT * FROM `user` where `user`.handle = officerId) AND NOT EXISTS(SELECT * FROM taxofficer WHERE taxofficer.officerId = officerId)  THEN
        START TRANSACTION;
			INSERT INTO `taxofficer`(officerId,firstName,middleInitial,lastName,DOB,street,city,parish) VALUES(officerId,fName,mInitial,lName,dob,address1, address2, parish);
			IF ROW_COUNT() = 1 THEN
				INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,officerId,MD5(password),2);
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
DELIMITER ;


DELIMITER $$
DROP TRIGGER IF EXISTS `trg_addPoliceUser`$$
CREATE TRIGGER `trg_addPoliceUser` AFTER INSERT ON police FOR EACH ROW
BEGIN
    INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,CAST(NEW.badgeId AS CHAR),MD5(NEW.pin),2);
END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS `trg_addTaxOfficerUser`$$
CREATE TRIGGER `trg_addTaxOfficerUser` AFTER INSERT ON taxofficer FOR EACH ROW
BEGIN
    INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,NEW.officerId,MD5(NEW.pin),2);
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_issueTicket`$$
CREATE PROCEDURE `sp_issueTicket` (OUT result int)
BEGIN
	SET result = 0;
    IF NOT EXISTS (SELECT * FROM `user` where `user`.handle = officerId) AND NOT EXISTS(SELECT * FROM taxofficer WHERE taxofficer.officerId = officerId)  THEN
        START TRANSACTION;
			INSERT INTO `taxofficer`(officerId,firstName,middleInitial,lastName,DOB,street,city,parish) VALUES(officerId,fName,mInitial,lName,dob,address1, address2, parish);
			IF ROW_COUNT() = 1 THEN
				INSERT INTO `user`(id,handle,pin,accountType) VALUES(DEFAULT,officerId,MD5(password),2);
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
DELIMITER ;
