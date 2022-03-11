package com.example.parsejson;

import androidx.annotation.NonNull;

public class Etudiant {
    public int id,age;
    public String nom,prenom,CIN;

    public Etudiant() {

    }

    public Etudiant(int id, int age, String nom, String prenom, String CIN) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCIN() {
        return CIN;
    }
}
