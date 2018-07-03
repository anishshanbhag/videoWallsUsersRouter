-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 03, 2018 at 08:29 AM
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
  `deviceId` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consumer`
--

INSERT INTO `consumer` (`id`, `name`, `phoneNumber`, `createdAt`, `deviceId`) VALUES
('05c0b3fd3a8caed72cc977cff1ba3903', 'saf', '345', 1530287032, '7074e69abc13d20d5f7abfaaa7792fdf'),
('27dfdc6abc9dd55b28732021cdb6b586', 'dsads', '9898', 1530286435, '7074e69abc13d20d5f7abfaaa7792fdf'),
('451c2664c5827d53908ddf04b2a3d99b', 'kadsa12', '132123', 1530284729, '7074e69abc13d20d5f7abfaaa7792fdf'),
('50cd57e72a1a96b6f6baa9b7c0b0f543', 'dgfdfgdg', '454455', 1530284916, '7074e69abc13d20d5f7abfaaa7792fdf'),
('c8c6c4a237642f66f28788f46ad40a00', 'asas', '121212', 1530286159, '7074e69abc13d20d5f7abfaaa7792fdf'),
('dc034522cf645d39ed3641c7a6b81f43', 'asasas', '1223345', 1530285689, '7074e69abc13d20d5f7abfaaa7792fdf'),
('f2d5177d755304c1e750c2700a23897e', 'asasasasas', '111111', 1530285753, '7074e69abc13d20d5f7abfaaa7792fdf');

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
('3d9ef4721090c957acce664e122c0b04', 'jvgkmjgvmgbm', 0, 1529400404, '');

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
('0d3d16436f5cb78883be340519df7049', 'Galaxy Note 4', 'Samsung Product', 'Mobile', 'Galaxy Note 4 Samsung Product Mobile', 0, 0, 0),
('2ddb5959e140743c12a7a281159c6b7f', 'Iphone 10', 'Its for rich bitch', 'mobilePhone', 'Iphone 10 Its for rich bitch mobilePhone', 0, 0, 0),
('4fba5179a39bd1ce5cd4fffd657b8bf9', 'nokia 1110', 'soft phone', 'mobile', 'nokia 1110 soft phone mobile', 0, 0, 0),
('50ffd6867478464dc873ed973bc4a595', 'Nexus 6', 'Nice Phone', 'Mobile', 'Nexus 6 Nice Phone Mobile', 0, 0, 0),
('51a5869f2d3e67e79e669ef8a39373cc', 'nokia 1000', 'soft phone', 'mobile', 'nokia 1000 soft phone mobile', 0, 0, 0),
('5ad79b9921c05b0d5288b496de22bd99', 'nokia 1000', 'hard phone', 'mobile', 'nokia 1000 hard phone mobile', 0, 0, 0),
('716cb1fe387f5d50d3d384c349527a5b', 'Pixel 2', 'Google Product', 'Mobile', 'Pixel 2 Google Product Mobile', 0, 0, 0),
('9aaf54cd6a4a923a7547c4b0ae7ad16b', '', '', '', '  ', 0, 0, 0),
('a6e62837d3a9541055026dab789d381f', 'nokia 1110', 'hard phone', 'mobile', 'nokia 1110 hard phone mobile', 0, 0, 0),
('ab2aa351ad030b5c0c5781645c65cdad', 'Samsung', 'Its good', 'mobilePhone', 'Samsung Its good mobilePhone', 0, 0, 0),
('cb666a25a70b1f4283b70bab81f6e4ff', 'nexus 7', 'Nice product', 'Mobile', 'nexus 7 Nice product Mobile', 0, 0, 0),
('ed15e988c3c258b68221e212daf539f7', '', '', '', '  ', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `productSalesman`
--

CREATE TABLE `productSalesman` (
  `id` varchar(63) NOT NULL,
  `salesmanId` varchar(63) NOT NULL,
  `productId` varchar(63) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productSalesman`
--

INSERT INTO `productSalesman` (`id`, `salesmanId`, `productId`) VALUES
('2f152cd87e6da2a628c506cfc834a366', '443893cb3fb04212f409dca45c2913dd', '50ffd6867478464dc873ed973bc4a595'),
('6a35715b92168068881cb5fe2db3acd1', '777a9aaa085a48e73989e32a4a15bf50', '50ffd6867478464dc873ed973bc4a595');

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
  `endTime` int(11) DEFAULT NULL,
  `salesmanId` varchar(63) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `consumerId`, `deviceId`, `requestedTime`, `startTime`, `endTime`, `salesmanId`) VALUES
('c8c6c4a237642f66f28788f46ad40a00', NULL, '7074e69abc13d20d5f7abfaaa7792fdf', 1530286159, NULL, NULL, '73e489ce4b10490191966519ab584f86'),
('78755aae2e9bc0c75f62a6da79bd1c0a', NULL, '7074e69abc13d20d5f7abfaaa7792fdf', 1530286434, NULL, NULL, 'e8072559e2d1f11b2f44ab304bebba80'),
('05c0b3fd3a8caed72cc977cff1ba3903', NULL, '7074e69abc13d20d5f7abfaaa7792fdf', 1530287032, NULL, NULL, '85d6492022212f867a6766e793b54f82');

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
('443893cb3fb04212f409dca45c2913dd', 'anish', '4Tq59tJZ3baMtSutwnrzvrl9ZU0qjtD', 'c488c7860f0780468b7d9382771777b7', 'salesman', 0, 1, 1530254390, 1530254390, 'bSrqisPDB4ihscCEmyrl6gX3PSlvb2t'),
('73e489ce4b10490191966519ab584f86', 'aaaaa', 'Y12QQW02EOxpF1M5HOv8eMzQzFc2l6A', '11800f75890986862a0a21f46e7b1fe3', 'salesman', 1, 1, 1530286179, 1530286179, 'h4cf9nCv1wLpBr2qDSh78sAF8LCcXh4'),
('85d6492022212f867a6766e793b54f82', 'jowysdah', 'Y0e71Iq6aGoSwOUZrL1p8gEBGZValoP', 'e6abd10778e25c80c2ca91b43e5cb0e4', 'salesman', 1, 1, 1530287077, 1530287077, '0VAX98XIzVNGp59R8U2bHiCMLO02sFG'),
('8dd9fe6c7595779478fb16698460d51b', 'as', 'TbNzGai0zmJuJADy22i8Vxdhnlasf82', 'e7ad48e896bed3022ae9cb55969bb96b', 'salesman', 1, 1, 1530282236, 1530282236, 'E3fAofefIP2rkUbS1pJxm9ihTMisuKB'),
('e8072559e2d1f11b2f44ab304bebba80', 'agg', '8R7L2cJNcZcDOzyutXpgpOZMEblEYtt', '0e1c798888b6d7f9b6b34c34f6c58718', 'salesman', 1, 1, 1530286463, 1530286463, 'OJ8KySOWWUnlPimFjJ3P3ytOfHXHnA5');

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
