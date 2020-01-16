-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: oa_app
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
-- Table structure for table `app_farmer`
--

DROP TABLE IF EXISTS `app_farmer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_farmer` (
  `id` varchar(100) NOT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `code` varchar(100) DEFAULT NULL COMMENT '养户编号',
  `simple_name` varchar(100) DEFAULT NULL COMMENT '简称',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `idcard` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `bank_card` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  `family_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `province` varchar(100) DEFAULT NULL COMMENT '省份',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `county` varchar(100) DEFAULT NULL COMMENT '县',
  `town` varchar(100) DEFAULT NULL COMMENT '镇',
  `village` varchar(100) DEFAULT NULL COMMENT '村',
  `piggery_address` varchar(100) DEFAULT NULL COMMENT '猪舍地址（详细）',
  `area` varchar(100) DEFAULT NULL COMMENT '猪舍占地面积',
  `max_size` varchar(100) DEFAULT NULL COMMENT '最大养殖规模',
  `longitude` varchar(100) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(100) DEFAULT NULL COMMENT '纬度',
  `max_radius` varchar(100) DEFAULT NULL COMMENT '半径范围最大值',
  `login_name` varchar(100) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `is_allow_login` int(11) DEFAULT NULL COMMENT '是否允许登录（1允许登录，其他 不允许登录）',
  `attachment` varchar(3000) DEFAULT NULL COMMENT '附件',
  `description` longtext COMMENT '描述',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_use_id` varchar(100) DEFAULT NULL COMMENT '修改人ID',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  `login_fail_count` int(11) DEFAULT NULL COMMENT '登录失败次数',
  `add_date` date DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_farmer`
--

LOCK TABLES `app_farmer` WRITE;
/*!40000 ALTER TABLE `app_farmer` DISABLE KEYS */;
INSERT INTO `app_farmer` VALUES ('99180105980d48188f5162232177375e',9,'测试','test','测试','1','111111','111111111','11111111111','111111111','110','110100000000','110101000000','110101001000','110101001001','11111','111111','111111111111111111111','111111111','1111111','11111111','1111','1111111111',NULL,'[{\"fileID\":\"au1sgtzd8mu\",\"fileName\":\"蒋正波.jpg\",\"fileSize\":\"17 Kb\",\"fileType\":\"image/jpeg\",\"filePath\":\"1\"},{\"fileID\":\"spfr9q3tro\",\"fileName\":\"刘红萍.jpg\",\"fileSize\":\"43 Kb\",\"fileType\":\"image/jpeg\",\"filePath\":\"1\"}]','<p style=\"text-align:center\"><img src=\"http://192.168.3.188:8089/oa/file/ueditor/jsp/upload/image/20191217/1576570714257002793.png\" title=\"1576570714257002793.png\"/></p><p style=\"text-align:center\"><img src=\"http://192.168.3.188:8089/oa/file/ueditor/jsp/upload/image/20191217/1576570714256073607.jpg\" title=\"1576570714256073607.jpg\"/></p><p style=\"text-align:center\"><img src=\"http://192.168.3.188:8089/oa/file/ueditor/jsp/upload/image/20191217/1576570714262076279.jpg\" title=\"1576570714262076279.jpg\"/></p><p><img src=\"http://192.168.3.188:8089/oa/file/ueditor/jsp/upload/image/20191217/1576570714326064367.jpg\" title=\"1576570714326064367.jpg\"/></p><p><br/></p>','1111111111111111111111111111111111111111111','2019-12-03 10:16:42',NULL,'2019-12-25 10:16:47',NULL,'2019-12-01');
/*!40000 ALTER TABLE `app_farmer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-13 11:40:56
