package miniSas.controller;

public class livreEmprunte {

        private String titre;
        private String auteur;
        private String nom;
        private String prenom;
    private int numero;

    private String dateEmprunt;
        private String dateRetour;

        // Constructors

        public livreEmprunte(String titre, String auteur, String nom, String prenom,int numero , String dateEmprunt, String dateRetour) {
            this.titre = titre;
            this.auteur = auteur;
            this.nom = nom;
            this.prenom = prenom;
            this.numero = numero;
            this.dateEmprunt = dateEmprunt;
            this.dateRetour = dateRetour;
        }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumero() {
        return numero;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }
}


