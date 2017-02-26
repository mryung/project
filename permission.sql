# Host: localhost  (Version: 5.7.13)
# Date: 2017-02-26 17:35:48
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_group"
#

CREATE TABLE `tb_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) DEFAULT NULL,
  `group_parent_id` int(11) DEFAULT NULL,
  `group_parents` varchar(255) DEFAULT NULL,
  `group_gen_time` datetime DEFAULT '0000-00-00 00:00:00',
  `group_description` varchar(1000) DEFAULT NULL,
  `available` int(11) DEFAULT '1' COMMENT '是否可获得1 表示有效，0 表示无效',
  `group_code` varchar(255) DEFAULT NULL COMMENT '分组代码',
  `sorted` tinyint(3) DEFAULT '0' COMMENT '组排序',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除，0:未删除，1:删除',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "tb_group"
#

INSERT INTO `tb_group` VALUES (1,'小组',0,NULL,NULL,'小组',1,'group:team',0,1);

#
# Structure for table "tb_group_right"
#

CREATE TABLE `tb_group_right` (
  `group_right_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `right_id` int(11) DEFAULT NULL,
  `right_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_group_right"
#


#
# Structure for table "tb_group_role"
#

CREATE TABLE `tb_group_role` (
  `group_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_group_role"
#


#
# Structure for table "tb_log"
#

CREATE TABLE `tb_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_operate_type` int(11) DEFAULT NULL,
  `log_operate_content` varchar(1000) DEFAULT NULL,
  `log_operate_user_id` int(11) DEFAULT NULL,
  `log_operate_time` datetime DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_log"
#


#
# Structure for table "tb_organization"
#

CREATE TABLE `tb_organization` (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_parent_id` int(11) DEFAULT NULL,
  `org_name` varchar(100) DEFAULT NULL,
  `org_gen_time` datetime DEFAULT NULL,
  `org_description` varchar(1000) DEFAULT NULL,
  `org_parents` varchar(255) DEFAULT NULL,
  `available` tinyint(3) DEFAULT '1' COMMENT '是否可获得,1表示有效，0表示无效',
  `org_code` varchar(255) DEFAULT NULL COMMENT '组织代码',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除，0:未删除，1:删除',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "tb_organization"
#

INSERT INTO `tb_organization` VALUES (1,0,'管理员部门',NULL,'管理员部门','0,',1,NULL,0),(2,1,'财务部门',NULL,'财务部门','0,1,',1,NULL,0),(3,2,'日日日','2017-02-25 18:18:31','恩恩额','0,1,2,',1,NULL,0),(4,3,'发发发','2017-02-25 18:22:42','顶顶顶顶','0,1,2,3,',1,NULL,0),(5,3,'点对点','2017-02-25 18:23:03','得到','0,1,2,3,',1,NULL,1),(6,3,'dsfasd','2017-02-25 18:25:04','adfsd','0,1,2,3,',1,NULL,1);

#
# Structure for table "tb_right"
#

CREATE TABLE `tb_right` (
  `right_id` int(11) NOT NULL AUTO_INCREMENT,
  `right_parent_id` int(11) DEFAULT NULL COMMENT '父权限id',
  `right_parents` varchar(255) DEFAULT NULL COMMENT '父列表字符串',
  `right_name` varchar(100) DEFAULT NULL COMMENT '显示的权限名',
  `right_url` varchar(100) DEFAULT NULL COMMENT '权限url地址',
  `right_description` varchar(1000) DEFAULT NULL COMMENT '权限描述',
  `right_code` varchar(255) DEFAULT NULL COMMENT 'right 权限符号',
  `available` int(11) DEFAULT '1' COMMENT '0 无效有效，1 有效',
  `sorted` int(11) DEFAULT '0' COMMENT '排序',
  `is_show` tinyint(3) DEFAULT '1' COMMENT '是否显示 1：显示，0不显示',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除，0:未删除，1:删除',
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "tb_right"
#

INSERT INTO `tb_right` VALUES (1,0,'0,','系统权限',NULL,'系统权限',NULL,1,0,1,0),(2,1,'0,1,','用户管理',NULL,'用户管理','',1,0,1,0),(3,2,'0,1,2,','用户添加','user/add','用户添加','user:add',1,0,1,0),(4,2,'0,1,2,','用户列表','sys/user/index','用户列表','user:index',1,0,1,0),(5,2,'0,1,2,','用户修改','user/update','用户修改','user:update',1,0,1,0),(6,1,'0,1,','模块管理',NULL,'模块管理',NULL,1,0,1,0),(7,6,'0,1,6,','模块列表','sys/right/index','模块列表','right:index',1,0,1,0),(9,1,'0,1,','角色权限',NULL,'角色权限',NULL,1,0,1,0),(11,9,'0,1,9,','角色列表','sys/role/index','角色列表','role:index',1,0,1,0),(13,1,'0,1,','组织权限',NULL,'组织列表',NULL,1,0,1,0),(14,13,'0,1,13,','组织列表','sys/org/index','组织列表','org:index',1,0,1,0),(17,13,'0,1,13,','ddd','asdf','ad','sdf',1,1,1,0);

#
# Structure for table "tb_role"
#

CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_parent_id` int(11) DEFAULT NULL,
  `role_parents` varchar(255) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `role_gen_time` datetime DEFAULT '0000-00-00 00:00:00',
  `role_description` varchar(1000) DEFAULT NULL,
  `available` int(11) DEFAULT '1' COMMENT '1表示有效，0表示无效',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色代码',
  `sorted` tinyint(3) DEFAULT '0' COMMENT '排序',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除，0:未删除，1:删除',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "tb_role"
#

INSERT INTO `tb_role` VALUES (1,0,'0,','系统角色','2017-02-07 18:09:22','系统角色',1,'sys:sys',0,0),(2,1,'0,1,','安全管理员','2017-02-07 18:09:30','安全管理员',1,'sys:sys',0,0);

#
# Structure for table "tb_role_right"
#

CREATE TABLE `tb_role_right` (
  `role_right_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `right_id` int(11) DEFAULT NULL,
  `right_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_right_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "tb_role_right"
#

INSERT INTO `tb_role_right` VALUES (1,2,1,NULL),(2,2,6,NULL),(3,2,7,NULL);

#
# Structure for table "tb_user"
#

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_id` int(11) DEFAULT NULL COMMENT '组织id',
  `username` varchar(100) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL COMMENT '用户性别',
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gen_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `login_ip` varchar(100) DEFAULT NULL,
  `login_count` int(11) DEFAULT NULL,
  `available` int(11) DEFAULT '1' COMMENT '是否有效 1表示有效，0表示有效',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐，用于加密',
  `deleted` int(11) DEFAULT '0' COMMENT '是否删除，0:未删除，1:删除',
  PRIMARY KEY (`user_id`),
  KEY `fk_user_org` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "tb_user"
#

INSERT INTO `tb_user` VALUES (1,1,'admin','?','管理员','9b84bf64612f601d0cecfa166407048f4269068d','232742415@qq.com','2327542415@qq.com',NULL,NULL,NULL,NULL,NULL,1,'123456',0),(11,1,'yulang','?','yulang','d5c15d787d8ac2f274ec094f74889665d6d20e2d','2327542415@q','hello','2017-02-20 19:27:08','2017-02-20 19:27:08','2017-02-20 19:27:08','0:0:0:0:0:0:0:1',0,1,'hello',0),(16,2,'中文','男','中文','c7cbe07fdff80ff40c48e203459039f6f9cb5fee','中文','中文','2017-02-21 09:53:36','2017-02-21 09:53:36','2017-02-21 09:53:36','0:0:0:0:0:0:0:1',0,1,'中文',0),(17,NULL,NULL,NULL,NULL,'fd571203974ba9afe270fe62151ae967eca5e0aa',NULL,NULL,'2017-02-26 15:22:31','2017-02-26 15:22:31','2017-02-26 15:22:31','0:0:0:0:0:0:0:1',0,1,NULL,0);

#
# Structure for table "tb_user_group"
#

CREATE TABLE `tb_user_group` (
  `user_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `tb_user_id` int(11) DEFAULT NULL,
  `tb_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_user_group"
#


#
# Structure for table "tb_user_right"
#

CREATE TABLE `tb_user_right` (
  `user_right_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `right_id` int(11) DEFAULT NULL,
  `right_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_right_id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

#
# Data for table "tb_user_right"
#

INSERT INTO `tb_user_right` VALUES (66,1,1,NULL),(67,1,2,NULL),(68,1,3,NULL),(69,1,4,NULL),(70,1,5,NULL),(71,1,6,NULL),(72,1,7,NULL),(73,1,9,NULL),(74,1,11,NULL),(75,1,10,NULL),(76,1,12,NULL),(77,1,13,NULL),(78,1,14,NULL),(161,11,1,NULL),(162,11,13,NULL),(163,11,14,NULL),(164,11,1,NULL),(165,11,10,NULL),(166,11,12,NULL),(167,11,13,NULL),(168,11,14,NULL),(194,1,17,NULL);

#
# Structure for table "tb_user_role"
#

CREATE TABLE `tb_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "tb_user_role"
#

INSERT INTO `tb_user_role` VALUES (7,1,1);
