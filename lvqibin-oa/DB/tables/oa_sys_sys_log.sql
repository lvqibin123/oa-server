-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sbm_admin_sys
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
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT  '主键id' ,
  `version`  int(10) DEFAULT NULL COMMENT  '版本' ,
 `type_name`  varchar(100) DEFAULT NULL COMMENT  '类别' ,
 `description`  varchar(3000) DEFAULT NULL COMMENT  '描述' ,
 `creator_id`  varchar(50) DEFAULT NULL COMMENT  '操作者ID' ,
 `creator_time`  datetime DEFAULT NULL COMMENT  '操作时间' ,
 `process`  varchar(300) DEFAULT NULL COMMENT  '过程' ,
 `process_name`  varchar(3000) DEFAULT NULL COMMENT  '过程' ,
 `activity`  varchar(300) DEFAULT NULL COMMENT  '环节' ,
 `activity_name`  varchar(3000) DEFAULT NULL COMMENT  '环节' ,
 `action_name`  varchar(300) DEFAULT NULL COMMENT  '动作名称' ,
 `action`  varchar(3000) DEFAULT NULL COMMENT  '动作' ,
 `status`  varchar(300) DEFAULT NULL COMMENT  '操作状态' ,
 `parameters`  text DEFAULT NULL COMMENT  '参数' ,
 `result`  varchar(3000) DEFAULT NULL COMMENT  '结果' ,
 `ip`  varchar(100) DEFAULT NULL COMMENT  'IP地址' ,
 `device_type`  varchar(100) DEFAULT NULL COMMENT  '终端类型' ,
 `operating_system`  varchar(100) DEFAULT NULL COMMENT  '操作系统' ,
 `remark`  varchar(3000) DEFAULT NULL COMMENT  '备注 ' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-08 15:26:46
