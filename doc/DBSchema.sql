-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 14, 2012 at 03:09 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jcf`
--

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE IF NOT EXISTS `division` (
  `id` int(11) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `parish` varchar(30) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `offence`
--

CREATE TABLE IF NOT EXISTS `offence` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `offender`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `police`
--

CREATE TABLE IF NOT EXISTS `police` (
  `badgeId` int(11) NOT NULL,
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

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL,
  `policeId` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `police`
--
ALTER TABLE `police`
  ADD CONSTRAINT `fk_police_division` FOREIGN KEY (`divisionId`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticekt_offence` FOREIGN KEY (`offenceId`) REFERENCES `offence` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_offender` FOREIGN KEY (`offenderTrn`) REFERENCES `offender` (`trn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ticekt_police` FOREIGN KEY (`policeId`) REFERENCES `police` (`badgeId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
