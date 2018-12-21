package com.assignment3.jpa.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String province;
    private String region;
    @OneToMany(mappedBy = "place", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "place", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<BusinessActivity> activities = new ArrayList<>();

    public Place() {
    }

    public Place(String city, String province, String region) {
        this.city = city;
        this.province = province;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<BusinessActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<BusinessActivity> activities) {
        this.activities = activities;
    }

    public void addBusinessActivity(BusinessActivity businessActivity) {
        this.activities.add(businessActivity);
        businessActivity.setPlace(this);
    }

    public void removeBusinessActivity(BusinessActivity businessActivity) {
        this.activities.remove(businessActivity);
        businessActivity.setPlace(null);
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setPlace(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.setPlace(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return id.equals(place.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}