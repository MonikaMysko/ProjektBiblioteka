package model;

import lombok.Data;

@Data
public class Author {
    private String name;
    private String AuthorUrl;

    public Author(String name, String authorUrl) {
        this.name = name;
        AuthorUrl = authorUrl;
    }

    public Author() {
    }
}
