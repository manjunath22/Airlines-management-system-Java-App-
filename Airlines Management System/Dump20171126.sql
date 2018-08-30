CREATE DATABASE  IF NOT EXISTS `airline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `airline`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: airline
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `cancellation`
--

DROP TABLE IF EXISTS `cancellation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancellation` (
  `pnr_no` varchar(45) DEFAULT NULL,
  `cancellation_no` varchar(45) NOT NULL,
  `cancellation_date` date DEFAULT NULL,
  `fli_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cancellation_no`),
  KEY `fli_code_idx` (`fli_code`),
  CONSTRAINT `fli_code` FOREIGN KEY (`fli_code`) REFERENCES `flight` (`f_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancellation`
--

LOCK TABLES `cancellation` WRITE;
/*!40000 ALTER TABLE `cancellation` DISABLE KEYS */;
INSERT INTO `cancellation` VALUES ('200','201','2017-03-15','AI266'),('300','261','2017-03-02','AI274'),('81','300','2017-06-10','AI358'),('401','378','2017-03-08','AI359'),('49','401','2017-03-07','AI274'),('151','503','2017-06-07','AI913'),('80','58','2017-06-01','AI933'),('80','67','2017-08-09','ai274'),('121','76','2017-07-06','ai359'),('667','78','2017-05-09','AI9731'),('56','8','2017-05-08','AI266'),('56','87','2017-03-08','AI266'),('300','90','2017-06-05','ai274');
/*!40000 ALTER TABLE `cancellation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `f_code` varchar(45) NOT NULL,
  `f_name` varchar(45) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `dst` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('AI266','AIR INDIA-9','PATNA','DELHI'),('AI274','AIR INDIA-3','HYDERABAD','CHENNAI'),('AI358','AIR INDIA-7','DELHI','PATNA'),('AI359','AIR INDIA-6','CHENNAI','PATNA'),('AI913','AIR INDIA-10','MUMBAI','HYDERABAD'),('AI933','AIR INDIA-8','HYDERABAD','BANGALORE'),('AI951','AIR INDIA-4','BANGALORE','PATNA'),('AI970','AIR INDIA-5','MUMBAI','CHENNAI'),('AI9730','AIR INDIA-1','BANGALORE','MUMBAI'),('AI9731','AIR INDIA-2','DELHI','CHENNAI');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `pnr_no` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `ph_no` varchar(45) DEFAULT NULL,
  `passport_no` varchar(45) NOT NULL,
  `fl_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`passport_no`),
  KEY `fl_code_idx` (`fl_code`),
  CONSTRAINT `fl_code` FOREIGN KEY (`fl_code`) REFERENCES `flight` (`f_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('','','','','','','',NULL),('91','JP NAGAR','INDIA','AJAY','MALE','9945266352','J836982','AI358'),('120','BSK','INDIA','PRIYA','FEMALE','9945266353','J836983','AI359'),('200','KORAMANGALA','INDIA','UDAY','MALE','9945266354','J836984','AI266'),('400','KS LAYOUT','IRAN','SALEEM','MALE','9945266355','J836985','AI913'),('331','JAYANAGAR','INDIA','SATHISH','MALE','9945266356','J836986','AI933'),('81','KENGERI','AFGHANISTAN','IRFAN','MALE','9945266357','J836987','AI951'),('49','BTM LAYOUT','CANADA','RICHA','FEMALE','9945266357','J836988','AI970'),('82','HSR LAYOUT','INDIA','RANJITH','MALE','9945266358','J836989','AI359'),('401','AGS LAYOUT','INDIA','NAVEEN','MALE','9945266359','J836990','AI913'),('409','ISRO LAYOUT','INDIA','MADHU','FEMALE','9945266360','J836991','AI970'),('500','NAYANDAHALLI','INDIA','BHARATH','MALE','9945266361','J836992','AI951'),('300','KENGERI','AMERICA','MICHAEL','MALE','9945266362','J836993','AI9730'),('320','RICHMOND TOWN','INDIA','VERONICA','FEMALE','9945266363','J836994','AI9731'),('200','HSR LAYOUT','INDIA','MANJUNATH','MALE','9945266364','J836995','AI913'),('151','ISRO LAYOUT','ENGLAND','DAVE','MALE','9945266365','J836996','AI359'),('349','KORAMANGALA','INDIA','CHAYA','FEMALE','9945266366','J836997','AI358'),('461','RICHMOND TOWN','INDIA','MURALI','MALE','9945266367','J836998','AI913'),('441','JP NAGAR','INDIA','ANUPAMA','FEMALE','9945266368','J836999','AI933'),('412','BSK','INDIA','VIJAY','MALE','9945266369','J837000','AI9730'),('419','UDUPI','INDIA','MONICA','female','9945678945','J837001','AI951');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `pnr_no` varchar(45) DEFAULT 'null',
  `ph_no` varchar(45) DEFAULT 'null',
  `cheque_no` varchar(45) DEFAULT 'null',
  `card_no` varchar(45) DEFAULT 'null',
  `paid_amt` varchar(45) DEFAULT 'null',
  `pay_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('56','9945266350','0046234','-','15000','2017-01-01'),('80','9945266351','0086001','-','20000','2017-01-03'),('91','9945266352','0096021','-','15000','2017-02-05'),('120','9945266353','0015020','-','20000','2017-02-07'),('200','9945266354','-','5195501955019','25000','2017-01-09'),('400','9945266355','0805010','-','25000','2017-02-11'),('331','9945266356','0915420','-','25000','2017-03-14'),('81','9945266357','0315020','-','15000','2017-03-18'),('49','9945266358','0815121','-','20000','2017-01-16'),('82','9945266359','0025020','-','15000','2017-02-20'),('401','9945266360','0515821','-','15000','2017-03-24'),('409','9945266361','0235121','-','15000','2017-03-26'),('500','9945266362','0345830','-','25000','2017-01-28'),('300','9945266363','0345760','-','25000','2017-01-07'),('320','9945266364','0565431','-','20000','2017-02-03'),('200','9945266365','-','5090051055019','15000','2017-01-11'),('151','9945266366','-','5090062055019','15000','2017-03-04'),('349','9945266367','0419321','-','15000','2017-03-18'),('461','9945266368','0419321','-','25000','2017-02-19'),('441','9945266369','0319321','-','20000','2017-02-11'),('411','9945266370','0328972','-','20000','2017-01-17');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `pnr_no` varchar(45) DEFAULT NULL,
  `ticket_id` varchar(45) NOT NULL,
  `f_code` varchar(45) DEFAULT NULL,
  `jny_date` date DEFAULT NULL,
  `jny_time` varchar(45) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `dst` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `f_code` (`f_code`),
  CONSTRAINT `f_code` FOREIGN KEY (`f_code`) REFERENCES `flight` (`f_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('331','AB650','AI9730','2017-06-02','5.30PM','BANGALORE','MUMBAI'),('81','AB651','AI951','2017-06-03','6.00PM','BANGALORE','PATNA'),('49','AB652','AI9731','2017-03-10','7.00PM','DELHI','CHENNAI'),('82','AB653','AI970','2017-04-20','4.00PM','MUMBAI','CHENNAI'),('401','AB654','AI9730','2017-03-11','4.00PM','BANGALORE','MUMBAI'),('409','AB655','AI274','2017-04-07','4.00PM','HYDERABAD','CHENNAI'),('500','AB656','AI358','2017-05-08','7.00PM','DELHI','PATNA'),('300','AB657','AI951','2017-03-09','8.00PM','BANGALORE','PATNA'),('320','AB658','AI359','2017-04-07','5.30PM','CHENNAI','PATNA'),('200','AB659','AI9731','2017-04-01','5.30PM','DELHI','CHENNAI'),('151','AB660','AI933','2017-06-10','4.00PM','HYDERABAD','BANGALORE'),('349','AB661','AI266','2017-01-11','2.00PM','PATNA','DELHI'),('461','AB662','AI9731','2017-02-21','7.00PM','DELHI','CHENNAI'),('441','AB663','AI933','2017-02-20','5.00PM','HYDERABAD','BANGALORE'),('411','AB664','AI9730','2017-03-17','3.00PM','BANGALORE','MUMBAI'),('56','AB665','AI274','2017-01-03','3.00PM','HYDERABAD','CHENNAI'),('80','AB666','AI9730','2017-06-07','8.00PM','BANGALORE','MUMBAI'),('91','AB667','AI358','2017-03-12','7.00PM','DELHI','PATNA'),('120','AB668','AI9731','2017-02-17','5.00PM','DELHI','CHENNAI'),('200','AB669','AI913','2017-03-19','4.00PM','MUMBAI','HYDERABAD'),('400','AB670','AI9730','2017-04-11','3.00PM','BANGALORE','MUMBAI');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `flight_code` varchar(45) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `class_code` varchar(45) DEFAULT NULL,
  `class_name` varchar(45) DEFAULT NULL,
  KEY `flight_code_idx` (`flight_code`),
  CONSTRAINT `flight_code` FOREIGN KEY (`flight_code`) REFERENCES `flight` (`f_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES ('AI9730',550,'A','FIRSTCLASSDISCOUNT'),('AI9731',800,'C','BUSINESSCLASSDISCOUNT'),('AI274',600,'F','FIRSTCLASS'),('AI951',500,'D','BUSINESSCLASSDISCOUNT'),('AI970',550,'B','ECONOMY/COACH'),('AI359',600,'V','SHUFFLESERVICE'),('AI358',700,'A','FIRSTCLASSDISCOUNT'),('AI933',700,'F','FIRSTCLASS'),('AI266',800,'C','BUSINESSCLASS'),('AI266',500,'V','SHUFFLESERVICE'),('AI913',500,'V','SHUFFLESERVICE');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 19:34:07
