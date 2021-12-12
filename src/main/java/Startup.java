import application.Application;
import connector.ApiConnector;
import connector.ApiConnectorImpl;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;
import repository.Repository;
import repository.RepositoryImpl;
import service.AppService;
import service.AppServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Startup {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "bookPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        ApiConnector apiConnector = new ApiConnectorImpl();
        Repository repository = new RepositoryImpl(entityManager);
        AppService appService = new AppServiceImpl(apiConnector, repository);


        EpochEntity epochEntity=new EpochEntity();
        epochEntity=repository.save(epochEntity);
        AuthorEntity authorEntity=new AuthorEntity();
        authorEntity=repository.save(authorEntity);
        BookEntity bookEntity=new BookEntity();
        bookEntity=repository.save(bookEntity);




        new Application(appService).start();
    }
}