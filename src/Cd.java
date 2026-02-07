public class Cd extends Document {

    //attributs
    private final String artiste;
    private final String genre;

    // Constructeur
    public Cd(int idDoc, String titre, String artiste, String genre) {
        super(idDoc, titre);

        if (artiste == null || artiste.isBlank())
            throw new IllegalArgumentException("L'artiste ne peut pas être vide.");
        if (genre == null || genre.isBlank())
            throw new IllegalArgumentException("Le genre ne peut pas être vide.");

        this.artiste = artiste;
        this.genre = genre;
    }

    // Getters
    public String getArtiste() {
        return artiste;
    }
    public String getGenre() {
        return genre;
    }

    // Affichage
    @Override
    public String toString() {
        return "Cd{" +
                "id=" + getIdDoc() +
                ", titre='" + getTitre() + '\'' +
                ", artiste='" + artiste + '\'' +
                ", genre='" + genre + '\'' +
                ", disponible=" + isDisponible() +
                '}';
    }
}

