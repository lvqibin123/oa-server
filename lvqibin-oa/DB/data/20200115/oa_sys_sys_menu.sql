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
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `parent` varchar(50) DEFAULT NULL COMMENT '父节点',
  `code` varchar(100) DEFAULT NULL COMMENT '菜单编码',
  `name` varchar(500) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(2048) DEFAULT NULL COMMENT '菜单URL',
  `sequence` varchar(100) DEFAULT NULL COMMENT '序号',
  `valid_state` varchar(10) DEFAULT NULL COMMENT '可用状态',
  `level` int(10) DEFAULT NULL COMMENT '级别',
  `version` int(10) DEFAULT NULL COMMENT '版本',
  `type` varchar(10) DEFAULT NULL COMMENT '菜单类型PCorAPP',
  `menu_type` varchar(45) DEFAULT NULL COMMENT '菜单类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1E494612A2644EA3AB2812DA26E9CB6F','C8055989BBB000017A5115BB195999E0','orgNewBut','组织机构新增按钮','/sys/org/new','1','1',3,1,'PC','button'),('2337BA16F2304206BFB9FF947C818F64','963BB3B7D4FA40529A8BB4A329F07514','leave','发起申请','/app/start-process','1','1',2,2,'PC','menu'),('2b69f1c34d384064862433a5a342344e','79deeabf58694d318ae9c7e0e697e25f','my-historic-agency','我处理的流程','/activiti/my-historic-agency','3','1',2,1,'PC','menu'),('58BCA2085EBE4268AFA2E7F43EEE8A2D','C2DC82DFDBE74BA9AB0CB123F7AF2B09','farmer','养户管理','/app/farmer','1','1',2,1,'PC','menu'),('68CC9575B7754CA7B266DFF19E73E601','F4937434B50C435C91589F0542261C49','codeHelp','代码生成工具','/utils/code-help','1','1',2,1,'PC','menu'),('6a2d4e960b2543eaa1252b6283692d09','F4937434B50C435C91589F0542261C49','java-api','后端api','/utils/java-api','2','1',2,4,'PC','menu'),('79deeabf58694d318ae9c7e0e697e25f','C805591C924000012CAF10C0A8C616E0','activiti','流程管理',NULL,'5','1',1,1,'PC','menu'),('963BB3B7D4FA40529A8BB4A329F07514','C805591C924000012CAF10C0A8C616E0','internalExternalManagement','内外勤管理',NULL,'4','1',1,1,'PC','menu'),('C2DC82DFDBE74BA9AB0CB123F7AF2B09','C805591C924000012CAF10C0A8C616E0','dome','测试用例',NULL,'3','1',1,1,'PC','menu'),('C805591C924000012CAF10C0A8C616E0','root','xyxt','SSMAngular系统',NULL,'1','1',0,2,'PC','menu'),('C805592553D000011ECE1BBB5CF91F5B','C805591C924000012CAF10C0A8C616E0','sysMag','系统管理',NULL,'1','1',1,1,'PC','menu'),('C8055989BBB000017A5115BB195999E0','C805592553D000011ECE1BBB5CF91F5B','org','组织机构管理','/sys/org','1','1',2,1,'PC','menu'),('C80559A29EA000014BE254E015009A90','C805592553D000011ECE1BBB5CF91F5B','menu','菜单管理','/sys/menu','2','1',2,1,'PC','menu'),('C80559AC87900001FB5116301D80FF50','C805592553D000011ECE1BBB5CF91F5B','role','角色管理','/sys/role','3','1',2,1,'PC','menu'),('C80563C9DE500001F1A81A305BA08300','C805592553D000011ECE1BBB5CF91F5B','permissionRole','按组织授权','/sys/org-authorization','4','1',2,1,'PC','menu'),('C80563E549600001BC6D1A801FF16530','C805592553D000011ECE1BBB5CF91F5B','dictionary','数据字典管理','/sys/dictionary','5','1',2,1,'PC','menu'),('EFB7D5CE8B15417F840559BC5DCDE01C','C805592553D000011ECE1BBB5CF91F5B','log','日志管理','/sys/log','6','1',2,1,'PC','menu'),('F4937434B50C435C91589F0542261C49','C805591C924000012CAF10C0A8C616E0','systemUtils','系统工具',NULL,'2','1',1,1,'PC','menu'),('f91eebc926e54c98b3b7765acaa032dc','79deeabf58694d318ae9c7e0e697e25f','add-process','添加流程','/activiti/add-process','1','1',2,1,'PC','menu'),('fbbe4fa1c3a94e3fa57ca1fd31ec3614','79deeabf58694d318ae9c7e0e697e25f','my-agent','我的代办','activiti/my-agent','2','1',2,1,'PC','menu'),('root',NULL,'root','root',NULL,'1',NULL,NULL,1,'PC','menu');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-15  9:40:55
