package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.model.UserStandardCard;

import java.util.Iterator;

public class UserService extends AbstractService<User, Long> {

    public UserService() {
        super(new UserDao());
    }

    @Override
    public void delete(User entity) {
        getDao().begin();
        Iterator<UserStandardCard> i = entity.getStandardCards().iterator();
        while (i.hasNext()) {
            UserStandardCard u = i.next();
            i.remove();
            u.getUser().removeStandardCard(u.getStandardCard());
        }
        getDao().delete(entity);
        getDao().commit();
    }

}
