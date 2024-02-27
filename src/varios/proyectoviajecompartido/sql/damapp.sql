-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 09-01-2024 a las 21:22:09
-- Versión del servidor: 8.0.35-0ubuntu0.22.04.1
-- Versión de PHP: 8.1.2-1ubuntu2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `damapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PUNTO_GEOGRAFICO`
--

CREATE TABLE `PUNTO_GEOGRAFICO` (
  `id` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `PUNTO_GEOGRAFICO`
--

INSERT INTO `PUNTO_GEOGRAFICO` (`id`, `nombre`, `latitud`, `longitud`) VALUES
(1, 'IES Chan do Monte', 42.3895784, -8.7099882),
(2, 'Plaza de Galicia. Pontevedra', 42.42787, -8.64451);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '(DC2Type:json)',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_verified` tinyint(1) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '(DC2Type:datetime_immutable)',
  `updated_at` datetime DEFAULT NULL COMMENT '(DC2Type:datetime_immutable)',
  `last_login` datetime DEFAULT NULL COMMENT '(DC2Type:datetime_immutable)',
  `enabled` tinyint(1) NOT NULL,
  `photo_filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `email`, `roles`, `password`, `is_verified`, `username`, `created_at`, `updated_at`, `last_login`, `enabled`, `photo_filename`) VALUES
(1, 'aguadoaudiovisual@gmail.com', '[\"ROLE_ADMIN\"]', '$2y$13$S4X31Z1qF4YGfgniESKrpu7TE5SazLNu0u3.KdEKHeZJod.Bk8GiO', 1, 'aguado', '2023-11-11 12:00:00', '2023-12-28 00:45:23', '2024-01-09 17:40:22', 1, 'Foto-Perfil-2-658cc0d5dfd5a.png'),
(6958, 'ale.piki.05@gmail.com', '[]', '$2y$13$FnWRojMAgk9tbwGfH4JkYeIIwpYo5CWF6pmagkPKpYhena75pVk6m', 1, 'acainrodr', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7008, 'angelbarralperez@gmail.com', '[]', '$2y$13$t2VGZxsftes/Yx0mkEvl.ucOYKcVlE4iUAH4tHQ6TDxZj3TYv.iEm', 1, 'mbarrpere', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7015, 'anton.vega.vidal@gmail.com', '[]', '$2y$13$dMnTH.eYSm62rtxGr.8DxeIowPh3W9cI/NLYXiXHcl5HL/fWzxHTm', 1, 'avegavida', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7045, 'bertoae013@gmail.com', '[]', '$2y$13$esEYKo.tCOYpyqjZyRAvKupVNHm4aJlWCo41jzabaI95KcYwqElIK', 1, 'aameneste', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7049, 'borjacastellano1@gmail.com', '[]', '$2y$13$eq6r5XKr14WlH9xZhhpZmu1ZqyGiM.vIoRjUfaxaiV8Qhw0H6xwrC', 1, 'bcastextr', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7103, 'david151003@gmail.com', '[]', '$2y$13$8EIWAzHWXCCgQo1QsrGBJe3HAtaMUAKfmetKtyrXa4edvoVGjak0m', 1, 'dperesert', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7107, 'davidsanchez92@iespontecaldelas.com', '[]', '$2y$13$YIs8NHpr5UNz.VkY3MLz9evXCpKbyqR86VUyyTdHtikHIghsTOmQi', 1, 'dsancpeso', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7116, 'diegopazos04@gmail.com', '[]', '$2y$13$wLMXrYMfK/4DvGMRy3sd8O6lYr8d3yQgpiEu0HKTLOVJk4XPUxwGK', 1, 'dpazoargi', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7126, 'eloyrodalperez@gmail.com', '[]', '$2y$13$ppRdK/7kjrpGtSn.ZCoAn.XgP.UOUlAXviZya7gCrmqg9skP8Nx9W', 1, 'erodapere', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7164, 'gonzalorodriguezaguilar08@gmail.com', '[]', '$2y$13$a.ugGPuQAvYSFX91Fj84MeVy9pW0Bvk1JJpxHtvRvvIKTiXeuHVUe', 1, 'grodragui', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7167, 'gutierrezalfonso37@gmail.com', '[]', '$2y$13$VUnB69Ta0ljmlEMVB1485unLArokwdt0qotOAP7aIFVbvWlV2MWB2', 1, 'agutivill', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7170, 'hugmanmarfer10@gmail.com', '[]', '$2y$13$ZQsRyN3we2htxqOGGxOmVueHm50tW8yUUiUoctmKZOioH/tjI0jsi', 1, 'hmartfern', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7224, 'jorgeiglesias290901@gmail.com', '[]', '$2y$13$XaQpLmXurPouUAfIN8qZK.UQPVXkyp8aYKtsKD0ZcbG693LB8pbRa', 1, 'jigleacun', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7286, 'marcoscostoya2014@gmail.com', '[]', '$2y$13$6Y5LDf.hAkagsbYK48oAsus1ldICotQp495lab63HQjvvOKBtPZ6u$2y$13$RXLQYx337qBWXloJwD/IbO8jdmK0LtpXltXAdOGr0ZXz9i/Rr8/w6', 1, 'mcostcruz', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7305, 'carlafuentesbesada@gmail.com', '[]', '$2y$13$ydSwNslzH1f4Caz/qf62YejwzCWHA4KTqMUgEvBSR0.s9z30Z26DW', 1, 'cfuenbesa', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7323, 'miguelpiedras77@gmail.com', '[]', '$2y$13$Rb/xqBlJatyQOmJDOkmkO.dc2YBwmAriN1tNAN7RBklJxqW9MPGUi', 1, 'mpiedsant', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7326, 'mirna_mch@hotmail.com', '[]', '$2y$13$tKh3MVJdIzp9bfnuWwOrTONEmo2wwvPuHhjpkMfdr64YX0JIiDNnu', 1, 'pucedcorn', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7345, 'noarosaslms@gmail.com', '[]', '$2y$13$MLWLH7dNhMZ/ZaPOM0GobOCbO0N1SXSgoMncvHIGQiURSgpfM8KR6', 1, 'nrosalemo', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7481, 'oscarfdezptza94@gmail.com', '[]', '$2y$13$TiQihps7RwDUZq8xognB7ei4900rK1WhCF/RIsymtoxvH3/vBQmmm', 1, 'ofernpast', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7483, 'oscarperdizbarros@gmail.com', '[]', '$2y$13$YkxN4o..J1ITWSlPAgwCMenEXBgCdNnr3ylqlZU1YR9j8tTZZGDG.', 1, 'operdbarr', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7509, 'pazex04@gmail.com', '[]', '$2y$13$atCkb5rAgd4oyo19TjzeZuz2Ac9G/VJBsAmsBQAoorRhtQQDyauES', 1, 'apazoamoe', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7514, 'pedroparapia@gmail.com', '[]', '$2y$13$2440IGqG.63nSwAPShhvIOmjbaTMi0g4KNzXJx2W0Ar2M3k2Pxt62', 1, 'plealfern', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7543, 'rodrigopazosbarcia98@gmail.com', '[]', '$2y$13$u6sdLH/j/8i/CyFiFhpSZep.YW8ncw5a7G6KSWs6MxZMxo5yTX1/u', 1, 'rpazobarc', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7627, 'victoriarua4@gmail.com', '[]', '$2y$13$bJvGiQXevJ2r5.yJGu4/Vu9h/nfgNiYCHd5MxmtheBbABQCIqhgUm', 1, 'vruagome', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7654, 'yoni.iglesias.sampedro@gmail.com', '[]', '$2y$13$PjOt7xkqVMhnWjER572w8O9q78KMbWEqaLJ3/ZY4tW53vZNaFK1iq', 1, 'jiglesamp', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7688, 'diegosobral1997@gmail.com', '[]', '$2y$13$cjiglQ5Cq.T2qqRKwDIfbenR/4woWq84U1c6EYSYfgX6NZHE3x3ke', 1, 'dsobrpine', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7691, 'sergiiovillar89@gmail.com', '[]', '$2y$13$oODsuXrBL6uJWAoE///yMeZioeOUgJSkC3EbDac6Ku3wQObfTWz36', 1, 'svilapere', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7692, 'igorcerdedo2803@gmail.com', '[]', '$2y$13$4WRgDPA/GyU.HRjBfQhFUONDjgGlMJAvbE7X3EgbHU7PcMPWsGDJO', 1, 'igarcrodr', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7698, 'sebasfontalvarez@gmail.com', '[]', '$2y$13$f20qcElexrfyyX3Qy/C/S.zYHEakG/2C1817VbXwvM2tNHXgNaByG', 1, 'salvafont', '2023-11-11 12:00:00', NULL, NULL, 1, NULL),
(7700, 'cosmena@gmail.com', '[]', '$2y$13$18MmR77ObJT1SogbdB5XUe699JZcPbm4RhcdVAgWDbaMmxxIM1bBG', 0, NULL, '2023-12-27 23:57:55', NULL, '2023-12-27 23:58:32', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `VIAJE`
--

CREATE TABLE `VIAJE` (
  `id` int NOT NULL,
  `conductor` int NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `punto_salida` int NOT NULL,
  `punto_llegada` int NOT NULL,
  `plazas` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `VIAJE`
--

INSERT INTO `VIAJE` (`id`, `conductor`, `fecha_hora`, `punto_salida`, `punto_llegada`, `plazas`) VALUES
(1, 1, '2023-12-21 14:30:00', 1, 2, 2),
(2, 7698, '2023-12-21 16:00:00', 2, 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `PUNTO_GEOGRAFICO`
--
ALTER TABLE `PUNTO_GEOGRAFICO`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8D93D649E7927C74` (`email`),
  ADD UNIQUE KEY `UNIQ_8D93D649F85E0677` (`username`);

--
-- Indices de la tabla `VIAJE`
--
ALTER TABLE `VIAJE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `conductor` (`conductor`),
  ADD KEY `punto_salida` (`punto_salida`),
  ADD KEY `punto_llegada` (`punto_llegada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `PUNTO_GEOGRAFICO`
--
ALTER TABLE `PUNTO_GEOGRAFICO`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7701;

--
-- AUTO_INCREMENT de la tabla `VIAJE`
--
ALTER TABLE `VIAJE`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `VIAJE`
--
ALTER TABLE `VIAJE`
  ADD CONSTRAINT `VIAJE_ibfk_1` FOREIGN KEY (`conductor`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `VIAJE_ibfk_2` FOREIGN KEY (`punto_salida`) REFERENCES `PUNTO_GEOGRAFICO` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `VIAJE_ibfk_3` FOREIGN KEY (`punto_llegada`) REFERENCES `PUNTO_GEOGRAFICO` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
