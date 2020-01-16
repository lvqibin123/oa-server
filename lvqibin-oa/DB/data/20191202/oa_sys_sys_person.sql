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
-- Table structure for table `sys_person`
--

DROP TABLE IF EXISTS `sys_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_person` (
  `id` varchar(100) NOT NULL COMMENT '主键id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `id_card` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `numb` int(10) DEFAULT NULL COMMENT '数字编号',
  `login_name` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码(MD5)',
  `password_time_limit` int(10) DEFAULT NULL COMMENT '密码时限（天）',
  `password_modify_time` datetime DEFAULT NULL COMMENT '密码修改时间',
  `main_org_id` varchar(100) DEFAULT NULL COMMENT '所属部门',
  `safe_level_id` varchar(100) DEFAULT NULL COMMENT '密级',
  `sequence` int(10) DEFAULT NULL COMMENT '序号',
  `valid_state` varchar(10) DEFAULT NULL COMMENT '可用状态',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `photo` longblob COMMENT '照片',
  `photo_last_modified` datetime DEFAULT NULL COMMENT '照片修改时间',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `join_date` date DEFAULT NULL COMMENT '参加工作日期',
  `home_place` varchar(100) DEFAULT NULL COMMENT '出生地',
  `country` varchar(100) DEFAULT NULL COMMENT '国家',
  `province` varchar(100) DEFAULT NULL COMMENT '省',
  `city` varchar(100) DEFAULT NULL COMMENT '市',
  `degree` varchar(100) DEFAULT NULL COMMENT '学历',
  `graduate_school` varchar(100) DEFAULT NULL COMMENT '毕业院校',
  `speciality` varchar(100) DEFAULT NULL COMMENT '专业',
  `school_length` varchar(100) DEFAULT NULL COMMENT '学年制',
  `title` varchar(100) DEFAULT NULL COMMENT '职称',
  `marriage` varchar(100) DEFAULT NULL COMMENT '婚姻状况',
  `card_no` varchar(100) DEFAULT NULL COMMENT '证件号码',
  `card_kind` varchar(100) DEFAULT NULL COMMENT '证件类型',
  `family_address` varchar(3000) DEFAULT NULL COMMENT '家庭住址',
  `zip` varchar(100) DEFAULT NULL COMMENT '邮编',
  `msn` varchar(100) DEFAULT NULL COMMENT 'MSN',
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `mail` varchar(100) DEFAULT NULL COMMENT '电子邮件',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `family_phone` varchar(10) DEFAULT NULL COMMENT '家庭电话',
  `office_phone` varchar(20) DEFAULT NULL COMMENT '办公电话',
  `english_name` varchar(100) DEFAULT NULL COMMENT '英文名称',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_person`
--

LOCK TABLES `sys_person` WRITE;
/*!40000 ALTER TABLE `sys_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 14:51:31
