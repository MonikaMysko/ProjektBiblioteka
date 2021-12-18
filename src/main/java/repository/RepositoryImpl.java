package repository;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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

        EpochEntity epochEntityInTable = null;
        try {
            epochEntityInTable = (EpochEntity) entityManager
                    .createQuery("from EpochEntity  where epoch = " + "'" + epochEntity.getEpoch() + "'")
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }

        if (epochEntityInTable == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(epochEntity);
            entityManager.getTransaction().commit();
        } else {
            epochEntity.setIdEpoch(epochEntityInTable.getIdEpoch());
        }

        return epochEntity;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        AuthorEntity authorInTable = null;
        try {
            authorInTable = (AuthorEntity) entityManager
                    .createQuery("from AuthorEntity  where author = " + "'" + authorEntity.getAuthor() + "'")
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }

        if (authorInTable == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(authorEntity);
            entityManager.getTransaction().commit();
        } else{
            authorEntity.setIdAuthor(authorInTable.getIdAuthor());
        }
        return authorEntity;
    }

    @Override
    public BookEntity getTitle(String searchingTitle) {
        BookEntity result = null;
        try {
            Query query = entityManager.createQuery("FROM BookEntity where title = " + "'" + searchingTitle + "'");
            result = (BookEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
        }
        return result;
    }

    @Override
    public AuthorEntity getAuthor(String searchingAuthor) {
        AuthorEntity result=null;

        try {
            Query query = entityManager.createQuery(("FROM AuthorEntity  where author = " + "'" + searchingAuthor + "'"));
            result = (AuthorEntity) query.getSingleResult();
        }catch (NoResultException ignored){

        }
        return result;
    }

    @Override
    public EpochEntity getEpoch(String searchingEpoch) {
        EpochEntity result=null;

        try{
            Query query=entityManager.createQuery(("FROM EpochEntity where epoch= " + "'" + searchingEpoch + "'"));
            result=(EpochEntity) query.getSingleResult();
        }catch (NoResultException ignored){

        }
        return result;
    }


}