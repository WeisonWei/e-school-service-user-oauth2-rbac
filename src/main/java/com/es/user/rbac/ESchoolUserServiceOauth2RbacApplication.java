package com.es.user.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.es.user.rbac.entity"})
@EnableJpaRepositories(basePackages = {"com.es.user.rbac.repository"})
@EnableJpaAuditing
@EnableDiscoveryClient
public class ESchoolUserServiceOauth2RbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(ESchoolUserServiceOauth2RbacApplication.class, args);
    }

}
