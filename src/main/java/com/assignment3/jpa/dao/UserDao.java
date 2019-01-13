package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;

import java.util.List;


public class UserDao extends AbstractDao<User, Long, String> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getUsersNotEquals(Long id) {
        return getEntityManager().createQuery("SELECT u FROM User u WHERE id <> "+id).getResultList();
    }

    public List<StandardCard> getUserStandardCards(Long id) {
        return getEntityManager().createQuery("SELECT sc FROM UserStandardCard sc WHERE user_id = "+id).getResultList();
    }
    public List<SharableCard> getUserSharableCards(Long id){
        return getEntityManager().createQuery("SELECT sh from UserSharableCard sh WHERE user1_id = "+id).getResultList();
    }
}
