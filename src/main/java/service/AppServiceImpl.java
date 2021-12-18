package service;

import connector.ApiConnector;
import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;
import mapper.AuthorMapper;
import mapper.BookMapper;
import mapper.EpochMapper;
import model.Author;
import model.Book;
import model.Epoch;
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
    public Author getAuthor(String searchingAuthor) {
        AuthorEntity authorEntity = repository.getAuthor(searchingAuthor);

        if (authorEntity == null) {

            Author author = apiConnector.getAuthor(searchingAuthor);


            authorEntity = AuthorMapper.mapAuthorToAuthorEntity(author);
            repository.save(authorEntity);

//            System.out.println(" TO AUTOR Z API: ");

            return author;

        } else {

            Author author= AuthorMapper.mapAuthorEntityToAuthor(authorEntity);
//            System.out.println(" TO AUTOR Z BAZY DANYCH: ");
            return author;
        }

    }

    @Override
    public Epoch getEpoch(String searchingEpoch) {

       EpochEntity epochEntity = repository.getEpoch(searchingEpoch);

        if (epochEntity == null) {

            Epoch epoch = apiConnector.getEpoch(searchingEpoch);


            epochEntity = EpochMapper.mapEpochToEpochEntity(epoch);
            repository.save(epochEntity);

//            System.out.println(" TO AUTOR Z API: ");

            return epoch;

        } else {

            Epoch epoch= EpochMapper.mapEpochEntityToEpoch(epochEntity);
//            System.out.println(" TO AUTOR Z BAZY DANYCH: ");
            return epoch;
        }

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