/*
Navicat MySQL Data Transfer

Source Server         : 39.106.166.147_3306
Source Server Version : 50730
Source Host           : 39.106.166.147:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-08-03 20:44:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `bean_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `params` longtext,
  `cron_expression` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('69', 'TestJobFirst', 'firstTest', null, '0/5 * * * * ?', '0', '类一方法一', '2020-08-04 19:31:29');
INSERT INTO `schedule_job` VALUES ('70', 'TestJobFirst', 'secondTest', null, '0/5 * * * * ?', '0', '类一方法二', '2020-08-04 19:35:12');
INSERT INTO `schedule_job` VALUES ('71', 'TestJobFirst', 'thirdTest', null, '0/5 * * * * ?', '0', '类一方法三', '2020-08-04 19:35:13');
INSERT INTO `schedule_job` VALUES ('72', 'TestJobSecond', 'firstTest', null, '0/5 * * * * ?', '0', '类二方法一', '2020-08-04 19:35:14');
INSERT INTO `schedule_job` VALUES ('73', 'TestJobSecond', 'secondTest', null, '0/5 * * * * ?', '0', '类二方法二', '2020-08-04 19:35:14');
INSERT INTO `schedule_job` VALUES ('75', 'TestJobSecond', 'thirdTest', null, '0/5 * * * * ?', '0', '类二方法二', '2020-08-04 19:35:14');
