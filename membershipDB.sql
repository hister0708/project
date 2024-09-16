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


-- membership 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `membership` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `membership`;

-- 테이블 membership.info 구조 내보내기
CREATE TABLE IF NOT EXISTS `info` (
  `name` varchar(10) DEFAULT NULL,
  `pwd` varchar(15) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `ID` varchar(12) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `acount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 membership.info:~1 rows (대략적) 내보내기
INSERT IGNORE INTO `info` (`name`, `pwd`, `age`, `ID`, `phone`, `acount`) VALUES
	(NULL, '1111', NULL, '1wh', NULL, NULL);

-- 프로시저 membership.info_pwdSearch 구조 내보내기
DELIMITER //
CREATE PROCEDURE `info_pwdSearch`(
	IN `inid` VARCHAR(50),
	IN `inphone` VARCHAR(50)
)
BEGIN
select pwd from info where id = inid and phone = inphone;
END//
DELIMITER ;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
