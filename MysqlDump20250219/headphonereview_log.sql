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
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(10) DEFAULT NULL,
  `message` text,
  `time_stamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'INFO','getUser 被調用','2025-01-29 03:26:46'),(2,'INFO','getUser 被調用','2025-01-29 03:28:29'),(3,'INFO','getUser 被調用','2025-01-29 03:29:27'),(4,'INFO','getUser 被調用','2025-01-29 03:31:18'),(5,'INFO','getUser 被調用','2025-01-29 03:34:01'),(6,'INFO','UserController.getUser 被調用','2025-01-29 03:35:03'),(7,'INFO','UserController.getUser 被調用','2025-01-29 03:35:39'),(8,'INFO','UserController.getUser 被調用','2025-01-29 06:35:39'),(9,'INFO','UserController.getUser 被調用','2025-01-29 06:35:46'),(10,'INFO','ReviewController.getReviewsOrderByViewsCount 被調用','2025-02-01 01:37:20'),(11,'INFO','BrandController.getListOfBrand 被調用','2025-02-01 01:37:20'),(12,'INFO','UserController.checkTokenExpired 被調用','2025-02-01 01:37:20'),(13,'INFO','UserController.login 被調用','2025-02-01 01:37:32'),(14,'INFO','ReviewController.getReviewsOrderByViewsCount 被調用','2025-02-01 01:37:32'),(15,'INFO','BrandController.getListOfBrand 被調用','2025-02-01 01:37:32'),(16,'INFO','UserController.getUserByName 被調用','2025-02-01 01:37:34'),(17,'INFO','ReviewController.getReviewsOrderByViewsCount 被調用','2025-02-01 01:37:37'),(18,'INFO','BrandController.getListOfBrand 被調用','2025-02-01 01:37:37'),(19,'INFO','HeadphoneController.getHeadphones 被調用','2025-02-01 01:37:38'),(20,'INFO','BrandController.getListOfBrand 被調用','2025-02-01 01:37:42'),(21,'INFO','ReviewController.getReviewsOrderByViewsCount 被調用','2025-02-01 01:37:42'),(22,'INFO','BrandController.getHeadphonesByBrand 被調用','2025-02-01 01:37:43'),(23,'INFO','ReviewController.getReviewsByHeadphoneId 被調用','2025-02-01 01:37:46'),(24,'INFO','ReviewController.getReview 被調用','2025-02-01 01:37:48'),(25,'INFO','CommentController.getCommentsByReviewId 被調用','2025-02-01 01:37:48'),(26,'INFO','CommentController.addComment 被調用','2025-02-01 01:37:57'),(27,'INFO','ReviewController.getReview 被調用','2025-02-01 01:37:57'),(28,'INFO','CommentController.getCommentsByReviewId 被調用','2025-02-01 01:37:57'),(29,'INFO','ReviewController.getReviewsOrderByViewsCount 被調用','2025-02-01 01:38:03'),(30,'INFO','BrandController.getListOfBrand 被調用','2025-02-01 01:38:03');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
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
