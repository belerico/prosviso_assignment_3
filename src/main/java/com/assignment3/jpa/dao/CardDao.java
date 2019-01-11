package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.Card;

public class CardDao extends AbstractDao<Card, Long, String> {

    public CardDao() {
        super(Card.class);
    }
    /*public List<Card> getStandardCard(){
        return getEntityManager().createQuery("SELECT c FROM Card c WHERE type(c) = Card " ).getResultList();
    }*/
}

