-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 01 Avril 2017 à 21:11
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tutorial`
--

-- --------------------------------------------------------

--
-- Structure de la table `categoriessql`
--

CREATE TABLE `categoriessql` (
  `nom` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categoriessql`
--

INSERT INTO `categoriessql` (`nom`, `description`, `id_categorie`) VALUES
('alimentation', 'Alimentation', 1),
('animauxFleu', 'Animaux - Fleuristes - Jardin', 2),
('batimmo', 'Batiments - Immobilier', 3),
('beautebienetre', 'Beauté - Bien-être', 4),
('cafetabacpresse', 'Café - Tabac - Presse', 5),
('finances', 'Finances', 6),
('hebergResto', 'Hébergement - Restauration', 7),
('loisirs', 'Loisirs', 8),
('bricodeco', 'Maison - Bricolage - Déco', 9),
('mode', 'Mode', 10),
('multimédia', 'Multimédia', 11),
('sante', 'Santé', 12),
('transpovehic', 'Transports - Véhicules', 13),
('autres', 'Autres', 14);

-- --------------------------------------------------------

--
-- Structure de la table `commerces`
--

CREATE TABLE `commerces` (
  `id` int(10) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `age` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commerces`
--

INSERT INTO `commerces` (`id`, `firstname`, `lastname`, `age`) VALUES
(1, 'Le cafe ducoin', 'Rue des Arts', '0350508080'),
(8, 'Ecole des Mines', 'Rue Grand Bail', '0658583035'),
(9, 'Match', 'Rue du Kiosque', '0680808080');

-- --------------------------------------------------------

--
-- Structure de la table `commerces2`
--

CREATE TABLE `commerces2` (
  `id` int(10) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commerces2`
--

INSERT INTO `commerces2` (`id`, `firstname`, `lastname`, `age`) VALUES
(1, 'Matthieu et la famille', 'Veron', 21),
(2, 'a', 'a', 10);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categoriessql`
--
ALTER TABLE `categoriessql`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `commerces`
--
ALTER TABLE `commerces`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commerces2`
--
ALTER TABLE `commerces2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categoriessql`
--
ALTER TABLE `categoriessql`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `commerces`
--
ALTER TABLE `commerces`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `commerces2`
--
ALTER TABLE `commerces2`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
