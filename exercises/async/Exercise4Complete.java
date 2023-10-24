import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Exercise4Complete {
    public static void main(String[] args) throws InterruptedException {
        long t0 = System.currentTimeMillis();
        List<CompletableFuture<?>> outputFutures = new ArrayList<CompletableFuture<?>>();

        for (int frame=0; frame < 100; frame++) {
            final int frame2 = frame;

            CompletableFuture<TinyRayTracer> rtFuture = CompletableFuture.supplyAsync(() -> new TinyRayTracer(Scene.frame(0, frame2, 100) , 1080, 720, 1.05f));

            CompletableFuture<byte[][]> linesFuture = rtFuture.thenApplyAsync(rt -> {
                byte[][] lines = new byte[720][];

                // This is probably overkill than just rendering all the lines in one CompletableFuture, but
                // it appeared to be a very slight improvement in performance.
                List<CompletableFuture<byte[]>> lineFutures = new ArrayList<CompletableFuture<byte[]>>();
                for (int i = 0; i < 720; i++) {
                    final int i2 = i;
                    lineFutures.add(CompletableFuture.supplyAsync(() -> rt.renderLine(i2)));
                }
                for (int i = 0; i < 720; i++) {
                    lines[i] = lineFutures.get(i).join();
                }
                return lines;
            });

            outputFutures.add(linesFuture.thenAcceptAsync(lines -> {
                // A static utility function to write the byte array to a standard image file.
                try (PrintStream out = new PrintStream(new FileOutputStream("scene" + frame2 + ".ppm"))) {
                    TinyRayTracer.writePPM(lines, out);
                }
                catch (IOException e) {
                    System.err.println("Error writing frame " + frame2 + ": " + e.getMessage());
                }
            }));
        }

        for (var f : outputFutures) {
            f.join();
        }

        long t1 = System.currentTimeMillis();
        System.out.println("Time: " + (t1 - t0) + "ms");
    }
}