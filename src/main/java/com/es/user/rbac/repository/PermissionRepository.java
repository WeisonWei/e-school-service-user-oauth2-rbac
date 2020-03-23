package com.es.user.rbac.repository;

import com.es.user.rbac.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>, CrudRepository<Permission, Long> {

    Optional<Permission> findByName(String name);

}
