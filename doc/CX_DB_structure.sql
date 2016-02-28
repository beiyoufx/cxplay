--
-- Create schema cx_db
--

-- ！！this statemnet will drop database
DROP DATABASE IF EXISTS cx_db;
CREATE DATABASE cx_db;

-- CREATE DATABASE IF NOT EXISTS cx_db;
USE cx_db;

--
-- Definition of table `video`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `en_name` VARCHAR(64) NULL,
  `create_time` DATE NOT NULL,
  `update_time` DATE NOT NULL,
  `url` VARCHAR(64) NOT NULL,
  `pic` VARCHAR(64) NOT NULL,
  `clarity` VARCHAR(64) NULL,
  `synopsis` VARCHAR(512) NULL,
  `episode` INT NOT NULL DEFAULT 1,
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  `actors` VARCHAR(64) NULL DEFAULT NULL,
  `directors` VARCHAR(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `category`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `area`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`area` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `tag`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `user`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `display_name` VARCHAR(64) NULL,
  `create_time` DATE NULL,
  `update_time` DATE NULL,
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `role`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `display_name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `permission`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `video_category`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`video_category` (
  `video_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`video_id`, `category_id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `video_area`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`video_area` (
  `video_id` INT NOT NULL,
  `area_id` INT NOT NULL,
  PRIMARY KEY (`video_id`, `area_id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `video_tag`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`video_tag` (
  `video_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`video_id`, `tag_id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `user_role`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

--
-- Definition of table `role_permission`
--

CREATE TABLE IF NOT EXISTS `cx_db`.`role_permission` (
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;