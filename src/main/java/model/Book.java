package model;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private String kind;
    private String epoch;
    private String genre;
    private String url;

    public Book(String title, String author, String kind, String epoch, String genre, String url) {
        this.title = title;
        this.author = author;
        this.kind = kind;
        this.epoch = epoch;
        this.genre = genre;
        this.url = url;
    }

    public Book() {
    }
}

