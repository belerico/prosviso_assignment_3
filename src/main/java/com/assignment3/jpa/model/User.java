package com.assignment3.jpa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;
    @NaturalId
    private String email;
    private Date dateOfBirth;
    private boolean sex;
    @OneToMany(mappedBy = "standardCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserStandardCard> standardCards = new HashSet<>();
    @OneToMany(mappedBy = "sharableCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserSharableCard> sharableCards = new HashSet<>();
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

    public Set<UserStandardCard> getStandardCards() {
        return standardCards;
    }

    public void setStandardCards(Set<UserStandardCard> standardCards) {
        this.standardCards = standardCards;
    }

    public Set<UserSharableCard> getSharableCards() {
        return sharableCards;
    }

    public void setSharableCards(Set<UserSharableCard> sharableCards) {
        this.sharableCards = sharableCards;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void addPlace(Place place) {
        setPlace(place);
        place.getUsers().add(this);
    }

    public void removePlace(Place place) {
        setPlace(null);
        place.getUsers().remove(this);
    }

    public void addStandardCard(StandardCard standardCard) {
        UserStandardCard userStandardCard = new UserStandardCard(this, standardCard);
        this.standardCards.add(userStandardCard);
        standardCard.getUsers().add(userStandardCard);
    }

    public void removeStandardCard(StandardCard standardCard) {
        UserStandardCard userStandardCard = new UserStandardCard(this, standardCard);
        this.standardCards.remove(userStandardCard);
        standardCard.getUsers().remove(userStandardCard);
        userStandardCard.setStandardCard(null);
        userStandardCard.setUser(null);
    }

    public void removeAllStandardCard() {
        Iterator<UserStandardCard> iUSC = getStandardCards().iterator();
        UserStandardCard usc;
        while (iUSC.hasNext()) {
            usc = iUSC.next();
            iUSC.remove();
            removeStandardCard(usc.getStandardCard());
        }
    }

    public void addSharableCard(User user, SharableCard sharableCard) {
        UserSharableCard userSharableCard = new UserSharableCard(this, user, sharableCard);
        this.getSharableCards().add(userSharableCard);
        sharableCard.getUsers1().add(userSharableCard);
        /*
            Need to maintain the simmetry between users
         */
        userSharableCard = new UserSharableCard(user, this, sharableCard);
        user.getSharableCards().add(userSharableCard);
        sharableCard.getUsers2().add(userSharableCard);
    }

    public void removeSharableCard(User user, SharableCard sharableCard) {
        UserSharableCard userSharableCard = new UserSharableCard(this, user, sharableCard);
        this.getSharableCards().remove(userSharableCard);
        sharableCard.getUsers1().remove(userSharableCard);
        sharableCard.getUsers2().remove(userSharableCard);
        /*
            Need to maintain the simmetry between users
         */
        userSharableCard = new UserSharableCard(user, this, sharableCard);
        user.getSharableCards().remove(userSharableCard);
        sharableCard.getUsers1().remove(userSharableCard);
        sharableCard.getUsers2().remove(userSharableCard);
    }

    public void removeAllSharableCard() {
        Iterator<UserSharableCard> iUSH = getSharableCards().iterator();
        UserSharableCard ush;
        while (iUSH.hasNext()) {
            ush = iUSH.next();
            iUSH.remove();
            removeSharableCard(ush.getUser2(), ush.getSharableCard());
        }
    }

    public void removeAllCard() {
        removeAllStandardCard();
        removeAllSharableCard();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
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
