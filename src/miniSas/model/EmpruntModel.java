package miniSas.model;

import miniSas.controller.Emprunt;
import miniSas.controller.Livre;
import miniSas.controller.Utilisateur;
import miniSas.controller.livreEmprunte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmpruntModel {

    static Connection connecter = DbConnection.connecter();

    public boolean emprunterLivre(Emprunt emprunt, Date dateRetour) {

        String sqlQuery = "INSERT INTO emprunt (livre_ISBN, emprunteur_id, dateEmprunt, dateRetour) VALUES (?, ?, ?, ?);";
        LivreModel livreModel = new LivreModel();
        int ISBN = emprunt.getLivre().getNumeroISBN();
        Livre livre = livreModel.getLivreByIsbn(ISBN);


        if (Objects.equals(livre.getStatut(), "Disponible")) {
            System.out.println("livre");
            try {

                PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
                prepare.setInt(1, emprunt.getLivre().getNumeroISBN());
                prepare.setInt(2, emprunt.getEmprunteur().getUtilisateurID());
                prepare.setDate(3, new java.sql.Date(emprunt.getDateEmprunt().getTime()));
                prepare.setDate(4, new java.sql.Date(dateRetour.getTime()));
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
        } else {
            return false;
        }

    }

    public boolean retournerLivre(int livre_ISBN) {

        String sqlQuery = "DELETE FROM Emprunt WHERE livre_ISBN = ?;";

        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, livre_ISBN);
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

    public void verifierStatutLivrePerdu() {
        String sqlQuery = "SELECT id, dateRetour FROM emprunt";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next()) {
                int empruntId = resultSet.getInt("id");
                Date dateRetour = resultSet.getDate("dateRetour");

                // Vérifie si la date de retour est passée ou retardée d'une journée
                if (dateRetour != null) {
                    Date dateActuelle = new Date();
                    long diff = dateRetour.getTime() - dateActuelle.getTime();
                    long diffEnJours = diff / (24 * 60 * 60 * 1000);

                    if (diffEnJours < 0 || diffEnJours == 0) {
                        // La date de retour est passée ou retardée d'une journée,
                        // met à jour le statut du livre en "perdu"
                        String updateQuery = "UPDATE livre SET statut = 'Perdu' WHERE numeroISBN = ?";
                        int ISBN = obtenirISBNParEmpruntId(empruntId);
                        PreparedStatement updateStatement = connecter.prepareStatement(updateQuery);
                        updateStatement.setInt(1, ISBN);
                        updateStatement.executeUpdate();
                        updateStatement.close();
                    }
                }
            }
            resultSet.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Méthode pour obtenir l'ISBN d'un livre par ID d'emprunt
    private int obtenirISBNParEmpruntId(int empruntId) {
        String sqlQuery = "SELECT livre_ISBN FROM emprunt WHERE id = ?";
        try {
            PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
            prepare.setInt(1, empruntId);
            ResultSet resultSet = prepare.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("livre_ISBN");
            }
            resultSet.close();
            prepare.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1; // ISBN invalide
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

    public static List<livreEmprunte> obtenirLivreEmprunte() {
        List<livreEmprunte> livreEmpruntes = new ArrayList<>();
        String sqlQuery = "SELECT livre.*, utilisateur.*, Emprunt.* FROM livre INNER JOIN Emprunt ON livre.numeroISBN = Emprunt.livre_ISBN INNER JOIN utilisateur ON utilisateur.id = Emprunt.emprunteur_id;";
    try{
        PreparedStatement prepare = connecter.prepareStatement(sqlQuery);
        ResultSet resultat = prepare.executeQuery();
        while(resultat.next()){

            String titre = resultat.getString("titre");
            String auteur = resultat.getString("auteur");
            String nom = resultat.getString("nom");
            String prenom = resultat.getString("prenom");
            int numero = resultat.getInt("numero");
            String dateEmprunt = resultat.getString("dateEmprunt");
            String dateRetour = resultat.getString("dateRetour");

            livreEmprunte livreEmprunte = new livreEmprunte(titre,auteur,nom,prenom,numero,dateEmprunt,dateRetour);
            livreEmpruntes.add(livreEmprunte);
        }
        resultat.close();
        prepare.close();

    }catch(SQLException e){
        System.out.println(e.getMessage());
        return null;
    }
    return livreEmpruntes;
    }

    private Livre fetchLivreById(int livreId) {
        return null;
    }

    private Utilisateur fetchUtilisateurById(int utilisateurId) {
        return null;
    }
}
