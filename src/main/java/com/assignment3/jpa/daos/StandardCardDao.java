package com.assignment3.jpa.daos;

import com.assignment3.jpa.models.StandardCard;

import java.util.List;

public class StandardCardDao extends AbstractDao<StandardCard, Long> {

    @Override
    public void create(StandardCard entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public StandardCard read(Long id) {
        return getEntityManager().find(StandardCard.class, id);
    }

    @Override
    public void update(StandardCard entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(StandardCard entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public List<StandardCard> readAll() {
        return getEntityManager().createQuery("SELECT card FROM Card card WHERE Type(card) = StandardCard").getResultList();
    }

    @Override
    public void deleteAll() {

    }
}
