package miniSas.controller;

public class Utilisateur {
    private int utilisateurID;
    private String nom;
    private String prenom;
    private int numero;

    public Utilisateur(int utilisateurID, String nom, String prenom, int numero) {
        this.utilisateurID = utilisateurID;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }


    public Utilisateur( String nom, String prenom, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    public Utilisateur() {
    }

    public int getUtilisateurID() {
        return utilisateurID;
    }

    public void setUtilisateurID(int utilisateurID) {
        this.utilisateurID = utilisateurID;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
