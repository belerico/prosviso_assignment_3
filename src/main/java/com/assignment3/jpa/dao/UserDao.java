package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;

import javax.persistence.NoResultException;

public class UserDao extends AbstractDao<User, Long> {

    public UserDao() {
        super(User.class);
    }

    public User findUserByEmail(String email) {
        User user = null;
        try {
            user = getEntityManager()
                    .createNamedQuery("findUserByEmail", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException n) {
            n.printStackTrace();
        }
        return user;
    }
}
