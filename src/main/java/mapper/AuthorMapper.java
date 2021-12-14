package mapper;

import entity.AuthorEntity;
import model.Author;


public class AuthorMapper {
    public static Author mapAuthorEntityToAuthor(AuthorEntity authorEntity) {
        Author author = new Author();

        author.setName(authorEntity.getAuthor());
        author.setAuthorUrl(authorEntity.getUrlAuthor());
        return author;
    }

    public static AuthorEntity mapAuthorToAuthorEntity(Author author) {
        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setAuthor(author.getName());
        authorEntity.setUrlAuthor(author.getAuthorUrl());
        return authorEntity;
    }
}
