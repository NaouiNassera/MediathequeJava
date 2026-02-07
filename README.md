# Médiathèque Java

## Description

Ce projet est une application Java permettant de gérer une médiathèque.  
Il permet de gérer :

- Les utilisateurs et les bibliothécaires
- Les documents : livres, CDs, DVDs
- Les emprunts et retours de documents

L'application suit une architecture orientée objet avec les classes principales suivantes :  

- `Mediatheque` : représente la médiathèque et gère les utilisateurs et documents.  
- `Utilisateur` : représente un utilisateur de la médiathèque.  
- `Bibliothecaire` : hérite de `Utilisateur` et peut gérer les inscriptions, les documents et les emprunts.  
- `Document` (abstrait) : représente un document générique.  
  - `Livre` : document type livre avec auteur et ISBN.  
  - `Cd` : document type CD avec artiste et genre musical.  
  - `Dvd` : document type DVD avec durée et genre.  
- `Emprunt` : représente un emprunt d’un document par un utilisateur, avec date d’emprunt et date de retour.

---

## Fonctionnement

1. Le bibliothécaire peut :
   - Inscrire de nouveaux utilisateurs
   - Ajouter des documents au catalogue
   - Enregistrer les emprunts et retours des utilisateurs

2. Les utilisateurs peuvent :
   - Emprunter un document disponible
   - Retourner un document emprunté

3. Chaque document possède un état de disponibilité (`disponible` ou `emprunté`).

4. L’application peut afficher :
   - La liste des documents
   - La liste des utilisateurs
   - Les emprunts en cours

---

## Technologies utilisées

  - Java 17
  - Programmation orientée objet
---

## Exemple d’utilisation

```java
Mediatheque mediatheque = new Mediatheque("Médiathèque Centrale", "Paris");
Bibliothecaire biblio = new Bibliothecaire(1, "Martin", "Paul", "paul@media.com", "BIB2025");
Utilisateur user = new Utilisateur(1, "Dupont", "Alice", "alice@mail.com");
Livre livre = new Livre(100, "Harry Potter", "J.K. Rowling", "12345");

biblio.inscrireNouvelUtilisateur(mediatheque, user);
biblio.ajouterDocumentCatalogue(mediatheque, livre);
biblio.enregistrerEmprunt(mediatheque, user, livre);
biblio.enregistrerRetour(mediatheque, user, livre);
