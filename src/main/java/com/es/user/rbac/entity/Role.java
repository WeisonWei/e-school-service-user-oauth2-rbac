package com.es.user.rbac.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate(true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_role", indexes = @Index(name = "idx_name", columnList = "name"))
public class Role extends BaseEntity {

    @Builder.Default
    @Column(name = "parent_id", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    private Long parentId = null;

    @Builder.Default
    @Column(name = "name", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String name = null;

    @Builder.Default
    @Column(name = "en_name", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String enname = null;


    @Builder.Default
    @Column(name = "description", nullable = true, columnDefinition = VARCHAR_DEFAULT_0)
    private String description = null;

    @Builder.Default
    @Column(name = "version", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    @Version //乐观锁字段
    private Long version = null;

}

