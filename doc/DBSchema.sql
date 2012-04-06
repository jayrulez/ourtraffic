-- create database if not exists ticketingdb;

CREATE TABLE IF NOT EXISTS `division` (
  `id` int(11) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

CREATE TABLE IF NOT EXISTS `offense` (
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
  `officerId` varchar(16) NOT NULL, 
  `ticket_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `paymentDate` datetime NOT NULL,
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

-- payment status (unpaid = 0), (paid = 1)
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policeId` varchar(16) NOT NULL,
  `offenderTrn` int(11) NOT NULL,
  `offenseId` int(11) NOT NULL,
  `offenseDate` datetime NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `description` text NULL,
  `fine` float NOT NULL,
  `points` int(11) NOT NULL,
  `paymentStatus` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `fk_ticekt_police` (`policeId`),
  KEY `fk_ticekt_offender` (`offenderTrn`),
  KEY `fk_ticekt_offense` (`offenseId`)
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
  ADD CONSTRAINT `fk_payment_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payment_officer` FOREIGN KEY(`officerId`) REFERENCES `taxofficer` (`officerid`) ON UPDATE CASCADE;

ALTER TABLE `police`
  ADD CONSTRAINT `fk_police_division` FOREIGN KEY (`divisionId`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticekt_offense` FOREIGN KEY (`offenseId`) REFERENCES `offense` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_offender` FOREIGN KEY (`offenderTrn`) REFERENCES `offender` (`trn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_police` FOREIGN KEY (`policeId`) REFERENCES `police` (`badgeId`) ON DELETE CASCADE ON UPDATE CASCADE;
  
  
DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getUser`$$
CREATE PROCEDURE `sp_getUser` (userHandle varchar(16))
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
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getUserLogin`$$
CREATE PROCEDURE `sp_getUserLogin` (userHandle varchar(16), password varchar(32))
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
DELIMITER ;

call sp_getUser("21223");

DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_addPolice`$$
CREATE PROCEDURE `sp_addPolice` (badgeId varchar(16),divId int(11), fName varchar(30), lName varchar(30), mInitial varchar(1), dob Date, address1 varchar(50), address2 varchar(50), parish varchar(30), password varchar(128), OUT result int)
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
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getAllOffenses`$$
CREATE PROCEDURE `sp_getAllOffenses` ()
BEGIN
	select * from `offense`;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getOffender`$$
CREATE PROCEDURE `sp_getOffender` (offenderTrn int)
BEGIN
	select * from `offender` where `offender`.trn = offenderTrn;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_issueTicket`$$
CREATE PROCEDURE `sp_issueTicket` (policeId varchar(16), offenderTrn int(11), offenseId int(11), offenseDate date, street varchar(50), city varchar(50), parish varchar(30), description text , fine float, points int(11),OUT result int)
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
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_issueTicketNewOffender`$$
CREATE PROCEDURE `sp_issueTicketNewOffender` (offenderTrn int(11), firstName varchar(30), lastName varchar(30), middleInitial varchar(1),street varchar(50), city varchar(30), parish varchar(30), dob date,licenseType varchar(20),licensePoints int(11), expiryDate Date ,policeId varchar(16), offenseId int(11), offenseDate date, ticketStreet varchar(50), ticketCity varchar(50), ticketParish varchar(30), description text, fine float, ticketPoints int(11),OUT result int)
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
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getTicket`$$
CREATE PROCEDURE `sp_getTicket` (ticketNumber int(11))
BEGIN
    select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where `ticket`.id = ticketNumber;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_getTickets`$$
CREATE PROCEDURE `sp_getTickets` (ticketNumber int(11),offenderTrn int(11),paymentStatus int)
BEGIN

    select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where `ticket`.id = ticketNumber;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_payTicket`$$
CREATE PROCEDURE `sp_payTicket` (ticketNumber int(11),officerId varchar(16),amount float,out result int(11))
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


DELIMITER $$
DROP PROCEDURE IF EXISTS `sp_addOffense`$$
CREATE PROCEDURE `sp_addOffense` (offenseName varchar(50), offenseDescription TEXT,OUT result int)
BEGIN
	SET result = 0;
	START TRANSACTION;
	INSERT INTO `offense`(id,name,description) values(default, offenseName,offenseDescription);
	IF ROW_COUNT()=1 THEN
    SET result = mysql_insert_id();
    commit;
	ELSE
		SET result = -1;
	END IF;
END$$
DELIMITER ;



insert into `offense`(id,name,description) values(default,"Speeding","");
insert into `offense`(id,name,description) values(default,"Double Park","");
insert into `offense`(id,name,description) values(default,"Traffic Light","");
insert into `offense`(id,name,description) values(default,"Overload","");
insert into `offense`(id,name,description) values(default,"No parking","");

insert into division values(101,"18 clover road","Kingtson 7","Kingston","988-2001");

insert into offender(trn,firstName,lastName,middleInitial,DOB,street,city,parish,licenseType,points,expiryDate) values('1000003','Dale','mcfarlane','B','2008-7-22','17 blue dale street','portmore','Saint Catherine','General',223,'2013-12-1');


call sp_getTicket("1");
call sp_getAllOffenses();
call sp_getUserLogin("K1001","password");

select * from division;
select * from police;
select * from taxofficer;
select * from user;
select * from offender;
select * from ticket;
select * from payment;

select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where 1=1;
select `ticket`.id as ticketNumber, `ticket`.offenseDate, `ticket`.street as ticketStreet,`ticket`.city as ticketCity, `ticket`.parish as ticketParish,`ticket`.description as ticketDescription,`ticket`.fine as ticketFine,`ticket`.points as ticketPoints,`ticket`.paymentStatus, `offender`.trn as offenderTrn, `offender`.firstName as offenderFirstName,`offender`.lastName as offenderLastName,`offender`.middleInitial as offenderMiddleInitial,`offender`.DOB as offenderDob,`offender`.street as offenderStreet, `offender`.city as offenderCity,`offender`.parish as offenderParish,`offender`.licenseType as licenseType,`offender`.points as licensePoints,`offender`.expiryDate as licenseExpiryDate, `police`.badgeId,`police`.divisionId,`police`.firstName as policeFirstName,`police`.lastName as policeLastName,`police`.middleInitial as policeMiddleInitial, `offense`.id as offenseId,`offense`.name as offenseName from `ticket` inner join `offender` on `offender`.trn = `ticket`.offenderTrn inner join `police` on `police`.badgeId = `ticket`.policeId inner join `offense` on  `offense`.id = `ticket`.offenseId where 1=1

 (select badgeId as userHandle,firstName,middleInitial,lastName,DOB,street,city,parish, `user`.accountType from police inner join `user` on `user`.handle = badgeId) union (select officerId as userHandle,firstName,middleInitial,lastName,DOB,street,city,parish,`user`.accountType from taxofficer inner join `user` on `user`.handle =officerId);