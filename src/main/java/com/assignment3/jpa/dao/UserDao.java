package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;


public class UserDao extends AbstractDao<User, Long, String> {

    public UserDao() {
        super(User.class);
    }

/*    public User findUserByEmail(String email) {
        User user = null;
        try {
            user = getEntityManager()
                    .createNamedQuery("findUserByEmail", gettClass())
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException n) {
            n.printStackTrace();
        }
        return user;
    }*/
}
