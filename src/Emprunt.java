import java.time.LocalDate;


public class Emprunt {

    //attributs
    private final LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private final Utilisateur utilisateur;
    private final Document document;
    private final LocalDate dateLimiteRetour;

    //Constructeur
    public Emprunt(Utilisateur utilisateur, Document document){
        if (utilisateur == null || document == null)
            throw new IllegalArgumentException("Utilisateur ou document invalide.");
        this.utilisateur = utilisateur;
        this.document = document;
        this.dateEmprunt = LocalDate.now();
        this.dateLimiteRetour = dateEmprunt.plusDays(14);
        this.dateRetour = null;
    }

    //Methodes specifiques
    //Terminer emprunt
    public void terminerEmprunt() {
        this.dateRetour = LocalDate.now();
        document.setDisponible(true);
    }
    // Vérifier retard
    public boolean estEnRetard() {
        return dateRetour == null && LocalDate.now().isAfter(dateLimiteRetour);
    }

    //Getters
    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }
    public LocalDate getDateRetour() {
        return dateRetour;
    }
    public LocalDate getDateLimiteRetour() {
        return dateLimiteRetour;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public Document getDocument() {
        return document;
    }

    //Affichage
    @Override
    public String toString() {
        return "Emprunt{" +
                "document=" + document.getTitre() +
                ", utilisateur=" + utilisateur.getNom() +
                ", dateEmprunt=" + dateEmprunt +
                ", dateLimiteRetour=" + dateLimiteRetour +
                ", dateRetour=" + dateRetour +
                '}';
    }

}
