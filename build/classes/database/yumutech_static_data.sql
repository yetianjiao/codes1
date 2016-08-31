-- MySQL Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: yumutech
-- ------------------------------------------------------
-- Server version	5.5.21

grant all on yumutech.* to yumutech@localhost identified by "123456";
grant all on yumutech.* to yumutech@"127.0.0.1" Identified by "123456";
grant all on yumutech.* to yumutech@"%" Identified by "123456";


use `yumutech`;

-- role
truncate `base_role`;
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (1, '管理员', 'sysadmin');
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (2, '角色一', 'role1');
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (3, '角色二', 'role2');


-- righttemplate
truncate righttemplate;
insert into `righttemplate`(`code`, `name`) values('right_platform','平台管理');

-- user
truncate `base_user`;
INSERT INTO `base_user`(`username`,`password`,`role_id`)VALUES('admin','7c4a8d09ca3762af61e59520943dc26494f8941b',1);

-- base_system_product
truncate `base_system_product`;
INSERT INTO `base_system_product` (`code`, `name`, `remark`, `order_no`) VALUES ('global','全局' , '',0);

-- base_system_field
truncate `base_system_field`;
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (1, 'global', 'user_state', '用户状态', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (2, 'global', 'audit_state', '审核状态', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (3, 'global', 'enable', '有效', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (4, 'global', 'gender', '性别', 1, 0, '');																							

-- base_system_option
truncate `base_system_option`;
-- 用户状态
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (1, '1', '正常', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (1, '-1', '未激活', 2, '');		
-- 审核状态
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '-1', '未审核', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '1', '审核通过', 2, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '-2', '已驳回', 3, '');	
-- 有效					
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (3, '1', '有效', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (3, '-1', '无效', 2, '');	
-- 性别
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (4, '1', '男', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (4, '2', '女', 2, '');							
								

