public class Bibliothecaire extends Utilisateur {

    //attributs
    private String matricule;

    // Constructeur
    public Bibliothecaire(int id, String nom, String prenom, String email, String matricule) {
        super(id, nom, prenom, email);

        if (matricule == null || matricule.isBlank())
            throw new IllegalArgumentException("Le matricule est obligatoire.");

        this.matricule = matricule;
    }

    // Méthodes spécifiques
    // Enregistrer un emprunt dans la médiathèque
    public void enregistrerEmprunt(Mediatheque mediatheque, Utilisateur u, Document d) {
        System.out.println("Bibliothécaire enregistre un emprunt du document : "+d.getTitre()+"par utilisateur : "+u.getNom());
        mediatheque.emprunterDocument(u, d);
    }
    // Enregistrer un retour dans la médiathèque
    public void enregistrerRetour(Mediatheque mediatheque, Utilisateur u, Document d) {
        System.out.println("Bibliothécaire enregistre un retour du document : "+ d.getTitre() + " par utilisateur : " + u.getNom());
        mediatheque.retournerDocument(u, d);
    }
    // Ajouter un document au catalogue
    public void ajouterDocumentCatalogue(Mediatheque mediatheque, Document d) {
        System.out.println("Bibliothécaire ajoute un document : " + d.getTitre());
        mediatheque.ajouterDocument(d);
    }
    // Inscrire un nouvel utilisateur
    public void inscrireNouvelUtilisateur(Mediatheque mediatheque, Utilisateur u) {
        System.out.println("Bibliothécaire inscrit un utilisateur : " + u.getNom() );
        mediatheque.inscrireUtilisateur(u);
    }

    // Getters
    public String getMatricule() {
        return matricule;
    }

    // Affichage
    @Override
    public String toString() {
        return "Bibliothecaire{" +
                "nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", matricule='" + matricule + '\'' +
                '}';
    }
}

