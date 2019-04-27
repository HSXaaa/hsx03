/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hsx02

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-27 15:02:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `sex` char(2) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '邓紫棋', 'gem', '女', '28', '1990-03-10');
INSERT INTO `t_user` VALUES ('2', '周杰伦', 'zjl', '男', '33', '1979-11-16');
INSERT INTO `t_user` VALUES ('3', '周润发', 'zrf', '男', '50', '1960-07-22');
INSERT INTO `t_user` VALUES ('4', '王力宏', 'wlh', '男', '33', '1988-07-16');
INSERT INTO `t_user` VALUES ('5', '刘德华', 'ldh', '男', '55', '1961-10-05');
INSERT INTO `t_user` VALUES ('6', '张三', '345', '男', '22', '2019-03-21');
INSERT INTO `t_user` VALUES ('7', '张三', '345', '男', '22', '2019-03-21');
INSERT INTO `t_user` VALUES ('8', '张三', '345', '男', '22', '2019-03-20');
INSERT INTO `t_user` VALUES ('9', '张学友', 'zxy', '男', '50', '1970-06-23');
INSERT INTO `t_user` VALUES ('10', '村上春树', 'cscs', '男', '60', '1959-08-27');


