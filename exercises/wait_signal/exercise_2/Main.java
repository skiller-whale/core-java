import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* Test rig for MyCountDownLatch.
 * This runs a test with 1000 threads, each of which just counts up to 500.
 * The test is run 10 times and the total running time is printed.
 * The test is run 10 times to get a better estimate of the average running time.
 */
public class Main {
    public static final Random random  = new Random();
    public static final int ITERATIONS = 2000;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            runTest();
        }
    }

    public static void runTest() throws InterruptedException {
        final long start = System.currentTimeMillis();
        var startLatch   = new MyCountDownLatch(1);
        var finishLatch  = new MyCountDownLatch(ITERATIONS);

        for (int i = 0; i < ITERATIONS; i++) {
            final var digit = i;
            Runnable r = () -> {
                startLatch.await();
                var count = 0;
                for (int j = 0; j < 500; j++) {
                    count++;
                }
                finishLatch.countDown();
            };
            Thread.ofVirtual().start(r);
        }

        startLatch.countDown(); // Start all the threads at once
        final long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Total running time for %d threads = %dms\n", ITERATIONS, elapsed);
    }
}
