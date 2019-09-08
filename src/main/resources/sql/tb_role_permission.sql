use db_blogs;
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`(
`id` INT AUTO_INCREMENT,
`role` INT(2) NOT NULL ,
`role_name` VARCHAR(24),
`permission` VARCHAR(48),
`menu` VARCHAR(1024),
PRIMARY KEY(`id`),
UNIQUE index_role (role)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;