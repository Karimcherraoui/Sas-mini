package miniSas.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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





}
