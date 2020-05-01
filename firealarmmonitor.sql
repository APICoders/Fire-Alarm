-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2020 at 03:04 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `firealarmmonitor`
--

-- --------------------------------------------------------

--
-- Table structure for table `firealarm`
--

CREATE TABLE `firealarm` (
  `id` int(11) NOT NULL,
  `floorNo` varchar(20) NOT NULL,
  `roomNo` varchar(20) NOT NULL,
  `co2Level` int(11) NOT NULL DEFAULT '0',
  `smokeLevel` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `firealarm`
--

INSERT INTO `firealarm` (`id`, `floorNo`, `roomNo`, `co2Level`, `smokeLevel`, `status`) VALUES
(3, '12', '9', 2, 7, 1),
(4, '2', '5', 4, 3, 0),
(5, '20', '2', 0, 0, 0),
(6, '20', 'b12', 0, 0, 0),
(20, 'floor 1', 'room 1', 0, 0, 0),
(24, 'f', 'r', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `name`, `password`) VALUES
('pasanpramuditha97@gmail.com', 'pasan', 'pop123'),
('kusalrathnakumara@gmail.com', 'kusal', 'dindincat'),
('madushanidissanyake@gmail.com', 'madushani', '123'),
('sandaminidhu@gmail.com', 'umesha', '456'),
('pasan@gmail.com', 'pramu', 'pop'),
('pasan123@gmail.com', 'pasannew', 'pop');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `firealarm`
--
ALTER TABLE `firealarm`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `firealarm`
--
ALTER TABLE `firealarm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
