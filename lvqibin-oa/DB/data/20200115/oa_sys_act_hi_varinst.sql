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
-- Table structure for table `act_hi_varinst`
--

DROP TABLE IF EXISTS `act_hi_varinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_varinst`
--

LOCK TABLES `act_hi_varinst` WRITE;
/*!40000 ALTER TABLE `act_hi_varinst` DISABLE KEYS */;
INSERT INTO `act_hi_varinst` VALUES ('103','89','89',NULL,'name','string',0,NULL,NULL,NULL,'吕启斌',NULL,'2020-01-15 09:34:42.689','2020-01-15 09:34:42.689'),('105','89','89',NULL,'type','string',0,NULL,NULL,NULL,'财务章',NULL,'2020-01-15 09:34:42.689','2020-01-15 09:34:42.689'),('107','89','89',NULL,'cause','string',0,NULL,NULL,NULL,'报销需要盖章',NULL,'2020-01-15 09:34:42.689','2020-01-15 09:34:42.689'),('109','89','89',NULL,'bTime','date',0,NULL,NULL,1579052036000,NULL,NULL,'2020-01-15 09:34:42.689','2020-01-15 09:34:42.689'),('111','89','89',NULL,'eTime','date',0,NULL,NULL,1579311241000,NULL,NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('113','89','89',NULL,'dSum','double',0,NULL,3.4,NULL,NULL,NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('115','89','89',NULL,'sum','long',0,NULL,NULL,1,'1',NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('117','89','89',NULL,'aDate','date',0,NULL,NULL,1579017600000,NULL,NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('119','89','89',NULL,'attachment','string',0,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"o0kqptub2xo\\\",\\\"fileName\\\":\\\"20.jpg\\\",\\\"fileSize\\\":\\\"228 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"a1svkv194gg\\\",\\\"fileName\\\":\\\"24.jpg\\\",\\\"fileSize\\\":\\\"263 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"vdl8e5bza6p\\\",\\\"fileName\\\":\\\"29.jpg\\\",\\\"fileSize\\\":\\\"113 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('121','89','89',NULL,'executiveUser0','null',0,NULL,NULL,NULL,NULL,NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('123','89','89',NULL,'executiveUser1','null',0,NULL,NULL,NULL,NULL,NULL,'2020-01-15 09:34:42.690','2020-01-15 09:34:42.690'),('128','127','127',NULL,'executiveUser0','string',1,NULL,NULL,NULL,'SYSTEM',NULL,'2020-01-15 09:34:42.734','2020-01-15 09:34:42.776'),('130','127','127',NULL,'executiveUser1','string',1,NULL,NULL,NULL,'73888c1b57084ec2b863fb137307c8de',NULL,'2020-01-15 09:34:42.734','2020-01-15 09:34:42.778'),('148','127','127',NULL,'name','string',1,NULL,NULL,NULL,'吕启斌',NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.765'),('150','127','127',NULL,'type','string',1,NULL,NULL,NULL,'财务章',NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.766'),('152','127','127',NULL,'cause','string',1,NULL,NULL,NULL,'报销需要盖章',NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.767'),('154','127','127',NULL,'bTime','date',1,NULL,NULL,1579052036000,NULL,NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.768'),('156','127','127',NULL,'eTime','date',1,NULL,NULL,1579311241000,NULL,NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.769'),('158','127','127',NULL,'dSum','double',1,NULL,3.4,NULL,NULL,NULL,'2020-01-15 09:34:42.774','2020-01-15 09:36:30.770'),('160','127','127',NULL,'sum','long',1,NULL,NULL,1,'1',NULL,'2020-01-15 09:34:42.775','2020-01-15 09:36:30.771'),('162','127','127',NULL,'aDate','date',1,NULL,NULL,1579017600000,NULL,NULL,'2020-01-15 09:34:42.775','2020-01-15 09:36:30.772'),('164','127','127',NULL,'attachment','string',1,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"o0kqptub2xo\\\",\\\"fileName\\\":\\\"20.jpg\\\",\\\"fileSize\\\":\\\"228 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"a1svkv194gg\\\",\\\"fileName\\\":\\\"24.jpg\\\",\\\"fileSize\\\":\\\"263 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"vdl8e5bza6p\\\",\\\"fileName\\\":\\\"29.jpg\\\",\\\"fileSize\\\":\\\"113 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL,'2020-01-15 09:34:42.775','2020-01-15 09:36:30.774'),('18','5','5',NULL,'title','string',0,NULL,NULL,NULL,'过年请假',NULL,'2020-01-15 09:23:20.707','2020-01-15 09:23:20.707'),('190','127','127',NULL,'executiveUser2','string',0,NULL,NULL,NULL,'SYSTEM',NULL,'2020-01-15 09:36:30.774','2020-01-15 09:36:30.774'),('20','5','5',NULL,'name','string',0,NULL,NULL,NULL,'吕启斌',NULL,'2020-01-15 09:23:20.708','2020-01-15 09:23:20.708'),('22','5','5',NULL,'beginTime','date',0,NULL,NULL,1579051349000,NULL,NULL,'2020-01-15 09:23:20.708','2020-01-15 09:23:20.708'),('24','5','5',NULL,'endTime','date',0,NULL,NULL,1579224151000,NULL,NULL,'2020-01-15 09:23:20.709','2020-01-15 09:23:20.709'),('26','5','5',NULL,'datySum','double',0,NULL,3.5,NULL,NULL,NULL,'2020-01-15 09:23:20.709','2020-01-15 09:23:20.709'),('28','5','5',NULL,'personSum','long',0,NULL,NULL,1,'1',NULL,'2020-01-15 09:23:20.709','2020-01-15 09:23:20.709'),('30','5','5',NULL,'cause','string',0,NULL,NULL,NULL,'过年回家',NULL,'2020-01-15 09:23:20.709','2020-01-15 09:23:20.709'),('32','5','5',NULL,'attachment','string',0,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"hec3x2k9gxt\\\",\\\"fileName\\\":\\\"07.jpg\\\",\\\"fileSize\\\":\\\"180 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"od3znulua\\\",\\\"fileName\\\":\\\"09.jpg\\\",\\\"fileSize\\\":\\\"208 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL,'2020-01-15 09:23:20.709','2020-01-15 09:23:20.709'),('34','5','5',NULL,'executiveUser0','null',0,NULL,NULL,NULL,NULL,NULL,'2020-01-15 09:23:20.710','2020-01-15 09:23:20.710'),('36','5','5',NULL,'executiveUser1','null',0,NULL,NULL,NULL,NULL,NULL,'2020-01-15 09:23:20.710','2020-01-15 09:23:20.710'),('41','40','40',NULL,'executiveUser0','string',1,NULL,NULL,NULL,'SYSTEM',NULL,'2020-01-15 09:23:20.875','2020-01-15 09:23:21.131'),('43','40','40',NULL,'executiveUser1','string',1,NULL,NULL,NULL,'73888c1b57084ec2b863fb137307c8de',NULL,'2020-01-15 09:23:20.875','2020-01-15 09:23:21.134'),('60','40','40',NULL,'title','string',0,NULL,NULL,NULL,'过年请假',NULL,'2020-01-15 09:23:21.123','2020-01-15 09:23:21.123'),('62','40','40',NULL,'name','string',0,NULL,NULL,NULL,'吕启斌',NULL,'2020-01-15 09:23:21.123','2020-01-15 09:23:21.123'),('64','40','40',NULL,'beginTime','date',0,NULL,NULL,1579051349000,NULL,NULL,'2020-01-15 09:23:21.124','2020-01-15 09:23:21.124'),('66','40','40',NULL,'endTime','date',0,NULL,NULL,1579224151000,NULL,NULL,'2020-01-15 09:23:21.124','2020-01-15 09:23:21.124'),('68','40','40',NULL,'datySum','double',0,NULL,3.5,NULL,NULL,NULL,'2020-01-15 09:23:21.124','2020-01-15 09:23:21.124'),('70','40','40',NULL,'personSum','long',0,NULL,NULL,1,'1',NULL,'2020-01-15 09:23:21.124','2020-01-15 09:23:21.124'),('72','40','40',NULL,'cause','string',0,NULL,NULL,NULL,'过年回家',NULL,'2020-01-15 09:23:21.125','2020-01-15 09:23:21.125'),('74','40','40',NULL,'attachment','string',0,NULL,NULL,NULL,'[{\\\"fileID\\\":\\\"hec3x2k9gxt\\\",\\\"fileName\\\":\\\"07.jpg\\\",\\\"fileSize\\\":\\\"180 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"},{\\\"fileID\\\":\\\"od3znulua\\\",\\\"fileName\\\":\\\"09.jpg\\\",\\\"fileSize\\\":\\\"208 Kb\\\",\\\"fileType\\\":\\\"image/jpeg\\\",\\\"filePath\\\":\\\"1\\\"}]',NULL,'2020-01-15 09:23:21.125','2020-01-15 09:23:21.125');
/*!40000 ALTER TABLE `act_hi_varinst` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-15  9:41:03
