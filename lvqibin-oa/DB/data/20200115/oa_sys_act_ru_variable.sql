-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: oa_sys
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act_ru_variable`
--

DROP TABLE IF EXISTS `act_ru_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_variable`
--

LOCK TABLES `act_ru_variable` WRITE;
/*!40000 ALTER TABLE `act_ru_variable` DISABLE KEYS */;
INSERT INTO `act_ru_variable` VALUES ('103',1,'string','name','89','89',NULL,NULL,NULL,NULL,'吕启斌',NULL),('105',1,'string','type','89','89',NULL,NULL,NULL,NULL,'财务章',NULL),('107',1,'string','cause','89','89',NULL,NULL,NULL,NULL,'报销需要盖章',NULL),('109',1,'date','bTime','89','89',NULL,NULL,NULL,1579052036000,NULL,NULL),('111',1,'date','eTime','89','89',NULL,NULL,NULL,1579311241000,NULL,NULL),('113',1,'double','dSum','89','89',NULL,NULL,3.4,NULL,NULL,NULL),('115',1,'long','sum','89','89',NULL,NULL,NULL,1,'1',NULL),('117',1,'date','aDate','89','89',NULL,NULL,NULL,1579017600000,NULL,NULL),('119',1,'string','attachment','89','89',NULL,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"o0kqptub2xo\\\",\\\"fileName\\\":\\\"20.jpg\\\",\\\"fileSize\\\":\\\"228 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"a1svkv194gg\\\",\\\"fileName\\\":\\\"24.jpg\\\",\\\"fileSize\\\":\\\"263 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"vdl8e5bza6p\\\",\\\"fileName\\\":\\\"29.jpg\\\",\\\"fileSize\\\":\\\"113 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL),('121',1,'null','executiveUser0','89','89',NULL,NULL,NULL,NULL,NULL,NULL),('123',1,'null','executiveUser1','89','89',NULL,NULL,NULL,NULL,NULL,NULL),('128',1,'string','executiveUser0','127','127',NULL,NULL,NULL,NULL,'SYSTEM',NULL),('130',1,'string','executiveUser1','127','127',NULL,NULL,NULL,NULL,'73888c1b57084ec2b863fb137307c8de',NULL),('148',1,'string','name','127','127',NULL,NULL,NULL,NULL,'吕启斌',NULL),('150',1,'string','type','127','127',NULL,NULL,NULL,NULL,'财务章',NULL),('152',1,'string','cause','127','127',NULL,NULL,NULL,NULL,'报销需要盖章',NULL),('154',1,'date','bTime','127','127',NULL,NULL,NULL,1579052036000,NULL,NULL),('156',1,'date','eTime','127','127',NULL,NULL,NULL,1579311241000,NULL,NULL),('158',1,'double','dSum','127','127',NULL,NULL,3.4,NULL,NULL,NULL),('160',1,'long','sum','127','127',NULL,NULL,NULL,1,'1',NULL),('162',1,'date','aDate','127','127',NULL,NULL,NULL,1579017600000,NULL,NULL),('164',1,'string','attachment','127','127',NULL,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"o0kqptub2xo\\\",\\\"fileName\\\":\\\"20.jpg\\\",\\\"fileSize\\\":\\\"228 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"a1svkv194gg\\\",\\\"fileName\\\":\\\"24.jpg\\\",\\\"fileSize\\\":\\\"263 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"vdl8e5bza6p\\\",\\\"fileName\\\":\\\"29.jpg\\\",\\\"fileSize\\\":\\\"113 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL),('18',1,'string','title','5','5',NULL,NULL,NULL,NULL,'过年请假',NULL),('190',1,'string','executiveUser2','127','127',NULL,NULL,NULL,NULL,'SYSTEM',NULL),('20',1,'string','name','5','5',NULL,NULL,NULL,NULL,'吕启斌',NULL),('22',1,'date','beginTime','5','5',NULL,NULL,NULL,1579051349000,NULL,NULL),('24',1,'date','endTime','5','5',NULL,NULL,NULL,1579224151000,NULL,NULL),('26',1,'double','datySum','5','5',NULL,NULL,3.5,NULL,NULL,NULL),('28',1,'long','personSum','5','5',NULL,NULL,NULL,1,'1',NULL),('30',1,'string','cause','5','5',NULL,NULL,NULL,NULL,'过年回家',NULL),('32',1,'string','attachment','5','5',NULL,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"hec3x2k9gxt\\\",\\\"fileName\\\":\\\"07.jpg\\\",\\\"fileSize\\\":\\\"180 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"od3znulua\\\",\\\"fileName\\\":\\\"09.jpg\\\",\\\"fileSize\\\":\\\"208 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL),('34',1,'null','executiveUser0','5','5',NULL,NULL,NULL,NULL,NULL,NULL),('36',1,'null','executiveUser1','5','5',NULL,NULL,NULL,NULL,NULL,NULL),('41',1,'string','executiveUser0','40','40',NULL,NULL,NULL,NULL,'SYSTEM',NULL),('43',1,'string','executiveUser1','40','40',NULL,NULL,NULL,NULL,'73888c1b57084ec2b863fb137307c8de',NULL),('60',1,'string','title','40','40',NULL,NULL,NULL,NULL,'过年请假',NULL),('62',1,'string','name','40','40',NULL,NULL,NULL,NULL,'吕启斌',NULL),('64',1,'date','beginTime','40','40',NULL,NULL,NULL,1579051349000,NULL,NULL),('66',1,'date','endTime','40','40',NULL,NULL,NULL,1579224151000,NULL,NULL),('68',1,'double','datySum','40','40',NULL,NULL,3.5,NULL,NULL,NULL),('70',1,'long','personSum','40','40',NULL,NULL,NULL,1,'1',NULL),('72',1,'string','cause','40','40',NULL,NULL,NULL,NULL,'过年回家',NULL),('74',1,'string','attachment','40','40',NULL,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"hec3x2k9gxt\\\",\\\"fileName\\\":\\\"07.jpg\\\",\\\"fileSize\\\":\\\"180 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"od3znulua\\\",\\\"fileName\\\":\\\"09.jpg\\\",\\\"fileSize\\\":\\\"208 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL);
/*!40000 ALTER TABLE `act_ru_variable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-15  9:41:00
