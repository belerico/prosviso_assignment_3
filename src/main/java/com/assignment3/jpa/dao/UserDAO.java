package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.model.UserSharableCard;
import com.assignment3.jpa.model.UserStandardCard;

import java.util.List;


public class UserDAO extends AbstractDAO<User, Long, String> {

    public UserDAO() {
        super(User.class);
    }

    public List<User> getUsersNotEquals(Long id) {
        return getEntityManager().createQuery("SELECT u FROM User u WHERE id <> "+id).getResultList();
    }

    public List<UserStandardCard> getUserStandardCards(Long id) {
        return getEntityManager().createQuery("SELECT sc FROM UserStandardCard sc WHERE user_id = " + id).getResultList();
    }

    public List<UserSharableCard> getUserSharableCards(Long id) {
        return getEntityManager().createQuery("SELECT sh from UserSharableCard sh WHERE user1_id = " + id).getResultList();
    }
}
