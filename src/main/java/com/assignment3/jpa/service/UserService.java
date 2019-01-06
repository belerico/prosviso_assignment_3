package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.UserDao;
import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;

public class UserService extends AbstractService<User, Long> {

    public UserService() {
        super(new UserDao());
    }

    public void addPlace(User user, Place place) {
        getDao().begin();
        user.addPlace(place);
        getDao().commit();
    }

    public void removePlace(User user) {
        Place place = user.getPlace();
        getDao().begin();
        if (place != null)
            user.removePlace(place);
        getDao().commit();
    }

    public void addStandardCard(User user, StandardCard standardCard) {
        getDao().begin();
        user.addStandardCard(standardCard);
        getDao().commit();
    }

    public void addSharableCard(User user1, User user2, SharableCard sharableCard) {
        getDao().begin();
        user1.addSharableCard(user2, sharableCard);
        getDao().commit();
    }

    public void removeAllCard(User user) {
        getDao().begin();
        user.removeAllCard();
        getDao().commit();
    }

    @Override
    public void delete(User user) {
        removeAllCard(user);
        getDao().begin();
        getDao().delete(user);
        getDao().commit();
    }

}
