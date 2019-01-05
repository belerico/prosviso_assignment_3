package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.User;

public class UserService extends AbstractService<User, Long> {

    public UserService() {
        super(new UserDao());
    }

    @Override
    public void delete(User user) {
        getDao().begin();
        user.removeAllCard();
        getDao().delete(user);
        getDao().commit();
    }

}
