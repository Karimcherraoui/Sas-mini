package Main.models;

public class Utilisateur {

    public String name;
    public String prenom;


    public Utilisateur(String name ,String prenom){
        this.name = name ;
        this.prenom = prenom
    }
    public String getName() {
        return name;
    }


    public String getPrenom() {
        return prenom;
    }


}
