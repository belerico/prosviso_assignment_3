package com.assignment3.action.user;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.utils.faker.UserFaker;
import com.opensymphony.xwork2.ActionSupport;

public class FakeUserAction extends ActionSupport {

    private UserFaker faker = new UserFaker();
    private User user = faker.create();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {
        return ActionSupport.SUCCESS;
    }
}
