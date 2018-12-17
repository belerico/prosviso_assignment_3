package com.assignment3.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Place
{

    @Id
    @GeneratedValue
    private Long id;
    private String citta;
    private String provincia;
    private String regione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }


    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                ", regione='" + regione + '\'' +
                '}';
    }
}
