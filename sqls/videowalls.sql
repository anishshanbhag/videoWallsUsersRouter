-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 03, 2018 at 12:28 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `videowalls`
--

-- --------------------------------------------------------

--
-- Table structure for table `consumer`
--

CREATE TABLE `consumer` (
  `id` varchar(63) NOT NULL,
  `name` varchar(63) NOT NULL,
  `phoneNumber` varchar(63) NOT NULL,
  `createdAt` int(11) NOT NULL,
  `deviceId` varchar(63) NOT NULL,
  `productId` varchar(63) NOT NULL,
  `productName` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE `device` (
  `id` varchar(63) NOT NULL,
  `deviceFingerprint` varchar(63) NOT NULL,
  `isVerified` tinyint(1) NOT NULL,
  `createdAt` int(11) NOT NULL,
  `salesmanId` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` varchar(63) NOT NULL,
  `productName` varchar(127) NOT NULL,
  `productDetails` text NOT NULL,
  `productCategory` varchar(31) NOT NULL,
  `productStringTags` text NOT NULL,
  `totalRatings` int(11) NOT NULL,
  `totalUsersRated` int(11) NOT NULL,
  `totalHits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `productSalesman`
--

CREATE TABLE `productSalesman` (
  `id` varchar(63) NOT NULL,
  `salesmanId` varchar(63) NOT NULL,
  `productId` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` varchar(63) NOT NULL,
  `consumerId` varchar(63) DEFAULT NULL,
  `deviceId` varchar(63) NOT NULL,
  `requestedTime` int(11) NOT NULL,
  `startTime` int(11) DEFAULT NULL,
  `averageWaitingTime` int(11) NOT NULL,
  `endTime` int(11) DEFAULT NULL,
  `salesmanId` varchar(63) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salesman`
--

CREATE TABLE `salesman` (
  `id` varchar(63) NOT NULL,
  `userName` varchar(63) NOT NULL,
  `randomString` varchar(63) NOT NULL,
  `hashedPassword` varchar(63) NOT NULL,
  `role` varchar(31) NOT NULL,
  `isActive` tinyint(1) NOT NULL,
  `isOccupied` tinyint(1) NOT NULL,
  `createdAt` int(11) NOT NULL,
  `lastSignedIn` int(11) NOT NULL,
  `authToken` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` varchar(63) NOT NULL,
  `technicalKnowledge` varchar(63) NOT NULL,
  `communicationSkill` varchar(63) NOT NULL,
  `conveyIdeas` varchar(63) NOT NULL,
  `trustFactor` varchar(63) NOT NULL,
  `satisfactionFactor` varchar(63) NOT NULL
)

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consumer`
--
ALTER TABLE `consumer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `productSalesman`
--
ALTER TABLE `productSalesman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salesman`
--
ALTER TABLE `salesman`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
