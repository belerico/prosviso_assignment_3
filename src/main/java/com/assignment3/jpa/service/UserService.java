package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.StandardCardDao;
import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;

import java.util.List;

public class UserService extends AbstractService<User, Long> {

    private StandardCardDao scDao;

    public UserService() {
        super(new UserDao());
        scDao = new StandardCardDao();
    }

    public void addStandardCard(User u, StandardCard s) {
        getDao().begin();
        getDao().create(u);
        scDao.create(s);
        u.addStandardCard(s);
        getDao().flush();
        getDao().commit();
    }

    public void removeStandardCardFromAllUser(StandardCard s) {
        List<User> users = readAll();
        getDao().begin();
        for (User u : users) {
            if (u.getStandardCards().contains(s))
                u.removeStandardCard(s);
        }
        getDao().commit();
    }
}
