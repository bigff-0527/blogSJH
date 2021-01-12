package com.bigff.blog.service;

import com.bigff.blog.po.User;

public interface UserService {

    User checkUser(String username,String password);
}
