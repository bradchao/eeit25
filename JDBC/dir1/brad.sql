-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2026-09-04 02:41:53
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `brad`
--

-- --------------------------------------------------------

--
-- 資料表結構 `cust`
--

CREATE TABLE `cust` (
  `id` int(10) UNSIGNED NOT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT '2000-01-01'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `cust`
--

INSERT INTO `cust` (`id`, `cname`, `tel`, `birthday`) VALUES
(1, 'Brad', '123', '1999-01-02'),
(2, 'Brad1', '123', '1999-01-02'),
(3, 'Brad2', '123', '1999-01-02'),
(4, 'Brad3', '123', '1999-01-02'),
(5, 'Brad4', '123', '1999-01-02'),
(7, 'Andy1', '345', '1999-01-02');

-- --------------------------------------------------------

--
-- 資料表結構 `food`
--

CREATE TABLE `food` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(1000) NOT NULL,
  `addr` varchar(1000) NOT NULL,
  `city` varchar(1000) NOT NULL,
  `town` varchar(1000) NOT NULL,
  `tel` varchar(1000) NOT NULL,
  `picurl` varchar(1000) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `feature` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `cust`
--
ALTER TABLE `cust`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `cust`
--
ALTER TABLE `cust`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `food`
--
ALTER TABLE `food`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
