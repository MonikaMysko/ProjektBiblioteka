package connector;

import model.Author;
import model.Book;
import model.Epoch;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ApiConnectorImpl implements ApiConnector {

    private static final String URL = "https://wolnelektury.pl";


    @Override
    public Book getTitle(String searchingTitle) {
        Map<String, Book> bookMap = new HashMap<>();

        Book result = new Book();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/books/"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s -> {

                JSONObject jsonObject = (JSONObject) s;

                Book book = new Book();
                book.setTitle(jsonObject.getString("title").toLowerCase());
                book.setUrl(jsonObject.getString("url"));
                book.setKind(jsonObject.getString("kind"));
                book.setAuthor(jsonObject.getString("author"));
                book.setGenre(jsonObject.getString("genre"));
                book.setEpoch(jsonObject.getString("epoch"));

                bookMap.put(book.getTitle(), (book));

            });

            result= new Book(bookMap.get(searchingTitle).getTitle(),
                    bookMap.get(searchingTitle).getAuthor(),
                    bookMap.get(searchingTitle).getEpoch(),
                    bookMap.get(searchingTitle).getKind(),
                    bookMap.get(searchingTitle).getGenre(),
                    bookMap.get(searchingTitle).getUrl()
            );




        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Author getAuthor(String searchingAuthor) {
        Map<String, Author> authorMap = new HashMap<>();

        Author result = new Author();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/authors/"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s -> {

                JSONObject jsonObject = (JSONObject) s;

                Author author = new Author();
                author.setName(jsonObject.getString("name"));
                author.setAuthorUrl(jsonObject.getString("url"));

                authorMap.put(author.getName(), author);

            });

            result=new Author(authorMap.get(searchingAuthor).getName(),authorMap.get(searchingAuthor).getAuthorUrl());


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return result;


    }

    @Override
    public Epoch getEpoch(String searchingEpoch) {

        Map<String, Epoch> epochMap = new HashMap<>();

        Epoch result = new Epoch();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/epochs/"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s -> {

                JSONObject jsonObject = (JSONObject) s;

                Epoch epoch = new Epoch();
                epoch.setEpochName(jsonObject.getString("name").toLowerCase());
                epoch.setEpochUrl(jsonObject.getString("url"));

                epochMap.put(epoch.getEpochName(), epoch);

            });

            result=new Epoch(epochMap.get(searchingEpoch).getEpochName(),epochMap.get(searchingEpoch).getEpochUrl());


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
