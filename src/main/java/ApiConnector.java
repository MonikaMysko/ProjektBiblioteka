import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class ApiConnector {

    private static final String URL = "https://wolnelektury.pl";

    public List<Book> getAll() {

        List<Book> result = new ArrayList<>();

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
                book.setAuthor(jsonObject.getString("author"));
                book.setTitle(jsonObject.getString("title"));
                book.setKind(jsonObject.getString("kind"));
                book.setEpoch(jsonObject.getString("epoch"));
                book.setGenre(jsonObject.getString("genre"));
                book.setUrl(jsonObject.getString("url"));

                result.add(book);

            });


//            System.out.println(result);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public String getURL(String title) {

        Map<String, String> bookMap = new HashMap<>();

        String searchingURL = null;

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

                bookMap.put(book.getTitle(), book.getUrl());

            });

            searchingURL = String.valueOf(bookMap.get(title));


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return searchingURL;
    }


    public String getAuthor(String searchingAuthor) {

        Map<String, String> authorMap = new HashMap<>();

        String searchingURL = null;

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
                author.setName(jsonObject.getString("name").toLowerCase());
                author.setAuthorUrl(jsonObject.getString("url"));

                authorMap.put(author.getName(), author.getAuthorUrl());

            });

            searchingURL = authorMap.get(searchingAuthor);


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return searchingURL;
    }


    public String getEpoch(String searchingEpoch) {

        Map<String, String> epochMap = new HashMap<>();

        String searchingURL = null;

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

                epochMap.put(epoch.getEpochName(), epoch.getEpochUrl());

            });

            searchingURL = epochMap.get(searchingEpoch);


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return searchingURL;
    }


}
