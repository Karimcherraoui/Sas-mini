package Main.models;

import java.util.Date;


public class Emprunt {
    private Livre livre;
    private Utilisateur emprunt;

    private Date dateEmprunt;
    private Date dateRetour;

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Utilisateur getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Utilisateur emprunt) {
        this.emprunt = emprunt;
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
