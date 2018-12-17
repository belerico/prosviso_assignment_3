package com.assignment3.jpa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Card implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    /*
        Find a card number structure and an algorithm to generate it
        @NaturalId(mutable = false)
        private Strig cardNumber;
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id.equals(card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                '}';
    }
}
