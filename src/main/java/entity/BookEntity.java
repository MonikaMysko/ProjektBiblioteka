package entity;

import javax.persistence.*;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String title;

    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private AuthorEntity author;

   @ManyToOne
   @JoinColumn(name = "idEpoch")
    private EpochEntity epoch;

    private String kind;
    private String genre;
    private String url;


    public BookEntity() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public EpochEntity getEpoch() {
        return epoch;
    }

    public void setEpoch(EpochEntity epoch) {
        this.epoch = epoch;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}