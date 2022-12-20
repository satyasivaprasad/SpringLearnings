DROP SCHEMA IF EXISTS `hb-practice-02-one-to-one-bi`;

CREATE SCHEMA `hb-practice-02-one-to-one-bi`;

use `hb-practice-02-one-to-one-bi`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `trainer_detail`;

CREATE TABLE `trainer_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `trainer`;

CREATE TABLE `trainer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `trainer_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`trainer_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`trainer_detail_id`) REFERENCES `trainer_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
