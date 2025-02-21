-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: headphonereview
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(70) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (29,'test','test@gmail.com','{bcrypt}$2a$10$kdIHYibQxjb6Qa2/TBaH/O/DMYfHLnHrUke1mZDTRsFGXxmaCYsfa','2024-10-19 19:56:48'),(32,'qwe',NULL,'{bcrypt}$2a$10$b4nucklDxtyi20Mu2t5y1eEJFF3NGCnKzpDXH1Bu4aBmQnDtiuOta','2024-10-25 21:33:25'),(33,'123',NULL,'{bcrypt}$2a$10$sCEcskf/PTBfrlpfTWg7wuUz/o0nUZ37rN/SCGRdKerLpmoIBC6qa','2024-10-30 21:35:03'),(34,'test1',NULL,'{bcrypt}$2a$10$JZTmN8ba64/ePA62ijXWAOSp9KUdrG/8OGduVo7X943PsS6SKEXIm','2025-01-07 20:36:29'),(35,'test123',NULL,'{bcrypt}$2a$10$5WKZ4/V/2s0meNX7x37kjupz//1YFP36lBMZ.pfL3Y/3u8XY.uGcS','2025-01-07 21:52:33'),(36,'test2',NULL,'{bcrypt}$2a$10$3YMyiCh98TImzg547ohw0eMUxrH66.PqAuzH4D/LHKeamUn9zCbLC','2025-01-12 17:52:56'),(39,'kl22965331','johnny36485@gmail.com','{bcrypt}$2a$10$rmjeq13AuVjSToYOzjEVAOkJTuA7m/mVDVziAPS0u77rS.M8TU4Cy','2025-01-21 19:45:17');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-19  4:20:49
