package fr.masterdapm.cgaiton611;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Chien {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    @OneToOne(mappedBy = "chien")
    private Personne proprio;

    public Chien() {
    }

    public Chien(String nom) {
        this.nom = nom;
    }


}
