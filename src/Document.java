public abstract class Document {

    //Attributes
    private final int idDoc;
    private final String titre;
    private boolean disponible;

    //Constructeur
    public Document(int idDoc, String titre){
        if (idDoc <= 0)
            throw new IllegalArgumentException("ID du document invalide.");
        if (titre == null || titre.isBlank())
            throw new IllegalArgumentException("Le titre ne peut pas être vide.");

        this.idDoc = idDoc;
        this.titre = titre;
        this.disponible = true;
    }

    //methodes specifiques


    //setters
    public void setDisponible(boolean disponible){
        this.disponible=disponible;
    }

    //getters
    public int getIdDoc(){
        return idDoc;
    }
    public String getTitre(){
        return titre;
    }
    public boolean isDisponible(){
        return disponible;
    }

    //Affichage
    @Override
    public String toString() {
        return "Document{" +
                "idDoc=" + idDoc +
                ", titre='" + titre + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
