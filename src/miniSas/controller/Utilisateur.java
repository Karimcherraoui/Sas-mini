package miniSas.controller;

public class Utilisateur {
    private int utilisateurID;
    private String nom;
    private String prenom;




    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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
}
