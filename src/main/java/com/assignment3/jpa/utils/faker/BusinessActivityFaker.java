package com.assignment3.jpa.utils.faker;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;

import java.util.List;

public class BusinessActivityFaker extends AbstractFaker<BusinessActivity> {

    @Override
    public BusinessActivity create() {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity.setName(getFaker().company().name());
        businessActivity.setType(getFaker().company().profession());
        return businessActivity;
    }

    public BusinessActivity createWithCards(int quantity) {
        BusinessActivity businessActivity = create();
        List<Card> cards = new CardFaker().create(quantity);
        for (Card card : cards)
            businessActivity.addCard(card);
        return businessActivity;
    }

    public BusinessActivity createWithPlace() {
        BusinessActivity businessActivity = create();
        businessActivity.addPlace(new PlaceFaker().create());
        return businessActivity;
    }
}
