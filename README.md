# e-school-service-user
## 开发步骤
    初始化 RBAC 相关表
    在数据库中配置“用户”、“角色”、“权限”相关信息
    数据库操作使用 tk.mybatis 框架，故需要增加相关依赖
    配置 Web 安全
        配置使用自定义认证与授权
    通过 GET 请求访问认证服务器获取授权码
        端点：/oauth/authorize
    通过 POST 请求利用授权码访问认证服务器获取令牌
        端点：/oauth/token

## 默认的端点 URL

    /oauth/authorize：授权端点
    /oauth/token：令牌端点
    /oauth/confirm_access：用户确认授权提交端点
    /oauth/error：授权服务错误信息端点
    /oauth/check_token：用于资源服务访问的令牌解析端点
    /oauth/token_key：提供公有密匙的端点，如果你使用 JWT 令牌的话

