package com.assignment3.struts2.action.user;

import com.assignment3.jpa.model.*;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User>, Preparable {

    private Long placeId;
    private List<User> users;
    private List<Place> places;
    private User user = new UserFaker().create();
    private List<StandardCard> userStandardCards;
    private List<SharableCard> userSharableCards;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<StandardCard> getUserStandardCards() {
        return userStandardCards;
    }

    public void setUserStandardCards(List<StandardCard> userStandardCards) {
        this.userStandardCards = userStandardCards;
    }

    public List<SharableCard> getUserSharableCards() {
        return userSharableCards;
    }

    public void setUserSharableCards(List<SharableCard> userSharableCards) {
        this.userSharableCards = userSharableCards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String createUserPage() {
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String createUser() {
        getUser().addPlace(ServiceFactory.getInstance().getPlaceService().read(getPlaceId()));
        ServiceFactory.getInstance().getUserService().create(getUser());
        return ActionSupport.SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String removeUser() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        userService.delete(userService.read(getUser().getId()));
        return ActionSupport.SUCCESS;
    }

    public String removeAllUsers() {
        ServiceFactory.getInstance().getUserService().deleteAll();
        return ActionSupport.SUCCESS;
    }

    public String showUsers() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        setUsers(userService.readAll());
        return ActionSupport.SUCCESS;
    }

    public String showUserCards(){
        setUserStandardCards(ServiceFactory.getInstance().getUserService().getUserStandardCard(userId));
        setUserSharableCards(ServiceFactory.getInstance().getUserService().getUserSharablecard(userId));
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }

    @Override
    public User getModel() {
        return user;
    }
}
