import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

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

                JSONObject jsonObject= (JSONObject) s;

                Book book = new Book();
                book.setAuthor(jsonObject.getString("author"));
                book.setTitle(jsonObject.getString("title"));
                book.setKind(jsonObject.getString("kind"));
                book.setEpoch(jsonObject.getString("epoch"));
                book.setGenre(jsonObject.getString("genre"));
                book.setUrl(jsonObject.getString("url"));

                result.add(book);

            });


            System.out.println(result);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
