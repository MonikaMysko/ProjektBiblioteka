package entity;

import javax.persistence.*;
import java.util.ArrayList;
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
        bookEntityList=new ArrayList<>();
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


    public void addBookEntityList(BookEntity bookEntity){
        bookEntityList.add(bookEntity);
    }


}
