-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Abr-2020 às 23:52
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--
-- Criação: 22-Abr-2020 às 19:24
-- Última actualização: 23-Abr-2020 às 20:13
--

CREATE TABLE `carro` (
  `id` bigint(11) NOT NULL,
  `Modelo` varchar(15) NOT NULL,
  `Marca` varchar(15) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Categoria` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONAMENTOS PARA TABELAS `carro`:
--

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`id`, `Modelo`, `Marca`, `Ano`, `Categoria`) VALUES
(1, 'Spider', 'Ferrari', 2014, 'Esportivo'),
(2, 'Aventador', 'Lamborghini', 2017, 'Esportivo'),
(3, 'Cayenne', 'Porsche', 2020, 'Coupé'),
(4, 'Class A', 'Mercedes-Benz', 2019, 'Sedan');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pais`
--
-- Criação: 23-Abr-2020 às 20:35
-- Última actualização: 23-Abr-2020 às 20:42
--

CREATE TABLE `pais` (
  `id` bigint(11) NOT NULL,
  `Nome` varchar(15) NOT NULL,
  `Continente` varchar(20) NOT NULL,
  `População` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONAMENTOS PARA TABELAS `pais`:
--

--
-- Extraindo dados da tabela `pais`
--

INSERT INTO `pais` (`id`, `Nome`, `Continente`, `População`) VALUES
(1, 'Brasil', 'América do Sul', 209900000),
(2, 'Luxemburgo', 'Europa (Ocidental)', 613894),
(3, 'Austrália', 'Oceania', 24990000),
(4, 'Itália', 'Europa', 60360000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--
-- Criação: 23-Abr-2020 às 20:43
-- Última actualização: 23-Abr-2020 às 20:46
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `Descrição` varchar(100) NOT NULL,
  `Marca` varchar(15) NOT NULL,
  `Preço` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONAMENTOS PARA TABELAS `produto`:
--

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `Descrição`, `Marca`, `Preço`) VALUES
(1, 'Beleza feminina (kit maquiagem completo)', 'Vult', 200),
(2, 'Carro de Brinquedo (Relâmpago McQueen - Disney)', 'Elka', 89.99),
(3, 'Relógio Esportivo ( série 5 40mm)', 'Apple', 3499),
(4, 'Cadeira Gamer (conforto para Games)', 'HyperX', 700);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `carro`
--
ALTER TABLE `carro`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `pais`
--
ALTER TABLE `pais`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
