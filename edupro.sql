/*
Navicat MySQL Data Transfer

Source Server         : 本机-root
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : edupro

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-02-07 09:09:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `username` varchar(50) CHARACTER SET gb2312 DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tel` varchar(20) CHARACTER SET gb2312 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('赵召', '2', '22');
INSERT INTO `sysuser` VALUES ('zz', '3', '1');
