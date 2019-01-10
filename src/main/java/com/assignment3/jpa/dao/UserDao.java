package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;


public class UserDao extends AbstractDao<User, Long, String> {

    public UserDao() {
        super(User.class);
    }
}
