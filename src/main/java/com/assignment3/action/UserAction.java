package com.assignment3.action;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.jpa.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private UserFaker faker = new UserFaker();
    private UserService userService = ServiceFactory.getInstance().getUserService();;
    private User user;

    public String cazzo() {
        user = faker.create();
        userService.create(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }
}
