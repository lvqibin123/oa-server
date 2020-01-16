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
INSERT INTO `sys_permission` VALUES ('14a45ce0b6e74c0dbbcf95ef4d8a16ad','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'532547CD89154A648E2ACE7A36A89948'),('1a839f6af6a0449db62163520c4241fe','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('1ddc5d49256844688fdfd84cc1aeb541','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'EFB7D5CE8B15417F840559BC5DCDE01C'),('29040c4906a44c29baa43f035235c044','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('2c13c5e9497f4401a2fbfc0071317c57','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559A29EA000014BE254E015009A90'),('2f154d3131c549f0a6d441af8e40307e','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'2337BA16F2304206BFB9FF947C818F64'),('3468e74e88e9484da5523264ec68f920','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563E549600001BC6D1A801FF16530'),('3abfb1ceb14845889a3961341d48ab90','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C8055989BBB000017A5115BB195999E0'),('57f8d5e41cbe46dbb589c3f172f0e2c7','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('7864b57b4c2949aa9ea9f7defd3d1a4d','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'32B914B24B534EBBAEA9A61F982F9B7D'),('7ab21e863c5b47f98e685bed59e884f2','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'F4937434B50C435C91589F0542261C49'),('7bc75919510d413081680765778f8a40','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('7c57cb59355347828ecb401c7dea732f','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559AC87900001FB5116301D80FF50'),('83bf32dc82e948beb90b4e55590a0c1d','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('8af2d65a1cc9490a8f2e2803feb7a73b','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'58BCA2085EBE4268AFA2E7F43EEE8A2D'),('91916f0bff774af994f7252a6f6b2dc0','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'963BB3B7D4FA40529A8BB4A329F07514'),('99fc806c506247f9bde5e8c615a062bd','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'68CC9575B7754CA7B266DFF19E73E601'),('aab050b047424190a86ea13aa8193cbd','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C2DC82DFDBE74BA9AB0CB123F7AF2B09'),('c02003e8b2824e5baa1373e09aaf230d','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'1E494612A2644EA3AB2812DA26E9CB6F'),('d2073845ea8c421b9046671d10a7e1e7','ebd22d04bbb944f9b594102a5b47d29d','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('dec30b4ccb4d4a559e850aaa579c5244','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'6a2d4e960b2543eaa1252b6283692d09'),('e4c28531195347dc975b14995af16fdb','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'4A85675B584343439FE37DD51FF80AAF');
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

-- Dump completed on 2019-12-19 16:36:00
