package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;
    private String author;
    private String urlAuthor;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    public AuthorEntity() {
        bookEntityList = new ArrayList<>();
    }

    public void addBookEntityList(BookEntity bookEntity) {
        bookEntityList.add(bookEntity);
    }
}
