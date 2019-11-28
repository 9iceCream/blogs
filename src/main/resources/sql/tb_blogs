use db_blogs;
DROP TABLE IF EXISTS `tb_blogs`;
CREATE table `tb_blogs`(
  `id` INT AUTO_INCREMENT,
  `blog_id` INT not null,
  `owner_id` INT not null,
  `title` VARCHAR(128) NOT NULL,
  `info` VARCHAR(256),
  `cover_img` VARCHAR(512),
  `tags` VARCHAR(512),
  `create_time` int,
  `update_time` int,
  `contents` text,
  `contents_md` text,
  `images` varchar(2014),
  `delete_flag` int(2) default 1,
  PRIMARY KEY(`id`),
  UNIQUE index_blogs (`owner_id`,`blog_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;