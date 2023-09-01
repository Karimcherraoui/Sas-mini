 
Utilisateur    
 
- nom: String
- prenom: String
 
+ getNom(): String
+ getPrenom(): String
+ setNom(nom: String): void
+ setPrenom(prenom: String): void
 

 
     Bibliothèque   
 
- livres: Liste<Livre>
- emprunts: Liste<Emprunt>
 
+ ajouterLivre(livre: Livre): void
+ rechercherLivres(titre: String, auteur: String): Liste<Livre>
+ emprunterLivre(livre: Livre, emprunteur: Utilisateur, dateEmprunt: Date): void
+ retournerLivre(livre: Livre, dateRetour: Date): void
+ genererRapports(): Rapports
 

 
     Livre       
 
- titre: String
- auteur: String
- numeroISBN: String
- statut: StatutLivre
 
+ getTitre(): String
+ getAuteur(): String
+ getNumeroISBN(): String
+ getStatut(): StatutLivre
+ setTitre(titre: String): void
+ setAuteur(auteur: String): void
+ setNumeroISBN(numeroISBN: String): void
+ setStatut(statut: StatutLivre): void
 

             Emprunt                   
 - livre: Livre
- emprunteur: Utilisateur
- dateEmprunt: Date
- dateRetour: Date
 + getLivre(): Livre
+ getEmprunteur(): Utilisateur
+ getDateEmprunt(): Date
+ getDateRetour(): Date
+ setLivre(livre: Livre): void
+ setEmprunteur(emprunteur: Utilisateur): void
+ setDateEmprunt(dateEmprunt: Date): void
+ setDateRetour(dateRetour: Date): void
 
 
     Rapports       
 
- livresDisponibles: int
- livresEmpruntes: int
- livresPerdus: int
 
+ getLivresDisponibles(): int
+ getLivresEmpruntes(): int
+ getLivres