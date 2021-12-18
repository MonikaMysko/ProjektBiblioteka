import application.Application;
import connector.ApiConnector;
import connector.ApiConnectorImpl;
import repository.Repository;
import repository.RepositoryImpl;
import service.AppService;
import service.AppServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Startup {

    private static final EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("bookPU");

    private static final EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        ApiConnector apiConnector = new ApiConnectorImpl();
        Repository repository = new RepositoryImpl(entityManager);
        AppService appService = new AppServiceImpl(apiConnector, repository);

        new Application(appService).start();
    }
}