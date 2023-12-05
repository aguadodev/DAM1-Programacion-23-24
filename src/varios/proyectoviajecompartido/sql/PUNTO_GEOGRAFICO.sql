-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 05-12-2023 a las 09:30:25
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
(1, 'IES Chan do Monte', 42.3895784, -8.7099882);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `PUNTO_GEOGRAFICO`
--
ALTER TABLE `PUNTO_GEOGRAFICO`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `PUNTO_GEOGRAFICO`
--
ALTER TABLE `PUNTO_GEOGRAFICO`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
