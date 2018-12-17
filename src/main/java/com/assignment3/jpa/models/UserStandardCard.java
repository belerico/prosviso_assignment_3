package com.assignment3.jpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class UserStandardCard implements Serializable {

    @Id
    @ManyToOne
    private User user;
    @Id
    @ManyToOne
    private StandardCard standardCard;
    private int consumed;

    public UserStandardCard() {
    }

    public UserStandardCard(User user, StandardCard standardCard, int consumed) {
        this.user = user;
        this.standardCard = standardCard;
        this.consumed = consumed;
    }

    public UserStandardCard(User user, StandardCard standardCard) {
        this.user = user;
        this.standardCard = standardCard;
        this.consumed = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StandardCard getStandardCard() {
        return standardCard;
    }

    public void setStandardCard(StandardCard standardCard) {
        this.standardCard = standardCard;
    }

    public int getConsumed() {
        return consumed;
    }

    public void setConsumed(int consumed) {
        this.consumed = consumed;
    }

    @Override
    public String toString() {
        return "UserStandardCard{" +
                "user=" + user +
                ", standardCard=" + standardCard +
                ", consumed=" + consumed +
                '}';
    }

}
