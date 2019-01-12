package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;

import java.util.List;


public class UserDao extends AbstractDao<User, Long, String> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getUsersNotEquals(Long id) {
        return getEntityManager().createQuery("SELECT u FROM User u WHERE id <> "+id).getResultList();
    }
}
