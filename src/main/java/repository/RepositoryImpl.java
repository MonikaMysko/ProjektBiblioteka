package repository;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;

import javax.persistence.EntityManager;

public class RepositoryImpl implements Repository {

    private final EntityManager entityManager;

    public RepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public BookEntity getByName(String name) {
        return new BookEntity();
    }

    @Override
    public BookEntity save(BookEntity bookEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(bookEntity);
        entityManager.getTransaction().commit();
        return bookEntity;
    }

    @Override
    public EpochEntity save(EpochEntity epochEntity) {
       entityManager.getTransaction().begin();
       entityManager.persist(epochEntity);
       entityManager.getTransaction().commit();
       return epochEntity;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
       entityManager.getTransaction().begin();
       entityManager.persist(authorEntity);
       entityManager.getTransaction().commit();
       return authorEntity;
    }


}