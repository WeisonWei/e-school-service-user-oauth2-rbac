package com.es.user.rbac.service;

import com.es.user.rbac.entity.BaseEntity;
import com.es.user.rbac.entity.Permission;
import com.es.user.rbac.entity.RolePermission;
import com.es.user.rbac.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户授权
        User user = userService.getByName(username);
        List<SimpleGrantedAuthority> grantedAuthorities = userRoleService.getByUserId(user.getId())
                .stream()
                .map(BaseEntity::getId)
                .map(rolePermissionService::getByRoleId)
                .flatMap(List::stream)
                .map(RolePermission::getPermissionId)
                .map(permissionService::getById)
                .map(Permission::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // 由框架完成认证工作
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);
    }
}
