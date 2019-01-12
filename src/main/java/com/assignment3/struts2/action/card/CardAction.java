package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.*;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.utils.faker.CardFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CardAction extends ActionSupport implements ModelDriven<Card>, Preparable {

    private List<Card> cards;
    private String cardType;
    private Card card = new CardFaker().create();
    private Long activityId;
    private List<SharableCard> sharableCards;
    private List<StandardCard> standardCards;
    private List<User> usersShare;
    private Long userId;
    private Long userShareId;
    private Long cardId;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String myType) {
        this.cardType = myType;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<SharableCard> getSharableCards() {
        return sharableCards;
    }

    public void setSharableCards(List<SharableCard> sharableCards) {
        this.sharableCards = sharableCards;
    }

    public Long getUserShareId() {
        return userShareId;
    }

    public void setUserShareId(Long userShareId) {
        this.userShareId = userShareId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public List<StandardCard> getStandardCards() {
        return standardCards;
    }

    public void setStandardCards(List<StandardCard> standardCards) {
        this.standardCards = standardCards;
    }

    public List<User> getUsersShare() {
        return usersShare;
    }

    public void setUsersShare(List<User> usersShare) {
        this.usersShare = usersShare;
    }

    public String createCardPage() {
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String createCard() {
        BusinessActivity activity = ServiceFactory.getInstance().getBusinessActivityService().read(getActivityId());
        Card card = getCard();
        if (card instanceof StandardCard && getCardType().equals("SH"))
            card = new SharableCard(card.getCardNumber(), card.getQuantity());
        else if (card instanceof SharableCard && getCardType().equals("ST"))
            card = new StandardCard(card.getCardNumber(), card.getQuantity());
        activity.addCard(card);
        ServiceFactory.getInstance().getCardService().create(card);
        return ActionSupport.SUCCESS;
    }

    public String createAddStandardCardPage() {
        setStandardCards(ServiceFactory.getInstance().getCardService().getStandardCards());
        return ActionSupport.SUCCESS;
    }

    public String createAddSharableCardPage() {
        sharableCards = ServiceFactory.getInstance().getCardService().getSharableCards();
        usersShare = ServiceFactory.getInstance().getUserService().getUsersNotEquals(getUserId());
        return ActionSupport.SUCCESS;
    }

    public String addStandardCard() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        User user = userService.read(getUserId());
        StandardCard st = (StandardCard) ServiceFactory.getInstance().getCardService().read(getCardId());
        userService.addStandardCard(user, st);
        userService.create(user);
        return ActionSupport.SUCCESS;
    }

    public String addSharableCard() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        User user1 = userService.read(getUserId());
        User user2 = userService.read(getUserShareId());
        SharableCard sh = (SharableCard) ServiceFactory.getInstance().getCardService().read(getCardId());
        userService.addSharableCard(user1, user2, sh);
        userService.create(user1);
        return  ActionSupport.SUCCESS;
    }

    public String removeCard() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        cardService.delete(cardService.read(getCard().getId()));
        return ActionSupport.SUCCESS;
    }

    public String removeAllCards() {
        ServiceFactory.getInstance().getCardService().deleteAll();
        return ActionSupport.SUCCESS;
    }

    public String showCards() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        if (card instanceof StandardCard)
            setCardType("ST");
        else if (card instanceof SharableCard)
            setCardType("SH");
    }

    @Override
    public Card getModel() {
        return card;
    }
}
