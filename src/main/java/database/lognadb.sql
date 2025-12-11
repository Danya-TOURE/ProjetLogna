-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 11 déc. 2025 à 12:59
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `lognadb`
--

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `book_url` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Lien vers le fichier audio ou ecrit',
  `created_by` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `book_type` enum('audio','ecrit') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'ecrit',
  `category_id` int DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`),
  KEY `category_id` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `books`
--

INSERT INTO `books` (`id`, `title`, `author`, `book_url`, `created_by`, `created_at`, `book_type`, `category_id`, `description`) VALUES
(1, 'Une si longue lettre', 'Mariama Bâ ', NULL, 0, '2025-12-11 11:20:58', 'ecrit', 1, 'Une si longue lettre est une oeuvre majeure, pour ce qu\'elle dit de la condition des femmes. Au coeur de ce roman, la lettre que l\'une d\'elle, Ramatoulaye, adresse à sa meilleure amie, pendant la réclusion traditionnelle qui suit son veuvage.'),
(2, 'L’aventure ambiguë', 'Cheick Amidou Kane', NULL, 0, '2025-12-11 11:28:47', 'ecrit', 1, 'De manière significative \"L\'aventure ambiguë\", histoire d\'un itinéraire spirituel, porte en sous-titre \"récit\". Ce qui frappe en effet le lecteur de ce livre, c\'est le classicisme dû autant à la retenue du ton qu\'à la portée universelle de la réflexion philosophique. Sans doute l\'auteur oppose-t-il à la pensée technique de l\'Occident, essentiellement tournée vers l\'action, la pensée de l\'Islam, repliée sur elle-même, mais au-delà de cette confrontation c\'est finalement le problème de l\'existence qui est posé. On voit par là comment Cheikh Hamidou Kane, échappant à la donnée temporelle et politique de son sujet, l\'angoisse d\'être noir, débouche sur une réflexion qui nous concerne tous : l\'angoisse d\'être homme.'),
(3, 'Allah n\'est pas obligé', 'Ahmadou Kourouma', NULL, 0, '2025-12-11 11:29:58', 'ecrit', 1, 'Birahima, le narrateur de ce roman, a une douzaine d\'années et il retrace son itinéraire d\'enfant-soldat de l\'Afrique contemporaine, entre le Liberia et la Sierra Leone. Orphelin, jeté sur les routes en compagnie d\'un marabout mi-philosophe mi-escroc, Birahima se fait enrôler dans une bande de pillards. Kalachnikov en bandoulière, pour gagner sa solde, il va bientôt participer aux pires exactions .'),
(4, 'Parachutage', 'Nobert Zongo ', NULL, 0, '2025-12-11 11:30:50', 'ecrit', 1, 'Un coup d\'Etat traîtreusement orchestré renverse Gouama, le \"Père Fondateur de la Nation\", Président de la République de Watinbow. Le \"Guide éclairé\" réussit à s\'échapper grâce à un âne. Dans sa fuite il est sauvé par des étudiants qu\'il avait emprisonnés pour \"communisme\". Ces derniers l\'aident à franchir la frontière pour la République de Zakro. Un plan est mis en place pour reconquérir le pouvoir perdu mais avec les nouveaux accords entre Watinbow et Zakro, l\'ancien \"Père Fondateur de la Nation\" est livré au nouveau maître de Watinbow.'),
(5, 'Le Vieux Nègre et la médaille', 'Ferdinand Oyono', NULL, 0, '2025-12-11 11:31:33', 'ecrit', 1, 'Dans une langue chaleureuse et piquante, Ferdinand Oyono brosse le portrait de Meka, un \" vieux nègre \" que l\'administration a décidé de récompenser pour son dévouement pour la France. Les truculentes aventures de cet homme, humble, mais non dépourvu de malice, sont un régal pour les sens et une subtile critique de la domination coloniale. Une pépite de la littérature africaine, réquisitoire et dénonciatrice.'),
(6, 'Harry Potter et les Reliques de la Mort ', 'J.K Rowling', NULL, 0, '2025-12-11 11:52:47', 'ecrit', 3, 'Cet été-là, Harry atteint ses dix-sept ans, l\'âge de la majorité pour un sorcier, et s\'apprête à faire face à son destin. Soutenu par Ron et Hermione, Harry se consacre pleinement à la mission confiée par Dumbledore avant de mourir, la chasse aux Horcruxes. Mais le Seigneur des Ténèbres règne désormais en maître absolu. Traqués, en exil, les trois fidèles amis vont connaître une solitude sans précédent, où leur courage, leurs choix et leurs sacrifices seront déterminants dans la lutte contre les forces du mal. Leur quête croisera celle des Reliques de la Mort, et fera surgir du passé des révélations capitales et parfois douloureuses. Ces épreuves conduiront Harry, sans détour, vers sa destinée, l\'affrontement final avec Lord Voldemort.'),
(7, 'Harry Potter et l\'Ordre du Phénix', 'J.K Rowling', NULL, 0, '2025-12-11 11:52:47', 'ecrit', 3, 'A quinze ans, Harry s\'apprête à entrer en cinquième année à Poudlard. Et s\'il est heureux de retrouver le monde des sorciers, il n\'a jamais été aussi anxieux. L\'adolescence, la perspective des examens importants en fin d\'année et ces étranges cauchemars... Car Celui-Dont-On-Ne-Doit-Pas-Prononcer-Le-Nom est de retour et, plus que jamais, Harry sent peser sur lui une terrible menace. Une menace que le ministère de la Magie ne semble pas prendre au sérieux, contrairement à Dumbledore. Poudlard devient alors le terrain d\'une véritable lutte de pouvoir. '),
(8, 'Le Seigneur des anneaux: La Fraternité de l\'Anneau', 'J. R. R. Tolkien', NULL, 0, '2025-12-11 11:56:06', 'ecrit', 3, 'Dans un paisible village du Comté, le jeune Frodo est sur le point de recevoir un cadeau qui changera sa vie à jamais : l\'Anneau de Pouvoir. Forgé par Sauron au coeur de la Montagne du Feu, on le croyait perdu depuis qu\'un homme le lui avait arraché avant de le chasser hors du monde. À présent, de noirs présages s\'étendent à nouveau sur la Terre du Milieu, les créatures maléfiques se multiplient et, dans les Montagnes de Brume, les Orques traquent les Nains. L\'ennemi veut récupérer son bien afin de dominer le monde ; l\'OEil de Sauron est désormais pointé sur le Comté. Heureusement Gandalf les a devancés. S\'ils font vite, Frodo et lui parviendront peut-être à détruire l\'Anneau à temps. '),
(9, 'Twilight : Fascination', 'Stephenie Meyer', NULL, 0, '2025-12-11 11:56:06', 'ecrit', 3, 'Bella Swan est une jeune fille de 17 ans qui vient d\'emménager chez son père à Forks, une ville réputée pour son mauvais temps. Persuadée qu\'elle ne s\'habituera pas à cette ville bien humide et qu\'elle mènera dorénavant un vie ennuyeuse, le destin en a voulu autrement. En effet, sa rencontre avec le sublime et mystérieux Edward Cullen aux yeux dorés va bouleverser son existence.'),
(12, 'L’Alchimiste', 'Paulo Coelho', NULL, 0, '2025-12-11 12:00:13', 'ecrit', 5, 'Santiago, un jeune berger andalou, part à la recherche d\'un trésor enfoui au pied des Pyramides. Lorsqu\'il rencontre l\'Alchimiste dans le désert, celui-ci lui apprend à écouter son coeur, à lire les signes du destin et, par dessus tout, à aller au bout de son rêve.'),
(11, 'Dune tome 1', 'Frank Herbert', NULL, 0, '2025-12-11 11:57:21', 'ecrit', 3, 'Dune est la planète la plus hostile de l’Empire : un désert infini où seule compte l’épice, substance rare et précieuse.\r\nQuand Leto Atréides reçoit Dune en fief, il comprend qu’on cherche à le piéger. Pour survivre, il devra compter sur les Fremen, peuple du désert endurci, gardiens de traditions anciennes et en attente d’un Messie qui mènera une guerre sacrée.\r\nPendant ce temps, les Révérendes Mères du Bene Gesserit poursuivent leur programme secret visant à créer un être humain aux capacités exceptionnelles.\r\nLeur prophète attendu serait-il déjà né ?\r\n'),
(13, 'L’art subtil de s’en foutre', 'Mark Manson', NULL, 0, '2025-12-11 12:00:13', 'ecrit', 5, 'Le discours ambiant nous pousse sans cesse à nous améliorer. Sois plus heureux. Sois en meilleure santé. Sois plus intelligent, plus rapide, plus riche, plus sexy, plus productif. Mais il faut en finir avec la pensée positive, nous dit Mark Manson. \"Soyons honnêtes : parfois tout va de travers, et il faut faire avec'),
(14, 'Réfléchissez et devenez riche', 'Napoleon Hill', NULL, 0, '2025-12-11 12:05:38', 'ecrit', 5, 'Vous trouverez dans ce livre ce que personne ne vous enseignera jamais ailleurs : comment assimiler et appliquer les principes qui vous permettront de faire fortune et d\'atteindre les buts que vous vous êtes fixés. Napoleon Hill parvient avec brio à démontrer comment vos pensées et vos croyances peuvent changer le cours de votre vie. Fruit d\'une recherche de plus de vingt ans sur la richesse et le talent, Réfléchissez et devenez riche développe treize principes universels qui stimuleront votre confiance et vous mèneront vers une réussite garantie.'),
(15, 'L’Homme qui voulait être heureux', 'Laurent Gounelle', NULL, 0, '2025-12-11 12:05:38', 'ecrit', 5, 'Imaginez...\r\nVous êtes en vacances à Bali et, peu de temps avant votre retour, vous consultez un vieux guérisseur. Sans raison particulière, juste parce que sa grande réputation vous a donné envie de le rencontrer, au cas où...\r\nSon diagnostic est formel : vous êtes en bonne santé, mais vous n\'êtes pas... heureux.\r\nPorteur d\'une sagesse infinie, ce vieil homme semble vous connaître mieux que vous-même. L\'éclairage très particulier qu\'il apporte à votre vécu va vous entraîner dans l\'aventure la plus captivante qui soit : celle de la découverte de soi. Les expériences dans lesquelles il vous conduit vont bouleverser votre vie, en vous donnant les clés d\'une existence à la hauteur de vos rêves.\r\n'),
(16, 'Le Moine qui vendit sa Ferrari', 'Robin Sharma', NULL, 0, '2025-12-11 12:45:35', 'ecrit', 5, 'Ulian Mantle est un grand ténor du barreau dont la vie déséquilibrée le mène inexorablement à une crise cardiaque en plein tribunal. Ayant frôlé la mort, il traverse une crise spirituelle qui l\'oblige à se poser les grandes questions de la vie. Espérant trouver le bonheur, il va entreprendre un voyage dans l\'Himalaya et rencontre un peuple détenteur des \" sept vertus éternelles \". Un livre-guide qui nous connecte à une source inépuisable de courage, de joie et d\'équilibre !'),
(10, 'Le Comte de Monte-Cristo', 'Alexandre Dumas', NULL, 0, '2025-12-11 12:45:35', 'ecrit', 2, 'Trahi par ses proches et emprisonné à tort, Edmond Dantès s’évade et découvre un trésor. Devenu riche, il prépare une vengeance magistrale contre ceux qui l’ont détruit. Un roman d’aventure et de justice inoubliable.'),
(18, 'La Nuit des temps', 'René Barjavel', NULL, 0, '2025-12-11 12:49:18', 'ecrit', 2, 'Lors d’une expédition en Antarctique, des scientifiques découvrent un couple en hibernation depuis des milliers d’années. Une histoire d’amour tragique mêlée à la science-fiction et au mystère.'),
(19, 'Orgueil et Préjugés', 'Jane Austen', NULL, 0, '2025-12-11 12:49:18', 'ecrit', 2, 'Elizabeth Bennet et le mystérieux Mr. Darcy s’affrontent dans une danse d’attirance et de malentendus. Un roman plein d’esprit sur les relations, la société anglaise et l’amour.'),
(17, ' Shining', 'Stephen King', NULL, 0, '2025-12-11 12:51:15', 'ecrit', 2, 'Un hôtel isolé, un hiver glacial, une famille seule face à des forces surnaturelles. Jack Torrance, gardien des lieux, sombre peu à peu dans la folie. Un classique de l’horreur psychologique.'),
(20, 'La Peste', 'Albert Camus', NULL, 0, '2025-12-11 12:51:15', 'ecrit', 2, 'À Oran, une épidémie de peste bouleverse la vie des habitants. À travers le docteur Rieux, le roman explore la solidarité, l’absurdité et la condition humaine. Profond et intemporel.'),
(21, 'Le Banquet ', 'Platon', NULL, 0, '2025-12-11 12:53:19', 'ecrit', 4, 'Un dialogue où différents personnages débattent de la nature de l’amour. Platon y développe l’idée d’un amour qui élève l’âme vers la beauté et la sagesse. Un texte fondateur de la pensée occidentale.'),
(22, 'Discours de la méthode', 'René Descartes', NULL, 0, '2025-12-11 12:53:19', 'ecrit', 4, 'Descartes y explique sa méthode pour parvenir à la vérité : douter de tout, analyser, raisonner clairement. C’est ici qu’apparaît la célèbre phrase « Je pense, donc je suis ». Un ouvrage essentiel pour comprendre le rationalisme.'),
(23, 'Ainsi parlait Zarathoustra ', 'Friedrich Nietzsche', NULL, 0, '2025-12-11 12:57:40', 'ecrit', 4, 'Un récit philosophique et poétique où Nietzsche expose ses idées majeures : le surhumain, la mort de Dieu, l’éternel retour. Une œuvre puissante qui invite à la transformation de soi.'),
(24, 'L’Éthique', 'Spinoza', NULL, 0, '2025-12-11 12:57:40', 'ecrit', 4, 'Dans ce traité rigoureux, Spinoza décrit une vision du monde où tout est nécessaire et interconnecté. Il y propose un chemin vers la liberté intérieure et la joie par la compréhension rationnelle.'),
(25, 'Le Monde comme volonté et comme représentation ', 'Arthur Schopenhauer', NULL, 0, '2025-12-11 12:59:00', 'ecrit', 4, 'Schopenhauer présente une vision pessimiste où le monde est gouverné par une volonté irrationnelle. Il explore la souffrance humaine et la possibilité d’y échapper grâce à l’art, la compassion ou l’ascèse.');

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `description` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Littérature africaine', 'La littérature africaine est l’expression vibrante d’un continent où la parole est mémoire. Elle explore la colonisation, la liberté, la modernité, mais aussi les liens familiaux, la spiritualité et la vie quotidienne.\r\nRiche, diverse et profondément humaine, elle fait entendre des voix qui mêlent sagesse ancestrale et regard lucide sur le monde moderne. C’est une littérature qui ne raconte pas seulement l’Afrique : elle la fait vibrer.'),
(2, 'Roman', 'Le roman est un voyage intérieur : une histoire qui fait voir le monde autrement, qui bouscule, qui émeut et qui transforme. Quelques pages suffisent pour ouvrir une porte vers un autre univers et parfois, pour changer celui qu’on porte en soi.'),
(3, 'science-fiction et fantaisie', 'Les romans de science-fiction et fantastiques plongent le lecteur dans des mondes où l’inconnu règne : futurs possibles, technologies folles, magie, créatures et mystères.\r\nIls repoussent les frontières du réel et invitent à explorer ce qui pourrait exister… ou ce qui échappe à toute explication.'),
(4, 'philosophique', 'Les romans philosophiques utilisent l’histoire pour interroger la vie. À travers des personnages et leurs choix, ils explorent le sens de l’existence, la liberté, le bonheur, la morale ou la vérité.\r\nCe sont des récits qui ne se lisent pas seulement : ils font réfléchir, remettre en question, et parfois voir le monde autrement.'),
(5, 'développement personnel', 'Les livres de développement personnel sont des guides pour mieux se comprendre, évoluer et transformer sa vie. Ils offrent des clés pour renforcer la confiance en soi, gérer ses émotions, atteindre ses objectifs ou trouver un équilibre intérieur.\r\nPratiques et inspirants, ils encouragent chacun à devenir la meilleure version de soi-même, pas à pas.');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(1, 'user'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password_hash` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `roles_id` int NOT NULL DEFAULT '1',
  `xp` int NOT NULL DEFAULT '0',
  `created_ad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `niveau` varchar(20) COLLATE utf8mb4_general_ci GENERATED ALWAYS AS ((case when (`xp` < 100) then _utf8mb4'débutant' when (`xp` < 500) then _utf8mb4'confirmé' else _utf8mb4'expert' end)) STORED,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email` (`Email`(191)),
  KEY `roles_id` (`roles_id`),
  KEY `idx_users_niveau` (`niveau`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
