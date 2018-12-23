package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;

public class UserDao extends AbstractDao<User, Long> {

    public UserDao(Class<User> userClass) {
        super(userClass);
    }
}
