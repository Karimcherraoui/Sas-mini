package Main;

import java.util.ArrayList;
import java.util.List;

import Main.models.Livre;
import Main.models.Emprunt;


public class Bibliotheque {

    public Livre livre;
    public Emprunt emprunt;
    private List<Livre> livres;

    public Bibliotheque() {
        livres = new ArrayList<>();
    }

    public void ajouterLivre(String titre, String auteur, String numeroISBN) {
        Livre livre = new Livre("hello", "hi", "java123", "test");

    }


}
