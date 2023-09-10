package miniSas.controller;

import miniSas.controller.Livre;
import miniSas.controller.Utilisateur;

import java.util.Date;

public class Emprunt {
    private int empruntID;
    private Livre livre;
    private Utilisateur emprunteur;
    private Date dateEmprunt;
    private Date dateRetour;

    public Emprunt(Livre livre, Utilisateur emprunteur, Date dateEmprunt, Date dateRetour) {
        this.livre = livre;
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Utilisateur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Utilisateur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }



}
