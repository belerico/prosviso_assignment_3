package com.assignment3.jpa.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "SH")
public class SharableCard extends Card implements Serializable {

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserSharableCard> users1 = new HashSet<>();

    @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserSharableCard> users2 = new HashSet<>();

    Set<UserSharableCard> getUsers1() {
        return users1;
    }

    Set<UserSharableCard> getUsers2() {
        return users2;
    }

    @Override
    public String toString() {
        return "SharableCard{} " + super.toString();
    }
}
