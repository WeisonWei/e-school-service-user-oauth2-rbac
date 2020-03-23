package com.es.user.rbac.service;

import com.es.user.rbac.entity.Permission;
import com.es.user.rbac.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission getByName(String name) {
        return permissionRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    public Permission getById(Long permissionId) {
        return permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }


}
