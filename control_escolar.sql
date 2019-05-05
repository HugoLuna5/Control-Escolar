-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-04-2019 a las 03:41:02
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `control_escolar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_p` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_m` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(16) COLLATE utf8_spanish_ci NOT NULL,
  `password` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `nombre`, `apellido_p`, `apellido_m`, `usuario`, `password`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 'ii9jU5C+f7TJ7PnhE+rE9A==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `numControl` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_p` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_m` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `curp` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `lugar_nacimiento` text COLLATE utf8_spanish_ci NOT NULL,
  `id_carrera` int(11) DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `correo` text COLLATE utf8_spanish_ci NOT NULL,
  `password` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`numControl`, `nombre`, `apellido_p`, `apellido_m`, `fecha_nacimiento`, `sexo`, `curp`, `lugar_nacimiento`, `id_carrera`, `telefono`, `correo`, `password`) VALUES
(1730008, 'Fulano', 'De', 'Tal', '1999-04-04', 'Femenino', 'FULD', 'Tempoal', 6, '7891005104', 'ful@mail.com', 'OF/lFmXnq+s='),
(1730009, 'Hugo Dario', 'Luna', 'Cruz', '1999-11-01', 'Masculino', 'LUCH', 'Tantoyuca, Veracruz, Mexico', 9, '', '', 'ii9jU5C+f7TJ7PnhE+rE9A=='),
(1730359, 'Gerardo', 'Facundo', 'Del Angel', '1998-09-24', 'Masculino', 'FAAG', 'Tantoyuca', 9, '', '', 'Hir3ci7ih6Ie78OXEAv0Fg==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `claveCarrera` int(11) NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`claveCarrera`, `nombre`, `descripcion`) VALUES
(1, 'Agronomía', 'Es un profesionista con capacidad de manejo y administración de sistemas de producción animal y vegetal; que posee conocimientos, habilidades y destrezas para elaborar, ejecutar y evaluar proyectos productivos del área agropecuaria y el desarrollo rural.'),
(2, 'Ambiental', 'Vincular el valor de los recursos naturales para promover su uso sustentable de acuerdo a las necesidades de la región, mediante instrumentos de la concientización, sensibilización y comunicación.'),
(3, 'Contador Público', 'El egresado de la carrera de contador público son profesionales competitivos, capaces de diseñar, establecer, controlar y avaluar, sistemas de información financiera, fiscal y administrativa, para la toma de decisiones de las entidades económicas nacionales e internacionales, con una actitud ética, crítica, emprendedora y de liderazgo.'),
(4, 'Electrónica', 'El ingeniero en electrónica lleva a cabo la generación, transmisión y distribución de energía eléctrica por medio de dispositivos diseñados por el mismo.'),
(5, 'Industrial', 'Es un profesional con base sólida en la optimización de recursos, (personas, maquinaria, materiales, información, energía, dinero, y tecnología), de una organización para la fabricación de productos o la prestación de servicios; cuenta con un visión integral de negocios y tiene como referencia el desarrollo sostenible.'),
(6, 'Gestión Empresarial', 'Desarrollar y aplicar habilidades directivas, y la ingeniería en el diseño, creación, gestión, desarrollo, fortalecimiento e innovación de las organizaciones, con una orientación sistemática y sustentable para la toma de decisiones en forma efectiva.'),
(7, 'Mecatrónica', 'Un ingeniero en mecatrónica es un profesional con amplio conocimiento teórico, práctico y multidisciplinario capaz de integrar y desarrollar sistemas automatizados y/o autónomos que involucren tecnologías de varios campos de la ingeniería. Este especialista entiende sobre el funcionamiento de los componentes mecánicos, eléctricos, electrónicos y computacionales de los procesos industriales, y tiene como referencia el desarrollo sostenible.'),
(8, 'Petrolera', 'Definir y estudiar las características geológicas, petrofísicas y dinámicas que controlan la capacidad de almacenamiento y producción de yacimientos petroleros.'),
(9, 'Sistemas Computacionales', 'El ingeniero en Sistemas Computacionales será capaz de: diseñar, desarrollar, implementar y mantener actualizadas las infraestructuras de cómputo y comunicación; desarrollando sistemas de información empresarial, la carrera de Ingeniero en Sistemas Computacionales, permite desarrollar su actividad profesional en diferentes áreas de una organización.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `id` int(11) NOT NULL,
  `numControl` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `ciudad` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `colonia` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `calle` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `numero` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `entidad` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `cp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`id`, `numControl`, `ciudad`, `colonia`, `calle`, `numero`, `entidad`, `cp`) VALUES
(1, '1730009', 'Tantoyuca', 'El Rastro', 'Quinta Minero', 'S/N', 'Veracruz', 92124);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `clave_materia` int(11) NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `id` int(11) NOT NULL,
  `periodo` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--

CREATE TABLE `semestre` (
  `id` int(11) NOT NULL,
  `semestre` int(11) NOT NULL,
  `descripcion` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`numControl`),
  ADD UNIQUE KEY `numControl` (`numControl`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`claveCarrera`),
  ADD UNIQUE KEY `claveCarrera` (`claveCarrera`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`clave_materia`),
  ADD UNIQUE KEY `clave_materia` (`clave_materia`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
