package com.ism.entities;

public class Categorie  extends AbstractEntity{
    
    public Categorie(){
        super();
    }

    public Categorie(int id, String libelle){
        super(id,libelle);
    }

    public Categorie(String libelle){
        super(libelle);
    }

    @Override
     public String toString() {
         return "Categorie" + super.toString();
     }
     
}
