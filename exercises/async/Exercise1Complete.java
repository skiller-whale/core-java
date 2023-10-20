import java.util.*;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class Exercise1Complete {

    static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    // "Whales, Dolphins, and Porpoises of the Western North Atlantic", Caldwell et. al.
    static final URI     bookUri = URI.create("https://www.gutenberg.org/cache/epub/33527/pg33527.txt");
    static final HttpClient http = HttpClient.newBuilder().build();

    public static Future<?> indexWhalesAsync(String input, Consumer<Integer> indexer) {
        return executor.submit(() -> {
            for (int offset=-5; offset != -1; indexer.accept(offset)) {
                offset = input.indexOf("whale", offset+5);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, java.io.IOException {
        HttpRequest request = HttpRequest.newBuilder().uri(bookUri).GET().build();
        Future<HttpResponse<String>> resultFuture = http.sendAsync(request, BodyHandlers.ofString());

        Future<List<Integer>> whaleIndexFuture = executor.submit(() -> {
            List<Integer> index = new ArrayList<Integer>();
            var counterFuture = indexWhalesAsync(resultFuture.get().body(), (i) -> { index.add(i); });
            counterFuture.get();
            return index;
        });

        System.out.println(whaleIndexFuture.get().size());
    }
}
