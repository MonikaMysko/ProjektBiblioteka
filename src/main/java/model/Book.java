package model;

public class Book {
    private String title;
    private String author;
    private String kind;
    private String epoch;
    private String genre;
    private String url;

    public Book(String title, String author, String epoch, String genre, String url) {
        this.title = title;
        this.author = author;
        this.epoch = epoch;
        this.genre = genre;
        this.url = url;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
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


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", kind='" + kind + '\'' +
                ", epoch='" + epoch + '\'' +
                ", genre='" + genre + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

