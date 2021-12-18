package connector;

import model.Book;

public interface ApiConnector {

    Book getTitle(String searchingTitle);

    String getAuthor(String searchingAuthor);

    String getEpoch(String searchingEpoch);

}
