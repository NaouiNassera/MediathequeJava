public class Livre extends Document{
    private String auteur;
    private String isbn;

    //Constructeur
    public Livre(int idDoc, String titre, String auteur, String isbn){
        super(idDoc,titre);
        this.auteur = auteur;
        this.isbn = isbn;
    }

    //setters
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    //getters
    public String getAuteur(){
        return auteur;
    }

    public String getIsbn(){
        return isbn;
    }
}
