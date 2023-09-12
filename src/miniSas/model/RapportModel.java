package miniSas.model;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RapportModel {

    Connection connecter = DbConnection.connecter();


        public int nombreLivreEmprunte(){
            int bookCount = 0;
            String sqlQuery = "SELECT COUNT(*) FROM livre WHERE statut = 'Emprunté';";

            try {
                PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
                ResultSet result = prepare.executeQuery();

                if (result.next()) {
                    bookCount = result.getInt(1);
                }

                result.close();
                prepare.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return bookCount;

        }

    public int nombrelivreDisponible(){

        int bookCount = 0;
        String sqlQuery = "SELECT COUNT(*) FROM livre WHERE statut = 'Disponible';";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                bookCount = result.getInt(1);
            }

            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookCount;

    }

    public int nombrelivrePerdu(){

        int bookCount = 0;
        String sqlQuery = "SELECT COUNT(*) FROM livre WHERE statut = 'Perdu';";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                bookCount = result.getInt(1);
            }

            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookCount;

    }

    public int afficheTousLivre(){
        int bookCount = 0;
        String sqlQuery = "SELECT COUNT(*) FROM livre ;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                bookCount = result.getInt(1);
            }

            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookCount;


    }


    public static String genererRapport() {
        // Placez ici la logique pour générer votre rapport
        // Par exemple, vous pouvez utiliser les méthodes de la classe RapportModel
        RapportModel rapportModel = new RapportModel();
        int countLivreEmprunté = rapportModel.nombreLivreEmprunte();
        int countLivreDisponible = rapportModel.nombrelivreDisponible();
        int countLivrePerdu = rapportModel.nombrelivrePerdu();
        int countLivre = rapportModel.afficheTousLivre();

        // Créez une chaîne de caractères contenant les informations du rapport
        String Rapport = "Date du rapport : " + getDateCourante() + "\n" +
                "Livres Empruntés : " + countLivreEmprunté + "\n" +
                "Livres Disponibles : " + countLivreDisponible + "\n" +
                "Livres Perdus : " + countLivrePerdu + "\n" +
                "Total Livres : " + (countLivre - countLivrePerdu) + "\n";

        return Rapport;
    }

    public static String getDateCourante() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void creerRapportFile(String Rapport) {
        String fileName = "rapport_journalier.txt";
        try (BufferedWriter rapport = new BufferedWriter(new FileWriter(fileName, true))) {
            rapport.write(Rapport);
            rapport.newLine();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du rapport dans le fichier.");
        }
    }









    }
