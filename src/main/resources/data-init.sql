delete from `tb_permission`;
delete from `tb_role`;
delete from `tb_role_permission`;
delete from `tb_user`;
delete from `tb_user_role`;
delete from `tb_content`;
delete from `tb_content_category`;

insert into `tb_permission`(`id`, `parent_id`, `name`, `en_name`, `url`, `description`)
values (37, 0, '系统管理', 'System', '/', NULL),
       (38, 37, '用户管理', 'SystemUser', '/users/', NULL),
       (39, 38, '查看用户', 'SystemUserView', '/users/view/**', NULL),
       (40, 38, '新增用户', 'SystemUserInsert', '/users/insert/**', NULL),
       (41, 38, '编辑用户', 'SystemUserUpdate', '/users/update/**', NULL),
       (42, 38, '删除用户', 'SystemUserDelete', '/users/delete/**', NULL),
       (44, 37, '内容管理', 'SystemContent', '/contents/', NULL),
       (45, 44, '查看内容', 'SystemContentView', '/contents/view/**', NULL),
       (46, 44, '新增内容', 'SystemContentInsert', '/contents/insert/**', NULL),
       (47, 44, '编辑内容', 'SystemContentUpdate', '/contents/update/**', NULL),
       (48, 44, '删除内容', 'SystemContentDelete', '/contents/delete/**', NULL);


insert into `tb_role`(`id`, `parent_id`, `name`, `en_name`, `description`)
values (37, 0, '超级管理员', 'admin', NULL);

insert into `tb_role_permission`(`id`, `role_id`, `permission_id`)
values (37, 37, 37),
       (38, 37, 38),
       (39, 37, 39),
       (40, 37, 40),
       (41, 37, 41),
       (42, 37, 42),
       (43, 37, 44),
       (44, 37, 45),
       (45, 37, 46),
       (46, 37, 47),
       (47, 37, 48);
insert into `tb_user`(`id`, `name`, `password`, `phone`, `email`)
values (37, 'admin', '$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi', '15888888888',
        'weixx3@126.com');


insert into `tb_user_role`(`id`, `user_id`, `role_id`)
values (37, 37, 37);
