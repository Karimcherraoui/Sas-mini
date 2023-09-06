package miniSas.model;

import miniSas.controller.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreModel {

    Connection connecter = DbConnection.connecter();

    public boolean ajouterLivre(Livre livre){

        String sqlQuery = "INSERT INTO livre (titre,auteur,numeroISBN,statut) VALUES (?,?,?,?);";

        try{
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1,livre.getTitre());
            prepare.setString(2,livre.getAuteur());
            prepare.setInt(3,livre.getNumeroISBN());
            prepare.setString(4,livre.getStatut());
            int rowsUpdated = prepare.executeUpdate();

            prepare.close();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modifierTitre(String titre , int numeroISBN ) {
        String sqlQuery = "UPDATE livre SET titre=? WHERE numeroISBN=?"; // Assuming 'id' is the primary key column

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1,titre);
            prepare.setInt(2,numeroISBN);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean modifierAuteur(String auteur , int numeroISBN ) {
        String sqlQuery = "UPDATE livre SET auteur=? WHERE numeroISBN=?"; // Assuming 'id' is the primary key column

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1,auteur);
            prepare.setInt(2,numeroISBN);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean supprimerByIsbn(int isbn){
        String sqlQuery = "DELETE FROM livre WHERE numeroISBN = ?;";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, isbn);
            int rowsUpdated = prepare.executeUpdate();

            prepare.close();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Livre getLivreByIsbn(int isbn){
        String sqlQuery = "SELECT * FROM livre WHERE numeroISBN = ?;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, isbn);

            ResultSet resultSet = prepare.executeQuery();

            if (resultSet.next()) {
                int numeroIsbn = resultSet.getInt("numeroIsbn");
                String titre = resultSet.getString("titre");
                String auteur = resultSet.getString("auteur");
                String statut = resultSet.getString("statut");

                Livre livre = new Livre( titre, auteur, numeroIsbn, statut);

                resultSet.close();
                prepare.close();

                return livre;
            } else {
                resultSet.close();
                prepare.close();
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Livre> getAll() {
        List<Livre> livres = new ArrayList<>();

        String sqlQuery = "SELECT * from livre";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                int numeroISBN = result.getInt("numeroISBN");
                String titre = result.getString("titre");
                String auteur = result.getString("auteur");
                String statut = result.getString("statut");

                Livre livre = new Livre(titre, auteur, numeroISBN, statut);
                livres.add(livre);
            }
            // Close the ResultSet and PreparedStatement after the loop is finished
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return livres;
    }


}




