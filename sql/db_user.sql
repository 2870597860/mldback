/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


CREATE DATABASE `db_user` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `db_user`;
CREATE TABLE `userinfo` (
  `Id` int(11) NOT NULL auto_increment,
  `UserID` int(11) default NULL,
  `Email` varchar(100) default NULL,
  `Phone` varchar(50) default NULL,
  `Address` varchar(100) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL auto_increment,
  `userName` varchar(20) default NULL,
  `userPwd` varchar(50) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
