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

    public void ajouterLivre(Livre livre) {

        String sqlQuery = "INSERT INTO livre (titre,auteur,numeroISBN) VALUES (?,?,?);";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, livre.getTitre());
            prepare.setString(2, livre.getAuteur());
            prepare.setInt(3, livre.getNumeroISBN());
            prepare.executeUpdate();

            prepare.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public boolean modifierTitre(String titre, int numeroISBN) {
        String sqlQuery = "UPDATE livre SET titre=? WHERE numeroISBN=?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, titre);
            prepare.setInt(2, numeroISBN);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean modifierAuteur(String auteur, int numeroISBN) {
        String sqlQuery = "UPDATE livre SET auteur=? WHERE numeroISBN=?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, auteur);
            prepare.setInt(2, numeroISBN);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean supprimerByIsbn(int isbn) {
        String sqlQuery = "DELETE FROM livre WHERE numeroISBN = ?;";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, isbn);
            int rowsUpdated = prepare.executeUpdate();

            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Livre getLivreByIsbn(int isbn) {
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

                Livre livre = new Livre(titre, auteur, numeroIsbn, statut);

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

    public List<Livre> afficherLivreDispo() {
        List<Livre> livres = new ArrayList<>();

        String sqlQuery = "SELECT * from livre WHERE statut = 'Disponible'";
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
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return livres;
    }
    public List<Livre> afficherLivrePerdu() {
        List<Livre> livres = new ArrayList<>();

        String sqlQuery = "SELECT * from livre WHERE statut = 'Perdu'";
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
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return livres;
    }


    public List<Livre> rechercheLivreByTitre(String titre) {
        List<Livre> livres = new ArrayList<>();
        String sqlQuery = "SELECT * FROM livre WHERE titre = ?";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, titre);

            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                int numeroISBN = result.getInt("numeroISBN");
                String auteur = result.getString("auteur");
                String statut = result.getString("statut");

                Livre livre = new Livre(titre, auteur, numeroISBN, statut);
                livres.add(livre);
            }
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return livres;

    }

    public List<Livre> rechercheLivreByAuteur(String auteur) {
        List<Livre> livres = new ArrayList<>();
        String sqlQuery = "SELECT * FROM livre WHERE auteur = ?";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, auteur);

            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                int numeroISBN = result.getInt("numeroISBN");
                String titre = result.getString("titre");
                String statut = result.getString("statut");

                Livre livre = new Livre(titre, auteur, numeroISBN, statut);
                livres.add(livre);
            }
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return livres;

    }

}




