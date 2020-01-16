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
-- Table structure for table `sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_org` (
  `id` varchar(100) NOT NULL COMMENT  '主键id' ,
 `parent`  varchar(100) DEFAULT NULL COMMENT  '父节点' ,
 `all_name`  varchar(2048) DEFAULT NULL COMMENT  '全路径名' ,
 `all_id`  varchar(2048) DEFAULT NULL COMMENT  '全路径ID' ,
 `name`  varchar(100) DEFAULT NULL COMMENT  '名称' ,
 `code`  varchar(100) DEFAULT NULL COMMENT  '编码' ,
 `long_name`  varchar(100) DEFAULT NULL COMMENT  '长名称' ,
 `all_code`  varchar(2048) DEFAULT NULL COMMENT  '全路径编码' ,
 `org_kind_id`  varchar(100) DEFAULT NULL COMMENT  '组织类型' ,
 `sequence`  varchar(100) DEFAULT NULL COMMENT  '序号' ,
 `valid_state`  varchar(10) DEFAULT NULL COMMENT  '可用状态' ,
 `level`  int(10) DEFAULT NULL COMMENT  '级别' ,
 `phone`  varchar(100) DEFAULT NULL COMMENT  '电话' ,
 `fax`  varchar(100) DEFAULT NULL COMMENT  '传真' ,
 `address`  varchar(2048) DEFAULT NULL COMMENT  '地址' ,
 `zip`  varchar(100) DEFAULT NULL COMMENT  '邮编' ,
 `description`  varchar(100) DEFAULT NULL COMMENT  '描述' ,
 `person_id`  varchar(100) DEFAULT NULL COMMENT  '人员' ,
 `node_kind`  varchar(100) DEFAULT NULL COMMENT  '节点类型' ,
 `version`  int(10) DEFAULT NULL COMMENT  '版本' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_org`
--

LOCK TABLES `sys_org` WRITE;
/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
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
