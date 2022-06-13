/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : eladmin

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 13/06/2022 22:02:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_report
-- ----------------------------
DROP TABLE IF EXISTS `sys_report`;
CREATE TABLE `sys_report`  (
  `report_id` int NOT NULL AUTO_INCREMENT COMMENT '表id',
  `proj_num` int NOT NULL DEFAULT 0 COMMENT '报告号',
  `proj_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `file_path` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '底稿路径',
  `module` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '对应模块',
  `sub_module` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '对应子模块',
  `audit_dept` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被审计部门',
  `rel_sys` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '涉及系统',
  `create_date` date NULL DEFAULT NULL COMMENT '启动日',
  `finish_date` date NULL DEFAULT NULL COMMENT '完成日',
  `report_date` date NULL DEFAULT NULL COMMENT '报告日',
  `prob_num` int NULL DEFAULT NULL COMMENT '缺陷数量',
  `comments` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `reporter_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '报告人',
  `reporter_id` int NOT NULL DEFAULT 1 COMMENT '报告人用户id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`report_id`) USING BTREE,
  UNIQUE INDEX `report_id_UNIQUE`(`report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '内审部门项目报告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_report
-- ----------------------------
INSERT INTO `sys_report` VALUES (1, 1, 'proj1', 'path1', 'mod1', 'sub1', 'dept1', 'sys1', '2022-06-10', '2022-06-10', '2022-06-10', 1, NULL, 'admin', 1, NULL, 'admin', '2022-06-11 21:30:23', '2022-06-11 21:10:16');
INSERT INTO `sys_report` VALUES (2, 2, 'proj2', 'path2', 'md2', '', 'dept2', 'sys2', '2022-06-01', '2022-06-01', '2022-06-01', 2, '', 'admin', 1, NULL, 'admin', '2022-06-11 21:30:23', '2022-06-11 22:22:50');
INSERT INTO `sys_report` VALUES (5, 3, '3', '3', '3', '3', '3', '3', '2022-06-13', '2022-06-13', '2022-06-13', 3, '', 'admin', 1, NULL, 'admin', '2022-06-13 15:29:16', '2022-06-13 15:29:16');
INSERT INTO `sys_report` VALUES (6, 4, '4', '4', '4', '', '4', '4', '2022-06-13', '2022-06-13', '2022-06-13', 4, '', 'test1', 1, NULL, 'admin', '2022-06-13 16:39:09', '2022-06-13 16:39:09');

SET FOREIGN_KEY_CHECKS = 1;
