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
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `type_name` varchar(100) DEFAULT NULL COMMENT '类别',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `creator_id` varchar(50) DEFAULT NULL COMMENT '操作者ID',
  `creator_time` datetime DEFAULT NULL COMMENT '操作时间',
  `process` varchar(300) DEFAULT NULL COMMENT '过程',
  `process_name` varchar(3000) DEFAULT NULL COMMENT '过程',
  `activity` varchar(300) DEFAULT NULL COMMENT '环节',
  `activity_name` varchar(3000) DEFAULT NULL COMMENT '环节',
  `action_name` varchar(300) DEFAULT NULL COMMENT '动作名称',
  `action` varchar(3000) DEFAULT NULL COMMENT '动作',
  `status` varchar(300) DEFAULT NULL COMMENT '操作状态',
  `parameters` text COMMENT '参数',
  `result` varchar(3000) DEFAULT NULL COMMENT '结果',
  `ip` varchar(100) DEFAULT NULL COMMENT 'IP地址',
  `device_type` varchar(100) DEFAULT NULL COMMENT '终端类型',
  `operating_system` varchar(100) DEFAULT NULL COMMENT '操作系统',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES ('2f4b47ca08cc47dd98f14179a1164141',1,NULL,NULL,NULL,'2019-12-03 15:01:54',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('39e10c786ba644ad8f2063296154150b',1,NULL,NULL,NULL,'2019-12-03 15:10:56',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('4d3de9e311604c30bb2ae56c2aa546fa',1,NULL,NULL,NULL,'2019-12-03 15:21:17',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('69bc6e1ffad84b0b9b91e482050b038c',1,NULL,NULL,NULL,'2019-12-03 15:34:00',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('6a5eff7465f8447583a8399b8824b567',1,NULL,NULL,NULL,'2019-12-03 15:39:35',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('6ef25674b5224b5792900a3c498936fb',1,NULL,NULL,NULL,'2019-12-03 14:58:00',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('780c1c78345a4e1eae875f94abc66866',1,NULL,NULL,NULL,'2019-12-03 15:00:19',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('84c3aad0e9594b2c86668fe9baef7ff9',1,NULL,NULL,NULL,'2019-12-03 15:01:51',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('9a7f0d294ddf41519d3585c6208bea2a',1,NULL,NULL,NULL,'2019-12-03 15:09:58',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('af0817977ec642a9846a91f25351fd82',1,NULL,NULL,NULL,'2019-12-03 15:01:53',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('af13064381dc494da2f75fb283a1ead4',1,NULL,NULL,NULL,'2019-12-03 15:03:12',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('bb1356accb974551a59193f026e0b1ea',1,NULL,NULL,NULL,'2019-12-03 15:30:37',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('c59c0c2bbc06433785b747f7ed2ad745',1,NULL,NULL,NULL,'2019-12-03 15:13:19',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('cb2348b9be254a06b6917c7b27293291',1,NULL,NULL,NULL,'2019-12-03 15:09:55',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL),('fd0dcb2f5e2c42408436d53b0379ca87',1,NULL,NULL,NULL,'2019-12-03 14:56:34',NULL,NULL,'/sys/sysPerson/loginSystemByAngular','用户登录','com.lvqibin.oa.sys.controller.SysPersonController','loginAction',NULL,'loginName=system&password=123456','true','127.0.0.1','pc',' Win64',NULL);
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-03 16:02:08
