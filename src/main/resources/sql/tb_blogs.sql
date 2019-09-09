use db_blogs;
DROP TABLE IF EXISTS `tb_blogs`;
CREATE table `tb_blogs`(
  `id` INT AUTO_INCREMENT,
  `owner_id` INT,
  `title` VARCHAR(128) NOT NULL,
  `info` VARCHAR(256) NOT NULL,
  `cover_img` VARCHAR(512),
  `tags` VARCHAR(512),
  `create_time` int,
  `update_time` int,
  `contents` text,
  `images` varchar(2014),
  PRIMARY KEY(`id`),
  UNIQUE index_blogs (`title`,`owner_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;