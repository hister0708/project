-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- rese 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `rese` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `rese`;

-- 테이블 rese.ct 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct` (
  `Id` varchar(50) DEFAULT NULL,
  `Movie` varchar(50) DEFAULT NULL,
  `Seat` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 rese.ct:~50 rows (대략적) 내보내기
INSERT IGNORE INTO `ct` (`Id`, `Movie`, `Seat`, `Price`) VALUES
	(NULL, '범죄도시', 'A1', 1000),
	(NULL, '범죄도시', 'A2', 1000),
	(NULL, '범죄도시', 'A3', 1000),
	(NULL, '범죄도시', 'A4', 1000),
	(NULL, '범죄도시', 'A5', 1000),
	(NULL, '범죄도시', 'A6', 1000),
	(NULL, '범죄도시', 'A7', 1000),
	(NULL, '범죄도시', 'A8', 1000),
	(NULL, '범죄도시', 'A9', 1000),
	(NULL, '범죄도시', 'A10', 1000),
	(NULL, '범죄도시', 'B1', 1000),
	(NULL, '범죄도시', 'B2', 1000),
	(NULL, '범죄도시', 'B3', 1000),
	(NULL, '범죄도시', 'B4', 1000),
	(NULL, '범죄도시', 'B5', 1000),
	(NULL, '범죄도시', 'B6', 1000),
	(NULL, '범죄도시', 'B7', 1000),
	(NULL, '범죄도시', 'B8', 1000),
	(NULL, '범죄도시', 'B9', 1000),
	(NULL, '범죄도시', 'B10', 1000),
	(NULL, '범죄도시', 'C1', 1000),
	(NULL, '범죄도시', 'C2', 1000),
	(NULL, '범죄도시', 'C3', 1000),
	(NULL, '범죄도시', 'C4', 1000),
	(NULL, '범죄도시', 'C5', 1000),
	(NULL, '범죄도시', 'C6', 1000),
	(NULL, '범죄도시', 'C7', 1000),
	(NULL, '범죄도시', 'C8', 1000),
	(NULL, '범죄도시', 'C9', 1000),
	(NULL, '범죄도시', 'C10', 1000),
	(NULL, '범죄도시', 'D1', 1000),
	(NULL, '범죄도시', 'D2', 1000),
	(NULL, '범죄도시', 'D3', 1000),
	(NULL, '범죄도시', 'D4', 1000),
	(NULL, '범죄도시', 'D5', 1000),
	(NULL, '범죄도시', 'D6', 1000),
	(NULL, '범죄도시', 'D7', 1000),
	(NULL, '범죄도시', 'D8', 1000),
	(NULL, '범죄도시', 'D9', 1000),
	(NULL, '범죄도시', 'D10', 1000),
	(NULL, '범죄도시', 'E1', 1000),
	(NULL, '범죄도시', 'E2', 1000),
	(NULL, '범죄도시', 'E3', 1000),
	(NULL, '범죄도시', 'E4', 1000),
	(NULL, '범죄도시', 'E5', 1000),
	(NULL, '범죄도시', 'E6', 1000),
	(NULL, '범죄도시', 'E7', 1000),
	(NULL, '범죄도시', 'E8', 1000),
	(NULL, '범죄도시', 'E9', 1000),
	(NULL, '범죄도시', 'E10', 1000);

-- 테이블 rese.ct2 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct2` (
  `Id` varchar(50) DEFAULT NULL,
  `Movie` varchar(50) DEFAULT NULL,
  `Seat` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 rese.ct2:~50 rows (대략적) 내보내기
INSERT IGNORE INTO `ct2` (`Id`, `Movie`, `Seat`, `Price`) VALUES
	(NULL, '범죄도시2', 'A1', 1000),
	(NULL, '범죄도시2', 'A2', 1000),
	(NULL, '범죄도시2', 'A3', 1000),
	(NULL, '범죄도시2', 'A4', 1000),
	(NULL, '범죄도시2', 'A5', 1000),
	(NULL, '범죄도시2', 'A6', 1000),
	(NULL, '범죄도시2', 'A7', 1000),
	(NULL, '범죄도시2', 'A8', 1000),
	(NULL, '범죄도시2', 'A9', 1000),
	(NULL, '범죄도시2', 'A10', 1000),
	(NULL, '범죄도시2', 'B1', 1000),
	(NULL, '범죄도시2', 'B2', 1000),
	(NULL, '범죄도시2', 'B3', 1000),
	(NULL, '범죄도시2', 'B4', 1000),
	(NULL, '범죄도시2', 'B5', 1000),
	(NULL, '범죄도시2', 'B6', 1000),
	(NULL, '범죄도시2', 'B7', 1000),
	(NULL, '범죄도시2', 'B8', 1000),
	(NULL, '범죄도시2', 'B9', 1000),
	(NULL, '범죄도시2', 'B10', 1000),
	(NULL, '범죄도시2', 'C1', 1000),
	(NULL, '범죄도시2', 'C2', 1000),
	(NULL, '범죄도시2', 'C3', 1000),
	(NULL, '범죄도시2', 'C4', 1000),
	(NULL, '범죄도시2', 'C5', 1000),
	(NULL, '범죄도시2', 'C6', 1000),
	(NULL, '범죄도시2', 'C7', 1000),
	(NULL, '범죄도시2', 'C8', 1000),
	(NULL, '범죄도시2', 'C9', 1000),
	(NULL, '범죄도시2', 'C10', 1000),
	(NULL, '범죄도시2', 'D1', 1000),
	(NULL, '범죄도시2', 'D2', 1000),
	(NULL, '범죄도시2', 'D3', 1000),
	(NULL, '범죄도시2', 'D4', 1000),
	(NULL, '범죄도시2', 'D5', 1000),
	(NULL, '범죄도시2', 'D6', 1000),
	(NULL, '범죄도시2', 'D7', 1000),
	(NULL, '범죄도시2', 'D8', 1000),
	(NULL, '범죄도시2', 'D9', 1000),
	(NULL, '범죄도시2', 'D10', 1000),
	(NULL, '범죄도시2', 'E1', 1000),
	(NULL, '범죄도시2', 'E2', 1000),
	(NULL, '범죄도시2', 'E3', 1000),
	(NULL, '범죄도시2', 'E4', 1000),
	(NULL, '범죄도시2', 'E5', 1000),
	(NULL, '범죄도시2', 'E6', 1000),
	(NULL, '범죄도시2', 'E7', 1000),
	(NULL, '범죄도시2', 'E8', 1000),
	(NULL, '범죄도시2', 'E9', 1000),
	(NULL, '범죄도시2', 'E10', 1000);

-- 테이블 rese.ct3 구조 내보내기
CREATE TABLE IF NOT EXISTS `ct3` (
  `Id` varchar(50) DEFAULT NULL,
  `Movie` varchar(50) DEFAULT NULL,
  `Seat` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 rese.ct3:~50 rows (대략적) 내보내기
INSERT IGNORE INTO `ct3` (`Id`, `Movie`, `Seat`, `Price`) VALUES
	(NULL, '범죄도시3', 'A1', 1000),
	(NULL, '범죄도시3', 'A2', 1000),
	(NULL, '범죄도시3', 'A3', 1000),
	(NULL, '범죄도시3', 'A4', 1000),
	(NULL, '범죄도시3', 'A5', 1000),
	(NULL, '범죄도시3', 'A6', 1000),
	(NULL, '범죄도시3', 'A7', 1000),
	(NULL, '범죄도시3', 'A8', 1000),
	(NULL, '범죄도시3', 'A9', 1000),
	(NULL, '범죄도시3', 'A10', 1000),
	(NULL, '범죄도시3', 'B1', 1000),
	(NULL, '범죄도시3', 'B2', 1000),
	(NULL, '범죄도시3', 'B3', 1000),
	(NULL, '범죄도시3', 'B4', 1000),
	(NULL, '범죄도시3', 'B5', 1000),
	(NULL, '범죄도시3', 'B6', 1000),
	(NULL, '범죄도시3', 'B7', 1000),
	(NULL, '범죄도시3', 'B8', 1000),
	(NULL, '범죄도시3', 'B9', 1000),
	(NULL, '범죄도시3', 'B10', 1000),
	(NULL, '범죄도시3', 'C1', 1000),
	(NULL, '범죄도시3', 'C2', 1000),
	(NULL, '범죄도시3', 'C3', 1000),
	(NULL, '범죄도시3', 'C4', 1000),
	(NULL, '범죄도시3', 'C5', 1000),
	(NULL, '범죄도시3', 'C6', 1000),
	(NULL, '범죄도시3', 'C7', 1000),
	(NULL, '범죄도시3', 'C8', 1000),
	(NULL, '범죄도시3', 'C9', 1000),
	(NULL, '범죄도시3', 'D1', 1000),
	(NULL, '범죄도시3', 'D2', 1000),
	(NULL, '범죄도시3', 'D3', 1000),
	(NULL, '범죄도시3', 'D4', 1000),
	(NULL, '범죄도시3', 'D5', 1000),
	(NULL, '범죄도시3', 'D6', 1000),
	(NULL, '범죄도시3', 'D7', 1000),
	(NULL, '범죄도시3', 'D8', 1000),
	(NULL, '범죄도시3', 'D9', 1000),
	(NULL, '범죄도시3', 'D10', 1000),
	(NULL, '범죄도시3', 'E1', 1000),
	(NULL, '범죄도시3', 'E2', 1000),
	(NULL, '범죄도시3', 'E3', 1000),
	(NULL, '범죄도시3', 'E4', 1000),
	(NULL, '범죄도시3', 'E5', 1000),
	(NULL, '범죄도시3', 'E6', 1000),
	(NULL, '범죄도시3', 'E7', 1000),
	(NULL, '범죄도시3', 'E8', 1000),
	(NULL, '범죄도시3', 'E9', 1000),
	(NULL, '범죄도시3', 'E10', 1000),
	(NULL, '범죄도시3', 'C10', 1000);

-- 테이블 rese.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `Id` varchar(50) DEFAULT NULL,
  `Seat` varchar(50) DEFAULT NULL,
  `Movie` varchar(50) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  KEY `아이디` (`Id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 rese.user:~0 rows (대략적) 내보내기

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
