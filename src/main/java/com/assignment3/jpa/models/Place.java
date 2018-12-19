package com.assignment3.jpa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String province;
    private String region;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private Set<BusinessActivity> activities = new HashSet<>();

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

    Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    Set<BusinessActivity> getActivities() {
        return activities;
    }

    public void setActivities(Set<BusinessActivity> activities) {
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
        return city.equals(place.city) &&
                province.equals(place.province) &&
                region.equals(place.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province, region);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                ", users=" + users +
                ", activities=" + activities +
                '}';
    }
}