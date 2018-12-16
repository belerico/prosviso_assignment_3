package com.assignment3.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Date dateOfBirth;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the date of birth
     */
    public Date dateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth of birth the dateOfBirth to set
     */
    public void setBirthdate(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", email="
                + email + ", birthdate=" + dateOfBirth + "]";
    }
}
