package miniSas.model;

import miniSas.controller.Emprunt;
import miniSas.controller.Livre;
import miniSas.controller.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpruntModel {

    Connection connecter = DbConnection.connecter();

    public boolean emprunterLivre(Emprunt emprunt ,  Date dateRetour) {

        String sqlQuery = "INSERT INTO emprunt (livre_ISBN, emprunteur_id, dateEmprunt, dateRetour) VALUES (?, ?, ?, ?);";
        LivreModel livreModel = new LivreModel();
        int ISBN = emprunt.getLivre().getNumeroISBN();
        Livre livre = livreModel.getLivreByIsbn(ISBN);
        if (livre.getStatut() == "Disponible") {
            try {
                PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
                prepare.setInt(1, emprunt.getLivre().getNumeroISBN());
                prepare.setInt(2, emprunt.getEmprunteur().getUtilisateurID());
                prepare.setDate(3, new java.sql.Date(emprunt.getDateEmprunt().getTime()));
                prepare.setDate(4, new java.sql.Date(dateRetour.getTime()));
                int rowsUpdated = prepare.executeUpdate();

                prepare.close();

                return rowsUpdated > 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }else{
            return false ;
        }

    }
    public boolean retournerLivre(int empruntId) {

        String sqlQuery = "UPDATE emprunt SET dateRetour = ? WHERE id = ?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setDate(1, new java.sql.Date(new Date().getTime()));
            prepare.setInt(2, empruntId);
            int rowsUpdated = prepare.executeUpdate();
            prepare.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Emprunt> afficherEmpruntsUtilisateur(int utilisateurId) {
        List<Emprunt> emprunts = new ArrayList<>();

        String sqlQuery = "SELECT * FROM emprunt WHERE emprunteur_id = ?";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, utilisateurId);
            ResultSet resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                int empruntId = resultSet.getInt("id");
                int livreId = resultSet.getInt("livre_id");
                Date dateEmprunt = resultSet.getDate("date_emprunt");
                Date dateRetour = resultSet.getDate("date_retour");

                Livre livre = fetchLivreById(livreId);
                Utilisateur emprunteur = fetchUtilisateurById(utilisateurId);

                Emprunt emprunt = new Emprunt(livre, emprunteur, dateEmprunt, dateRetour);
                emprunts.add(emprunt);
            }

            resultSet.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return emprunts;
    }


    private Livre fetchLivreById(int livreId) {
        return null;
    }

    private Utilisateur fetchUtilisateurById(int utilisateurId) {
        return null;
    }
}
