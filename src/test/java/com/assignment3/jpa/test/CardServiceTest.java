package com.assignment3.jpa.test;

import com.assignment3.jpa.Helper;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.service.CardService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CardServiceTest {

    private static Faker faker;
    private static CardService cardService;
    private static ArrayList<String> codeCard;

    @BeforeAll
    static void before() {
        Helper.dropDatabase();
        Helper.resetIdAutoIncrement(Card.class);
        faker = new Faker(new Locale("it"));
        cardService =  new CardService();
        codeCard = new ArrayList<String>();
    }

    @AfterAll
    static void tearDown() {
        cardService.getDao().close();
    }

    private Card createCard() {
        Card card = new Card();
        String code = faker.code().asin();
        System.out.println(codeCard);
        if(codeCard.size() == 0) {
            codeCard.add(code);
        }
        else {
            do {
                code = faker.code().asin();
            } while (codeCard.contains(code));
            codeCard.add(code);
        }
        card.setCardNumber(code);
        card.setQuantity(10);
        cardService.create(card);
        return card;
    }

    @Test
    void create() {
        Card card = createCard();
        assertNotNull(card.getId(), "PASSED");
    }

    @Test
    void read() {
        Card card = createCard();
        Card card2 = cardService.read(card.getId());
        assertNotNull(card2);
    }

    @Test
    void update() {
        Card card = createCard();
        String num = faker.code().asin();
        card.setQuantity(8);
        assertEquals(8, card.getQuantity());
    }

    @Test
    void readAll() {
        Card card1 = createCard();
        Card card2 = createCard();
        List<Card> cards = cardService.readAll();
        assertNotEquals(0, cards.size());
    }

    @Test
    void deleteAll() {
        Card card1 = createCard();
        Card card2 = createCard();
        cardService.deleteAll();
        List<Card> cards = cardService.readAll();
        assertEquals(0, cards.size());
    }

    @Test
    void delete() {
        Card card = createCard();
        cardService.delete(card);
        Card card2 = cardService.read(card.getId());
        assertNull(card2);
    }
}
