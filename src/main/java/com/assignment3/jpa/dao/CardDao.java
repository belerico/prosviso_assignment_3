package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.Card;

public class CardDao extends AbstractDao<Card, Long> {

    public CardDao() {
        super(Card.class);
    }
}
