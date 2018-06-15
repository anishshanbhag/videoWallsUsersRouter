-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 14, 2018 at 05:06 PM
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
