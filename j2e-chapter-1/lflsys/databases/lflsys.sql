/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.6.21-log : Database - lflsys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lflsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lflsys`;

/*Table structure for table `t_brand` */

/*品牌*/
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '品牌名称',
  `type_id` int(11) DEFAULT NULL COMMENT '分类外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_brand` */

/*Table structure for table `t_channel` */

/*渠道*/
DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '渠道名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channel` */

/*Table structure for table `t_dept` */

/*部门*/
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_dept` */

insert  into `t_dept`(`id`,`name`) values (1,'销售部'),(2,'渠道部'),(3,'后勤部');

/*Table structure for table `t_employee` */

/*员工*/
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `empNo` varchar(40) DEFAULT NULL COMMENT '员工编号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别 0:女,1:男',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `dept_id` int(11) DEFAULT NULL COMMENT '所属部门',
  `job_id` int(11) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

/*Table structure for table `t_firsttype` */

/*一级类别*/
DROP TABLE IF EXISTS `t_firsttype`;
CREATE TABLE `t_firsttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_firsttype` */

insert  into `t_firsttype`(`id`,`name`) values (1,'男士'),(2,'女士'),(3,'幼儿');

/*Table structure for table `t_goods` */

/*商品表*/
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goodNo` varchar(40) DEFAULT NULL COMMENT '产品编号 UUID',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `firstType_id` int(11) DEFAULT NULL COMMENT '一级分类ID',
  `secType_id` int(11) DEFAULT NULL COMMENT '二级分类ID',
  `inPrice` int(11) DEFAULT NULL COMMENT '进价',
  `outPrice` int(11) DEFAULT NULL COMMENT '售价',
  `produceDate` date DEFAULT NULL COMMENT '生产日期 年月日',
  `shelfTime` int(11) DEFAULT NULL COMMENT '保质期 单位 月',
  `goodDir_id` int(11) DEFAULT NULL COMMENT '进出日期',
  `mark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_goods` */

/*Table structure for table `t_goodsdir` */


/*进出表*/
DROP TABLE IF EXISTS `t_goodsdir`;
CREATE TABLE `t_goodsdir` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(11) DEFAULT NULL COMMENT '进出方向 0:进货,1:出货',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `channel_id` int(11) DEFAULT NULL COMMENT '渠道',
  `time` datetime DEFAULT NULL COMMENT '进出时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '经手人 -> 员工',
  `batchNo` varchar(40) DEFAULT NULL COMMENT '进出批号',
  `manager_id` int(11) DEFAULT NULL COMMENT '审批人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_goodsdir` */

/*Table structure for table `t_job` */


/*职位表*/
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '职位名称',
  `dept_id` int(11) DEFAULT NULL COMMENT '岗位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_job` */

insert  into `t_job`(`id`,`name`,`dept_id`) values (1,'员工',1),(2,'经理',1),(3,'扫地僧',2),(4,'CEO',3);

/*Table structure for table `t_manager` */

/*管理员*/
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nikeName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名(登录)',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `mgrLevel` int(1) DEFAULT NULL COMMENT '管理等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_manager` */

/*Table structure for table `t_sectype` */

/*二级类别*/
DROP TABLE IF EXISTS `t_sectype`;
CREATE TABLE `t_sectype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '二级类别名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_sectype` */

insert  into `t_sectype`(`id`,`name`,`parent_id`) values (1,'美白',1),(2,'保湿',1),(3,'祛痘',1),(4,'控油',1),(5,'美白',2),(6,'保湿',2),(7,'祛痘',2),(8,'控油',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
