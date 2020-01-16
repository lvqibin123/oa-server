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
INSERT INTO `sys_permission` VALUES ('11f4cc11233e49558388494fd2eaf323','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559A29EA000014BE254E015009A90'),('1a839f6af6a0449db62163520c4241fe','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('1db79d5016e84a908197a2a0473e9291','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'4A85675B584343439FE37DD51FF80AAF'),('1f3f009aa2d842438e8fb1713dcc7fa6','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'58BCA2085EBE4268AFA2E7F43EEE8A2D'),('250b88b127b24ca7a0059e1efeee888a','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C8055989BBB000017A5115BB195999E0'),('2a2613030b1349d6b8dc8fa3ac3657a8','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563E549600001BC6D1A801FF16530'),('2ec6a5db7f154f3aa353efa0591d90fc','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'F4937434B50C435C91589F0542261C49'),('32f8de2247e54a0fa11875de99187db8','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'6a2d4e960b2543eaa1252b6283692d09'),('3950549fe51546c39abca321fa54bbb3','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559AC87900001FB5116301D80FF50'),('47c3e85f137d4800a93b1078af6692b4','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'f91eebc926e54c98b3b7765acaa032dc'),('6008c5884c7c4337a3337d19f3a11df4','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C2DC82DFDBE74BA9AB0CB123F7AF2B09'),('675953da536440e29c8703fd48fd102d','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('6ec6daaf5e394637a6947a01365b3d11','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'2337BA16F2304206BFB9FF947C818F64'),('79aa03ec5e4646c49680c3e9fabcc64f','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'1E494612A2644EA3AB2812DA26E9CB6F'),('83bf32dc82e948beb90b4e55590a0c1d','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('87100f272dfd4c79957ba38b6fab7719','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'32B914B24B534EBBAEA9A61F982F9B7D'),('9245b0257e2d41b585228aba7ece0eb0','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('a4f919d714344c8289aaba51917c4f89','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('a50a48d826964f47a5c8b0151d2d63ab','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'EFB7D5CE8B15417F840559BC5DCDE01C'),('aae93ba865244384acd8a1a9070681fe','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'532547CD89154A648E2ACE7A36A89948'),('ae34d198fad543149376154514520b40','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'68CC9575B7754CA7B266DFF19E73E601'),('d2073845ea8c421b9046671d10a7e1e7','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('e4792f38ccb6492ea603cab4781af383','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'79deeabf58694d318ae9c7e0e697e25f'),('f1f46deb7d1941f9a97a1f485f9914a4','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'963BB3B7D4FA40529A8BB4A329F07514');
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

-- Dump completed on 2019-12-25  9:50:37
