SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `yumutech`.`base_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_log` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_log` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `controller` VARCHAR(45) NULL COMMENT 'controller' ,
  `action` VARCHAR(45) NULL COMMENT 'action' ,
  `event` VARCHAR(512) NULL COMMENT '事件描述' ,
  `op_user_id` INT NULL COMMENT '操作人' ,
  `op_time` DATETIME NULL COMMENT '操作时间' ,
  `ip` VARCHAR(128) NULL COMMENT '访问ip' ,
  `product_code` VARCHAR(12) NULL COMMENT '产品代号' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '基础-日志表';


-- -----------------------------------------------------
-- Table `yumutech`.`base_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_user` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `username` VARCHAR(45) NOT NULL COMMENT '登录帐号' ,
  `password` VARCHAR(64) NOT NULL COMMENT '登录密码' ,
  `nickname` VARCHAR(45) NULL COMMENT '昵称' ,
  `gender` TINYINT NULL COMMENT '性别：1 男 2女' ,
  `birthday` DATE NULL COMMENT '生日' ,
  `email` VARCHAR(128) NULL COMMENT '电子邮箱' ,
  `mobile` VARCHAR(45) NULL COMMENT '手机' ,
  `telephone` VARCHAR(45) NULL COMMENT '座机' ,
  `qq` VARCHAR(45) NULL COMMENT 'QQ' ,
  `address` VARCHAR(128) NULL COMMENT '地址' ,
  `post_code` VARCHAR(12) NULL COMMENT '邮政编码' ,
  `role_id` INT NOT NULL COMMENT '所属角色' ,
  `user_state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态 -1：未激活，1：激活' ,
  `is_delete` TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除' ,
  `logo_path` VARCHAR(128) NULL COMMENT '照片' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB
COMMENT = '基础-用户表';


-- -----------------------------------------------------
-- Table `yumutech`.`base_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_role` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_role` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `name` VARCHAR(45) NOT NULL COMMENT '角色名' ,
  `code` VARCHAR(45) NOT NULL COMMENT '角色code' ,
  `is_delete` TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
COMMENT = '基础-角色表';


-- -----------------------------------------------------
-- Table `yumutech`.`base_system_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_system_product` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_system_product` (
  `code` VARCHAR(24) NOT NULL COMMENT '产品代码' ,
  `name` VARCHAR(64) NOT NULL COMMENT '产品名称' ,
  `remark` VARCHAR(128) NULL COMMENT '备注' ,
  `order_no` INT NOT NULL DEFAULT 99 COMMENT '排序' )
ENGINE = InnoDB
COMMENT = '基础-系统产品表';


-- -----------------------------------------------------
-- Table `yumutech`.`base_system_field`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_system_field` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_system_field` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `system_product_code` VARCHAR(24) NOT NULL DEFAULT 0 COMMENT '所属产品' ,
  `code` VARCHAR(24) NOT NULL COMMENT '分类代码' ,
  `name` VARCHAR(64) NOT NULL COMMENT '分类名' ,
  `order_no` INT NULL DEFAULT 999 COMMENT '排序' ,
  `allow_edit_option` TINYINT NULL DEFAULT 1 COMMENT '是否允许编辑，默认为1，可以编辑；0为不可以编辑' ,
  `remark` VARCHAR(128) NULL COMMENT '备注' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '基础-系统分类表';


-- -----------------------------------------------------
-- Table `yumutech`.`base_system_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`base_system_option` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`base_system_option` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `system_field_id` INT NOT NULL COMMENT '所属系统分类' ,
  `code` VARCHAR(24) NOT NULL COMMENT '代码' ,
  `name` VARCHAR(64) NOT NULL COMMENT '名称' ,
  `order_no` INT NULL DEFAULT 999 COMMENT '排序' ,
  `remark` VARCHAR(128) NULL COMMENT '备注' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '基础-系统选项表';


-- -----------------------------------------------------
-- Table `yumutech`.`righttemplate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`righttemplate` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`righttemplate` (
  `code` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NULL ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB
COMMENT = '权限模板表';


-- -----------------------------------------------------
-- Table `yumutech`.`roleright`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`roleright` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`roleright` (
  `role_id` INT NOT NULL ,
  `righttemplate_code` VARCHAR(45) NOT NULL )
ENGINE = InnoDB
COMMENT = '角色权限表';


-- -----------------------------------------------------
-- Table `yumutech`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yumutech`.`student` ;

CREATE  TABLE IF NOT EXISTS `yumutech`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `sn` VARCHAR(20) NOT NULL COMMENT '学号' ,
  `name` VARCHAR(20) NOT NULL COMMENT '姓名' ,
  `gender` TINYINT NULL COMMENT '性别，1：男；2：女' ,
  `age` INT NULL COMMENT '年龄' ,
  `is_deleted` TINYINT NOT NULL COMMENT '是否有效，0：有效；1：已删除' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '学生表';



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
