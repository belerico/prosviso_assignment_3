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
    private int quantity;

    public Card() {
    }

    public Card(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return quantity == card.quantity &&
                id.equals(card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
