package com.es.user.rbac.repository;

import com.es.user.rbac.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomizedUserRepository {

    public List<User> findUserListByAgeAndSexAndHobbies();

}
