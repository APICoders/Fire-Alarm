-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2020 at 06:32 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

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
(1, 'f01', 'r14', 0, 0, 0),
(2, 'f15', 'r03', 0, 0, 0),
(3, 'f09', 'r08', 0, 0, 0),
(4, 'f03', 'r07', 0, 0, 0);

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
('pramuditha97@gmail.com', 'Pasan Pramuditha', 'p5@n97'),
('madushanidissanayake@gmail.com', 'Madushani Dissanayake', 'm123@dis'),
('kusalrathnakumara@gmail.com', 'Kusal Rathnakumara', 'ku5@1r5th'),
('sandaminidhu@gmail.com', 'Umesha Sandamini', '5@nd@miniu33');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
