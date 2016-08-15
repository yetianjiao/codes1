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
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (1, '����Ա', 'sysadmin');
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (2, '��ɫһ', 'role1');
INSERT INTO `base_role` (`id`, `name`,`code`) VALUES (3, '��ɫ��', 'role2');


-- righttemplate
truncate righttemplate;
insert into `righttemplate`(`code`, `name`) values('right_platform','ƽ̨����');

-- user
truncate `base_user`;
INSERT INTO `base_user`(`username`,`password`,`role_id`)VALUES('admin','7c4a8d09ca3762af61e59520943dc26494f8941b',1);

-- base_system_product
truncate `base_system_product`;
INSERT INTO `base_system_product` (`code`, `name`, `remark`, `order_no`) VALUES ('global','ȫ��' , '',0);

-- base_system_field
truncate `base_system_field`;
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (1, 'global', 'user_state', '�û�״̬', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (2, 'global', 'audit_state', '���״̬', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (3, 'global', 'enable', '��Ч', 1, 0, '');
INSERT INTO `base_system_field` (`id`, `system_product_code`, `code`, `name`, `order_no`, `allow_edit_option`, `remark`) 
								VALUES (4, 'global', 'gender', '�Ա�', 1, 0, '');																							

-- base_system_option
truncate `base_system_option`;
-- �û�״̬
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (1, '1', '����', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (1, '-1', 'δ����', 2, '');		
-- ���״̬
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '-1', 'δ���', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '1', '���ͨ��', 2, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (2, '-2', '�Ѳ���', 3, '');	
-- ��Ч					
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (3, '1', '��Ч', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (3, '-1', '��Ч', 2, '');	
-- �Ա�
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (4, '1', '��', 1, '');	
INSERT INTO `base_system_option` (`system_field_id`, `code`, `name`, `order_no`, `remark`) 
						VALUES (4, '2', 'Ů', 2, '');							
								

