import java.util.*;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.*;

public class Exercise1 {
    // "Whales, Dolphins, and Porpoises of the Western North Atlantic", Caldwell et. al.
    static final URI                      bookUri = URI.create("https://www.gutenberg.org/cache/epub/33527/pg33527.txt");
    static final HttpClient                  http = HttpClient.newBuilder().build();

    public static void indexWhales(String input, List<Integer> index) {
        String word = "whale";
        int offset = -word.length();
        while (offset != -1) {
            offset = input.indexOf(word, offset+word.length());
            index.add(offset);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, java.io.IOException {
        HttpRequest         request = HttpRequest.newBuilder().uri(bookUri).GET().build();
        HttpResponse<String> result = http.send(request, BodyHandlers.ofString());
        List<Integer>    whaleIndex = new ArrayList<Integer>();

        indexWhales(result.body(), whaleIndex);
        System.out.println(whaleIndex.size());
    }
}
