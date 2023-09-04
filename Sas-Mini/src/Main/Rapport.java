package Main;

public class Rapport {

    public int livresDisponibles;
    public int livresEmpruntes;
    public int livrePerdus;

    public int getLivresDisponibles() {
        return livresDisponibles;
    }

    public int getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public int getLivrePerdus() {
        return livrePerdus;
    }

    public int getLivres() {
        return livresDisponibles + livresEmpruntes + livrePerdus;
    }
}
