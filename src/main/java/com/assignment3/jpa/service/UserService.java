package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.User;

public class UserService extends AbstractService<User, Long> {

    public UserService() {
        super(new UserDao(User.class));
    }
}
