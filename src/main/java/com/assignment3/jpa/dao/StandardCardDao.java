package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.StandardCard;

public class StandardCardDao extends AbstractDao<StandardCard, Long> {

    public StandardCardDao() {
        super(StandardCard.class);
    }

}
