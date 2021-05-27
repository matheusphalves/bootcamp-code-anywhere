import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ClienteHttpExemplo{
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
        .GET().uri(URI.create("https://www.google.com.br"))
        .build();


    }
}