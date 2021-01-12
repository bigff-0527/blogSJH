package com.bigff.blog.service;

import com.bigff.blog.dao.UserRepository;
import com.bigff.blog.po.User;
import com.bigff.blog.po.util.MD5utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5utils.getMD5(password));
        return user;
    }
}
