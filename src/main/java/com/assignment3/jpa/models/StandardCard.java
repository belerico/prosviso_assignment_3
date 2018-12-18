package com.assignment3.jpa.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "ST")
public class StandardCard extends Card implements Serializable {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStandardCard> users = new HashSet<>();

    public StandardCard() {
    }

    public StandardCard(int quantity) {
        super(quantity);
    }

    Set<UserStandardCard> getUsers() {
        return users;
    }

    public void setUsers(Set<UserStandardCard> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardCard)) return false;
        if (!super.equals(o)) return false;
        StandardCard that = (StandardCard) o;
        return users.equals(that.users);
    }

    @Override
    public String toString() {
        return "StandardCard{" +
                "users=" + users +
                "} " + super.toString();
    }
}
