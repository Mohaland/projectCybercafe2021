package com.example.bottomnavmyapplication;


public class PersonnelAdapter {
    private int idpersonnel;
    private String nom;
    private String prenom;
    private String login;
    private String password;

    public PersonnelAdapter(int idpersonnel, String nom, String prenom, String login, String password) {
        this.idpersonnel = idpersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public int getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(int idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
