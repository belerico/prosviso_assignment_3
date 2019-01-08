package com.assignment3.action.user;

import com.assignment3.jpa.model.User;
import com.assignment3.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport {

    private UserFaker faker = new UserFaker();
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {
        user = faker.create();
        return ActionSupport.SUCCESS;
    }
}
