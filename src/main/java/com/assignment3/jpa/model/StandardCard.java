package com.assignment3.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "ST")
public class StandardCard extends Card implements Serializable {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStandardCard> users = new HashSet<>();

    public StandardCard() {
    }

    public StandardCard(String cardNumber, int quantity) {
        super(cardNumber, quantity);
    }

    public StandardCard(String cardNumber) {
        super(cardNumber);
    }

    public StandardCard(int quantity) {
        super(quantity);
    }

    public Set<UserStandardCard> getUsers() {
        return users;
    }

    public List<User> getUsersList() {
        List<User> l = new ArrayList<>();
        for (UserStandardCard u : users)
            l.add(u.getUser());
        return l;
    }

    public void setUsers(Set<UserStandardCard> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "StandardCard{} " + super.toString();
    }
}
