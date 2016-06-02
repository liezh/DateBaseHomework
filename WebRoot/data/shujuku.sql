/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : shujuku

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-06-02 20:41:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `att_id` int(6) NOT NULL AUTO_INCREMENT,
  `emp_id` int(6) DEFAULT NULL,
  `time` char(20) DEFAULT NULL,
  `state` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('3', '1', '2016-1-1', '1');
INSERT INTO `attendance` VALUES ('4', '3', '2016-1-1', '1');
INSERT INTO `attendance` VALUES ('5', '7', '2016-9-3', '5');
INSERT INTO `attendance` VALUES ('6', '7', '2016-9-3', '5');
INSERT INTO `attendance` VALUES ('7', '2', '2017-1-1', '4');

-- ----------------------------
-- Table structure for `employeesinfo`
-- ----------------------------
DROP TABLE IF EXISTS `employeesinfo`;
CREATE TABLE `employeesinfo` (
  `id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `personalID` bigint(30) DEFAULT NULL,
  `name` char(10) DEFAULT NULL,
  `age` int(6) DEFAULT NULL,
  `sex` char(8) DEFAULT NULL,
  `marriage` char(20) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `title` char(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phoneNum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeesinfo
-- ----------------------------
INSERT INTO `employeesinfo` VALUES ('0001', '201406114254', '李林', '20', '男', '未婚', '本科', '广州大学', '职工', '北京朝阳区18街8号', '13453783496');
INSERT INTO `employeesinfo` VALUES ('0002', '201495334856', '王五', '34', '男', '已婚', '本科', '复旦大学', '经理', '北京朝阳区34街45号', '1356970294');
INSERT INTO `employeesinfo` VALUES ('0004', '987654321', '林西', '49', '男', '离异', '研究生', '吉林大学', '经理', '北京朝阳区12街23号', '13553049586');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` char(30) NOT NULL DEFAULT '',
  `password` char(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aa', 'bb');

-- ----------------------------
-- Table structure for `wages`
-- ----------------------------
DROP TABLE IF EXISTS `wages`;
CREATE TABLE `wages` (
  `wage_id` int(6) NOT NULL AUTO_INCREMENT,
  `emp_id` int(6) NOT NULL,
  `attendance_id` int(6) DEFAULT NULL,
  `attendSkimp` double(8,0) DEFAULT NULL,
  `basic_wage` double(8,0) DEFAULT NULL,
  `ot_wage` double(8,0) DEFAULT NULL,
  `sum_wage` double(12,0) DEFAULT NULL,
  `insurance` double(8,0) DEFAULT NULL,
  `realWage` double(12,0) DEFAULT NULL,
  PRIMARY KEY (`wage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wages
-- ----------------------------
INSERT INTO `wages` VALUES ('1', '1', '1', '0', '2000', '200', '2200', '200', '2000');
