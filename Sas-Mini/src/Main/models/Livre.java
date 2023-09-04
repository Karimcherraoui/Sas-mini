package Main.models;

public class Livre {
    public String titre;
    public String auteur;
    public String numeroISBN;
    public String Statut;

    public void ajouterLivre(String titre, String auteur, String numeroISBN, String Statut) {
        this.titre = titre;
        this.auteur = auteur;
        this.numeroISBN = numeroISBN;
        this.titre = "disponible";


    }

    public String getTitre() {
        return titre;
    }


    public String getAuteur() {
        return auteur;
    }


    public String getNumeroISBN() {
        return numeroISBN;
    }


    public String getStatut() {
        return Statut;
    }

}
