package com.es.user.rbac.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate(true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_role_permission", indexes = @Index(name = "idx_role_id", columnList = "role_id"))
public class RolePermission extends BaseEntity {

    @Builder.Default
    @Column(name = "role_id", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    private Long roleId = null;

    @Builder.Default
    @Column(name = "permission_id", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    private Long permissionId = null;

}

