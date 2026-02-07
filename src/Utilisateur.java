import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilisateur {

    //attributs
    private final int id;
    private final String nom;
    private final String prenom;
    private String email;
    //Liste des documents empruntes de la bibliotheque
    private final List<Document> documentsEmpruntes;
    //Le nombre maximum des documents empruntes
    private static final int MAX_EMPRUNTS = 5;

    //constructeur
    public Utilisateur(int id, String nom, String prenom, String email){
        if(nom == null || nom.isBlank()){
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        if(prenom == null || prenom.isBlank()){
            throw new IllegalArgumentException("Le prenom ne peut pas être vide.");
        }
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("L'email ne peut pas être vide.");
        }

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.documentsEmpruntes = new ArrayList<>();
    }

    //setters
    public void setEmail(String email){
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email invalide.");
        this.email = email;
    }

    //getters
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getEmail(){
        return email;
    }
    //retourner une liste nom modifiable des documents empruntes
    public List<Document> getDocumentsEmpruntes(){
        return Collections.unmodifiableList(documentsEmpruntes);
    }

    //Methodes specifiques à la classe
    public void emprunter(Document d){
        if(d == null){
            System.out.println("Impossible : document null.");
            return;
        }
        if(!d.isDisponible()){
            System.out.println("le document \""+ d.getTitre() + "\" est déjà emprunté.");
            return;
        }
        if (documentsEmpruntes.size() >= MAX_EMPRUNTS) {
            System.out.println("Limite atteinte : max " + MAX_EMPRUNTS + " emprunts.");
            return;
        }

        documentsEmpruntes.add(d);
        d.setDisponible(false);
        System.out.println(nom + " a emprunté : " + d.getTitre());
    }
    public void retourner(Document d){
        if (d == null) {
            System.out.println("Impossible : document null.");
            return;
        }
        if (!documentsEmpruntes.contains(d)) {
            System.out.println("Ce document n’a pas été emprunté par " + nom);
            return;
        }

        documentsEmpruntes.remove(d);
        d.setDisponible(true);
        System.out.println(nom + " a retourné : " + d.getTitre());
    }

    //Affichage
    @Override
    public String toString(){
        return "Utilisateur {"+
                "id =" + id+
                ", nom ='" + nom + '\'' +
                ", prenom ='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", emprunts=" + documentsEmpruntes.size() +
                '}';
    }
}
