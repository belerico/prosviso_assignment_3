package com.assignment3.struts2.action.user;

import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class UserAction extends ActionSupport {

    private Long userId;
    private List<User> users;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String removeUser() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        userService.delete(userService.read(userId));
        return ActionSupport.SUCCESS;
    }

    public String showUsers() {
        UserService userService = ServiceFactory.getInstance().getUserService();
        setUsers(userService.readAll());
        return ActionSupport.SUCCESS;
    }
}
