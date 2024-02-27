-- phpMyAdmin SQL Dump
-- version 5.1.4deb2~bpo11+1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 09-01-2024 a las 21:21:44
-- Versión del servidor: 10.5.15-MariaDB-0+deb11u1
-- Versión de PHP: 8.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sendaabertaapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group`
--

CREATE TABLE IF NOT EXISTS `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by_id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `descripcion` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `public` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_6DC044C5B03A8386` (`created_by_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group_access`
--

CREATE TABLE IF NOT EXISTS `group_access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_a_id` int(11) NOT NULL,
  `fecha_hora_union` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `role` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_D5EFF384A76ED395` (`user_id`),
  KEY `IDX_D5EFF38412840828` (`group_a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE IF NOT EXISTS `ingrediente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notas` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_BFB4A41E3A909126` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`id`, `nombre`, `notas`) VALUES
(1, 'Arroz', NULL),
(2, 'Pollo', NULL),
(3, 'Brócoli', NULL),
(4, 'Patatas', NULL),
(5, 'Huevos', NULL),
(6, 'Canelones', NULL),
(7, 'Atún en aceite de oliva', NULL),
(8, 'Tomate frito casero', NULL),
(9, 'Mantequilla', NULL),
(10, 'Harina', NULL),
(11, 'Leche', NULL),
(12, 'Pimienta negra', NULL),
(13, 'Queso para gratinar', NULL),
(14, 'Manzana', NULL),
(15, 'Limón', NULL),
(16, 'Agua', NULL),
(17, 'Canela', NULL),
(18, 'Pescado', NULL),
(19, 'Gambas', NULL),
(20, 'Cebolla', NULL),
(21, 'Ajo', NULL),
(22, 'Calabacín', NULL),
(23, 'Puerro', NULL),
(24, 'Caldo de pollo', NULL),
(25, 'Quesitos', NULL),
(26, 'AOVE', NULL),
(27, 'Guisantes congelados', NULL),
(28, 'Garbanzos cocidos', NULL),
(29, 'Pisto', NULL),
(30, 'Pimentón dulce', NULL),
(31, 'Vinagre', NULL),
(32, 'Cuscús integral', NULL),
(33, 'Zanahoria', NULL),
(34, 'Pimiento rojo', NULL),
(35, 'Calamares', NULL),
(36, 'Fideos', NULL),
(37, 'Harina de fuerza', NULL),
(38, 'Levadura fresca', NULL),
(39, 'Aceite', NULL),
(40, 'Queso de untar', NULL),
(41, 'Pimiento verde', NULL),
(42, 'Tomate', NULL),
(43, 'Costilla', NULL),
(44, 'Calabaza', NULL),
(45, 'Curry', NULL),
(46, 'Pasta', NULL),
(47, 'Salsa boloñesa', NULL),
(48, 'Queso gratinar', NULL),
(49, 'Avena', NULL),
(50, 'Pera', NULL),
(51, 'Macarrones', NULL),
(52, 'Tomate frito', NULL),
(53, 'Queso en polvo', NULL),
(54, 'Judías blancas cocidas', NULL),
(55, 'Lentejas', NULL),
(56, 'Espaguetis', NULL),
(57, 'Alcaparras', NULL),
(58, 'Verduras congeladas', NULL),
(59, 'Sésamo', NULL),
(60, 'Nachos', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `notas` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `audiencia_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_7D053A93A76ED395` (`user_id`),
  KEY `IDX_7D053A932CC1F6A7` (`audiencia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=210 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_receta`
--

CREATE TABLE IF NOT EXISTS `menu_receta` (
  `menu_id` int(11) NOT NULL,
  `receta_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`,`receta_id`),
  KEY `IDX_63D41196CCD7E912` (`menu_id`),
  KEY `IDX_63D4119654F853F8` (`receta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE IF NOT EXISTS `receta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `titulo` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notas` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_B093494EA76ED395` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `user_id`, `titulo`, `notas`) VALUES
(3, 1, 'Garbanzos con Pisto', '<p>400g Garbanzos cocidos 400g Pisto AOVE Ajo Piment&oacute;n dulce Vinagre</p>'),
(4, 1, 'Fideos de calabacín', NULL),
(5, 1, 'Lasaña de Calabacín', 'Calabacín 2\r\nCarne picada 500 g\r\nCebolla 1\r\nChampiñones 300 g\r\nZanahoria 1\r\nSalsa de tomate 500 g\r\nPimienta negra\r\nQueso rallado\r\n\r\nNotas\r\nhttps://www.velocidad cuchara.com/bechamel-de -dieta/\r\n\r\nFuente\r\nhttps://www.pequerecetas.com/receta/lasana-de -calabacin/'),
(6, 1, 'Canelones de huevo y atún', '<p>6 raciones.</p>\r\n<p>Ingredientes:</p>\r\n<ul>\r\n<li>1 Caja 20 Placas Gallo</li>\r\n<li>3 huevos</li>\r\n<li>2 latas de at&uacute;n en aceite de oliva</li>\r\n<li>1 brick de tomate casero (Hacendado)</li>\r\n<li>Bechamel\r\n<ul>\r\n<li>40g mantequilla</li>\r\n<li>40g harina</li>\r\n<li>500ml leche</li>\r\n<li>pimienta negra</li>\r\n</ul>\r\n</li>\r\n<li>1 bolsa queso para gratinar</li>\r\n</ul>'),
(7, 1, 'Tortilla de patata', NULL),
(8, 1, 'Ensalada de brotes verdes', '2 raciones\r\n\r\n1 bolsa de brotes verdes\r\n2 tomates\r\n1 aguacate\r\n1 lata de atún\r\nQueso semicurado\r\nPipas peladas\r\nArándanos deshidratados'),
(9, 1, 'Sandwich de pavo', '<ol>\r\n<li>Pan de molde</li>\r\n<li>Queso</li>\r\n<li>Pavo o jam&oacute;n cocido</li>\r\n</ol>'),
(10, 1, 'Cuscús con verduras y pavo', '<p>Raciones: 3</p>\r\n<p>Ingredientes:</p>\r\n<ol>\r\n<li>190 gr Cusc&uacute;s integral (Planeta Huerto)</li>\r\n<li>190 gr Agua</li>\r\n<li>50 gr AOVE</li>\r\n<li>Ajo</li>\r\n<li>100 gr Zanahoria</li>\r\n<li>250 gr Calabac&iacute;n</li>\r\n<li>130 gr Pimiento rojo</li>\r\n<li>Pavo o pollo</li>\r\n</ol>\r\n<p>Preparaci&oacute;n Thermomix:</p>\r\n<ol>\r\n<li>Picar: calabac&iacute;n, zanahoria, pimiento, aceite. 8 seg., Vel 5</li>\r\n<li>Sofre&iacute;r: 8 min, 100&deg;C, Vel 1</li>\r\n<li>Cocer (Mariposa): Cusc&uacute;s, agua y sal. 4 min, 70&deg;C, Vel. 1</li>\r\n</ol>'),
(11, 1, 'Pasta con huevo cocido', NULL),
(12, 1, 'Tortilla de coliflor', NULL),
(13, 1, 'Crema de Calabaza', '<p><a href=\"https://www.google.com/amp/s/elcomidista.elpais.com/elcomidista/2015/11/17/receta/1447783054_899636.amp.html\" target=\"_blank\" rel=\"noopener\">Receta El Comidista</a></p>\r\n<ol>\r\n<li>30gr AOVE</li>\r\n<li>2-3 dientes de ajo</li>\r\n<li>80gr cebolla</li>\r\n<li>60gr puerro</li>\r\n<li>80gr pimiento rojo\r\n<ol>\r\n<li>Picar y sofre&iacute;r (15\')</li>\r\n</ol>\r\n</li>\r\n<li>150gr zanahoria</li>\r\n<li>670gr Calabaza</li>\r\n<li>1 Manzana</li>\r\n<li>Especias: piment&oacute;n dulce, curry\r\n<ol>\r\n<li>Picar y rehogar (15\')</li>\r\n</ol>\r\n</li>\r\n<li>Agua hasta cubrir\r\n<ol>\r\n<li>Cocer (20\')</li>\r\n<li>Triturar</li>\r\n</ol>\r\n</li>\r\n</ol>'),
(14, 1, 'Arroz con Pollo', NULL),
(15, 1, 'Pescado a la plancha', '<ul>\r\n<li>Pescado (Lubina, ....)</li>\r\n</ul>'),
(16, 2, 'Nuggets de verdura', NULL),
(17, 2, 'Pizza casera', '<p>Harina fuerza</p>\r\n<p>Harina</p>\r\n<p>Aceite</p>\r\n<p>Levadura fresca</p>'),
(18, 1, 'Arroz con leche', '<p><a href=\"https://www.google.com/amp/s/www.velocidadcuchara.com/arroz-con-leche-de-libro/amp/\" target=\"_blank\" rel=\"noopener\">Receta Thermomix</a></p>'),
(19, 1, 'Brócoli con patatas y huevos', '<p><a href=\"https://www.velocidadcuchara.com/brocoli-con-patatas-y-huevos-al-varoma/\" target=\"_blank\" rel=\"noopener\">Receta Thermomix</a></p>'),
(20, 2, 'Lomo merluza al vapor', '<p><a href=\"https://www.velocidadcuchara.com/merluza-al-limon-en-el-varoma-thermomix/\">https://www.velocidadcuchara.com/merluza-al-limon-en-el-varoma-thermomix/</a></p>\r\n<p>&nbsp;</p>'),
(21, 1, 'Compota de Manzana', '<p><a href=\"https://www.recetasderechupete.com/compota-de-manzana-casera/12509/\">Receta en recetasderechupete.com</a></p>'),
(22, 2, 'Arroz amarillo', '<p><a href=\"https://www.aplicandoblw.com/2017/07/28/receta-de-arroz-con-pollo-adaptada-para-bebes/\">https://www.aplicandoblw.com/2017/07/28/receta-de-arroz-con-pollo-adaptada-para-bebes/</a></p>'),
(23, 2, 'Tortilla de calabacín y patata', '<p><a href=\"https://elfogondelatlantico.es/tortilla-de-calabacin-thermomix/\">https://elfogondelatlantico.es/tortilla-de-calabacin-thermomix/</a></p>\r\n<p>&nbsp;</p>\r\n<p>450g de calabac&iacute;n y patata</p>\r\n<p>60g de Aove</p>\r\n<p>5 huevos</p>\r\n<p>&nbsp;</p>\r\n<p>Receta adaptada:</p>\r\n<p>Echar el aceite, el calabac&iacute;n y la patata en la TMX.&nbsp;</p>\r\n<p>Triturar 10seg Velocidad 4</p>\r\n<p>Sofreir 20min aprox, 120&deg;C, giro inverso cuchara (mejor velocidad 1).</p>\r\n<p>Comprobar que est&aacute; pochado.&nbsp;</p>\r\n<p>A&ntilde;adir los huevos y pasar a sart&eacute;n vuelta y vuelta.&nbsp;</p>'),
(24, 2, 'Albóndigas de pescado', '<p><a href=\"https://www.google.com/amp/s/www.velocidadcuchara.com/albondigas-de-pescado-en-salsa/amp/\">https://www.google.com/amp/s/www.velocidadcuchara.com/albondigas-de-pescado-en-salsa/amp/</a></p>'),
(25, 2, 'Espaguetis  salsa boloñesa', NULL),
(26, 2, 'Burguer', NULL),
(27, 2, 'Crema de judías blancas y verduras', '<p>Dificultad</p>\r\n<p>f&aacute;cil</p>\r\n<p>Tiempo de preparaci&oacute;n</p>\r\n<p>5min</p>\r\n<p>Tiempo total</p>\r\n<p>30min</p>\r\n<p>Raciones</p>\r\n<p>6 raciones</p>\r\n<p>Ingredientes</p>\r\n<p>100 g de zanahoria en trozos</p>\r\n<p>200 g de puerro en rodajas</p>\r\n<p>100 g de cebolla en cuartos</p>\r\n<p>250 g de patata en trozos</p>\r\n<p>1000 g de agua</p>\r\n<p>400 g de jud&iacute;as blancas cocidas (en conserva) (lavadas y escurridas)</p>\r\n<p>20 g de aceite de oliva virgen extra (y un chorrito m&aacute;s para servir)</p>'),
(28, 1, 'Crema de Guisantes', '<p><a href=\"https://www.velocidadcuchara.com/crema-de-guisantes/\" target=\"_blank\" rel=\"noopener\">https://www.velocidadcuchara.com/crema-de-guisantes/</a></p>\r\n<p>Ingredientes</p>\r\n<ol>\r\n<li>50 g de aceite de oliva virgen extra</li>\r\n<li>300 g de puerro o mezcla de puerro y cebolla</li>\r\n<li>600 g de guisantes congelados</li>\r\n<li>650 g de caldo de jam&oacute;n, verduras o ave -o agua y pastilla de caldo</li>\r\n<li>2 cucharadas de queso de untar o quesitos.</li>\r\n</ol>\r\n<p>El puerro se puede cambiar por cebolla, el queso de untar por quesitos.</p>\r\n<p><strong>Preparaci&oacute;n:</strong></p>\r\n<ol>\r\n<li>Pon en el vaso el puerro y el aceite y trocea 4 segundos en velocidad 4. Cocina 12 minutos, 120&ordm;C o Varoma, velocidad 2.</li>\r\n<li>Incorpora los guisantes y reh&oacute;galos durante 8 minutos, 120&ordm;C o Varoma, velocidad 2.</li>\r\n<li>A&ntilde;ade el caldo y programa 7 minutos, Varoma, velocidad 3.</li>\r\n<li>Acabado el tiempo rectifica el punto de sal, incorpora las 2 cucharadas de queso ARLA&reg; deja que baje un poco la temperatura y tritura 2-3 minutos en velocidad 7 para que te quede una crema perfecta.</li>\r\n</ol>\r\n<p>Notas:</p>\r\n<p>Decora al gusto, con picatostes, puerro frito o alfalfa y otros brotes</p>\r\n<p>&nbsp;</p>\r\n<p>Variante:</p>\r\n<ul>\r\n<li>Zanahoria o alguna otra verdura en el primer paso.</li>\r\n<li>400g de guisantes</li>\r\n<li>500ml de caldo (de pollo o verdura)</li>\r\n<li>Jam&oacute;n serrano o bacon crujiente para acompa&ntilde;ar</li>\r\n</ul>'),
(29, 2, 'Pescado vapor', NULL),
(30, 2, 'Lentejas', NULL),
(31, 2, 'Cordón Bleu', NULL),
(32, 2, 'Guiso ternera', NULL),
(33, 2, 'Nuggets de pavo', '<p>Nuggets de pavo con arroz</p>'),
(34, 2, 'Pasta con atún', NULL),
(35, 2, 'Muslos de pollo guisado con patata', NULL),
(36, 2, 'Arroz blanco', NULL),
(37, 2, 'Pescado a la gallega', '<p>Salsa gallega:</p>\r\n<p>&nbsp;</p>\r\n<p><a href=\"https://www.google.com/amp/s/estoyhechouncocinillas.com/2019/08/ajada.html/amp\">https://www.google.com/amp/s/estoyhechouncocinillas.com/2019/08/ajada.html/amp</a></p>\r\n<p>&nbsp;</p>'),
(38, 2, 'Fideos', '<p>&nbsp;</p>\r\n<p>Preparaci&oacute;n TM6:</p>\r\n<ol>\r\n<li>Vaso: 50ml AOVE, 1 cebolla peque&ntilde;a, 2 dientes de ajo, 80gr de pimiento rojo, 80gr pimiento verde.</li>\r\n<li>Triturar: 5s/v4</li>\r\n<li>Sofre&iacute;r: 8m/120&ordm;/vCuchara</li>\r\n<li>Agregar 500g costilla.</li>\r\n<li>Mariposa: 8m/120&ordm;/vReversoCuchara</li>\r\n<li>Agregar 500ml caldo, 2-3 tomates pelados en trozos, pimienta negra, (sal)</li>\r\n<li>30m/100&ordm;/vReversoCuchara</li>\r\n<li>Agregar 250g fideos n&ordm;2</li>\r\n<li>Cocer: 6m/100&ordm;/vReversoCuchara</li>\r\n</ol>'),
(39, 2, 'Revuelto', NULL),
(40, 1, 'Crema de Calabacín', '<p><a href=\"https://www.velocidadcuchara.com/crema-de-calabacin/\">https://www.velocidadcuchara.com/crema-de-calabacin/</a></p>'),
(41, 1, 'Hummus', '<ul>\r\n<li>1 o 2 ajos</li>\r\n<li>Bote de garbanzos (escurrir un poco)</li>\r\n<li>60 g. agua</li>\r\n<li>30 g. Zumo lim&oacute;n</li>\r\n<li>40 g. S&eacute;samo</li>\r\n<li>70 g. Aceite Oliva Virgen Extra</li>\r\n<li>Opcional: una pizca de sal</li>\r\n</ul>\r\n<p>Preparaci&oacute;n Thermomix:R</p>\r\n<ol>\r\n<li>Triturar v10</li>\r\n<li>Bajar con la esp&aacute;tula</li>\r\n<li>Triturar v10</li>\r\n</ol>\r\n<p>Servir con unas gotas de aceite, piment&oacute;n dulce y nachos o palitos.</p>\r\n<p>&nbsp;</p>'),
(42, 2, 'Calamares', NULL),
(44, 2, 'Macarrones con carne gratinados', NULL),
(45, 2, 'Nuggets pescado', NULL),
(46, 1, 'Avena con fruta', '<p>Preparaci&oacute;n en Thermomix:</p>\r\n<ol>\r\n<li>Pela y pica una pera u otra fruta (2s/v5)</li>\r\n<li>A&ntilde;ade 40gr de avena y 300gr de leche</li>\r\n<li>Cocina en Thermomix: 13m/90&deg;/v2Reverso</li>\r\n<li>Servir con canela opcional</li>\r\n</ol>'),
(47, 1, 'Macarrones con atún', NULL),
(48, 2, 'Carne', NULL),
(49, 2, 'Pollo', NULL),
(50, 2, 'Pasta boloñesa', NULL),
(52, 1, 'Ensalada de Lentejas', '<p><a href=\"https://www.instagram.com/reel/CfUXaVzouNn/\" target=\"_blank\" rel=\"noopener\">https://www.instagram.com/reel/CfUXaVzouNn/</a></p>'),
(53, 1, 'Revuelto de verduras', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta_ingrediente`
--

CREATE TABLE IF NOT EXISTS `receta_ingrediente` (
  `receta_id` int(11) NOT NULL,
  `ingrediente_id` int(11) NOT NULL,
  PRIMARY KEY (`receta_id`,`ingrediente_id`),
  KEY `IDX_F7A6A61354F853F8` (`receta_id`),
  KEY `IDX_F7A6A613769E458D` (`ingrediente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `receta_ingrediente`
--

INSERT INTO `receta_ingrediente` (`receta_id`, `ingrediente_id`) VALUES
(3, 21),
(3, 26),
(3, 28),
(3, 29),
(3, 30),
(3, 31),
(6, 5),
(6, 6),
(6, 7),
(6, 8),
(6, 9),
(6, 10),
(6, 11),
(6, 12),
(6, 13),
(7, 4),
(7, 5),
(7, 26),
(10, 2),
(10, 16),
(10, 21),
(10, 22),
(10, 26),
(10, 32),
(10, 33),
(10, 34),
(13, 14),
(13, 20),
(13, 21),
(13, 23),
(13, 26),
(13, 30),
(13, 33),
(13, 34),
(13, 44),
(13, 45),
(14, 1),
(14, 2),
(17, 10),
(17, 37),
(17, 38),
(17, 39),
(18, 1),
(18, 11),
(18, 17),
(19, 3),
(19, 4),
(19, 5),
(21, 14),
(21, 15),
(21, 16),
(21, 17),
(22, 1),
(23, 4),
(23, 5),
(23, 22),
(23, 26),
(24, 18),
(24, 19),
(24, 20),
(27, 4),
(27, 20),
(27, 23),
(27, 24),
(27, 26),
(27, 33),
(27, 54),
(28, 23),
(28, 24),
(28, 26),
(28, 27),
(28, 40),
(29, 4),
(29, 18),
(34, 7),
(34, 21),
(34, 52),
(34, 53),
(34, 56),
(34, 57),
(36, 1),
(36, 16),
(36, 21),
(38, 12),
(38, 20),
(38, 21),
(38, 24),
(38, 26),
(38, 34),
(38, 36),
(38, 41),
(38, 42),
(38, 43),
(40, 4),
(40, 20),
(40, 22),
(40, 23),
(40, 24),
(40, 25),
(40, 26),
(41, 15),
(41, 16),
(41, 21),
(41, 26),
(41, 28),
(41, 59),
(41, 60),
(42, 35),
(44, 46),
(44, 47),
(44, 48),
(46, 11),
(46, 17),
(46, 49),
(46, 50),
(47, 7),
(47, 21),
(47, 26),
(47, 51),
(47, 52),
(47, 53),
(52, 55),
(53, 5),
(53, 21),
(53, 26),
(53, 58);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reset_password_request`
--

CREATE TABLE IF NOT EXISTS `reset_password_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `selector` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hashed_token` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `requested_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `expires_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  PRIMARY KEY (`id`),
  KEY `IDX_7CE748AA76ED395` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '(DC2Type:json)',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_verified` tinyint(1) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `updated_at` datetime DEFAULT NULL COMMENT '(DC2Type:datetime_immutable)',
  `last_login` datetime DEFAULT NULL COMMENT '(DC2Type:datetime_immutable)',
  `enabled` tinyint(1) NOT NULL,
  `photo_filename` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D649E7927C74` (`email`),
  UNIQUE KEY `UNIQ_8D93D649F85E0677` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `group`
--
ALTER TABLE `group`
  ADD CONSTRAINT `FK_6DC044C5B03A8386` FOREIGN KEY (`created_by_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `group_access`
--
ALTER TABLE `group_access`
  ADD CONSTRAINT `FK_D5EFF38412840828` FOREIGN KEY (`group_a_id`) REFERENCES `group` (`id`),
  ADD CONSTRAINT `FK_D5EFF384A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `FK_7D053A932CC1F6A7` FOREIGN KEY (`audiencia_id`) REFERENCES `group` (`id`),
  ADD CONSTRAINT `FK_7D053A93A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `menu_receta`
--
ALTER TABLE `menu_receta`
  ADD CONSTRAINT `FK_63D4119654F853F8` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_63D41196CCD7E912` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `FK_B093494EA76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `receta_ingrediente`
--
ALTER TABLE `receta_ingrediente`
  ADD CONSTRAINT `FK_F7A6A61354F853F8` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_F7A6A613769E458D` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `reset_password_request`
--
ALTER TABLE `reset_password_request`
  ADD CONSTRAINT `FK_7CE748AA76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
