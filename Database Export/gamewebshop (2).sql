-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2021 at 02:55 AM
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
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `id` bigint(20) NOT NULL,
  `gamename` varchar(255) DEFAULT NULL,
  `gameplaytype` int(11) DEFAULT NULL,
  `gameprice` double DEFAULT NULL,
  `gamesize` double DEFAULT NULL,
  `app_user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`id`, `gamename`, `gameplaytype`, `gameprice`, `gamesize`, `app_user_id`) VALUES
(13, 'Mario', 0, 19.99, 500, 7),
(14, 'Zelda', 1, 29.99, 400, 7),
(15, 'AdventureGame', 0, 39.99, 900, 7),
(16, 'Rust', 1, 59.99, 1000, 7);

-- --------------------------------------------------------

--
-- Table structure for table `games_game_types`
--

CREATE TABLE `games_game_types` (
  `game_id` bigint(20) NOT NULL,
  `game_types_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `games_game_types`
--

INSERT INTO `games_game_types` (`game_id`, `game_types_id`) VALUES
(14, 11),
(13, 10),
(15, 12),
(15, 9),
(16, 11);

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
-- Table structure for table `game_rating`
--

CREATE TABLE `game_rating` (
  `ratingid` bigint(20) NOT NULL,
  `rating` double NOT NULL,
  `game_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `game_system_requirements`
--

CREATE TABLE `game_system_requirements` (
  `game_id` bigint(20) NOT NULL,
  `system_requirements` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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
(17);

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
(8, 'ARCADE'),
(9, 'HORROR'),
(10, 'SCI_FI'),
(11, 'ADVENTURE'),
(12, 'SURVIVAL');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `username`) VALUES
(4, 'ivan888@gmail.com', 'Ivan Ovcharov', '$2a$10$lwbE7fVAGbC2ynP/hSOgnOx047JCaVwTIhDykUL3l6hzXsqzs0F6O', 'ivan2e'),
(5, 'tom123@gmail.com', 'Hamako Yutai', '$2a$10$ifrXd4fbKQap7pWqledaz.AJoXIJC48/vG05k9qZbNG7hLyN.kuPW', 'hamako'),
(6, 'boriz@gmail.com', 'Boriz Tunai', '$2a$10$g82yllmoHLI.7bLOsXUvQ.AJQjw8EQkbbbZM2M4Mms342HMN2nHzC', 'boriz1'),
(7, 'ivan@gmail.com', 'Ivan Test', '$2a$10$brmz9um0Bs2YXtU3cyjZp.EC1NwJ93Gf2nv/18WdtZCqXgFuDScj.', 'ivantest');

-- --------------------------------------------------------

--
-- Table structure for table `users_gameids`
--

CREATE TABLE `users_gameids` (
  `app_user_id` bigint(20) NOT NULL,
  `gameids_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `app_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`app_user_id`, `roles_id`) VALUES
(4, 1),
(5, 2),
(6, 2),
(6, 3),
(6, 1),
(7, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD KEY `FK23e7b5jyl3ql41rk3566gywdd` (`roles_id`),
  ADD KEY `FKkwxexnudtp5gmt82j0qtytnoe` (`app_user_id`);

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0kpgf4yas7dgsmrdvqv65pge` (`app_user_id`);

--
-- Indexes for table `games_game_types`
--
ALTER TABLE `games_game_types`
  ADD KEY `FKsfhaoyo6ldso4uejxf73kdt4h` (`game_types_id`),
  ADD KEY `FKf7do7fpdctgnhk0vom00g8tu0` (`game_id`);

--
-- Indexes for table `game_game_types`
--
ALTER TABLE `game_game_types`
  ADD KEY `FK4ewe6v9wk5sanx5uw0k5objof` (`game_types_id`),
  ADD KEY `FKe2tc4ihloiwcu63dsyi7of5xv` (`game_id`);

--
-- Indexes for table `game_rating`
--
ALTER TABLE `game_rating`
  ADD PRIMARY KEY (`ratingid`),
  ADD KEY `FKlshfk3wvme0j53er2a480gty3` (`game_id`);

--
-- Indexes for table `game_system_requirements`
--
ALTER TABLE `game_system_requirements`
  ADD KEY `FK10c1qp5g6e6k3xjw6w005c8x` (`game_id`);

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

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`) USING HASH;

--
-- Indexes for table `users_gameids`
--
ALTER TABLE `users_gameids`
  ADD UNIQUE KEY `UK_5oxnfnuwbcm8piy15pvkoacs8` (`gameids_id`),
  ADD KEY `FKjxqri8nx7718ya58cyksyjpga` (`app_user_id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK15d410tj6juko0sq9k4km60xq` (`roles_id`),
  ADD KEY `FKar2y0lww0xn3x3aoqfg9qsgr5` (`app_user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
