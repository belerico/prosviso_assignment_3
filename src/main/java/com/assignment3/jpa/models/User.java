package com.assignment3.jpa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String password;
    /*
        @NaturalId represent domain model unique identifiers that have a meaning in the real world too.
        A natural id may be mutable or immutable, so an immutable natural id is expected to never change its value.
    */
    // @NaturalId(mutable = true)
    private String email;
    private Date dateOfBirth;
    private boolean sex;
    @OneToMany(mappedBy = "standardCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStandardCard> standardCards = new HashSet<>();
    @ManyToOne
    private Place place;


    public User() {
    }

    public User(String name, String surname, String password, String email, Date dateOfBirth, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Place getPlace() {
        return place;
    }

    void setPlace(Place place) {
        this.place = place;
    }

    public Set<UserStandardCard> getStandardCards() {
        return standardCards;
    }

    public void setStandardCards(Set<UserStandardCard> standardCards) {
        this.standardCards = standardCards;
    }

    public void addStandardCard(StandardCard standardCard) {
        UserStandardCard userStandardCard = new UserStandardCard(this, standardCard);
        this.standardCards.add(userStandardCard);
        standardCard.getUsers().add(userStandardCard);
    }

    public void removeStandardCard(StandardCard standardCard) {
        UserStandardCard userStandardCard = new UserStandardCard(this, standardCard);
        standardCard.getUsers().remove(userStandardCard);
        this.standardCards.remove(userStandardCard);
        userStandardCard.setStandardCard(null);
        userStandardCard.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                '}';
    }

}
