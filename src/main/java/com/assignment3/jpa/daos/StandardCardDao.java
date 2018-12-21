package com.assignment3.jpa.daos;

import com.assignment3.jpa.models.StandardCard;

import java.util.List;

public class StandardCardDao extends AbstractDao<StandardCard, Long> {

    public StandardCardDao(Class<StandardCard> standardCardClass) {
        super(standardCardClass);
    }

    public List<StandardCard> readAll() {
        return readAll("SELECT card FROM Card card WHERE Type(card) = StandardCard");
    }

    @Override
    public void deleteAll() {

    }
}
