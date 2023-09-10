package miniSas;


import miniSas.controller.Emprunt;
import miniSas.controller.Livre;
import miniSas.controller.Utilisateur;
import miniSas.controller.livreEmprunte;
import miniSas.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException, IOException {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        LivreModel livreModel = new LivreModel();
        EmpruntModel empruntModel = new EmpruntModel();
        String response;
        boolean menu = true;

            empruntModel.verifierStatutLivrePerdu();

        while (menu) {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "---------------------------------------------------------");
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "|              Gestionnaire de Bibliothèque             |");
            System.out.println(ConsoleColors.BLUE_BRIGHT + "---------------------------------------------------------");
            System.out.println(ConsoleColors.WHITE_BRIGHT + "1. Ajouter un nouveau livre");
            System.out.println(ConsoleColors.WHITE_BRIGHT + "2. Ajouter un nouveau utilisateur");
            System.out.println("3. Afficher la liste complète des livres disponibles");
            System.out.println("4. Rechercher un livre par son titre ou son auteur");
            System.out.println("5. Emprunter un livre ");
            System.out.println("6. Retourner un livre emprunté");
            System.out.println("7. Afficher la liste des livres empruntés");
            System.out.println("8. Supprimer un livre de la bibliothèque");
            System.out.println("9. Modifier les informations d'un livre");
            System.out.println("10. Generer rapport");
            System.out.println("11. Quitter");
            System.out.println(ConsoleColors.GREEN_BRIGHT + "****************************************************");
            System.out.print(ConsoleColors.WHITE_BRIGHT + "Choisissez une option : ");


            int choix = scannerInt.nextInt();


            switch (choix) {
                case 1:

                    System.out.print("Entrez le titre de livre : ");
                    String titre = scannerStr.nextLine();
                    System.out.print("Entrez le nom d'auteur : ");
                    String auteur = scannerStr.nextLine();
                    System.out.print("Entrez le numero ISBN : ");
                    int ISBN = Integer.parseInt(scannerInt.next());
                    System.out.println(ConsoleColors.GREEN_BRIGHT + "****************************************************");
                    Livre livre = new Livre(titre, auteur, ISBN);
                    livreModel.ajouterLivre(livre);

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 2:


                    System.out.print("Entrez le nom de client : ");
                    String name = scannerStr.next();
                    System.out.print("Entrez le prenom de client : ");
                    String prenom = scannerStr.next();
                    System.out.print("Entrez le numero de client : ");
                    int numero = scannerInt.nextInt();


                    UtilisateurModel utilisateurModel = new UtilisateurModel();
                    Utilisateur nvUtilisateur = new Utilisateur(name, prenom, numero);
                    utilisateurModel.ajouterUtilisateur(nvUtilisateur);


                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.next();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 3:


                    List<Livre> livres = (List<Livre>) livreModel.afficherLivreDispo();

                    if (!livres.isEmpty()) {
                        for (Livre livree : livres) {
                            System.out.println("##----------------------------##"); // Add a newline for readability
                            System.out.println("Titre: " + livree.getTitre());
                            System.out.println("Auteur: " + livree.getAuteur());
                            System.out.println("Numéro ISBN: " + livree.getNumeroISBN());
                            System.out.println("Statut: " + livree.getStatut());
//                System.out.println("##---------------------------------------------##"); // Add a newline for readability
                        }
                    } else {
                        System.out.println("No livres found.");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.println(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 4:

                    System.out.println("1 - Recherche livre par titre. ");
                    System.out.println("2 - Recherche livre par d'auteur. ");
                    System.out.println(ConsoleColors.GREEN_BRIGHT + "****************************************************");
                    System.out.print(ConsoleColors.WHITE_BRIGHT + "Choisissez une option : ");
                    int inputChoix = scannerInt.nextInt();
                    if (inputChoix == 1) {
                        System.out.print("Entrez le titre de livre : ");
                        String titreLivre = scannerStr.nextLine();
                        System.out.println(ConsoleColors.YELLOW_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability


                        List<Livre> listlivres = livreModel.rechercheLivreByTitre(titreLivre);
                        if (!listlivres.isEmpty()) {
                            for (Livre livree : listlivres) {
                                System.out.println(ConsoleColors.GREEN_BRIGHT + "Titre: " + livree.getTitre());
                                System.out.println(ConsoleColors.GREEN_BRIGHT + "Auteur: " + livree.getAuteur());
                                System.out.println(ConsoleColors.GREEN_BRIGHT + "Numéro ISBN: " + livree.getNumeroISBN());
                                System.out.println(ConsoleColors.GREEN_BRIGHT + "Statut: " + livree.getStatut());
                                System.out.println(ConsoleColors.YELLOW_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability

                            }
                        } else {
                            System.out.println("No livres found.");
                        }
                    } else if (inputChoix == 2) {
                        System.out.print("Entrez l'auteur de livre : ");
                        String auteurLivre = scannerStr.nextLine();
                        System.out.println("##----------------------------##"); // Add a newline for readability


                        List<Livre> Listlivres = livreModel.rechercheLivreByAuteur(auteurLivre);
                        if (!Listlivres.isEmpty()) {
                            for (Livre livree : Listlivres) {
                                System.out.println(ConsoleColors.WHITE_BRIGHT + "Titre: " + livree.getTitre());
                                System.out.println("Auteur: " + livree.getAuteur());
                                System.out.println("Numéro ISBN: " + livree.getNumeroISBN());
                                System.out.println("Statut: " + livree.getStatut());
                                System.out.println(ConsoleColors.GREEN_BRIGHT + "##----------------------------##"); // Add a newline for readability

                            }
                        } else {
                            System.out.println("No livres found.");
                        }

                    } else {
                        System.out.println("Option introuvable. ");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }


                    break;

                case 5:
                    Livre book = new Livre();

                    Scanner input = new Scanner(System.in);
                    System.out.print("Entrez le ISBN de livre : ");
                    int numeroISBN = Integer.parseInt(input.nextLine());
                    Livre getLivre = livreModel.getLivreByIsbn(numeroISBN);
                    String statut = getLivre.getStatut();
                    book.setStatut(statut);
                    book.setNumeroISBN(numeroISBN);


                    Utilisateur utilisateur = new Utilisateur();
                    Scanner inputUtilisateur = new Scanner(System.in);
                    System.out.print("Entrez le nom d'utilisateur : ");
                    String nom = input.nextLine();
                    UtilisateurModel ModelUtilisateur = new UtilisateurModel();
                    Utilisateur utilisateurDetails = ModelUtilisateur.getUtilisateurByNom(nom);
                    int UtilisateurID = utilisateurDetails.getUtilisateurID();
                    utilisateur.setUtilisateurID(UtilisateurID);

                    Date dateEmprunt = new Date();
                    Scanner inputDate = new Scanner(System.in);
                    System.out.print("Entrez la date de retour (YYYY-MM-DD) : ");
                    String retour = input.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateRetour = dateFormat.parse(retour);


                    EmpruntModel emprunt_Model = new EmpruntModel();
                    Emprunt emprunt = new Emprunt(book, utilisateur, dateEmprunt, dateRetour);

                    boolean empruntReussi = emprunt_Model.emprunterLivre(emprunt, dateRetour);
                    if (empruntReussi) {
                        System.out.println("Livre emprunté avec succès !");
                    } else {
                        System.out.println("L'emprunt du livre a échoué en raison d'une location existante ou d'une erreur.");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }


                    break;

                case 6:
                    System.out.print("Entrez le ISBN de livre : ");
                    int ISBNnumero = scannerInt.nextInt();
                    boolean retournerLivre = empruntModel.retournerLivre(ISBNnumero);
                    if (retournerLivre) {
                        System.out.println("Le livre est retourné avec succès.");
                    } else {
                        System.out.println("Une erreur est survenue.");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }


                    break;

                case 7:


                    List<livreEmprunte> listLivres = (List<livreEmprunte>) EmpruntModel.obtenirLivreEmprunte();

                    if (!listLivres.isEmpty()) {
                        System.out.println(ConsoleColors.BLUE_BRIGHT + "------------------------------------------");
                        System.out.println(ConsoleColors.YELLOW_BRIGHT + "|         Liste des livres empruntés       |");
                        System.out.println(ConsoleColors.BLUE_BRIGHT + "--------------------------------------------");
                        for (livreEmprunte livreee : listLivres) {
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Titre de livre : " + ConsoleColors.WHITE_BRIGHT + livreee.getTitre());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Auteur de livre: " + ConsoleColors.WHITE_BRIGHT + livreee.getAuteur());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Nom d'emprunteur: " + ConsoleColors.WHITE_BRIGHT + livreee.getNom());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Prenom d'emprunteur: " + ConsoleColors.WHITE_BRIGHT + livreee.getPrenom());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Numero d'emprunteur: " + ConsoleColors.WHITE_BRIGHT + livreee.getNumero());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Date d'emprunt: " + ConsoleColors.WHITE_BRIGHT + livreee.getDateEmprunt());
                            System.out.println(ConsoleColors.BLUE_BRIGHT + "Date retour: " + ConsoleColors.WHITE_BRIGHT + livreee.getDateRetour());
                            System.out.println(ConsoleColors.YELLOW_BRIGHT + "##------------------------------------##"); // Add a newline for readability

                        }
                    } else {
                        System.out.println("Aucun livre emprunté");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 8:

                    System.out.print("Entrez le ISBN de livre : ");
                    int livreISBN = scannerInt.nextInt();

                    boolean livreSupprime = livreModel.supprimerByIsbn(livreISBN);
                    if (livreSupprime) {
                        System.out.println("Le livre a été supprimé avec succès.");
                    } else {
                        System.out.println("Le livre n'existe pas ou une erreur est survenue.");

                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 9:

                    System.out.println("1 - Modifier le titre de livre. ");
                    System.out.println("2 - Modifier l'auteur de livre. ");
                    System.out.println(ConsoleColors.GREEN_BRIGHT + "****************************************************");
                    System.out.print(ConsoleColors.WHITE_BRIGHT + "Choisissez une option : ");
                    int inputDeChoix = scannerInt.nextInt();
                    if (inputDeChoix == 1) {
                        System.out.print("Entrez le ISBN de livre : ");
                        int numero_ISBN = scannerInt.nextInt();
                        System.out.print("Entrez le nouveau titre de livre : ");
                        String nouveauTitre = scannerStr.nextLine();
                        System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability


                        boolean listlivres = livreModel.modifierTitre(nouveauTitre, numero_ISBN);
                        if (listlivres) {
                            System.out.println("Le titre a été modifié avec succès.");
                            System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability

                        } else {
                            System.out.println("Une erreur s'est produite lors du traitement de votre demande.");
                            System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability

                        }
                    } else if (inputDeChoix == 2) {
                        System.out.print("Entrez le ISBN de livre : ");
                        int numero_ISBN = scannerInt.nextInt();
                        System.out.print("Entrez le nouveau auteur de livre : ");
                        String auteurLivre = scannerStr.nextLine();
                        System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability


                        boolean Listlivres = livreModel.modifierAuteur(auteurLivre, numero_ISBN);
                        if (Listlivres) {
                            System.out.println("L'auteur a été modifié avec succès.");
                            System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability

                        } else {
                            System.out.println("Une erreur s'est produite lors du traitement de votre demande.");
                            System.out.println(ConsoleColors.GREEN_BRIGHT + "##--------------------------------------------------##"); // Add a newline for readability

                        }

                    } else {
                        System.out.println("Option introuvable. ");
                    }

                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 10:
                    RapportModel rapportModel = new RapportModel();
                    int countLivreEmprunté = rapportModel.nombreLivreEmprunte();
                    int countLivreDisponible = rapportModel.nombrelivreDisponible();
                    int countLivrePerdu = rapportModel.nombrelivrePerdu();
                    int countLivre = rapportModel.afficheTousLivre();

                    System.out.println(ConsoleColors.BLUE_BRIGHT + "--------------------------------------------------------------------------");
                    System.out.println(ConsoleColors.YELLOW_BRIGHT + "|                       STATISTIQUE                     |");
                    System.out.println(ConsoleColors.BLUE_BRIGHT + "--------------------------------------------------------------------------");
                    System.out.println(ConsoleColors.GREEN_BRIGHT + "| Livres Empruntés   | Livres Disponibles | Livres Perdus | Total Livres |");
                    System.out.println(ConsoleColors.BLUE_BRIGHT + "--------------------------------------------------------------------------");
                    System.out.println(ConsoleColors.WHITE_BRIGHT + "|          " + countLivreEmprunté + "         |          " + countLivreDisponible + "         |       " + countLivrePerdu+ "       |       " + countLivre + "      |");


                    //-----------------------------------------------------------------------------------
                    menu = false;
                    System.out.print(ConsoleColors.RED_BRIGHT + "Voulez-vous continuer (y/n) ? ");
                    response = scannerStr.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        menu = true;
                    } else if (response.equalsIgnoreCase("n")) {
                        menu = false;
                    } else {
                        System.out.println("Réponse invalide.");
                    }

                    break;

                case 11:
                    menu = false;
                    break;


                default:

                    break;
            }
        }

    }
}