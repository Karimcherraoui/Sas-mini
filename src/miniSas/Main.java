package miniSas;


import miniSas.controller.Livre;
import miniSas.model.DbConnection;
import miniSas.model.LivreModel;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Connection connect = DbConnection.connecter();
//        if(connect == null){
//            System.out.println("connection faild!");
//        }else {
//            System.out.println("connection success!");
//
//        }

//        LivreModel livreModel = new LivreModel();
//        int isbn = 3333;
//        livreModel.supprimerByIsbn(isbn);


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




//        LivreModel livreModel = new LivreModel();
//
//        // Call the getAll() method to retrieve the list of livres
//        List<Livre> livres = (List<Livre>) livreModel.getAll();
//
//        // Check if there are any livres in the list
//        if (!livres.isEmpty()) {
//            // Iterate through the list and display the information of each livre
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


//        LivreModel livreModel = new LivreModel();
//        int isbn = 111;
//
//        livreModel.modifierTitre("nchof",isbn);


        LivreModel livreModel = new LivreModel();
    int isbn = 555;

       livreModel.modifierAuteur("qqqq",isbn);



    }
}