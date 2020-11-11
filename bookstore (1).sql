-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 nov. 2020 à 16:03
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `author` varchar(50) NOT NULL,
  `releaseDate` date NOT NULL,
  `cover` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `title`, `price`, `author`, `releaseDate`, `cover`) VALUES
(13, 'amen', 10, 'amen', '1970-01-01', 'C:\\\\Users\\\\Amen\\\\eclipse-workspace\\\\bookstore\\\\src\\\\gui\\\\iconb.png'),
(444, 'sdsd', 20, 'dsd', '2020-02-02', ''),
(445, 'sasa', 12, 'sas', '2020-02-02', 'asdcdf'),
(1122, 'aaa', 20, 'aaa', '2020-02-02', 'C:\\\\Users\\\\Amen\\\\eclipse-workspace\\\\bookstore\\\\src\\\\gui\\\\iconb.png'),
(8184, 'ssxxs', 45, 'xscd', '2020-02-02', 'C:\\\\Users\\\\Amen\\\\eclipse-workspace\\\\bookstore\\\\src\\\\gui\\\\iconb.png'),
(55415, 'aas', 205, 'asaa', '2020-05-05', 'C:\\\\Users\\\\Amen\\\\eclipse-workspace\\\\bookstore\\\\src\\\\gui\\\\iconb.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
