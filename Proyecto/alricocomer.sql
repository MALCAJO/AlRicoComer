-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-05-2017 a las 08:38:08
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `alricocomer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
  `num_pedido` int(11) NOT NULL DEFAULT '0',
  `fecha_hora` date NOT NULL,
  PRIMARY KEY (`num_pedido`,`fecha_hora`),
  KEY `num_pedido` (`num_pedido`),
  KEY `fecha_hora` (`fecha_hora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_pedido`
--

CREATE TABLE IF NOT EXISTS `linea_pedido` (
  `num_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_plato` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha_hora` date NOT NULL,
  PRIMARY KEY (`num_pedido`),
  KEY `fecha_hora` (`fecha_hora`),
  KEY `cod_plato` (`cod_plato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `cod_plato` int(11) NOT NULL AUTO_INCREMENT,
  `cod_restaurante` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cod_plato`),
  KEY `cod_restaurante` (`cod_restaurante`),
  KEY `cod_restaurante_2` (`cod_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE IF NOT EXISTS `ofertas` (
  `cod_oferta` int(11) NOT NULL AUTO_INCREMENT,
  `descuento` int(11) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_oferta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=52896 ;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`cod_oferta`, `descuento`, `descripcion`) VALUES
(52895, 5, 'oferta usuario nuevo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `num_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_hora` date NOT NULL,
  `cod_restaurante` int(11) DEFAULT NULL,
  `cod_personal` int(11) NOT NULL,
  PRIMARY KEY (`num_pedido`),
  KEY `cod_personal` (`cod_personal`),
  KEY `cod_restaurante` (`cod_restaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE IF NOT EXISTS `personal` (
  `cod_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cod_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE IF NOT EXISTS `restaurante` (
  `cod_restaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cod_postal` int(5) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `cif` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cod_restaurante`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`cod_restaurante`, `nombre`, `direccion`, `cod_postal`, `telefono`, `cif`) VALUES
(1, 'chino mandalin', 'langstrass', 28007, 123456789, '123456789x');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_registrado`
--

CREATE TABLE IF NOT EXISTS `usuario_registrado` (
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cod_postal` int(5) NOT NULL,
  `cod_oferta` int(11) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `cod_oferta` (`cod_oferta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario_registrado`
--

INSERT INTO `usuario_registrado` (`email`, `contrasena`, `nombre`, `apellidos`, `direccion`, `cod_postal`, `cod_oferta`) VALUES
('a.tatschke@gmail.com', 'ricocomer', 'alejandro', 'tatschke', 'calle tu madre 89', 28007, 52895);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_visitante`
--

CREATE TABLE IF NOT EXISTS `usuario_visitante` (
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL COMMENT 'direccion del usuario no registrado',
  `telefono` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL COMMENT 'telefono del usuario no registrado'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE IF NOT EXISTS `vehiculo` (
  `matricula` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `cod_empleado` int(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `cod_empleado` (`cod_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`num_pedido`) REFERENCES `linea_pedido` (`num_pedido`),
  ADD CONSTRAINT `historial_ibfk_2` FOREIGN KEY (`fecha_hora`) REFERENCES `linea_pedido` (`fecha_hora`);

--
-- Filtros para la tabla `linea_pedido`
--
ALTER TABLE `linea_pedido`
  ADD CONSTRAINT `linea_pedido_ibfk_1` FOREIGN KEY (`cod_plato`) REFERENCES `menu` (`cod_plato`);

--
-- Filtros para la tabla `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`cod_restaurante`) REFERENCES `restaurante` (`cod_restaurante`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cod_personal`) REFERENCES `personal` (`cod_empleado`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`cod_restaurante`) REFERENCES `restaurante` (`cod_restaurante`);

--
-- Filtros para la tabla `usuario_registrado`
--
ALTER TABLE `usuario_registrado`
  ADD CONSTRAINT `usuario_registrado_ibfk_1` FOREIGN KEY (`cod_oferta`) REFERENCES `ofertas` (`cod_oferta`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`cod_empleado`) REFERENCES `personal` (`cod_empleado`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
