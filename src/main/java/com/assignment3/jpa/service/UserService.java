package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.User;

public class UserService extends AbstractService<User, Long> {

    public UserService() {
        super(new UserDao());
    }

    public void deleteAllCard(User user) {
        getDao().begin();
        user.removeAllCard();
        getDao().commit();
    }

    @Override
    public void delete(User user) {
        deleteAllCard(user);
        getDao().begin();
        getDao().delete(user);
        getDao().commit();
    }

}
