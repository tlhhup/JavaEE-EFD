# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.30)
# Database: mybatis
# Generation Time: 2020-06-14 03:10:13 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_lecture
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_lecture`;

CREATE TABLE `t_lecture` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `lecture_name` varchar(60) NOT NULL COMMENT '课程名称',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_rights
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_rights`;

CREATE TABLE `t_rights` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `rights_name` varchar(60) NOT NULL COMMENT '权限名称',
  `rights_url` varchar(200) NOT NULL COMMENT '权限地址',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(60) NOT NULL COMMENT '角色名称',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_role_right
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role_right`;

CREATE TABLE `t_role_right` (
  `right_id` int(20) NOT NULL COMMENT '权限编号',
  `role_id` int(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`right_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_role_right_ibfk_1` FOREIGN KEY (`right_id`) REFERENCES `t_rights` (`id`),
  CONSTRAINT `t_role_right_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cnname` varchar(60) NOT NULL COMMENT '学生姓名',
  `sex` tinyint(4) NOT NULL COMMENT '性别',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息表';

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;

INSERT INTO `t_student` (`id`, `cnname`, `sex`, `note`)
VALUES
	(1,'张三',1,'蜗牛学院');

/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_student_health_female
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_student_health_female`;

CREATE TABLE `t_student_health_female` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `check_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '检查时间',
  `heart` varchar(60) NOT NULL COMMENT '心',
  `liver` varchar(60) NOT NULL COMMENT '肝',
  `spleen` varchar(60) NOT NULL COMMENT '脾',
  `lung` varchar(60) NOT NULL COMMENT '肺',
  `kidney` varchar(60) NOT NULL COMMENT '肾',
  `uterus` varchar(60) NOT NULL COMMENT '子宫',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `t_student_health_female_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='女生学生健康信息表';



# Dump of table t_student_health_male
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_student_health_male`;

CREATE TABLE `t_student_health_male` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `check_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '检查时间',
  `heart` varchar(60) NOT NULL COMMENT '心',
  `liver` varchar(60) NOT NULL COMMENT '肝',
  `spleen` varchar(60) NOT NULL COMMENT '脾',
  `lung` varchar(60) NOT NULL COMMENT '肺',
  `kidney` varchar(60) NOT NULL COMMENT '肾',
  `prostate` varchar(60) NOT NULL COMMENT '前列腺',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `t_student_health_male_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='男生学生健康信息表';

LOCK TABLES `t_student_health_male` WRITE;
/*!40000 ALTER TABLE `t_student_health_male` DISABLE KEYS */;

INSERT INTO `t_student_health_male` (`id`, `student_id`, `check_date`, `heart`, `liver`, `spleen`, `lung`, `kidney`, `prostate`, `note`)
VALUES
	(1,1,'2016-11-09 16:37:23','好','好','好','好','好','好','好');

/*!40000 ALTER TABLE `t_student_health_male` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_student_lecture
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_student_lecture`;

CREATE TABLE `t_student_lecture` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `lecture_id` int(20) DEFAULT NULL COMMENT '课程编号',
  `grade` decimal(5,2) NOT NULL COMMENT '评分',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `lecture_id` (`lecture_id`),
  CONSTRAINT `t_student_lecture_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`),
  CONSTRAINT `t_student_lecture_ibfk_2` FOREIGN KEY (`lecture_id`) REFERENCES `t_lecture` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生成绩表';



# Dump of table t_student_selfcard
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_student_selfcard`;

CREATE TABLE `t_student_selfcard` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `native` varchar(60) NOT NULL COMMENT '籍贯',
  `issue_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发证日期',
  `end_date` datetime NOT NULL COMMENT '结束日期',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `t_student_selfcard_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证信息表';

LOCK TABLES `t_student_selfcard` WRITE;
/*!40000 ALTER TABLE `t_student_selfcard` DISABLE KEYS */;

INSERT INTO `t_student_selfcard` (`id`, `student_id`, `native`, `issue_date`, `end_date`, `note`)
VALUES
	(1,1,'成都','2016-11-09 17:55:36','2016-12-11 17:55:32','蜗牛学院16期');

/*!40000 ALTER TABLE `t_student_selfcard` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(60) NOT NULL COMMENT '用户名称',
  `cnname` varchar(60) NOT NULL COMMENT '姓名',
  `sex` tinyint(3) NOT NULL COMMENT '性别',
  `mobile` varchar(20) NOT NULL COMMENT '手机号码',
  `email` varchar(60) NOT NULL COMMENT '电子邮件',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`id`, `user_name`, `cnname`, `sex`, `mobile`, `email`, `note`)
VALUES
	(1,'zhangsan','张三',1,'123456','zhangsan@woniuxy.com','蜗牛学院');

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` int(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
