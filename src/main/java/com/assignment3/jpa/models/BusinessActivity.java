package com.assignment3.jpa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class BusinessActivity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        /*Name of the activity*/
        private String name;
        /*Type of the activity (e.g restaurant, bar, kebabbaro..)*/
        private String type;
        @ManyToOne
        private Place place;
        @OneToMany
        private Set<Card> cards = new HashSet<>();


        public BusinessActivity(){}

        public BusinessActivity(String name, String type, Place place) {
            this.name = name;
            this.type = type;
            this.place = place;
        }


        public Long getId() { return id; }
        public String getName() { return name; }
        public String getType() { return type; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessActivity that = (BusinessActivity) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(type, that.type) &&
                place.equals(that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, place);
    }

    @Override
        public String toString() {
        return "BusinessActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place=" + place +
                '}';

    }
}
