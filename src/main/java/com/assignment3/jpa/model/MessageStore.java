package com.assignment3.jpa.model;

import java.io.Serializable;

public class MessageStore implements Serializable {
    private String message;

    public MessageStore() {
        message = "Hello Struts User";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
