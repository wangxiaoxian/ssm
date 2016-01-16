-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: wxx_store
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `store_goods`
-- 

DROP TABLE IF EXISTS `store_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `price` int(11) DEFAULT NULL COMMENT '最新价格',
  `goods_no` varchar(16) DEFAULT NULL COMMENT '商品编号',
  `goods_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
  `brand` varchar(64) DEFAULT NULL COMMENT '品牌',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_goods`
--

LOCK TABLES `store_goods` WRITE;
/*!40000 ALTER TABLE `store_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_income_log`
--

DROP TABLE IF EXISTS `store_income_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store_income_log` (
  `income_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,自增',
  `goods_id` varchar(16) DEFAULT NULL COMMENT '商品id',
  `income_time` date DEFAULT NULL COMMENT '进货时间',
  `income_quantity` int(11) DEFAULT NULL COMMENT '进货数量',
  `quantity_unit` varchar(16) DEFAULT NULL COMMENT '数量单位',
  `product_time` date DEFAULT NULL COMMENT '生产时间',
  `expire_time` date DEFAULT NULL COMMENT '过期时间',
  `suplier_id` varchar(16) DEFAULT NULL COMMENT '供应商id',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `quality_time` int(11) DEFAULT NULL COMMENT '保质期，单位天',
  PRIMARY KEY (`income_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_income_log`
--

LOCK TABLES `store_income_log` WRITE;
/*!40000 ALTER TABLE `store_income_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_income_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_price_change_log`
--

DROP TABLE IF EXISTS `store_price_change_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store_price_change_log` (
  `price_change_log_id` int(11) NOT NULL COMMENT 'id字段,自增',
  `goods_id` varchar(16) DEFAULT NULL COMMENT '商品id',
  `price` int(11) DEFAULT NULL COMMENT '最新的价格',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`price_change_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_price_change_log`
--

LOCK TABLES `store_price_change_log` WRITE;
/*!40000 ALTER TABLE `store_price_change_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_price_change_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_user`
--

DROP TABLE IF EXISTS `store_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码，md5加密',
  `nickname` varchar(128) DEFAULT NULL COMMENT '昵称',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_user`
--

LOCK TABLES `store_user` WRITE;
/*!40000 ALTER TABLE `store_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-16 14:50:35
