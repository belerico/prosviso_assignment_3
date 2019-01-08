package com.assignment3.utils.faker;

import com.assignment3.jpa.model.StandardCard;

public class StandardCardFaker extends AbstractFaker<StandardCard> {

    @Override
    public StandardCard create() {
        StandardCard standardCard = new StandardCard();
        standardCard.setQuantity(10);
        standardCard.setCardNumber(getFaker().code().gtin8());
        return standardCard;
    }
}
