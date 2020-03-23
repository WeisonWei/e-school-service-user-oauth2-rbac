package com.es.user.rbac.entity;

import com.es.user.rbac.repository.UserAuditListener;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name = "tb_user_role", indexes = @Index(name = "idx_user_id", columnList = "user_id"))
@EntityListeners({AuditingEntityListener.class, UserAuditListener.class})
public class UserRole extends BaseEntity {

    @Builder.Default
    @Column(name = "user_id", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    private Long userId = null;

    @Builder.Default
    @Column(name = "role_id", nullable = true, columnDefinition = BIGINT_DEFAULT_0)
    private Long roleId = null;

}


