package miniSas;


import miniSas.controller.Emprunt;
import miniSas.controller.Livre;
import miniSas.controller.Utilisateur;
import miniSas.model.*;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

//        Connection connect = DbConnection.connecter();
//        if(connect == null){
//            System.out.println("connection faild!");
//        }else {
//            System.out.println("connection success!");
//
//        }
// -----------------------------------Supprimer Livre by ISBN-----------------------------------

//        LivreModel livreModel = new LivreModel();
//        int isbn = 0;
//       boolean hi = livreModel.supprimerByIsbn(isbn);
//        if(hi){
//            System.out.println("Le livre a été supprimé avec succès.");
//        }else{
//            System.out.println("Le livre n'existe pas ou une erreur est survenue.");
//        }



// ---------------------------- afficher livre By ISBN ------------------------------------------


//        LivreModel livreModel = new LivreModel();
//        int isbn = 567;
//        Livre livre = livreModel.getLivreByIsbn(isbn);
//        if (livre != null) {
//            // Livre was found, so print its details
//            System.out.println("Livre details:");
//            System.out.println("ID: " + livre.getNumeroISBN()); // Replace with appropriate getter method
//            System.out.println("Titre: " + livre.getTitre());
//            System.out.println("Auteur: " + livre.getAuteur());
//            System.out.println("ISBN: " + livre.getNumeroISBN());
//            System.out.println("Statut: " + livre.getStatut());
//        } else {
//            // Livre with the specified ISBN was not found
//            System.out.println("No livre found with ISBN: " + isbn);
//        }


// ----------------------------Afficher tous les livre ------------------------------------------


//        LivreModel livreModel = new LivreModel();
//
//        List<Livre> livres = (List<Livre>) livreModel.afficherTous();
//
//        if (!livres.isEmpty()) {
//            for (Livre livre : livres) {
//                System.out.println("##----------------------------##"); // Add a newline for readability
//                System.out.println("Titre: " + livre.getTitre());
//                System.out.println("Auteur: " + livre.getAuteur());
//                System.out.println("Numéro ISBN: " + livre.getNumeroISBN());
//                System.out.println("Statut: " + livre.getStatut());
////                System.out.println("##---------------------------------------------##"); // Add a newline for readability
//            }
//        } else {
//            System.out.println("No livres found.");
//        }
// ----------------------------Modifier titre de livre ------------------------------------------


//        LivreModel livreModel = new LivreModel();
//        int isbn = 111;
//
//        livreModel.modifierTitre("nchof",isbn);
// -------------------------------Modifier Auteur livre ---------------------------------------


//        LivreModel livreModel = new LivreModel();
//    int isbn = 555;
//
//       livreModel.modifierAuteur("ahlan",isbn);

// ----------------------------- Ajouter Livre -----------------------------------------

//        LivreModel livreModel = new LivreModel();
//        Livre livre = new Livre("wa9ila","nchof",321);
//        livreModel.ajouterLivre(livre);




// ------------------------------- Emprunter Livre ---------------------------------------
//        Livre livre = new Livre();
//        livre.setNumeroISBN(3);
//
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setUtilisateurID(2);
//
//        Date dateEmprunt = new Date();
//        String date_retour = "2025-09-20";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateRetour = dateFormat.parse(date_retour);

//        EmpruntModel empruntModel = new EmpruntModel();
//        Emprunt emprunt = new Emprunt(livre, utilisateur, dateEmprunt, dateRetour);
//
//        boolean empruntReussi = empruntModel.emprunterLivre(emprunt , dateRetour);
//        if (empruntReussi) {
//            System.out.println("Livre emprunté avec succès !");
//        } else {
//            System.out.println("L'emprunt du livre a échoué en raison d'une location existante ou d'une erreur.");
//        }

        // ---------------------------- Ajouter utilisateur ------------------------------------------


//        UtilisateurModel utilisateurModel = new UtilisateurModel();
//       Utilisateur utilisateur = new Utilisateur("test","tttttt");
//        utilisateurModel.ajouterUtilisateur(utilisateur);

        // ---------------------------Recherche by titre-------------------------------------------

//        LivreModel livreModel = new LivreModel();
//        List<Livre> livres = livreModel.rechercheLivreByTitre("kim");
//        if (!livres.isEmpty()) {
//            for (Livre livre : livres) {
//                System.out.println("##----------------------------##"); // Add a newline for readability
//                System.out.println("Titre: " + livre.getTitre());
//                System.out.println("Auteur: " + livre.getAuteur());
//                System.out.println("Numéro ISBN: " + livre.getNumeroISBN());
//                System.out.println("Statut: " + livre.getStatut());
////                System.out.println("##---------------------------------------------##"); // Add a newline for readability
//            }
//        } else {
//            System.out.println("No livres found.");
//        }


        // --------------------------------- Recherche by auteur -------------------------------------


//        LivreModel livreModel = new LivreModel();
//        List<Livre> livres = livreModel.rechercheLivreByAuteur("java");
//        if (!livres.isEmpty()) {
//            for (Livre livre : livres) {
//                System.out.println("##----------------------------##"); // Add a newline for readability
//                System.out.println("Titre: " + livre.getTitre());
//                System.out.println("Auteur: " + livre.getAuteur());
//                System.out.println("Numéro ISBN: " + livre.getNumeroISBN());
//                System.out.println("Statut: " + livre.getStatut());
////                System.out.println("##---------------------------------------------##"); // Add a newline for readability
//            }
//        } else {
//            System.out.println("No livres found.");
//        }


        RapportModel rapportModel = new RapportModel();
       int countLivreEmprunté = rapportModel.afficheLivreEmprunte();
       int countLivreDisponible = rapportModel.affichelivreDisponible();
       int countLivre = rapportModel.afficheTousLivre();


//        System.out.println("Nombre de Livre emprunté : " + countLivreEmprunté + " Livres empruntés / " + countLivre + " Livres en totalité" );
//        System.out.println("Nombre de Livre disponible : " + countLivreDisponible + " Livres disponible / " + countLivre + " Livres en totalité" );



        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                       Gestionnaire de Bibliothèque                     |");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| Livres Empruntés   | Livres Disponibles | Livres Perdus | Total Livres |");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|          " + countLivreEmprunté + "         |          " + countLivreDisponible + "         |  " + "livresPerdus" + " |       " +  countLivre + "      |");




    }
}