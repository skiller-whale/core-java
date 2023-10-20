import java.util.*;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class Exercise1Async {

    // You'll need this
    static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    // "Whales, Dolphins, and Porpoises of the Western North Atlantic", Caldwell et. al.
    static final URI     bookUri = URI.create("https://www.gutenberg.org/cache/epub/33527/pg33527.txt");
    static final HttpClient http = HttpClient.newBuilder().build();

    // Convert this function to work asynchronously, supplying indexes via a user-supplied function.
    public static Future<?> countWhalesAsync(String input, Consumer<Integer> indexer) {
        // Copy the code from countWhales, wrapping
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, java.io.IOException {
        HttpRequest request = HttpRequest.newBuilder().uri(bookUri).GET().build();

        // The one API in core Java that has an async version!
        Future<HttpResponse<String>> resultFuture = http.sendAsync(request, BodyHandlers.ofString());

        Future<List<Integer>> whaleIndexFuture = // Submit a job that creates the index, calls countWhalesAsync, returns the result

        System.out.println(whaleIndexFuture.get().size());
    }
}
