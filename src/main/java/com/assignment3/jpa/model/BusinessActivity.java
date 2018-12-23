package com.assignment3.jpa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BusinessActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String name;
    private String type;
    @ManyToOne
    private Place place;
    @OneToMany(mappedBy = "businessActivity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    public BusinessActivity() {
    }

    public BusinessActivity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        card.setBusinessActivity(this);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
        card.setBusinessActivity(null);
    }

    public void removeAllCard() {
        this.cards.clear();
    }

    public void addPlace(Place place) {
        this.place = place;
        place.getActivities().add(this);
    }

    public void removePlace(Place place) {
        this.place = null;
        place.getActivities().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessActivity)) return false;
        BusinessActivity that = (BusinessActivity) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "BusinessActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cards=" + cards +
                '}';
    }
}
