use db_blogs;
DROP TABLE IF EXISTS `tb_blogs_dustbin`;
CREATE table `tb_blogs_dustbin`(
  `id` INT AUTO_INCREMENT,
  `blog_id` INT not null,
  `owner_id` INT not null,
  `title` VARCHAR(128) NOT NULL,
  `info` VARCHAR(256),
  `cover_img` VARCHAR(512),
  `tags` VARCHAR(512),
  `create_time` int,
  `update_time` int,
  `delete_time` int,
  `contents` text,
  `contents_md` text,
  `images` varchar(2014),
  PRIMARY KEY(`id`),
  UNIQUE index_blogs_dustbin (`owner_id`,`blog_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;