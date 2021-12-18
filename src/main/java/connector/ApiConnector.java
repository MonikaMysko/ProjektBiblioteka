package connector;

import model.Author;
import model.Book;
import model.Epoch;

public interface ApiConnector {

    Book getTitle(String searchingTitle);

   Author getAuthor(String searchingAuthor);

   Epoch getEpoch(String searchingEpoch);

   String getEpochUrl(String ssearchingEpoch,Epoch epoch);

}
