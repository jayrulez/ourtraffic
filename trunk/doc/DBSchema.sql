create table division
(
	id INT(11) PRIMARY KEY NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	parish VARCHAR(30) NOT NULL,
	phoneNumber VARCHAR(10) NOT NULL
);

create table police
(
	badgeId INT(11) PRIMARY KEY NOT NULL,
	divisionId INT(11) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(30) NOT NULL,
	middleInitial VARCHAR(1) DEFAULT NULL,
	DOB DATE NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	parish VARCHAR(30) NOT NULL
);

create table offender
(
	trn INT(11) PRIMARY KEY NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(30) NOT NULL,
	middleInitial VARCHAR(1) DEFAULT NULL,
	DOB DATE NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	parish VARCHAR(30) NOT NULL,
	licenseType VARCHAR(20) NOT NULL,
	points INT NOT NULL,
	expiryDate DATE NOT NULL
);


create table Offence
(
	Id INT(11) PRIMARY KEY NOT NULL,
	Name VARCHAR(50) NOT NULL
);

create table Ticket
(
	Id INT(11) PRIMARY KEY NOT NULL,
	PoliceID INT NOT NULL,
	OffenderTRN INT NOT NULL,
	OffenceId INT NOT NULL,
	OffenceDate DATE NOT NULL,
	OffenceLocation VARCHAR(100) NOT NULL,
	Description TEXT NOT NULL,
	Fine FLOAT(11) NOT NULL,
	Points INT NOT NULL,
	PaymentStatus INT NOT NULL
);
