package com.assignment3.jpa.service;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.utils.Helper;
import com.assignment3.jpa.utils.faker.CardFaker;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardServiceTest {

    private CardService cardService;

    @AfterClass
    public static void tearDown() {
        Helper.dropDatabase();
    }

    @Before
    public void before() {
        Helper.dropDatabase();
        //Helper.resetIdAutoIncrement(Card.class);
        cardService = ServiceFactory.getInstance().getCardService();
    }

    private Card createCard() {
        Card card = new CardFaker().create();
        cardService.create(card);
        return card;
    }

    @Test
    public void create() {
        Card card = createCard();
        assertNotNull(card.getId());
    }

    @Test
    public void read() {
        Card card = createCard();
        card = cardService.read(card.getId());
        assertNotNull(card);
    }

    @Test
    public void update() {
        Card card = createCard();
        card.setQuantity(8);
        card = cardService.update(card);
        Card newCard = cardService.read(card.getId());
        assertEquals(8, newCard.getQuantity());
    }

    @Test
    public void readAll() {
        createCard();
        createCard();
        createCard();
        List<Card> cards = cardService.readAll();
        assertEquals(3, cards.size());
    }

    @Test
    public void deleteAll() {
        createCard();
        createCard();
        cardService.deleteAll();
        List<Card> cards = cardService.readAll();
        assertEquals(0, cards.size());
    }

    @Test
    public void delete() {
        Card card = createCard();
        cardService.delete(card);
        Card card2 = cardService.read(card.getId());
        assertNull(card2);
    }
}
