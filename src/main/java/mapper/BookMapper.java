package mapper;

import entity.BookEntity;
import model.Book;

public class BookMapper {

    public static Book mapBookEntityToBook(BookEntity bookEntity) {
        Book book = new Book();

        book.setTitle(bookEntity.getTitle());
        book.setGenre(bookEntity.getGenre());
        book.setUrl(bookEntity.getUrl());
        book.setKind(bookEntity.getKind());
        book.setAuthor(String.valueOf(bookEntity.getAuthor()));
        book.setEpoch(String.valueOf(bookEntity.getEpoch()));

        return book;
    }

    public static BookEntity mapBookToBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(book.getTitle());
        bookEntity.setGenre(book.getGenre());
        bookEntity.setUrl(book.getUrl());
        bookEntity.setKind(book.getKind());

        return bookEntity;
    }
}