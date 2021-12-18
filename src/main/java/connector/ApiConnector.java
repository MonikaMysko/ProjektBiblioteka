package connector;

import model.Author;
import model.Book;
import model.Epoch;

public interface ApiConnector {

    Book getTitle(String searchingTitle);

   String getAuthor(String searchingAuthor);

   String getEpoch(String searchingEpoch);

}
