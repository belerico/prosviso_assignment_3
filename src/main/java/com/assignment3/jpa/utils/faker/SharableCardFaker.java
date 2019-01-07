package com.assignment3.jpa.utils.faker;

import com.assignment3.jpa.model.SharableCard;

public class SharableCardFaker extends AbstractFaker<SharableCard> {

    @Override
    public SharableCard create() {
        SharableCard sharableCard = new SharableCard();
        sharableCard.setQuantity(10);
        sharableCard.setCardNumber(getFaker().code().gtin8());
        return sharableCard;
    }
}
