DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `goods_no` varchar(16) DEFAULT NULL COMMENT '商品编号',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_py_name` varchar(255) DEFAULT NULL COMMENT '拼音',
  `goods_short_py_name` varchar(255) DEFAULT NULL COMMENT '拼音简写',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `goods_price`;
CREATE TABLE `goods_price` (
  `price_id`  int NOT NULL AUTO_INCREMENT ,
  `goods_id`  int NULL ,
  `brand_id`  int NULL ,
  `price`  decimal(10,2) NULL,
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `goods_brand`;
CREATE TABLE `goods_brand` (
  `brand_id`  int NOT NULL AUTO_INCREMENT ,
  `brand_name`  varchar(255) NULL ,
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `income_log`;
CREATE TABLE `income_log` (
  `income_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,自增',
  `goods_id` varchar(16) DEFAULT NULL COMMENT '商品id',
  `income_time` date DEFAULT NULL COMMENT '进货时间',
  `income_quantity` int(11) DEFAULT NULL COMMENT '进货数量',
  `quantity_unit` varchar(16) DEFAULT NULL COMMENT '数量单位',
  `product_time` date DEFAULT NULL COMMENT '生产时间',
  `expire_time` date DEFAULT NULL COMMENT '过期时间',
  `suplier_id` varchar(16) DEFAULT NULL COMMENT '供应商id',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `quality_time` int(11) DEFAULT NULL COMMENT '保质期，单位天',
  PRIMARY KEY (`income_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `price_change_log`;
CREATE TABLE `price_change_log` (
  `price_change_log_id` int(11) NOT NULL COMMENT 'id字段,自增',
  `goods_id` varchar(16) DEFAULT NULL COMMENT '商品id',
  `price` int(11) DEFAULT NULL COMMENT '最新的价格',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`price_change_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(128) DEFAULT NULL COMMENT '昵称',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

