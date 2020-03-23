package com.es.user.rbac.repository;

import com.es.user.rbac.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>, CrudRepository<UserRole, Long> {

    List<UserRole> findByRoleId(Long roleId);

    List<UserRole> findByUserId(Long userId);
}
