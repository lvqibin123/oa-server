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
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `role_id` varchar(50) DEFAULT NULL COMMENT '所属角色',
  `description` varchar(3000) DEFAULT NULL COMMENT '描述',
  `sequence` int(10) DEFAULT NULL COMMENT '序号',
  `valid_state` varchar(10) DEFAULT NULL COMMENT '可用状态',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `menu_id` varchar(50) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES ('0302ea6c49b44e83b9baee220efc87c7','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'32B914B24B534EBBAEA9A61F982F9B7D'),('076980f8b6e44553aa54333376b5dc1e','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'f91eebc926e54c98b3b7765acaa032dc'),('08673bea05c14c33bd0cd6cbd736c78b','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'532547CD89154A648E2ACE7A36A89948'),('0a482af481544bb7a74176a741367274','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'f91eebc926e54c98b3b7765acaa032dc'),('1224693b3983434db7399635d374c3bd','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'68CC9575B7754CA7B266DFF19E73E601'),('2a7f2355bf5f4bab9801c8f0377f0021','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563E549600001BC6D1A801FF16530'),('3883a61157694a769581303981cd9f75','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('423bb2d1d98d4db994f38b3b6fe60a26','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('4336fbbf56b64797aebea4491929efa4','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'79deeabf58694d318ae9c7e0e697e25f'),('4cf2db119f5a4997ad3a25752c0543a0','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'EFB7D5CE8B15417F840559BC5DCDE01C'),('5799a9f6f5614da3934bcadb5fee26cf','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'fbbe4fa1c3a94e3fa57ca1fd31ec3614'),('57b740af9bf64f64b0859fc5f957fe70','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'963BB3B7D4FA40529A8BB4A329F07514'),('5ceda0a2c93f4e12a2a21b4e52c3d7da','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('65350cfe5e23402980b7dd25a6f61fef','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'1E494612A2644EA3AB2812DA26E9CB6F'),('6c2fcbbf44bb401fb4b062b1a6080671','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C2DC82DFDBE74BA9AB0CB123F7AF2B09'),('72c6061710a347cd9d81c1cd56bd5934','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'4A85675B584343439FE37DD51FF80AAF'),('75e1d3a32fdb429b88c3dcf197708b48','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'F4937434B50C435C91589F0542261C49'),('76e3a450dbd540cbaa41ce3d1f06a89c','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'58BCA2085EBE4268AFA2E7F43EEE8A2D'),('8590ddd310644f0dafd9bd240b45d034','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'fbbe4fa1c3a94e3fa57ca1fd31ec3614'),('8f73c0ac1f3a42228e99f82c50a8d5b0','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C8055989BBB000017A5115BB195999E0'),('8fa86bab30944996b791825f880dfdfb','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'6a2d4e960b2543eaa1252b6283692d09'),('975c0adf7b174209845e1fc675b9471d','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559AC87900001FB5116301D80FF50'),('adf41937195643f3abee267344ff9967','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559A29EA000014BE254E015009A90'),('c5113609491c4ce4b8fce407413be964','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'2337BA16F2304206BFB9FF947C818F64'),('d4a359105f744411b47a39780612bc91','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'79deeabf58694d318ae9c7e0e697e25f'),('fd1fed8d40e94d458ce835849ab3d725','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-08 10:22:00
