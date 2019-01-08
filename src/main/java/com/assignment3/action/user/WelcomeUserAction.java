package com.assignment3.action.user;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class WelcomeUserAction extends ActionSupport {

    private User user;
    private UserService userService = ServiceFactory.getInstance().getUserService();
    private String name = "Dio cane";
    private String surname;
    private String email;
    private String username;
    private String password;
    private boolean sex;
    private String dateOfBirth;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String execute() {
        DateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ITALIAN);
        user = new User();
        user.setName(getName());
        user.setEmail(getEmail());
        user.setSurname(getSurname());
        user.setSex(isSex());
        user.setPassword(getPassword());
        try {
            user.setDateOfBirth(format.parse(getDateOfBirth()));
        } catch (ParseException p) {
            System.out.println("PORCODIO");
            return ActionSupport.ERROR;
        }
        userService.create(user);
        return ActionSupport.SUCCESS;
    }
}



