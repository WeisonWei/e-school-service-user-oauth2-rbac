-- Oauth2.0
CREATE TABLE IF NOT EXISTS `clientdetails`
(
    `appId`                  varchar(128) NOT NULL,
    `resourceIds`            varchar(256)  DEFAULT NULL,
    `appSecret`              varchar(256)  DEFAULT NULL,
    `scope`                  varchar(256)  DEFAULT NULL,
    `grantTypes`             varchar(256)  DEFAULT NULL,
    `redirectUrl`            varchar(256)  DEFAULT NULL,
    `authorities`            varchar(256)  DEFAULT NULL,
    `access_token_validity`  int(11)       DEFAULT NULL,
    `refresh_token_validity` int(11)       DEFAULT NULL,
    `additionalInformation`  varchar(4096) DEFAULT NULL,
    `autoApproveScopes`      varchar(256)  DEFAULT NULL,
    PRIMARY KEY (`appId`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_access_token`
(
    `token_id`          varchar(256) DEFAULT NULL,
    `token`             blob,
    `authentication_id` varchar(128) NOT NULL,
    `user_name`         varchar(256) DEFAULT NULL,
    `client_id`         varchar(256) DEFAULT NULL,
    `authentication`    blob,
    `refresh_token`     varchar(256) DEFAULT NULL,
    PRIMARY KEY (`authentication_id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_approvals`
(
    `userId`         varchar(256)   DEFAULT NULL,
    `clientId`       varchar(256)   DEFAULT NULL,
    `scope`          varchar(256)   DEFAULT NULL,
    `status`         varchar(10)    DEFAULT NULL,
    `expiresAt`      timestamp NULL DEFAULT NULL,
    `lastModifiedAt` timestamp NULL DEFAULT NULL
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_client_details`
(
    `client_id`               varchar(128) NOT NULL,
    `resource_ids`            varchar(256)  DEFAULT NULL,
    `client_secret`           varchar(256)  DEFAULT NULL,
    `scope`                   varchar(256)  DEFAULT NULL,
    `authorized_grant_types`  varchar(256)  DEFAULT NULL,
    `web_server_redirect_uri` varchar(256)  DEFAULT NULL,
    `authorities`             varchar(256)  DEFAULT NULL,
    `access_token_validity`   int(11)       DEFAULT NULL,
    `refresh_token_validity`  int(11)       DEFAULT NULL,
    `additional_information`  varchar(4096) DEFAULT NULL,
    `autoapprove`             varchar(256)  DEFAULT NULL,
    PRIMARY KEY (`client_id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_client_token`
(
    `token_id`          varchar(256) DEFAULT NULL,
    `token`             blob,
    `authentication_id` varchar(128) NOT NULL,
    `user_name`         varchar(256) DEFAULT NULL,
    `client_id`         varchar(256) DEFAULT NULL,
    PRIMARY KEY (`authentication_id`)
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_code`
(
    `code`           varchar(256) DEFAULT NULL,
    `authentication` blob
) DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `oauth_refresh_token`
(
    `token_id`       varchar(256) DEFAULT NULL,
    `token`          blob,
    `authentication` blob
) DEFAULT CHARSET = utf8;


-- 用户管理
CREATE TABLE IF NOT EXISTS `tb_user`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`      varchar(50) NOT NULL COMMENT '用户名',
    `password`  varchar(64) NOT NULL COMMENT '密码，加密存储',
    `phone`     varchar(20) DEFAULT NULL COMMENT '注册手机号',
    `email`     varchar(50) DEFAULT NULL COMMENT '注册邮箱',
    `birthday`  varchar(50) DEFAULT NULL COMMENT '生日',
    `address`   varchar(50) DEFAULT NULL COMMENT '地址',
    `version`   bigint(20)  DEFAULT NULL COMMENT '版本',
    `createdId` bigint(20)  DEFAULT NULL,
    `updatedId` bigint(20)  DEFAULT NULL,
    `created`   datetime    DEFAULT NULL,
    `updated`   datetime    DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`) USING BTREE,
    UNIQUE KEY `phone` (`phone`) USING BTREE,
    UNIQUE KEY `email` (`email`) USING BTREE
) AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

CREATE TABLE IF NOT EXISTS `tb_role`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)   DEFAULT NULL COMMENT '父角色',
    `name`        varchar(64) NOT NULL COMMENT '角色名称',
    `en_name`     varchar(64) NOT NULL COMMENT '角色英文名称',
    `description` varchar(200) DEFAULT NULL COMMENT '备注',
    `createdId`   bigint(20)   DEFAULT NULL,
    `updatedId`   bigint(20)   DEFAULT NULL,
    `created`     datetime     DEFAULT NULL,
    `updated`     datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

CREATE TABLE IF NOT EXISTS `tb_permission`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)   DEFAULT NULL COMMENT '父权限',
    `name`        varchar(64)  NOT NULL COMMENT '权限名称',
    `en_name`     varchar(64)  NOT NULL COMMENT '权限英文名称',
    `url`         varchar(255) NOT NULL COMMENT '授权路径',
    `description` varchar(200) DEFAULT NULL COMMENT '备注',
    `createdId`   bigint(20)   DEFAULT NULL,
    `updatedId`   bigint(20)   DEFAULT NULL,
    `created`     datetime     DEFAULT NULL,
    `updated`     datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='权限表';

-- -- relation
CREATE TABLE IF NOT EXISTS `tb_user_role`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id`   bigint(20) NOT NULL COMMENT '用户 ID',
    `role_id`   bigint(20) NOT NULL COMMENT '角色 ID',
    `createdId` bigint(20) DEFAULT NULL,
    `updatedId` bigint(20) DEFAULT NULL,
    `created`   datetime   DEFAULT NULL,
    `updated`   datetime   DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='用户角色表';

CREATE TABLE IF NOT EXISTS `tb_role_permission`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`       bigint(20) NOT NULL COMMENT '角色 ID',
    `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
    `createdId`     bigint(20) DEFAULT NULL,
    `updatedId`     bigint(20) DEFAULT NULL,
    `created`       datetime   DEFAULT NULL,
    `updated`       datetime   DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='角色权限表';