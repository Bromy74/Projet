package com.test.projetfinal;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on +-19/02/2017.
 */

public class Categorie {
    private String nom;
    private int idLogo;
    private ArrayList sousCats;
    // todo Color catégorie
    public Categorie(String nom,int idLogo){
        this.nom = nom;
        this.idLogo = idLogo;
        sousCats = new ArrayList();
    }

    public void addCat(Categorie sousCat){sousCats.add(sousCat);
    }

    public String getNom() {
        return nom;
    }

    public int getIdLogo() {
        return idLogo;
    }

    public ArrayList getSousCats() {
        return sousCats;
    }
}

