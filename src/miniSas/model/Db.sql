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
    prenom varchar(255),
    numero int(15)

);


CREATE TABLE Emprunt
(
    id            INT(15) AUTO_INCREMENT PRIMARY KEY,
    livre_ISBN    INT,
    emprunteur_id INT,
    dateEmprunt   DATE,
    dateRetour    DATE,
    FOREIGN KEY (livre_ISBN) REFERENCES Livre (numeroISBN) ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (emprunteur_id) REFERENCES Utilisateur (id) ON DELETE CASCADE
        ON UPDATE CASCADE
);

DELIMITER //
CREATE TRIGGER Emprunt_AfterInsert
    AFTER INSERT
    ON Emprunt
    FOR EACH ROW
BEGIN
    UPDATE Livre SET statut = 'Emprunté' WHERE numeroISBN = NEW.livre_ISBN;
END;
//
CREATE TRIGGER Emprunt_AfterDelete
    AFTER DELETE
    ON Emprunt
    FOR EACH ROW
BEGIN
    UPDATE Livre SET statut = 'Disponible' WHERE numeroISBN = OLD.livre_ISBN;
END;
//
DELIMITER ;


