import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mediatheque {

    //Attributs
    private final String nom;
    private final String adresse;
    //Liste des utilisateurs inscrits dans la mediatheque
    private final List<Utilisateur> utilisateurs;
    //liste des documents disponibles dans la mediatheque
    private final List<Document> documents;

    //Constructeur
    public Mediatheque(String nom, String adresse){
        if (nom == null || nom.isBlank())
            throw new IllegalArgumentException("Le nom de la médiathèque est obligatoire.");
        if (adresse == null || adresse.isBlank())
            throw new IllegalArgumentException("L'adresse est obligatoire.");

        this.nom = nom;
        this.adresse = adresse;
        this.utilisateurs = new ArrayList<>();
        this.documents = new ArrayList<>();
    }

    //Méthodes specifiques à la classe mediatheque
    //inscrire un utilisateur
    public void inscrireUtilisateur(Utilisateur u){
        if (u == null) {
            System.out.println("Impossible : utilisateur null.");
            return;
        }
        if (utilisateurs.contains(u)) {
            System.out.println("Utilisateur déjà inscrit : " + u.getNom());
            return;
        }

        utilisateurs.add(u);
        System.out.println("Utilisateur inscrit : "+ u.getNom());
    }
    //ajouter un document
    public void ajouterDocument(Document d){
        if (d == null) {
            System.out.println("Impossible : document null.");
            return;
        }
        if (documents.contains(d)) {
            System.out.println("Document déjà موجود : " + d.getTitre());
            return;
        }

        documents.add(d);
        System.out.println("Document ajouté : "+ d.getTitre());
    }
    //emprunter un document
    public void emprunterDocument(Utilisateur u, Document d){
        if (!utilisateurs.contains(u)) {
            System.out.println("Erreur : utilisateur non inscrit.");
            return;
        }
        if (!documents.contains(d)) {
            System.out.println("Erreur : document inexistant.");
            return;
        }
        if (!d.isDisponible()) {
            System.out.println("Document déjà emprunté.");
            return;
        }

        u.emprunter(d);
        System.out.println("Emprunt validé dans la médiathèque.");
    }
    //Retourner un document
    public void retournerDocument(Utilisateur u,Document d){
        if (!utilisateurs.contains(u)) {
            System.out.println("Erreur : utilisateur non inscrit.");
            return;
        }
        if (!documents.contains(d)) {
            System.out.println("Erreur : document inexistant.");
            return;
        }

        u.retourner(d);
        System.out.println("Retour validé dans la médiathèque.");
    }

    //getters
    public String getNom(){
        return nom;
    }
    public String getAdresse(){
        return adresse;
    }
    public List<Utilisateur> getUtilisateurs(){
        return Collections.unmodifiableList(utilisateurs);
    }
    public List<Document> getDocuments(){
        return Collections.unmodifiableList(documents);
    }

    //Affichage
    @Override
    public String toString() {
        return "Mediatheque{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", utilisateurs=" + utilisateurs.size() +
                ", documents=" + documents.size() +
                '}';
    }

}
