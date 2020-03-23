package com.es.user.rbac.service;

import com.es.user.rbac.entity.UserRole;
import com.es.user.rbac.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getByRoleId(Long roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }

    public List<UserRole> getByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }



}
