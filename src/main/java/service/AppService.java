package service;

import entity.AuthorEntity;
import entity.EpochEntity;
import model.Author;
import model.Book;
import model.Epoch;

public interface AppService {

    Book getByName(String name);

    public Book getTitle(String searchingTitle);
    public Author getAuthor(String searchingAuthor);
    public Epoch getEpoch(String searchingEpoch);

    public AuthorEntity getAuthorEntity(Book book);
    public EpochEntity getEpochEntity(Book book);

    public AuthorEntity getAuthorEntity(Author author);



}