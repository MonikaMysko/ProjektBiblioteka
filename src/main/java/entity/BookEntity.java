package entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    private String title;
    private String kind;
    private String genre;
    private String url;


    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "idEpoch")
    private EpochEntity epoch;
}