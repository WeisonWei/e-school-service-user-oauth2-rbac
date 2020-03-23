package com.es.user.rbac.service;

import com.es.user.rbac.entity.RolePermission;
import com.es.user.rbac.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<RolePermission> getByRoleId(Long roleId) {
        return rolePermissionRepository.findByRoleId(roleId);
    }

    public List<RolePermission> getByPermissionId(Long permissionId) {
        return rolePermissionRepository.findByPermissionId(permissionId);
    }


}
