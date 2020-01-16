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
INSERT INTO `sys_permission` VALUES ('0758D72F0E1F41C8922A237D554D4352','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559A29EA000014BE254E015009A90'),('0B78338C828140FC85653520766B1984','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'EFB7D5CE8B15417F840559BC5DCDE01C'),('106C3627512249B698E066E8EA1861ED','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'4A85675B584343439FE37DD51FF80AAF'),('12600087946446259B03FE049BE80EB7','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80559AC87900001FB5116301D80FF50'),('17BF505668BE4DA7BF7B69C03FFB5C69','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'1E494612A2644EA3AB2812DA26E9CB6F'),('350F827FAC5F42D38E56D048F58523E5','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'32B914B24B534EBBAEA9A61F982F9B7D'),('3D04665758144EB29D226233A187604F','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'963BB3B7D4FA40529A8BB4A329F07514'),('4B3997CEE2BC4DCBA5E70185A5D12F6A','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563E549600001BC6D1A801FF16530'),('4C36DC1367954EC7AC706EBE670B5F86','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'532547CD89154A648E2ACE7A36A89948'),('4E5507C41AAD42E3B25D80C69B7E5743','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C80563C9DE500001F1A81A305BA08300'),('54F03E01BDE64F848CE979B707224262','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'68CC9575B7754CA7B266DFF19E73E601'),('57506C6A482F474F9951AA70AC549E28','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'F4937434B50C435C91589F0542261C49'),('7DDDE21A134D4593AE76AC3B4DA649D3','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805591C924000012CAF10C0A8C616E0'),('868963897CCE45169D814EF0D71F3954','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C805592553D000011ECE1BBB5CF91F5B'),('A8EE20575FB549B6A9D67E00598521B3','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C8055989BBB000017A5115BB195999E0'),('C499D581A8214A3DA6DB4044615D4E08','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'58BCA2085EBE4268AFA2E7F43EEE8A2D'),('CD2EFEBA24904F4DB6BF7566D9CB8853','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'C2DC82DFDBE74BA9AB0CB123F7AF2B09'),('E5949A212D43448EA6DD671C7589ADF5','14B63E2558B3428CBDC9B1539E95DA1F','功能权限',NULL,'1',1,'2337BA16F2304206BFB9FF947C818F64');
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

-- Dump completed on 2019-12-03 16:02:10
