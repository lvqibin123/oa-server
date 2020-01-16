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
-- Table structure for table `sys_city`
--

DROP TABLE IF EXISTS `sys_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(10) unsigned NOT NULL COMMENT '省id',
  `city_id` bigint(20) unsigned NOT NULL COMMENT '市id',
  `city_name` char(64) NOT NULL COMMENT '市名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `city_id` (`city_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='市表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_city`
--

LOCK TABLES `sys_city` WRITE;
/*!40000 ALTER TABLE `sys_city` DISABLE KEYS */;
INSERT INTO `sys_city` VALUES (1,110,110100000000,'市辖区'),(2,110,110200000000,'市辖县'),(3,120,120100000000,'市辖区'),(4,120,120200000000,'市辖县'),(5,130,130100000000,'石家庄市'),(6,130,130200000000,'唐山市'),(7,130,130300000000,'秦皇岛市'),(8,130,130400000000,'邯郸市'),(9,130,130500000000,'邢台市'),(10,130,130600000000,'保定市'),(11,130,130700000000,'张家口市'),(12,130,130800000000,'承德市'),(13,130,130900000000,'沧州市'),(14,130,131000000000,'廊坊市'),(15,130,131100000000,'衡水市'),(16,140,140100000000,'太原市'),(17,140,140200000000,'大同市'),(18,140,140300000000,'阳泉市'),(19,140,140400000000,'长治市'),(20,140,140500000000,'晋城市'),(21,140,140600000000,'朔州市'),(22,140,140700000000,'晋中市'),(23,140,140800000000,'运城市'),(24,140,140900000000,'忻州市'),(25,140,141000000000,'临汾市'),(26,140,141100000000,'吕梁市'),(27,150,150100000000,'呼和浩特市'),(28,150,150200000000,'包头市'),(29,150,150300000000,'乌海市'),(30,150,150400000000,'赤峰市'),(31,150,150500000000,'通辽市'),(32,150,150600000000,'鄂尔多斯市'),(33,150,150700000000,'呼伦贝尔市'),(34,150,150800000000,'巴彦淖尔市'),(35,150,150900000000,'乌兰察布市'),(36,150,152200000000,'兴安盟'),(37,150,152500000000,'锡林郭勒盟'),(38,150,152900000000,'阿拉善盟'),(39,210,210100000000,'沈阳市'),(40,210,210200000000,'大连市'),(41,210,210300000000,'鞍山市'),(42,210,210400000000,'抚顺市'),(43,210,210500000000,'本溪市'),(44,210,210600000000,'丹东市'),(45,210,210700000000,'锦州市'),(46,210,210800000000,'营口市'),(47,210,210900000000,'阜新市'),(48,210,211000000000,'辽阳市'),(49,210,211100000000,'盘锦市'),(50,210,211200000000,'铁岭市'),(51,210,211300000000,'朝阳市'),(52,210,211400000000,'葫芦岛市'),(53,220,220100000000,'长春市'),(54,220,220200000000,'吉林市'),(55,220,220300000000,'四平市'),(56,220,220400000000,'辽源市'),(57,220,220500000000,'通化市'),(58,220,220600000000,'白山市'),(59,220,220700000000,'松原市'),(60,220,220800000000,'白城市'),(61,220,222400000000,'延边朝鲜族自治州'),(62,230,230100000000,'哈尔滨市'),(63,230,230200000000,'齐齐哈尔市'),(64,230,230300000000,'鸡西市'),(65,230,230400000000,'鹤岗市'),(66,230,230500000000,'双鸭山市'),(67,230,230600000000,'大庆市'),(68,230,230700000000,'伊春市'),(69,230,230800000000,'佳木斯市'),(70,230,230900000000,'七台河市'),(71,230,231000000000,'牡丹江市'),(72,230,231100000000,'黑河市'),(73,230,231200000000,'绥化市'),(74,230,232700000000,'大兴安岭地区'),(75,310,310100000000,'市辖区'),(76,310,310200000000,'市辖县'),(77,320,320100000000,'南京市'),(78,320,320200000000,'无锡市'),(79,320,320300000000,'徐州市'),(80,320,320400000000,'常州市'),(81,320,320500000000,'苏州市'),(82,320,320600000000,'南通市'),(83,320,320700000000,'连云港市'),(84,320,320800000000,'淮安市'),(85,320,320900000000,'盐城市'),(86,320,321000000000,'扬州市'),(87,320,321100000000,'镇江市'),(88,320,321200000000,'泰州市'),(89,320,321300000000,'宿迁市'),(90,330,330100000000,'杭州市'),(91,330,330200000000,'宁波市'),(92,330,330300000000,'温州市'),(93,330,330400000000,'嘉兴市'),(94,330,330500000000,'湖州市'),(95,330,330600000000,'绍兴市'),(96,330,330700000000,'金华市'),(97,330,330800000000,'衢州市'),(98,330,330900000000,'舟山市'),(99,330,331000000000,'台州市'),(100,330,331100000000,'丽水市'),(101,340,340100000000,'合肥市'),(102,340,340200000000,'芜湖市'),(103,340,340300000000,'蚌埠市'),(104,340,340400000000,'淮南市'),(105,340,340500000000,'马鞍山市'),(106,340,340600000000,'淮北市'),(107,340,340700000000,'铜陵市'),(108,340,340800000000,'安庆市'),(109,340,341000000000,'黄山市'),(110,340,341100000000,'滁州市'),(111,340,341200000000,'阜阳市'),(112,340,341300000000,'宿州市'),(113,340,341500000000,'六安市'),(114,340,341600000000,'亳州市'),(115,340,341700000000,'池州市'),(116,340,341800000000,'宣城市'),(117,350,350100000000,'福州市'),(118,350,350200000000,'厦门市'),(119,350,350300000000,'莆田市'),(120,350,350400000000,'三明市'),(121,350,350500000000,'泉州市'),(122,350,350600000000,'漳州市'),(123,350,350700000000,'南平市'),(124,350,350800000000,'龙岩市'),(125,350,350900000000,'宁德市'),(126,360,360100000000,'南昌市'),(127,360,360200000000,'景德镇市'),(128,360,360300000000,'萍乡市'),(129,360,360400000000,'九江市'),(130,360,360500000000,'新余市'),(131,360,360600000000,'鹰潭市'),(132,360,360700000000,'赣州市'),(133,360,360800000000,'吉安市'),(134,360,360900000000,'宜春市'),(135,360,361000000000,'抚州市'),(136,360,361100000000,'上饶市'),(137,370,370100000000,'济南市'),(138,370,370200000000,'青岛市'),(139,370,370300000000,'淄博市'),(140,370,370400000000,'枣庄市'),(141,370,370500000000,'东营市'),(142,370,370600000000,'烟台市'),(143,370,370700000000,'潍坊市'),(144,370,370800000000,'济宁市'),(145,370,370900000000,'泰安市'),(146,370,371000000000,'威海市'),(147,370,371100000000,'日照市'),(148,370,371200000000,'莱芜市'),(149,370,371300000000,'临沂市'),(150,370,371400000000,'德州市'),(151,370,371500000000,'聊城市'),(152,370,371600000000,'滨州市'),(153,370,371700000000,'菏泽市'),(154,410,410100000000,'郑州市'),(155,410,410200000000,'开封市'),(156,410,410300000000,'洛阳市'),(157,410,410400000000,'平顶山市'),(158,410,410500000000,'安阳市'),(159,410,410600000000,'鹤壁市'),(160,410,410700000000,'新乡市'),(161,410,410800000000,'焦作市'),(162,410,410900000000,'濮阳市'),(163,410,411000000000,'许昌市'),(164,410,411100000000,'漯河市'),(165,410,411200000000,'三门峡市'),(166,410,411300000000,'南阳市'),(167,410,411400000000,'商丘市'),(168,410,411500000000,'信阳市'),(169,410,411600000000,'周口市'),(170,410,411700000000,'驻马店市'),(171,410,419000000000,'省直辖县级行政区划'),(172,420,420100000000,'武汉市'),(173,420,420200000000,'黄石市'),(174,420,420300000000,'十堰市'),(175,420,420500000000,'宜昌市'),(176,420,420600000000,'襄阳市'),(177,420,420700000000,'鄂州市'),(178,420,420800000000,'荆门市'),(179,420,420900000000,'孝感市'),(180,420,421000000000,'荆州市'),(181,420,421100000000,'黄冈市'),(182,420,421200000000,'咸宁市'),(183,420,421300000000,'随州市'),(184,420,422800000000,'恩施土家族苗族自治州'),(185,420,429000000000,'省直辖县级行政区划'),(186,430,430100000000,'长沙市'),(187,430,430200000000,'株洲市'),(188,430,430300000000,'湘潭市'),(189,430,430400000000,'衡阳市'),(190,430,430500000000,'邵阳市'),(191,430,430600000000,'岳阳市'),(192,430,430700000000,'常德市'),(193,430,430800000000,'张家界市'),(194,430,430900000000,'益阳市'),(195,430,431000000000,'郴州市'),(196,430,431100000000,'永州市'),(197,430,431200000000,'怀化市'),(198,430,431300000000,'娄底市'),(199,430,433100000000,'湘西土家族苗族自治州'),(200,440,440100000000,'广州市'),(201,440,440200000000,'韶关市'),(202,440,440300000000,'深圳市'),(203,440,440400000000,'珠海市'),(204,440,440500000000,'汕头市'),(205,440,440600000000,'佛山市'),(206,440,440700000000,'江门市'),(207,440,440800000000,'湛江市'),(208,440,440900000000,'茂名市'),(209,440,441200000000,'肇庆市'),(210,440,441300000000,'惠州市'),(211,440,441400000000,'梅州市'),(212,440,441500000000,'汕尾市'),(213,440,441600000000,'河源市'),(214,440,441700000000,'阳江市'),(215,440,441800000000,'清远市'),(216,440,441900000000,'东莞市'),(217,440,442000000000,'中山市'),(218,440,445100000000,'潮州市'),(219,440,445200000000,'揭阳市'),(220,440,445300000000,'云浮市'),(221,450,450100000000,'南宁市'),(222,450,450200000000,'柳州市'),(223,450,450300000000,'桂林市'),(224,450,450400000000,'梧州市'),(225,450,450500000000,'北海市'),(226,450,450600000000,'防城港市'),(227,450,450700000000,'钦州市'),(228,450,450800000000,'贵港市'),(229,450,450900000000,'玉林市'),(230,450,451000000000,'百色市'),(231,450,451100000000,'贺州市'),(232,450,451200000000,'河池市'),(233,450,451300000000,'来宾市'),(234,450,451400000000,'崇左市'),(235,460,460100000000,'海口市'),(236,460,460200000000,'三亚市'),(237,460,460300000000,'三沙市'),(238,460,469000000000,'省直辖县级行政区划'),(239,500,500100000000,'市辖区'),(240,500,500200000000,'市辖县'),(241,510,510100000000,'成都市'),(242,510,510300000000,'自贡市'),(243,510,510400000000,'攀枝花市'),(244,510,510500000000,'泸州市'),(245,510,510600000000,'德阳市'),(246,510,510700000000,'绵阳市'),(247,510,510800000000,'广元市'),(248,510,510900000000,'遂宁市'),(249,510,511000000000,'内江市'),(250,510,511100000000,'乐山市'),(251,510,511300000000,'南充市'),(252,510,511400000000,'眉山市'),(253,510,511500000000,'宜宾市'),(254,510,511600000000,'广安市'),(255,510,511700000000,'达州市'),(256,510,511800000000,'雅安市'),(257,510,511900000000,'巴中市'),(258,510,512000000000,'资阳市'),(259,510,513200000000,'阿坝藏族羌族自治州'),(260,510,513300000000,'甘孜藏族自治州'),(261,510,513400000000,'凉山彝族自治州'),(262,520,520100000000,'贵阳市'),(263,520,520200000000,'六盘水市'),(264,520,520300000000,'遵义市'),(265,520,520400000000,'安顺市'),(266,520,520500000000,'毕节市'),(267,520,520600000000,'铜仁市'),(268,520,522300000000,'黔西南布依族苗族自治州'),(269,520,522600000000,'黔东南苗族侗族自治州'),(270,520,522700000000,'黔南布依族苗族自治州'),(271,530,530100000000,'昆明市'),(272,530,530300000000,'曲靖市'),(273,530,530400000000,'玉溪市'),(274,530,530500000000,'保山市'),(275,530,530600000000,'昭通市'),(276,530,530700000000,'丽江市'),(277,530,530800000000,'普洱市'),(278,530,530900000000,'临沧市'),(279,530,532300000000,'楚雄彝族自治州'),(280,530,532500000000,'红河哈尼族彝族自治州'),(281,530,532600000000,'文山壮族苗族自治州'),(282,530,532800000000,'西双版纳傣族自治州'),(283,530,532900000000,'大理白族自治州'),(284,530,533100000000,'德宏傣族景颇族自治州'),(285,530,533300000000,'怒江傈僳族自治州'),(286,530,533400000000,'迪庆藏族自治州'),(287,540,540100000000,'拉萨市'),(288,540,542100000000,'昌都地区'),(289,540,542200000000,'山南地区'),(290,540,542300000000,'日喀则地区'),(291,540,542400000000,'那曲地区'),(292,540,542500000000,'阿里地区'),(293,540,542600000000,'林芝地区'),(294,610,610100000000,'西安市'),(295,610,610200000000,'铜川市'),(296,610,610300000000,'宝鸡市'),(297,610,610400000000,'咸阳市'),(298,610,610500000000,'渭南市'),(299,610,610600000000,'延安市'),(300,610,610700000000,'汉中市'),(301,610,610800000000,'榆林市'),(302,610,610900000000,'安康市'),(303,610,611000000000,'商洛市'),(304,620,620100000000,'兰州市'),(305,620,620200000000,'嘉峪关市'),(306,620,620300000000,'金昌市'),(307,620,620400000000,'白银市'),(308,620,620500000000,'天水市'),(309,620,620600000000,'武威市'),(310,620,620700000000,'张掖市'),(311,620,620800000000,'平凉市'),(312,620,620900000000,'酒泉市'),(313,620,621000000000,'庆阳市'),(314,620,621100000000,'定西市'),(315,620,621200000000,'陇南市'),(316,620,622900000000,'临夏回族自治州'),(317,620,623000000000,'甘南藏族自治州'),(318,630,630100000000,'西宁市'),(319,630,630200000000,'海东市'),(320,630,632200000000,'海北藏族自治州'),(321,630,632300000000,'黄南藏族自治州'),(322,630,632500000000,'海南藏族自治州'),(323,630,632600000000,'果洛藏族自治州'),(324,630,632700000000,'玉树藏族自治州'),(325,630,632800000000,'海西蒙古族藏族自治州'),(326,640,640100000000,'银川市'),(327,640,640200000000,'石嘴山市'),(328,640,640300000000,'吴忠市'),(329,640,640400000000,'固原市'),(330,640,640500000000,'中卫市'),(331,650,650100000000,'乌鲁木齐市'),(332,650,650200000000,'克拉玛依市'),(333,650,652100000000,'吐鲁番地区'),(334,650,652200000000,'哈密地区'),(335,650,652300000000,'昌吉回族自治州'),(336,650,652700000000,'博尔塔拉蒙古自治州'),(337,650,652800000000,'巴音郭楞蒙古自治州'),(338,650,652900000000,'阿克苏地区'),(339,650,653000000000,'克孜勒苏柯尔克孜自治州'),(340,650,653100000000,'喀什地区'),(341,650,653200000000,'和田地区'),(342,650,654000000000,'伊犁哈萨克自治州'),(343,650,654200000000,'塔城地区'),(344,650,654300000000,'阿勒泰地区'),(345,650,659000000000,'自治区直辖县级行政区划');
/*!40000 ALTER TABLE `sys_city` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-23 14:02:35
