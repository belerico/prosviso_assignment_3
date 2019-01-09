package com.assignment3.action.user;

import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class CreateUserAction extends ActionSupport implements Preparable {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Long placeId;
    private List<Place> places;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        User user = new UserFaker().create();
        setName(user.getName());
        setSurname(user.getSurname());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setDateOfBirth(user.getDateOfBirth());
        return ActionSupport.SUCCESS;
    }

    public String createUser() {
        User user = new User();
        user.setName(getName());
        user.setSurname(getSurname());
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setDateOfBirth(getDateOfBirth());
        user.addPlace(ServiceFactory.getInstance().getPlaceService().read(placeId));
        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            userService.create(user);
        } catch (PersistenceException p) {
            userService.getDao().rollback();
            addActionError(p.toString());
            return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }
}
