import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Exercise4 {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        final int MAX_TIME       = 2000;
        List<byte[]> lines;

        int lower = 9, upper = 100000;
        while (upper - lower > 100) {
            int height = lower + ((upper - lower) / 2);
            int width  = height*16/9;
            System.out.printf("Rendering %d×%d: ", width, height);

            TinyRayTracer rt = new TinyRayTracer(Scene.DEFAULT, width, height, 1.05f);
            List<Future<byte[]>> futures = new ArrayList<Future<byte[]>>(height);
            lines = new ArrayList<byte[]>(height);

            for (int i = 0; i < rt.height(); i++) {
                final int iFinal = i;
                futures.add(executor.submit(() -> rt.renderLine(iFinal)));
            }

            long deadline = System.currentTimeMillis() + MAX_TIME;
            for (Future<byte[]> future : futures) {
                try { lines.add(future.get(deadline - System.currentTimeMillis(), TimeUnit.MILLISECONDS)); }
                catch (ExecutionException e) { System.err.println(e); return; }
                catch (TimeoutException e) { break; }
            }

            if (System.currentTimeMillis() > deadline) {
                for (Future<byte[]> future : futures) {
                    future.cancel(true);
                }
            }

            if (System.currentTimeMillis() > deadline) {
                System.out.println("❌");
                upper = height;
            } else {
                System.out.println("✅");
                lower = height;
            }
        }
        System.out.println("Largest height picture we could render in "+MAX_TIME+"ms is "+lower);
    }
}