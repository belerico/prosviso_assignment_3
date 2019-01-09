package com.assignment3.action.user;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class UserAction extends ActionSupport {

    private List<User> users;
    private UserService userService;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String showUsers() {
        userService = ServiceFactory.getInstance().getUserService();
        setUsers(userService.readAll());
        return ActionSupport.SUCCESS;
    }
}
