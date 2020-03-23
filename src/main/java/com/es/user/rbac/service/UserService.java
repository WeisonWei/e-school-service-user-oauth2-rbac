package com.es.user.rbac.service;

import com.es.user.rbac.entity.User;
import com.es.user.rbac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
    }


}
