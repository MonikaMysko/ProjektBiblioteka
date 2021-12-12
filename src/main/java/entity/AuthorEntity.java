package entity;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;
    private String author;

    public String getUrlAuthor() {
        return urlAuthor;
    }

    public void setUrlAuthor(String urlAuthor) {
        this.urlAuthor = urlAuthor;
    }

    private String urlAuthor;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    public AuthorEntity() {
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "idAuthor=" + idAuthor +
                ", author='" + author + '\'' +
                ", urlAuthor='" + urlAuthor + '\'' +
                ", bookEntityList=" + bookEntityList +
                '}';
    }

    public void addBookEntityList(BookEntity bookEntity){
        bookEntityList.add(bookEntity);
    }
}
