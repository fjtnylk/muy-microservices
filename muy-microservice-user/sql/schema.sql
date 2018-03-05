DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户名',
  `nick_name` varchar(32) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `birthday` varchar(10) DEFAULT '' COMMENT '生日(1999-07-16)',
  `signature` varchar(90) DEFAULT '' COMMENT '个性签名',
  `sex` char(1) DEFAULT '' COMMENT '性别(F-女,M-男)',
  `avatar` varchar(64) DEFAULT '' COMMENT '头像',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `my_user_role`;
CREATE TABLE `my_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户名',
  `role` varchar(32) NOT NULL DEFAULT '' COMMENT '用户权限',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';
