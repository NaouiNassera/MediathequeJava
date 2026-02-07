public class Dvd extends Document {

    //attributs
    private final int duree; // en minutes
    private final String genre;

    // Constructeur
    public Dvd(int idDoc, String titre, int duree, String genre) {
        super(idDoc, titre);

        if (duree <= 0)
            throw new IllegalArgumentException("La durée doit être positive.");
        if (genre == null || genre.isBlank())
            throw new IllegalArgumentException("Le genre ne peut pas être vide.");

        this.duree = duree;
        this.genre = genre;
    }

    // Getters
    public int getDuree() {
        return duree;
    }
    public String getGenre() {
        return genre;
    }

    // Affichage
    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + getIdDoc() +
                ", titre='" + getTitre() + '\'' +
                ", duree=" + duree + " min" +
                ", genre='" + genre + '\'' +
                ", disponible=" + isDisponible() +
                '}';
    }
}
