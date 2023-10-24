import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Exercise5Complete {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<List<String>> origin = CompletableFuture.supplyAsync(() -> new ArrayList<String>());

        for (int i=0; i<10000; i++) {
            final int i2 = i;

            origin.thenAcceptAsync(list -> {
                list.add("Incoming data "+i2);
            }).exceptionally(ex -> {
                System.err.println("Error in receiving incoming data: "+ex.getMessage());
                return null;
            });

            origin.thenApplyAsync(list -> {
                int total=0;
                for (String s : list) { total += s.length(); }
                return total;
            }).whenCompleteAsync((total, ex) -> {
                if (ex == null) {
                    updateUiWithLength(total);
                } else {
                    System.err.println("Error scanning list: "+ex.getMessage());
                }
            });
        }

        ForkJoinPool.commonPool().awaitQuiescence(10, java.util.concurrent.TimeUnit.SECONDS);

        System.out.println(origin.join().size()+" items"); // ...oh no.
    }

    public static void updateUiWithLength(int length) {
        // ...imagine updating a GUI here...
    }
}
