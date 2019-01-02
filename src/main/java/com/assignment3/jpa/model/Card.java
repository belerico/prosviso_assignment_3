package com.assignment3.jpa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String cardNumber;
    private int quantity;
    @ManyToOne
    private BusinessActivity businessActivity;

    public Card() {
    }

    public Card(String cardNumber, int quantity) {
        this.cardNumber = cardNumber;
        this.quantity = quantity;
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
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

    public BusinessActivity getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(BusinessActivity businessActivity) {
        this.businessActivity = businessActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
