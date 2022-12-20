DROP SCHEMA IF EXISTS `hb-practice-05-many-to-many`;

CREATE SCHEMA `hb-practice-05-many-to-many`;

use `hb-practice-05-many-to-many`;

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
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`trainer_detail_id`) 
  REFERENCES `trainer_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `technology`;

CREATE TABLE `technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  
  KEY `FK_TRAINER_idx` (`trainer_id`),
  
  CONSTRAINT `FK_TRAINER` 
  FOREIGN KEY (`trainer_id`) 
  REFERENCES `trainer` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(256) DEFAULT NULL,
  `technology_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_TECHNOLOGY_ID_idx` (`technology_id`),

  CONSTRAINT `FK_TECHNOLOGY` 
  FOREIGN KEY (`technology_id`) 
  REFERENCES `technology` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `technology_employee`;

CREATE TABLE `technology_employee` (
  `technology_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  
  PRIMARY KEY (`technology_id`,`employee_id`),
  
  KEY `FK_EMPLOYEE_idx` (`employee_id`),
  
  CONSTRAINT `FK_TECHNOLOGY_05` FOREIGN KEY (`technology_id`) 
  REFERENCES `technology` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`) 
  REFERENCES `employee` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
