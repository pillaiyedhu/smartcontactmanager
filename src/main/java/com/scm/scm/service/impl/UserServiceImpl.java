package com.scm.scm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.entity.User;
import com.scm.scm.repository.UserRepository;
import com.scm.scm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

}
