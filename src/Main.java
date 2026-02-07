//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //creation de la mediatheque
        Mediatheque mediatheque = new Mediatheque("Médiathèque Centrale", "Paris");

        //creation des utilisateurs
        Utilisateur user1 = new Utilisateur(1, "Dupont", "Alice", "alice@mail.com");
        Utilisateur user2 = new Utilisateur(2, "Durand", "Bob", "bob@mail.com");

        //creation du bibliothecaire
        Bibliothecaire biblio = new Bibliothecaire(99, "Martin", "Paul", "paul@media.com", "BIB2025");

        //creation des documents
        Livre livre1 = new Livre(100, "Harry Potter", "J.K. Rowling", "12345");
        Dvd dvd1 = new Dvd(200, "Inception", 148, "Science-fiction");
        Cd cd1 = new Cd(301, "Thriller", "Michael Jackson", "Pop");

        //inscription des utilisateurs
        biblio.inscrireNouvelUtilisateur(mediatheque, user1);
        biblio.inscrireNouvelUtilisateur(mediatheque, user2);

        //ajout des documents dans la mediatheque
        biblio.ajouterDocumentCatalogue(mediatheque, livre1);
        biblio.ajouterDocumentCatalogue(mediatheque, dvd1);
        biblio.ajouterDocumentCatalogue(mediatheque, cd1);

        System.out.println("\n--- Contenu de la médiathèque ---");
        System.out.println(mediatheque);

        //Emprunts
        biblio.enregistrerEmprunt(mediatheque, user1, livre1);
        biblio.enregistrerEmprunt(mediatheque, user2, dvd1);
        biblio.enregistrerEmprunt(mediatheque, user1, cd1);

        System.out.println("\n--- Emprunts après emprunt ---");
        System.out.println(user1);
        System.out.println(user2);

        //Retours
        biblio.enregistrerRetour(mediatheque, user1, livre1);
        biblio.enregistrerRetour(mediatheque, user2, dvd1);

        System.out.println("\n--- Emprunts après retour ---");
        System.out.println(user1);
        System.out.println(user2);

        //Test de disponibilté des documents
        System.out.println("\n--- Disponibilité des documents ---");
        System.out.println(livre1);
        System.out.println(dvd1);
        System.out.println(cd1);
    }
}