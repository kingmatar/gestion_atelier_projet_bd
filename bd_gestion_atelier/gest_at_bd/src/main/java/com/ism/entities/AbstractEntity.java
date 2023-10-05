package com.ism.entities;

public abstract class AbstractEntity {
    //Attributs   Instances
    protected static int nbr;
    protected int id;
    protected String libelle;

    public AbstractEntity(String libelle) {
        this.id=++nbr;
        this.libelle = libelle;
    }
    //constructeur avec argument
    public AbstractEntity(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    //sans argument
    public AbstractEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return " [id=" + id + ", libelle=" + libelle + "]";
    }
    
}
