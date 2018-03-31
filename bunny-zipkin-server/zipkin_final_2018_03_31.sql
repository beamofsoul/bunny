/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : zipkin

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2018-03-31 19:37:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zipkin_annotations`
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'sr', null, '-1', '1522493956211000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'ss', null, '-1', '1522493956212000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'mvc.controller.class', 0x42756E6E79536C657574685472616365324170706C69636174696F6E, '6', '1522493956211000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'mvc.controller.method', 0x7472616365, '6', '1522493956211000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D323A39313032, '6', '1522493956211000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'cs', null, '-1', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'cr', null, '-1', '1522493956213000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'http.host', 0x74726163652D32, '6', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'http.method', 0x474554, '6', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'http.path', 0x2F74726163652D32, '6', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'http.url', 0x687474703A2F2F74726163652D322F74726163652D32, '6', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D313A39313031, '6', '1522493956208000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'sr', null, '-1', '1522493956207000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'ss', null, '-1', '1522493956214000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'mvc.controller.class', 0x42756E6E79536C657574685472616365314170706C69636174696F6E, '6', '1522493956207000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'mvc.controller.method', 0x7472616365, '6', '1522493956207000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D313A39313031, '6', '1522493956207000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'cs', null, '-1', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'cr', null, '-1', '1522493963833000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'http.host', 0x74726163652D32, '6', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'http.method', 0x474554, '6', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'http.path', 0x2F74726163652D32, '6', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'http.url', 0x687474703A2F2F74726163652D322F74726163652D32, '6', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D313A39313031, '6', '1522493963829000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '329092721391777676', 'sr', null, '-1', '1522493963828000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '329092721391777676', 'ss', null, '-1', '1522493963834000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '329092721391777676', 'mvc.controller.class', 0x42756E6E79536C657574685472616365314170706C69636174696F6E, '6', '1522493963827000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '329092721391777676', 'mvc.controller.method', 0x7472616365, '6', '1522493963827000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '329092721391777676', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D313A39313031, '6', '1522493963827000', '-1442926111', null, '9101', 'trace-1');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'sr', null, '-1', '1522493963831000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'ss', null, '-1', '1522493963832000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'mvc.controller.class', 0x42756E6E79536C657574685472616365324170706C69636174696F6E, '6', '1522493963831000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'mvc.controller.method', 0x7472616365, '6', '1522493963831000', '-1442926111', null, '9102', 'trace-2');
INSERT INTO `zipkin_annotations` VALUES ('0', '329092721391777676', '-1676999454571767298', 'spring.instance_id', 0x4445534B544F502D4354384C35454F3A74726163652D323A39313032, '6', '1522493963831000', '-1442926111', null, '9102', 'trace-2');

-- ----------------------------
-- Table structure for `zipkin_dependencies`
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  `error_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for `zipkin_spans`
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------
INSERT INTO `zipkin_spans` VALUES ('0', '-8328378142094495316', '-8328378142094495316', 'http:/trace-1', null, null, '1522493956207000', '8154');
INSERT INTO `zipkin_spans` VALUES ('0', '-8328378142094495316', '4855364006641179427', 'http:/trace-2', '-8328378142094495316', null, '1522493956208000', '5000');
INSERT INTO `zipkin_spans` VALUES ('0', '329092721391777676', '-1676999454571767298', 'http:/trace-2', '329092721391777676', null, '1522493963829000', '4000');
INSERT INTO `zipkin_spans` VALUES ('0', '329092721391777676', '329092721391777676', 'http:/trace-1', null, null, '1522493963827000', '7015');
