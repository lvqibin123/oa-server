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
-- Table structure for table `sys_org`
--

DROP TABLE IF EXISTS `sys_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_org` (
  `id` varchar(100) NOT NULL COMMENT '主键id',
  `parent` varchar(100) DEFAULT NULL COMMENT '父节点',
  `all_name` varchar(2048) DEFAULT NULL COMMENT '全路径名',
  `all_id` varchar(2048) DEFAULT NULL COMMENT '全路径ID',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `long_name` varchar(100) DEFAULT NULL COMMENT '长名称',
  `all_code` varchar(2048) DEFAULT NULL COMMENT '全路径编码',
  `org_kind_id` varchar(100) DEFAULT NULL COMMENT '组织类型',
  `sequence` varchar(100) DEFAULT NULL COMMENT '序号',
  `valid_state` varchar(10) DEFAULT NULL COMMENT '可用状态',
  `level` int(10) DEFAULT NULL COMMENT '级别',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `fax` varchar(100) DEFAULT NULL COMMENT '传真',
  `address` varchar(2048) DEFAULT NULL COMMENT '地址',
  `zip` varchar(100) DEFAULT NULL COMMENT '邮编',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `person_id` varchar(100) DEFAULT NULL COMMENT '人员',
  `node_kind` varchar(100) DEFAULT NULL COMMENT '节点类型',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_org`
--

LOCK TABLES `sys_org` WRITE;
/*!40000 ALTER TABLE `sys_org` DISABLE KEYS */;
INSERT INTO `sys_org` VALUES ('0e177c5d3be140ac8c934b033ba3b8a1','c119f69185a64f78afe1dc27a99b392e','/root/测试机构/测试部门/测试岗位/测试','/root/db6d914fe997404c8dbf5c3ace23faf4/78ac83efe67548ee86154d2a3521bf45/c119f69185a64f78afe1dc27a99b392e/0e177c5d3be140ac8c934b033ba3b8a1','测试','test',NULL,'/root/testogn/testdpt/testpos/test','psm','1','1',3,'111111',NULL,'1111','1111',NULL,'73888c1b57084ec2b863fb137307c8de','nkLeaf',1),('78ac83efe67548ee86154d2a3521bf45','db6d914fe997404c8dbf5c3ace23faf4','/root/测试机构/测试部门','/root/db6d914fe997404c8dbf5c3ace23faf4/78ac83efe67548ee86154d2a3521bf45','测试部门','testdpt','测试部门','/root/testogn/testdpt','dpt','1','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),('c119f69185a64f78afe1dc27a99b392e','78ac83efe67548ee86154d2a3521bf45','/root/测试机构/测试部门/测试岗位','/root/db6d914fe997404c8dbf5c3ace23faf4/78ac83efe67548ee86154d2a3521bf45/c119f69185a64f78afe1dc27a99b392e','测试岗位','testpos','测试岗位','/root/testogn/testdpt/testpos','pos','1','1',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),('db6d914fe997404c8dbf5c3ace23faf4','root','/root/测试机构','/root/db6d914fe997404c8dbf5c3ace23faf4','测试机构','testogn','测试机构','/root/testogn','ogn','2','1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),('root',NULL,'/root','/root','root','root','root','/root','ogn','1','1',0,'','','','','','','',1),('SYSTEM@root','root','/root/system','/root/SYSTEM@root','system','SYSTEM','system','/root/SYSTEM','psm','1','1',1,'13698711929','lvqibin_123@126.com','','','','SYSTEM','nkLeaf',2);
/*!40000 ALTER TABLE `sys_org` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-29 14:58:19
