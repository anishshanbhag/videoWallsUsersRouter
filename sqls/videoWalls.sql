-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 19, 2018 at 03:34 PM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `videoWalls`
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
  `deviceId` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consumer`
--

INSERT INTO `consumer` (`id`, `name`, `phoneNumber`, `createdAt`, `deviceId`) VALUES
('4e5b9964736b9e948ab7b292d42deb48', 'joeydash', '9435840783', 1529321445, 'sample');

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

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`id`, `deviceFingerprint`, `isVerified`, `createdAt`, `salesmanId`) VALUES
('3d9ef4721090c957acce664e122c0b04', 'jvgkmjgvmgbm', 0, 1529400404, ''),
('fecec767ed805ccf4c98b9f4342e8f87', 'jvgkmjgvmgbm', 0, 1529400264, '');

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

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `productName`, `productDetails`, `productCategory`, `productStringTags`, `totalRatings`, `totalUsersRated`, `totalHits`) VALUES
('2ddb5959e140743c12a7a281159c6b7f', 'Iphone 10', 'Its for rich bitch', 'mobilePhone', 'Iphone 10 Its for rich bitch mobilePhone', 0, 0, 0),
('4fba5179a39bd1ce5cd4fffd657b8bf9', 'nokia 1110', 'soft phone', 'mobile', 'nokia 1110 soft phone mobile', 0, 0, 0),
('51a5869f2d3e67e79e669ef8a39373cc', 'nokia 1000', 'soft phone', 'mobile', 'nokia 1000 soft phone mobile', 0, 0, 0),
('5ad79b9921c05b0d5288b496de22bd99', 'nokia 1000', 'hard phone', 'mobile', 'nokia 1000 hard phone mobile', 0, 0, 0),
('a6e62837d3a9541055026dab789d381f', 'nokia 1110', 'hard phone', 'mobile', 'nokia 1110 hard phone mobile', 0, 0, 0),
('ab2aa351ad030b5c0c5781645c65cdad', 'Samsung', 'Its good', 'mobilePhone', 'Samsung Its good mobilePhone', 0, 0, 0);

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
-- Dumping data for table `salesman`
--

INSERT INTO `salesman` (`id`, `userName`, `randomString`, `hashedPassword`, `role`, `isActive`, `isOccupied`, `createdAt`, `lastSignedIn`, `authToken`) VALUES
('74af7fc1c163ca34c65c5893993d6b58', 'joeydash', '6pc5hsaZgdiRd8mlDbsB5C1czDdQMVR', '959cbc8a1c3266f0fb177cae68b71a84', 'salesman', 0, 0, 1528972632, 1528972632, '7oiCkZpLwEwo4VkNZsAhp9Ilklfzg8N');

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
