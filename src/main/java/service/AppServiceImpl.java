package service;

import connector.ApiConnector;
import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;
import mapper.BookMapper;
import model.Book;
import repository.Repository;

public class AppServiceImpl implements AppService {

    private final ApiConnector apiConnector;
    private final Repository repository;

    public AppServiceImpl(ApiConnector apiConnector, Repository repository) {
        this.apiConnector = apiConnector;
        this.repository = repository;
    }

    @Override
    public Book getByName(String name) {
        return null;
    }

    @Override
    public Book getTitle(String name) {

        BookEntity bookEntity = repository.getTitle(name);


        if (bookEntity == null) {

            Book book = apiConnector.getTitle(name);

            AuthorEntity authorEntity = getAuthorEntity(book);
            EpochEntity epochEntity = getEpochEntity(book);

            bookEntity = BookMapper.mapBookToBookEntity(book);
            bookEntity.setAuthor(authorEntity);
            bookEntity.setEpoch(epochEntity);
            //authorEntity.addBookEntityList(bookEntity);
            //epochEntity.addBookEntityList(bookEntity);
            repository.save(bookEntity);

//            System.out.println(" TO KSIĄŻKA Z API: ");

            return book;

        } else {

            Book book = BookMapper.mapBookEntityToBook(bookEntity);
//            System.out.println(" TO KSIĄŻKA Z BAZY DANYCH: ");
            return book;
        }
    }


    @Override
    public String getAuthor(String searchingAuthor) {

        return null;
    }

    @Override
    public String getEpoch(String searchingEpoch) {
        return null;
    }


    @Override
    public AuthorEntity getAuthorEntity(Book book) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthor(book.getAuthor());
        repository.save(authorEntity);
        return authorEntity;
    }

    @Override
    public EpochEntity getEpochEntity(Book book) {
        EpochEntity epochEntity = new EpochEntity();
        epochEntity.setEpoch(book.getEpoch());
        repository.save(epochEntity);
        return epochEntity;
    }


}