package com.assignment3.jpa.utils.faker;

import com.assignment3.jpa.model.Card;

public class CardFaker extends AbstractFaker<Card> {

    @Override
    public Card create() {
        if (getFaker().random().nextBoolean())
            return new StandardCardFaker().create();
        else
            return new SharableCardFaker().create();
    }

/*    public SharableCard createSharableCard() {
        SharableCard sharableCard = new SharableCard();
        sharableCard.setQuantity(10);
        sharableCard.setCardNumber(getFaker().code().gtin8());
        return sharableCard;
    }

    public StandardCard createStandardCard() {
        StandardCard standardCard = new StandardCard();
        standardCard.setQuantity(10);
        standardCard.setCardNumber(getFaker().code().gtin8());
        return standardCard;
    }*/
}
