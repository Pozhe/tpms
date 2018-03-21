/*
Navicat MySQL Data Transfer

Source Server         : manage
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : tpms

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2018-03-21 14:34:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `id` varchar(20) NOT NULL,
  `roleId` varchar(20) DEFAULT NULL,
  `privilegeId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与权限对应表';

-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------
INSERT INTO `t_role_privilege` VALUES ('1', '1', '1');
INSERT INTO `t_role_privilege` VALUES ('2', '1', '2');
INSERT INTO `t_role_privilege` VALUES ('3', '1', '3');
INSERT INTO `t_role_privilege` VALUES ('4', '1', '4');
INSERT INTO `t_role_privilege` VALUES ('5', '1', '5');
INSERT INTO `t_role_privilege` VALUES ('6', '1', '6');
INSERT INTO `t_role_privilege` VALUES ('7', '1', '7');

-- ----------------------------
-- Table structure for t_system_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_system_privilege`;
CREATE TABLE `t_system_privilege` (
  `id` int(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `parent` int(20) DEFAULT NULL COMMENT '父id',
  `state` int(20) DEFAULT '0' COMMENT '状态 0：未启用 1：启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_system_privilege
-- ----------------------------
INSERT INTO `t_system_privilege` VALUES ('1', '系统管理', 'tables.html', 'icon-desktop', '0', '1');
INSERT INTO `t_system_privilege` VALUES ('2', '用户管理', 'tables.html', 'icon-double-angle-right', '1', '1');
INSERT INTO `t_system_privilege` VALUES ('3', '角色管理', 'resources/tables.html', 'icon-double-angle-right', '1', '1');
INSERT INTO `t_system_privilege` VALUES ('4', '权限管理', 'tables.html', 'icon-pencil', '2', '1');
INSERT INTO `t_system_privilege` VALUES ('5', '日志管理', 'tables.html', 'icon-double-angle-right', '4', '1');
INSERT INTO `t_system_privilege` VALUES ('6', '日志管理2', 'tables.html', 'icon-double-angle-right', '1', '1');
INSERT INTO `t_system_privilege` VALUES ('7', '日志管理3', 'tables.html', 'icon-double-angle-right', '1', '1');

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(20) NOT NULL,
  `roleName` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', '0');

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` int(20) NOT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1', '111', '111');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(20) NOT NULL,
  `userId` int(20) NOT NULL,
  `roleId` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
