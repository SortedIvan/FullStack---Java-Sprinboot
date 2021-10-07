-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2021 at 09:12 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamewebshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `email`, `name`, `password`, `username`) VALUES
(4, 'ivan@gmail.com', 'Ivan Ovcharov', '$2a$10$DTLr27ttYMrBxOxgkbjyEuxDWDjW/qWsDVVAJ6ZZpMtLNQWJOpc1e', 'ivan2e'),
(5, 'tom123@gmail.com', 'Hamako Yutai', '$2a$10$09EopZCcdUeM76yzeSxwTeCfOUGa4qP6.NgsMISRO7KW9IF2Og14i', 'hamako'),
(6, 'boriz@gmail.com', 'Boriz Tunai', '$2a$10$bY730HJwnTsvF.T7.QRyouJVNVqbdLOvqe.iw3xFf.wMz5rqMQUgG', 'boriz1');

-- --------------------------------------------------------

--
-- Table structure for table `app_user_roles`
--

CREATE TABLE `app_user_roles` (
  `app_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_user_roles`
--

INSERT INTO `app_user_roles` (`app_user_id`, `roles_id`) VALUES
(4, 1),
(5, 2),
(6, 2),
(6, 3),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `id` bigint(20) NOT NULL,
  `game_name` varchar(255) DEFAULT NULL,
  `game_price` double NOT NULL,
  `game_rating` double NOT NULL,
  `game_size` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `game_name`, `game_price`, `game_rating`, `game_size`) VALUES
(12, 'Zelda', 19.99, 5, 500),
(13, 'Halo', 29.99, 4.5, 5010),
(14, 'Rust', 29.99, 3.4, 2300),
(15, 'Amnesia', 24.99, 5, 300);

-- --------------------------------------------------------

--
-- Table structure for table `game_game_types`
--

CREATE TABLE `game_game_types` (
  `game_id` bigint(20) NOT NULL,
  `game_types_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game_game_types`
--

INSERT INTO `game_game_types` (`game_id`, `game_types_id`) VALUES
(12, 10),
(13, 9),
(14, 11),
(15, 8),
(15, 10);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_GAMEDEV'),
(3, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `type_game`
--

CREATE TABLE `type_game` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type_game`
--

INSERT INTO `type_game` (`id`, `name`) VALUES
(7, 'ARCADE'),
(8, 'HORROR'),
(9, 'SCI_FI'),
(10, 'ADVENTURE'),
(11, 'SURVIVAL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD KEY `FK23e7b5jyl3ql41rk3566gywdd` (`roles_id`),
  ADD KEY `FKkwxexnudtp5gmt82j0qtytnoe` (`app_user_id`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game_game_types`
--
ALTER TABLE `game_game_types`
  ADD KEY `FK4ewe6v9wk5sanx5uw0k5objof` (`game_types_id`),
  ADD KEY `FKe2tc4ihloiwcu63dsyi7of5xv` (`game_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_game`
--
ALTER TABLE `type_game`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
