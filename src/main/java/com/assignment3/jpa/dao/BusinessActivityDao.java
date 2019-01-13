package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;

import java.util.List;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long, String> {

    public BusinessActivityDao() {
        super(BusinessActivity.class);
    }

    public List<Card> getActivityCards(Long id){
        return getEntityManager().createQuery("SELECT c from Card c WHERE businessActivity_id =" + id).getResultList();
    }

}
