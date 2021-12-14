package service;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;
import model.Book;

public interface AppService {

    Book getByName(String name);

    public Book getTitle(String searchingTitle);
    public String getAuthor(String searchingAuthor);
    public String getEpoch(String searchingEpoch);

    public AuthorEntity getAuthorEntity(Book book);
    public EpochEntity getEpochEntity(Book book);


}