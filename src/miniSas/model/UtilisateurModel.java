package miniSas.model;

import miniSas.controller.Utilisateur;
import miniSas.model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurModel {

    Connection connecter = DbConnection.connecter();

    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sqlQuery = "INSERT INTO utilisateur (nom, prenom) VALUES (?, ?);";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, utilisateur.getNom());
            prepare.setString(2, utilisateur.getPrenom());
            int rowsUpdated = prepare.executeUpdate();

            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modifierNom(String nom, int utilisateurId) {
        String sqlQuery = "UPDATE utilisateur SET nom=? WHERE id=?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, nom);
            prepare.setInt(2, utilisateurId);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modifierPrenom(String prenom, int utilisateurId) {
        String sqlQuery = "UPDATE utilisateur SET prenom=? WHERE id=?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, prenom);
            prepare.setInt(2, utilisateurId);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean supprimerUtilisateur(int utilisateurId) {
        String sqlQuery = "DELETE FROM utilisateur WHERE id = ?;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, utilisateurId);
            int rowsUpdated = prepare.executeUpdate();

            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Utilisateur getUtilisateurById(int utilisateurId) {
        String sqlQuery = "SELECT * FROM utilisateur WHERE id = ?;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, utilisateurId);

            ResultSet resultSet = prepare.executeQuery();

            if (resultSet.next()) {

                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");

                Utilisateur utilisateur = new Utilisateur(nom, prenom);

                resultSet.close();
                prepare.close();

                return utilisateur;
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

    public Utilisateur getUtilisateurByNom(String nom) {
        String sqlQuery = "SELECT * FROM utilisateur WHERE nom = ?;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setString(1, nom);

            ResultSet resultSet = prepare.executeQuery();

            if (resultSet.next()) {

                String prenom = resultSet.getString("prenom");

                Utilisateur utilisateur = new Utilisateur(nom, prenom);

                resultSet.close();
                prepare.close();

                return utilisateur;
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

    public List<Utilisateur> afficherTous() {
        List<Utilisateur> utilisateurs = new ArrayList<>();

        String sqlQuery = "SELECT * from utilisateur";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");

                Utilisateur utilisateur = new Utilisateur(nom, prenom);
                utilisateurs.add(utilisateur);
            }
            result.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return utilisateurs;
    }
}
