package com.assignment3.jpa.models;
import javax.persistence.*;
import java.util.ArrayList;


@Entity(name="Place")
@Table
public class Place
{

    @Id
    @GeneratedValue
    private Long place_id;
    private String citta;
    private String provincia;
    private String regione;

    @OneToMany(mappedBy = "place")
    private ArrayList<User> user = new ArrayList<>();

    public void setPlace_id(Long place_id) { this.place_id = place_id; }

    public void setCitta(String citta) { this.citta = citta; }

    public void setProvincia(String provincia) { this.provincia = provincia; }

    public void setRegione(String regione) { this.regione = regione; }

    public Long getPlace_id() { return place_id; }

    public String getCitta() { return citta; }

    public String getProvincia() { return provincia; }

    public String getRegione() { return regione; }



    @Override
    public String toString() {
        return "Place{" +
                "id=" + place_id +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                ", regione='" + regione + '\'' +
                '}';
    }


}
