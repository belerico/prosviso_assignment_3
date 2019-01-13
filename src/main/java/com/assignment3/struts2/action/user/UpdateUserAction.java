package com.assignment3.struts2.action.user;

import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.util.List;

public class UpdateUserAction extends ActionSupport implements ModelDriven<User>, Preparable {

    private Long userId;
    private Long placeId;
    private List<Place> places;
    private User user;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String createUpdateUserPage() {
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String updateUser() {
        User user = ServiceFactory.getInstance().getUserService().read(getUserId());
        User userModified = getUser();
        user.setName(userModified.getName());
        user.setSurname(userModified.getSurname());
        user.setPassword(userModified.getPassword());
        user.setSex(userModified.isSex());
        user.setDateOfBirth(userModified.getDateOfBirth());
        user.addPlace(ServiceFactory.getInstance().getPlaceService().read(getPlaceId()));
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        if (userId != null) {
            User user = ServiceFactory.getInstance().getUserService().read(getUserId());
            setUser(user);
            setPlaceId(user.getPlace().getId());
        }
        if (places == null)
            setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }

    @Override
    public User getModel() {
        return user;
    }
}
