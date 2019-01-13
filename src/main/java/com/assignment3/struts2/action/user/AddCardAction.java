package com.assignment3.struts2.action.user;

import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class AddCardAction extends ActionSupport {

    private List<SharableCard> sharableCards;
    private List<StandardCard> standardCards;
    private List<User> usersShare;
    private Long userId;
    private Long userShareId;
    private Long cardId;

    public List<SharableCard> getSharableCards() {
        return sharableCards;
    }

    public void setSharableCards(List<SharableCard> sharableCards) {
        this.sharableCards = sharableCards;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return ActionSupport.SUCCESS;
    }
}
