package service;

import model.Book;

public interface AppService {

    Book getByName(String name);

    public Book getTitle(String searchingTitle);
    public String getAuthor(String searchingAuthor);
    public String getEpoch(String searchingEpoch);


}