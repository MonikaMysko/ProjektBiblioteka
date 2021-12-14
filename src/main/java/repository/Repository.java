package repository;
import entity.AuthorEntity;
import entity.BookEntity;
import entity.EpochEntity;

public interface Repository {

    BookEntity getByName(String name);

    BookEntity save(BookEntity bookEntity);

    EpochEntity save(EpochEntity epochEntity);

    AuthorEntity save(AuthorEntity authorEntity);

    BookEntity getTitle(String name);


}