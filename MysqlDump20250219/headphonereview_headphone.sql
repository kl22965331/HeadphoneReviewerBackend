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
-- Table structure for table `headphone`
--

DROP TABLE IF EXISTS `headphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `headphone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `price` int NOT NULL,
  `image` mediumblob,
  `create_date_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headphone`
--

LOCK TABLES `headphone` WRITE;
/*!40000 ALTER TABLE `headphone` DISABLE KEYS */;
INSERT INTO `headphone` VALUES (9,'T1','Beyerdynamic',39900,'','2024-10-30 05:25:43.200222'),(10,'T2','Beyerdynamic',39900,'','2024-10-31 05:14:08.079622'),(11,'T3','Beyerdynamic',39900,'','2024-10-31 05:34:21.665616'),(12,'n5005','AKG',29900,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	( \Z&#=!%)+../583,7(-.+\n\n\n\r1+++-+--+-+------+--+--8------+----8----+-7+++77-8+ÿÀ\0\0\á\0\á\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0G\0\0\0\0\0!1AQ\"2aq‘¡#BRbr±‚’¢Á\ÑS²\Âð35CD\áñ$%4³\Òÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\01Aÿ\Ú\0\0\0?\0¸¢\"\" \"\"\" \"\".µn!#4Ò²1\Õ\îkñ—k¨[Æª/c˜ÿ\0\r\Ðf\Ñk\Í\Û|<€~—‰·\Ú\Zü4]úm ¥\åeL.<l\Ëü.ƒ$‹\ã\\¸7F«\ê\" \"\"\" \"\"\" \"\"\" \"\"\" \"\"\"øJ*º¦D\ÇI#ƒX\Ñw8\è\0S¤Þ‘\ï2•¹ýó\ìIü¬þ·ôX]ºÚ‰1\n“G\Ë\ZKcc²¿†nš\ë\è:\\­\Ûbw(Žz–¶Z 8ñŽ/&½Ç¥”Tò“gq<C\ë{\'œ\Çý­KŒ^–oŒ·\ÐYlnŠwe®ct°Ã˜þóu[D\áÔ¯ÿ\0\'4û„žT\Ëkÿ\0UŽ­\ÝcA0\Ö\Å!\ä$ˆÅ§›†o\ÑYQ8u;;ŽQXG\ËF¤\ÓIpdO\î®\Î½ŠÈžc©±#‹&Œ\Æñ\î\Ëe÷]GÁ©\ê™\Ù\Ô\Â\É[\Ñ\í\Þ`ñió	Ã¬\Î\íý%Pk\\\áŽ\Ð6B\0qü/\à}\r’\ÛŸh·:\Ý_†\Ìb<{o$dô7s}ó{-^‹jq<*FÁTÔµ²ZH\\®¹°ü§ž¶Nœz«²{qh\r?U/®#+¿+¹ú}VÔªˆ€ˆˆˆ€ˆˆˆ€ˆˆˆ€ˆˆE\Þ\Æ6\èi„:\Ò\Ïq¡±\È5\"ü®l=.·¥\0\ÞŸ[‹KO\ï\Æ\èá‰§š\Ü\Ã÷Ë”«†\ç6{\ê\Åt\Ìú\ÎüQ_P\Zg¼y’2ß =U=pP\Ó£dm\àÆµƒ—eÎªˆ€ˆˆˆ€ºX¶Tf*˜™+\Ùx_¨\è|Æ«ºˆ!;c»ZŠ\Õ\Ïó:	’1\Ôeñ´uö\âŸ\Ý\îó[&Xj\\@\0HOy¾O¿ø¿^\"®¥›\ÉÝ·iž·gt€2\ÍÔ´r—ë©œ^ªMp\"\à\ÜA_Tkv“-%A³AÉ¯u\Ñ:ü2r_\áñV@UG\ÔD@DDD@DDD@DDD@^~\Ø\æ\ÇUµ\Î%²6¢y8‘\ãß‚ô\nóþ\î§cq†¶VZFI4a\ÝM\å`\â²•c\Ðˆªˆ€ˆˆˆ€ˆˆˆ‚M½ÝŠ#6\'F-#\çŒ‡´q[P@\ãn _ˆ\×\'º]®mD-¦‘\Ýöƒ\Ù\ë{´qeú·§EE!@6\Ïv‰6¢\Ú	\ÚD[ ‰\ã\Å\ïù]øTW cvwm]<s´[0\ïºá£‡\Åd•A@±\Ç\ÉAŽJ{0YÚŠ†zH;Co.\ÐH>>Jú¦[\îÀžø#­„\èImýÓˆ\ï&>\Ç\È9Ç…Ô«¸¤hp\à@#Ð‹…úZ\ë6 M¦•÷•žoqk–ƒÌ}­\È-ýTk›À\Ù\æWQM›wµ¦H$h%¶>z´ù8­F7)\È\Ù\r,·9´óh\'1´>aY\Ô_m(FŒ\ÃXX\åse³l<\rc$ŽÃ…\Å\Íùö„+4R\0æ›‚¨\"\à©¿Hˆªˆ€ˆˆˆ€ˆˆˆ€¿\Ä\Ò\×\0Z\àZA\ÔEˆ#¥—\í@v³e\'Á§úU0s \Ív<_\êõ¸ý-\ÉüøJ\ÞvGy‘\Ë[Z;)>ð\ä\\\Ñ|¾¼=F\×\0AÐƒ¨#¡Ô·o÷aM\Ø\ÍWH\É,l2c\Ö7[W²\×iµôn‡¢œVJ“|{\Þöå¹M³:=\â°qp %”yXiÿ\0˜#\Ö9‡ùš°üPG#\Ý÷€u‰\Ñf#\Çc>&Q\è&\ï?óm÷l£õj\ì\Ó\í¶!\re\\dž\ä\ìBóôx;¸‹.\Äf™\Üo0lG˜<z›CHtP_§hÀ~\Ýdcxp»H#¨7\ÏQ\àôÒ‚È±b\á\Ã,ŽdŸ’?E\Ó\Ãð“a\îkš\ç0º7:<Å®-\Í\Ý<\ìƒ\Òh ´[a‰\Ñ8\Ø\ÔGÍ“w\î<Ÿ\âió¹EWöKi\á\Ä!\íb»\\;²F\ïn\èzƒÈŽ?6ˆˆˆ‚y¾œ9¯¤ŽbÛº)@\äXò34žZµºù[\ÖÇ°X\Ò()äµ»½ŸOön1\ßøW\ïni{Z\n¦e\Ì{\'8\êÑ˜\æ¸ó]\Ü\ÍS\ßG#^A\É)\róicu÷9½î§«\ãDEPDDD@DDD@DDD@D\\U5,¥\Ò85£™\ÑOÀijª)¡—ó\ÆÇŸ‰GÆ·-‡MsiL\íOÕ¸½—=Y%ôò,\å~\ÞÀ\Ãf5\ÏóÑ¡tY¼¸A\ï\Ä\à:‡ò  ˜c›•\Ä!¹¦’:–Ž\0\ÆCû/9‰hø¶YI¤\ÓM,\Îcƒ}\á?\é—\íõh%\î¹\00“\éq¥ýÖµml•t\Õ@G’­\Ë\Æy{‡º…—\á{;Ëª;Š‘\Ìòý®tq¶\ÇN6÷X\nxL¯hW\04[ž³Ï›»NÀö·º\é¥.\ì\æÁâ·Ÿ\É;1€ö\Ù\Ë)°˜á¤®\à÷DRŽEŽ6¹ü¦Î¿‘\êW$›º”\ê*c¿Ac~N?¢\èÉ°õ\Ì\à\"\äyø\ÚzIf6‰µM\È\æ>\Ø\Ð_€[@^\Ò	2ÿ\0i§K‹\Ø\è³\ÈˆƒŠ®2\æ=­6.kšBA\0©~\äl\×VG›PYÜ½\Ãrº@\à:\êF¾jª¤»¦\È\ÌB¶&ƒp\×Y\Ýcd¡¬>Dƒ¯¢—bÌª\Ò\"*‚\" \"\"\" \"\"\" \"-kl¶¾*r|®ð²ö·\âwAú \Í\âX„p0¾Wl9¸{Ì¨\Þ\Óm;\êI6hð´púù¬~%]W3]YQ›#\Ý\Ø\Æ\ã£o«ˆcy4ðZ\ÍEZ„õ‹U+ˆ>…t\ßX¿Omb0L@³B\â\ZIq\×@M®\ëu°¾ÿ\0\âH\Z[+l†½¥®µÇ²\ìF\ím4ø\\sV5”\ï·m|ùlDmñHA\åp-nW\èªð†D\Æ\ÇCXÑ”\Ð(N]$/‰ÅŽ\0‹\"Çˆ²Ý¶Sk¤t‚*—£_`\Ò\Èiª\rø\ÔZ\Ú\Úü5\â¹T\à±XŒ.x!¶\Ðfm\Å\îñ\Þa\Z\ÜY\Í— ‡]¬p\Ì\\\à\Ëõ˜°6û&\Ç_¼=m˜mVg7€{Nh\Ü~Ë¸~\é\Z\Ì·\è%\ÌÖ¸ip\r\ä|\Ô^—ŽI&F÷ldq÷7ñ\ê8zh«\Ø,Ð±À\Ü;3\Z‚\ÜE¼w‘J7n\çkW\0\Ð~}nÁ“\Ûùªº”\îñŽþØ¯sÎ 9¿·eÏ¥¿Öª_z«\"\"¨\"\"\" \"\"\" \"/Ä²´¹\ÆÁ ’O\0ƒ¶{L\ÊŽ±y»cg\Þu¸ú=Ø­˜“•Õ•„˜Kƒ€:v®Fºöcþ‹©–Lk½È·\æØ›\Ï\É\Î?¯’³\ÒÓ¶668\Ú\ZÖ€ÖÀ\0,‹Wy˜A›{bn°–\ÊÖ´rh-p\0tcð^p­˜‚½|¥;yºq35V¸Üº\Ýi=Xx7ò<\ÇQ– ®9[+±u¸‰)¥o\ì8g\r\n\â\Ãö6®g4®ôc­ñµ‚\rm¬»­\ÕlT\Ø\\ÀZ\ç|´<\Ç\\\Ø\Ñögµ\Ä\Z\Çh@‹\ÄEÅ‰/ù~+![º£Ë¨\ænSÿ\0k\Û÷\Úø~(!U#\Ûr\r\í\Ê\Ö%t£z¼O°\Ö +\ØG¶b	ø-sÝ‹¤q=”±¿«X\ç\ë`[t\Z5\Ô\ÕF\0l·€xù~k%\Ý\Ô#w³›ü\ÖR}\ÒÕcù£#ô+\í\çqº\Î±¿yÎ·\Ê\Äük¥F#S~\'\È\à\Æ5¢\Ím\Ït\çr½U„Ð¶ž g†&21\èÖ’‹3g±k¨\Æ|\åö{ŸkkŸ+š?\r’º \"\"“\î¼0\â•\Äj\à$\ä[\Û7+¿ký•Y\î°\' º“\îj£=Ua\Ën\ë\\<®y\Ê\ß<¶!K±fUiAk{Â¯P\Ê,¤&ƒ\Â\ä\ä\n\Ù\ëxdTV\ÑQ@sƒ\É‰wÿ\0~*\\Y¬¾\î6q´´í´‰fk] ?gRCGM\nÛ—Æ‹h¾ª‚\" \"\"\" \"\"\" ˜\ï–ÁôG04š[[Yºÿ\0®ª•LnÆŸ\Â?E-\Û9þ›ŠAKk„D5\Üõ.¼šù4|•TõG{\Ü\"³\Ä\â\Ûð\Ì\ZmóR}Ä‡kI7hlYM‡\Ú|¤\ë\Ë\Â4óT½©u¨\ê‰~O©—½÷~­Ú©\æ\á\"+^\Þ|C\Ò\Íy\Ëo,\ß5.Å™UtDUD@DDD@DD>¡\Í6;+®Ü°°‚\Þ`\å\ryœÊ‚§{g\âx„™MÁ°w\"\Ó!ù\éòRø³\ÕAk»cµ\Ð\áñ‚þôŽ¾HÁ±>g R\Zý\é\â<öNŽh°÷7%k[{º®ºg_Lî¾Mc‹G\éuø¦Œ5 v÷þþþ\Ìþ‹-‚\í\Ö+!{\Z#€¹sY”a\ÄXðZ`câº¸”Jö\nl\îq&á·½¸ý’¬¢‡_¼lV•\Í\í¢„‡@wx›q\ï0Ž£’\ìR\ï¦Oø´M>l‘iýT\á›%‰¼\åm-D‡®We´ûß‡wX‘ñ¶|¥ž&ŸƒI*\nmø\é\ß#%4‘µ\Ä4¿3\\}35²\å\Ú\íå±­1\Ñ]\ïq\íll\Ò~\ëx¹\Þ\ÖZV¹\êÇ¾3-D,À¼\Æ÷H\ì·\Ô7º\Õo\0Øª:Gv‘\Æ]\'÷’\Ñ\ã\È_Fû=\Úl³\á«©M&l­w‰q¹.ün°ô\ë~D@DD\Z\îð\çk0Ú²\á{Ç÷ž\à\Æ{fsV«¸h¿ôS¼\êdE$—þk7½º‡3Ÿ(ò\Æu°/þº[Ô®®\å\â#kˆ\0\É,\Î u\ÉþE=_\Ú\"*‚\" \"\"\" \"\"\î¼Þ£9\ïõƒ»÷Ng\ß\ÙQ\ëuŸüŒ@d·}¶w\ÞŸou.Å™TTDU\Ç<\ÍcKœl¹\Ç|bú7Á®‘\×$[P\Öÿ\0™3¢’:Ú†e=\Ù^nxe/.i¿¡·n“W9t]|o|\î.}6\Zpep\ÙZ\0\ÒútºÀ¡oE\Ç6H¬EÃ¹X}ˆà»›»\Ãýj°Ø­@°<\Ðm¬\Ûúß£ˆ;²ƒ£¯y2\Û\Â_ÄŸšÀMŠ½\ÇW}V¹ô²y®\Í\âú \Úpl~¦‡\Å#šGC¡õ\n»l&ÖŠ\èò\Èf`\ïÁ\Ã\ï\è¼÷O\\À¶}„\Æ$\"ð=\ÄI\æ-¡\ÑM÷\ë5¨¡f|¹\æ\0‹ø­\È6\æ¬}l¶-\ÚS˜ðº6ž&0ó\ÏW’ó\í\ÞS\íÿ\0Õ°\ÉM\r\Î`\Ém¨å¡‡\Öñ»\à«x5 †ž€°Ž8\ã\0pX¾Jz¾;ˆˆªˆ€ˆˆˆ€ˆˆ\no»b~$\Ì÷9\î[\È\Ñ\×#\ËQñT…3\Øg–\ã\ì\ì\ì\Òsse\à~?¢—bÌªb\"*‚Žoÿ\0{þTÀHht.\×3Oø•uq*\ê#tR·3\\,‘Aã™¨\ßlÅ¤\Z‹.j\Zò\Î\ë½:+v/»9\ZOf¬>\Öóù-r£tÓ¿\Ã·Gr÷4\âWi\ZjoóXª\ÙnªP\î^ ò·«¬s\n\Üdw¦m>\ìw$ùfw‚Cb%·	\Õ\Õ;¶ÃŸN\Úq\0`m\Ë^\Ý$ñ%\Ç\Å\î´z\ÝÅ‚ïªª5ùPCâ«&\ä6y\ÒH*¤a\rˆœ¯<Hð\Î\Ün³ø\åi¢puD®š\Ú\åh\ì\Ú}M\É#\à©Ô´Ì‰Ž6†1¢\ÍkE€ˆ9Q|s€:©(!\Ûs#ªñøiò6H!\ZØ\Ò\'s\ÏC«ý›\æ®J»v>³’¥\Î\ÎÖ‰g.ñ\âDMh<…žm\ä\ÅrR-T·´{E8/9ž\×\Ø}—]­p ðU%/®\Í\ÑDZÁg‹m~ôF\î‘R¬TT¯¼¬Q´øuAq7‘Ž€q.{Hö°¹ôm\n?¿<e\Ù\à£cn;³;™sž_>~¹‚—k¿¸Œ,6\nŠ®&Y\Z\Z	\Óó¹\ß\ÑTV#dpŸ¢QS\Ó\Ú\Æ8\ÚùÈ»\Ï\ï²\é\n\"\"¨\"\"\" \"\"\" )v\Ù¿ðÿ\0Hÿ\0ûˆ³ô±QDE¤;x?\ï\Ö~z/ñµgé¯\\Qi‘ÿ\Ù','2025-01-09 06:41:42.916797'),(13,'dt770 pro 80hm','Beyerdynamic',4990,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	( \Z&\Z!2!&)+... 383-7(-.-\n\n\n\r+-+++---++----.-2--+-++++++-+/-7--5-++-+-++6+-047++ÿÀ\0\0\á\0\á\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0F\0\0\0\0\0!1AQa\"q2‘±#BRb¡Áð3r‚\Ñ\á$CS’¢²4£\Â%6s“³ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0ÿ\Ú\0\0\0?\0œQ%~ÒŠ\ï¾xgzñ/Ž†\åÑ§^H2\ÑYö¦Y§,\ït\â#÷yú*ûC5\Ä\Þ\'Q \×\à‚\ê+>\Õ\Æ\Ë!cslòX\î\Úð	„VwŽkœ~ ;=‹€¶¹¦\Z\ÎEiõ,»\Ú-­\Ü­Ï’\Z†_&\Þ×µ\Å\í\ÎÜº ºŠÏµGöÙ¨ð÷Ž`y‘ÁX¤Ú±JÀö;\"\ç1¸Ã£%\Í6 5\à˜\Ö\ÙðLMf¢OiN,uTD\æ÷\Ù	©ÙŒ6ý\Þa\ãGs.+uº;\à+¤’>\äÇ‚(%i\Æ³³\à,Z\ë´ù-ßŸRmŒ\Îù·B\",6\"\"\" ¢ª\"¢ª **¢\" \"\"\" ._¶µqÓ¶E\'uPÉŸ®,c\Ø\Ø\åii!§Rð4\Òúèº„W›—bY³½šÕ–DˆŒ´\Ä\ÉX\ÑNd™Ò´\Æù “+8Z\Z\àZ,VE^\â\Ï3«cŒadnµ\'y\ák\ÄÒ¶¦ \\‚0—\0\á#,Á\nWE\ÓÛ¦<\â7\Ø]Ÿ¹³\Ã%DL\î\ØÉŽ#Y+\äc˜Z\"Š6Xa.°h\Ä\ÎkYI\Ù\Ü\í\ìž(\0\ÕºHœ\ç\Ë<®{dŠb\Â\Ñ\â¢\Â\äøGKKhž\Ý/\â\"È·i\ã†i\ãˆ\É$UrN\Ù2\"¦¨4\Å\á±÷0´k–\0x+³ú\Òc%”¡\Ñ\Æ\ÖµÀ9\ã\Øûƒ\Æ<n!ù{Á¸máº–‘=ºO8Š[Ù¼Áƒt\á\â:\ã”ð8\Z‡\ß®ÚžŠö\Ï\ÜJ˜\ê#–Hijy$pörú—\Ì&Ž\Í8…\Ã,Û­” ¨B{t¾qVm\ßY%@>V\Í+O%;ƒ\ß\ä\ìC>>‹\Ù?´¾\ÇötT\Íwœ¸¦oúHRp\Ùð\Ú\Ý\Ôvµ½\Æ\ès#MÈ co…­m\í{\0/l…\íª\×_m\çóŒÏž]\Õ\ÔD\\Eó$ ¹\Ä\03$›\0:•Áo§i°Rb†—óŒ\ÑG\ÏÇ¼\áöF|\ÈP–ôoU_ýUCž/û1\áˆt\îÛ‘·nz«‚{\Û¦l\Êr[\ß÷®V™\Ô<?Š\ç\Ûm5ü4•ut`üŠ‚’¸]ŒË™\ÉTC-\ì\\\Ûð\É0z#dvÁ³¦!²™i\É6úV]¿\ça ;.ò–¥’0I\Úö;0\æ\æ‘ÐŒŠñðGP¶Û»¼õt½,\ÎcI¹a³£w›W\ê,z¦X¢÷+µ\Zj¼1Tá§œ\è	ú7þ\ãÎ‡\îŸBW~\n‚¨ˆ€ˆˆˆ€ˆˆ(ª¨ª€ˆˆˆ€ˆˆˆ€ˆ…Ì\r\Î \0.I6\0\rI<„ûD\í-\ÓS\Ñ=Ìƒ0ù…Ã¦\æ#\â\Øú\ê\îƒZö§¿b£3ÿ\0³´\ÚYý»‡\Ôiÿ\0q?[\ËÞ‰¥¼®\ÌÙœ\í.™+\Ã\æ|ž\ÆŽ6ùq´\ì‰À\Ø8õ\Î\çòWqg…‡\0u\Zhz|¾Ëš|Mô9´ùQP÷:\ãK+F/ž«>02·õøGBº-\Ö\Ý:š÷\áŠ;F=\é]v\Æ\ß#õ\Ý>Z \ã\Ú\\=\íÁVF)‰ÝŒK˜ö¨ˆ<\ãp¿˜\Åø¨\×zwvmŸR\êi‡\ÞcÀ8da\Ñ\ÍùÀ„\ZX&-9eýrù*v_\Ú+i¿²Ö¼ˆM„rKb:XŒ\ËXz-¶€\\¨²¡º¾\ã7=ƒÃ€sH ‹‚\rÁB¾”K\Ønô—±\Û2g]\Ñps1_\Åð-÷]oª¥¥•QQU.ª€ˆˆˆ€ˆˆˆ€¢\î\Öw\Ç\0vÏ§}œGö‰\Zsc\Ê x=\Ã^@õËª\íz){lf’ì…§LV\Í\îe£3\è8¯9\ÔJùœKœM\ÜKœ}\ç¹Ù¹\Äó\'\æ¬óô\Ø0e\Ó%õ+H\åÙ¡\"\çK*\ßQºq·+h¯\Æ\Ûd-¦‡Cú\å\äª5‚€9¸ q<\Øs>œ\Ö\Çc\Ó\Í;„±\Ò=\ÆÁ¸¯ü­Äý›±]Q;a¦\ÂWŸt{½\\NhÔŸ\Ízt7R\Z¬ÑŠW\Þ\ÊssŽW\ì²ú7\ãsšZ9­\Ð\ì¶Ce­\rš]{»“+\Ú<º)(š\Ð\Z\Ð\ZÑ\0\0\0\è‹\íTQ\ïm›O³½¡¾ý+»Àt¼n³dòµü\nBZ\î§\ï6}Tyx ”gÕŽA\åœ7`_,]¥g¨ù,¨\âZEv\ÓuT5þ\å\á\Î\ã>\ê\Â\ïÁz¶7‡\0\àn¸<Á\ÑyNJpE¹\ä½\Ù\Õa—eR=\Æ\äB\Ö8ótF)\Z\"(¢\" ¢ª¢ª** \"\"\" \"\"\Ó\ïó\ÒP´:®vG‹\Ýnn{³·†6‚\çz¸^X\ß} jv\ÝL¤\ÜG#š\Ûðl?F\Ð9bþ¥fý\ïg·Öº\\Xcm\Ù]v‘I\Î\Îú\Î>-9ª…ÕnL:þ¿E|VT\Æ\ï£-\Å\éò<KN\êI\ÈkNC¯róZGMD8ü\Ö~Ù¶\ÄI f\âN@gs\Ñs?i–ø\\¦¾\Ç÷c¼¶Òœd.)\ÚG‘”ó\â\êy \ë{=\Ý!C9\ê%¼:\àn¢6ôO\ä\\ˆ²¢\" -F÷\Ê³\ê\Ütóûn[uö¿\Ô,Š¯f¸\Êf19‡.Æ½\ì»Auþð½\Õ\'D\ß¯\È,\ØZ°©d$xs¯c E•º´Œ£\Z›{!\Ù1ROÿ\0\ï)ü\Ô\Ú\Ñr\Ò\ÇXZ\ï\ásžŠtì¶\ÙQu|\ÇþüŠR:ôDQDEDED@UD@DDD@DD\ç>\Ó÷\nzZ\Ék!it¼\ÉqõKÝ‰\Ìw/6:h½­U`À\îóX­‡\r³½òµy6–{\í\'¨9Xý\á¨+\çg\Ùø\ä?]\Ù~\ë<#óU\Ú\Ðã¨’¦žñ¶G½\Í`½„eÄµ¶<›aeM²j\"§ŽY ‘±¹£¥\Ì\"ú’=\Ü\ïýF”ñ\Ê\âÌ‹‡\Ö\Ìºýkiü—¦÷&¿¿ ‚^\äBpˆÛ›CXKºCn<ýWŸ7[`º®©±@qd\ç7„L&\î{ˆò6¿`½1EJØ£dQ‹1\rh\äÖ‹À%\ÑEº‰ƒ\ç»F‚\ã\ä\Ï\Éy:WZ\éŸre‘Ò¸¼K°üHjõV×¤\ï©\å†ö\ï#{/\ËKoø¯-\ì\è\ßG^\Ø\ê£te®\Âü@€,u¿\Þ\Ä\"ÇŠ±n\Ð\ØT\ØZ\Ç}­“Û–cŸ\Åiª¨\ç¦ý£D±px¹°\ëlÇžawòB×·0\Ó\ê\n\Õ\ÉH[g@|9ør•ôó\é\Ö\êŽ_g\Õ1¤½¸K\\<Lyð3¯esŸ\"r\ÒÓŸg¦=—N\×$µÏµ­f\Ê÷H\Ñc÷\\;\ì\Ñ2f\Ô1½ÔŒs\è\Ü/\ì\í\ÜÅ\Ú\êmÝ\àede\Íic\Ûll&ö¾…®óMM”\Ò\"(¢\" ¢ª\"\" \"\"\"¡6Ì \â{A\í›hš\Þú¡\Â\â;Ù¬i\Ñ\Ò;;_€žƒ5I\Ú\î\Ós®G\ÙlB\ÃüÄŸ\ÅpûÏ¶\rUlõ.7\ï$q¸\r˜=\Z\0ô[½\Ö\Ü]¡Z\Ñ$\ÒYOv\Ç~\íóp\ê\ÐB¸Ž–.\ÕöŸ\Ãÿ\0\Ô?š±¶7úºªA,ŒvN°4¹¿d›“‡˜\Zù,-©¹U4Ò¶›<³‘ˆ\Å\Þ\ã>Ü®sX\ÞW77\ÈG°£€^f÷\Ï<vF\Ã\Èý\'ñ|\Zm™G\Þ=€µ\Æ2öµ\î\0\Ø4¸]\Ã!•\ÔÁ¸\Ûn\nhç¡šV\Ó\Ìþ\å\åØ›,2#K]Ä‚\â\Zd	$\åùa\Ë!k\0,C\Ð\Û3‘ýpL\Í\rd…ñ¸°[ò1y\Úv,þYôüWk»û\Å_c0>h†DH3\r\é)ü\ÉS*\"\Õ\r½\çÝ—\à\ë\\t¸$|\n\ÆnøQ_	€õ ~j\rò-l{~·©ƒ3#\0üJøÿ\0™h¸U\Ó)£?\"ƒj´{Ïº\Ô\ÕÑ–N\Ïˆlƒ\'¶üÐ«’oEÏ¾÷Z÷ÿ\0´\Ï\ïù\ã\ÑP¶Ln\Þ\ÇFØÈ¹­=ü…°\å™\àB-¢mM’8\ÞÚˆc‘ñ€›ˆFp²\ä\Ú\î\Êö\Ë-V\æ‡jE(k[v‘«“m²±×ž\\•\ÖR†01 Ù \056Ù“©R$;‘H\èÉ¡ixh\ÄðKIv¦\äkbM¯¢¨Žk\é› \×Ë‘²’÷e˜iñ¸Yò\Ù\Ö\Ò\Ì\àø‰}Qne$N{­˜‘\Ïh>D\ç\êº0DEDT@º*¢\" \"\"\Ó\ïos³\ê¦\Z²	óÀmø\Ùn{\ÛF\Ý\Ðû&U‡08X5……\äó$8\0:“\Ã0‹;Ü¶W\Ô:¢¥·§§±->ì’œ\Ú\ÓÍ Dqð	]¾óöƒ-U@Ù»†¶øR-Ÿ6\ÃÉ [bx¶\Õ]4\ÇK3\Ù\Î!Ñ¶\Öyv\ë›_0Ö‹\ßK	Rf\à\ìQOM\Þ\ÜÉ“]©\Â.m\Â\î\åÁ­TfCF\Úhð62ü\ï$¯»¤‘ÿ\0i\î7q\äÖ¶­\íÌ‚vÿ\0\ÏE²¬s\ã%\ÆLd\ë|ºú.nºª\îøeÁi’[›i•ÿ\0ª\Ï\Ù[%Ò’m“F\"t\rþ·\á\Ñh¶eQ¨ªa\'Y¥9²Ç¼~ó³°\Z^Þ’UX1D\ÖS>#F’1;,Ë\Ìó²ƒ–Zx\Î\Ú\'\Ú6\Å{ði\Èz.goo‰i|q–\Ë¯£x‹\Úy¹­6ô\ïyfFZ\ÐCœÓ›\É\Ôbû:ù.2¦¡\ÎÉ¹Öœn«6Ü¯ú7\Í#9FCs\à\ÝG\Ö\Óen¸uŸP\0#nGø\Ü4ò\n\Þ\ê\ìQ\ïdHt¿\Õ\Íu\åš^H\r\Z¹\Ä5£\Í\Ç ‚´´‘F-l`û­\âu>«-®\\ýNôS0‘ŠG\Ûü8\ÉŽyh>—XŸóD/6l“\Å\Õ\ÑFð<\Ã]t€+\è9st»]\Í!\ÒH\É!¸\Ç$m7cx¹Ñœ\ÛoQ–¡v[Kb\ËD¾\" +3n˜.V\ãŽcª6¼\r´7·’–)§k\Ø×°Ý®\0ƒÐ¨‚\ë±\Ü]«­37Gÿ\0“?Š•]’\"(ˆ€ˆ¨‚¨¨ˆ*ˆˆˆ€¢>ÞªYjX¾¸/“,\Öþ\'ý¥K‹\í¥±\rš^\æ4\É\Þ1‘¼‰—8„\ê.Ö¸z¤¶\î\ì\ïh­\rðÙ\'@ù3&ý\Z\ÊrpkCZ-ak\r\0\à¸\Ë(A™Ï¶mñº\Ì\é`\å\ÞÖ‰°+H\ä7– \\5\Ò\Ö\ä¸m\áÚ¦\ìÜž\ìšy.\éýV÷n\Ô}!m³¾f÷õ\\\ÖÁ¡ÿ\0ˆmh¡p\Å]wò\î¢ñ>þd[ø‚Q#n\Çÿ\0‡\ìö\Í$E\ï¨Ir»ƒH¼l±\ä\r\ÏWAj÷\ÏhÓ¶ÂŸL‚\ïk² oQ™\énk³Û•\ÓF\×Hn‰™’„·<‡®–P¾Ðªt\Ó>g’K\Î]ùp¾¶\ën>dn,Ï§óY\Û.\Ùô²q <:ž½¢ª9#g‡6ñ7\ÄZ1\ÂË \ÝZ5¦® µ\Ý\Ù8K/”\æ\ÒñÁ¢Ø­\Ðktrˆ\Ø%™§\Å\â„\ä\â8>_°\ÞM\ÔôZš\Ìs¸:cŠ\Þ\ëtkG&´d\ßEt¹\Ò8½\çœn\âyþ²YÂƒ_\ìB\Ùð\nÌ›1§‚\ß6|(9\ÆÀ\è\ÍÁ\"\Úúü…\Ùnö\änÎ¨ý”™C}#øYÿ\0v\á|#»t bX.Ð<&\Î-w\'v‘\äl‚G\ß\rš\ÊY\Ú@dØ‹qv¹¶\Ä\Ð5-\Ì\Ë1À_UMT\è\Þ\Ùl\æG˜ü–\Ëdn³*ös¶¤²IS[4&FI!·röx»˜\ØÜ˜\Ð\æ–\î\í.B\Ð\Ç0sC†„\\y>Ë­lð²Vh\á§#¡‡%”¹.\Î%&™\í:6CoV´\Û\ãó]jÊˆˆ€¨ªˆ(Š¨€ˆˆˆ€£N\Ý\Ü}ŠÎ¢ÿ\0¤þjK\\mT…û=¯\Ý\Ì\Ç\'5ñü\Þ/²\à0Nl\í14^\Ö/?¯%\ÖÖ¶ñ\èOš\á;3”\Þvr9\ßK»ˆü\×w[!“kp\Íi>\Ýyq[N\Ä\èHeUey´,¿¤’_ýY¶Á$\â\â\âc\Ùv\Ïÿ\0\Ò#7sK\ä‘÷nG\ÞÁ\ë\î Á\í­ÍŒ1Ñ±†C«ˆ6\Ù[…\É\åQþ,#·ô]ŽøÅ†¥\Ñ¹\áŒ`»­ß œ(i\ÓC\Âù|}\Åy]‰\Ù7€\çýA²¨D¯¹\Í\äKI\' \êV¿gPºFJ\æ8é˜\ÆG\ÄÖ†\ÜhI\"\Ëu»›A‘€Ù¾Œ\â..>\é\à\ßƒ\Ö\È6\Í\Ù\ÒÇŸ\íÁ\Ãòw\áæ²©\\\×d2:–œ\Ãó[X^¸ ŽŠüû>7Š×µñ\\^þÅ‰\r¾y Öˆ•\Z\Êöi1=E¹6ë™¿Uðei\È\\G#\å\×\Ñ¾V,*¨\íš\ÚLÕƒVÛ´¢$\ÎÉ¶{£:6W\Û\Ê@\ÙOú¤rŒ¶d¿A´À\ÛyX.\ãw6²\ì*Šg_+\Êöµ‘W9¡sû°½¦fEo¢ˆ!û£ \ß7Z\ÞWä¢¤Á£1\Ñ4¸X\ÈLž†Á¿\éh>«£Tkl,2‚ªŠ\"\"¢ª¢\" ª\" \"\"\Öo.\ÌT“S›}#mø<f\Ã\è\à\nÙ¢7n‘tUÏ\Þñ¹ƒ•ž\Ë\å\çp\áa\ÅI2F]\rˆø\\-Oj»¸\êyÙµ m\Ú \áq°\ÄG\ÙwÌžk²j£š¹¹‡4~DrZDg·)Ž2mú\Ïó]ž\àÓødQ\Ý\Â\ÆLÁ\Ì}+\Î_%ƒ¼\Ô$æŒŽ¶×™Ï‚\Ï\Ü\éðÐ†›ñc¦gþH8}\îU\Õ\â\ì.`\Ä\íM¡Ž\×Q\Ìr©+|}®§±xö\×.\ì2ÿ\0µ–$r6A\Ölj\Z‡}©aü¡ò%›J\ÐV\Ãÿ\0 ˜r¨Þ†77\æ³hÞƒmIM‡8œc?tøy\æÓ–|\Ækm|\ÊF‡´\Í}[¯\Â\ë_HVs^ƒmI\\\Ç{Žû¤^\Æ\ÆØ±\rKˆ\áÃ‡5|“\'X\è“©d³\Ó#~Z·†»QŸ\ÇÐ –F{§\ä\ì\èxþ>\ê¨^\ßqÁÃ“ˆ>G[ùp\åuªªšÀ\ã¹z|x;-¨\Ú-}›{™i°:\ê2ý<\ã\Ë\Ëó\èˆø\Ú;A\ÕŸfSñ±?÷•akG6±¾\"t¹ûªc\Ý]†\Ú:v\Ä,^|R;\í<\ënƒAä¸Ž\ÊvHö‰ªDm\r\rÀ\ÊBC‡\ÓS\ÕI\êV„DPQQQUZª§lŒtr49®iÐ´‹}>\Ø²*\Í,\Çû4„šyŽ™ýG\Ï\ã¡\ÊeXkdCW ¨`{\èA\Z9§P\á\ÍSx\Â\Ó`HóZÍ‰Nc–JwŸ\ãmò»†F\Þb\ß|\ì\Z\ížp±®¬¦\Â\æ\Û\Ú#œÃ”€}\ÜúpY”Õ°Lmˆ·P\àXöF&87\Ô*Ž+~©p\ÔF\âw0\Ä\âlFD¹–#\Íú¨¶º›\îi\ã¢ôö\Ð2Zgƒ®­v~3k´<@P\æÜ¢27¼\Ïa³‡\"5ôTWvÙ‰³Á\ÆHñ4s|G‡R.¾©±vMAk›+=öm\Ôp=\Ë\Õm6¬\riEû)so\ÝwÖŒò \ÝÂ’U°l‹Ÿ¦¨[ªlƒÓ¼X^\Ð‰«@\Ñý ö\á±Ï—0zu¹¹SA\ÞX\Ûû­‘¦þX‡–|Á\ä¬n6é¾¦A4À†7?\×\Þ\å\ËS\Âó$1´5 \0€\0SF»vöH¥¦d\0‚@»\Ýöž\ì\Ü~?€hˆ¢ˆˆ€ˆˆ\nŠ¨€ˆˆˆ€ˆˆˆ€ˆˆ\nÜ°µ\ÞóZ\ï0\Í\\D³\ìøœ,n|@\0üB·\Ëq$$\Í\Ä@\å\ï7[<4dFvw\ÅJhƒ\È\Õð\É\Ä5…\Z±\Ù_ùŽ¡m(v™8\â\Åœ,$ø‹ˆ$>>N§>Zð^\Úû»ISÿ\0Qo\êEˆòp±yž½’6ºf–INÈ¥v\ähqcI[!¹\Ï\Üù•u\ãgø©%`É›\Ï]`|\ÇÁ|Šj‘‚kÿ\0ñ¿\æ”÷_piç…•/u@kÀ!Žkr\Ôýk´œÁ\È\Ùv4»£Ep¶‘÷‹Ÿþ\âSL@Ô›\"ªWˆ\Ü\Û\é‹#~÷ R\éönA\Õ\\q±÷½õ|\Î}ªK¥¢Š!h£c&´7\ä²Eªjv\Æ\Ð\Æ45£@?ZõWQQ,‚¨ˆ€ˆˆˆ€ˆˆˆ€ˆˆˆƒ\í_j¶\r•P\Ó,q>h\ßxÃŽ2\æœLnñ\0t‹¨“²Ý’y\â{¡k\Øqw¯–7‘„[d_žZZÀùõ}¼V¶W\Ñ\ì\è\Ø\×L÷÷·°.c=\Ð\Ëÿ\0\"\ï÷3vE%˜\Ü÷<‡<\r\Í+^ù\ê}o ‰¬kX\ÐZZ€`¢ûD@DDD@DDD@DDDADETD@DDD@DDDAò\åôˆ‚\Þý\Ý\î\Óÿ\0½ªmD@DDD@DDD@DDD@_(ˆ*ˆˆ?ÿ\Ù','2025-01-09 06:55:27.770676');
/*!40000 ALTER TABLE `headphone` ENABLE KEYS */;
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
