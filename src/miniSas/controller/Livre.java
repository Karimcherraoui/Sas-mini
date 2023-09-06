package miniSas.controller;

public class Livre {

    private int numeroISBN;
    private String titre;
    private String auteur;
    private String statut;

    public Livre(String titre, String auteur,int numeroISBN,  String statut) {
        this.numeroISBN = numeroISBN;
        this.titre = titre;
        this.auteur = auteur;
        this.statut = statut;
    }

    public Livre() {
    }

    public int getNumeroISBN() {
        return numeroISBN;
    }

    public void setNumeroISBN(int numeroISBN) {
        this.numeroISBN = numeroISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "numeroISBN=" + numeroISBN +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
