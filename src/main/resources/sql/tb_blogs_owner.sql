use db_blogs;
DROP TABLE IF EXISTS `tb_blogs_owner`;
CREATE table `tb_blogs_owner`(
  `id` INT AUTO_INCREMENT,
	`name` VARCHAR(12) NOT NULL,
	`info` VARCHAR(128) NOT NULL,
	`role` INT(2),
	`create_time` int,
	`update_time` int,
	PRIMARY KEY(`id`),
	UNIQUE index_user (name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;