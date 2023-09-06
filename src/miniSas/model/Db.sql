# CREATE DATABASE `Bibliotheque`;
# USE `Bibliotheque`;

CREATE TABLE livre
(
    numeroISBN int(15) PRIMARY KEY,
    titre      varchar(255),
    auteur     varchar(255),
    statut     varchar(255) DEFAULT 'Disponible'
);

CREATE TABLE utilisateur
(
    id     int(15) PRIMARY KEY AUTO_INCREMENT,
    nom    varchar(255),
    prenom varchar(255)
);


CREATE TABLE Emprunt
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    livre_ISBN    INT,
    emprunteur_id INT,
    dateEmprunt   DATE,
    dateRetour    DATE,
    FOREIGN KEY (livre_ISBN) REFERENCES Livre (numeroISBN),
    FOREIGN KEY (emprunteur_id) REFERENCES Utilisateur (id)
);

DELIMITER //
CREATE TRIGGER Emprunt_BeforeInsert
    BEFORE INSERT
    ON Emprunt
    FOR EACH ROW
BEGIN
    UPDATE Livre SET statut = 'Emprunté' WHERE id = NEW.livre_ISBN;
END;
//
CREATE TRIGGER Emprunt_AfterDelete
    AFTER DELETE
    ON Emprunt
    FOR EACH ROW
BEGIN
    UPDATE Livre SET statut = 'Disponible' WHERE id = OLD.livre_ISBN;
END;
//
DELIMITER ;
