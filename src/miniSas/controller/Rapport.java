package miniSas.controller;

public class Rapport {

    private int statistiqueLivreEmprunte;
    private int statistiqueLivreDisponible;
    private int statistiqueLivrePerdu;
    private int nombreLivre;

    public Rapport(int statistiqueLivreEmprunte, int statistiqueLivreDisponible, int statistiqueLivrePerdu, int nombreLivre) {
        this.statistiqueLivreEmprunte = statistiqueLivreEmprunte;
        this.statistiqueLivreDisponible = statistiqueLivreDisponible;
        this.statistiqueLivrePerdu = statistiqueLivrePerdu;
        this.nombreLivre = nombreLivre;

    }

    public Rapport() {
    }




}
