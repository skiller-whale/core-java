import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.net.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        var myLatch = new CountDownLatch(800);
        final WeatherReport object = new WeatherReport();
        object.createFile(WeatherReport.tempsPath);
        object.createFile(WeatherReport.rainfallPath);
        final long start = System.currentTimeMillis();
        for (var i = 0; i < 800; i++) {
            final var digit = i;
            Thread.ofVirtual().start(() -> {
                try {
                    if (digit % 2 == 0) {
                        object.writeTemp();
                    } else {
                        object.writeRainfall();
                    }
                    myLatch.countDown();
                } catch (InterruptedException | IOException ex) {
                    System.out.println(ex);
                }
            });
        }
        myLatch.await();
        final long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Total time to retrieve weather data: %s second(s)\n", elapsed / 1000f);
    }
}

class WeatherReport {
    static final Path tempsPath    = Paths.get("temperatures.txt");
    static final Path rainfallPath = Paths.get("rainfall.txt");
    final Lock temperatureLock     = new ReentrantLock();
    final Lock rainfallLock        = new ReentrantLock();

    void createFile(Path path) throws IOException {
        List<String> lines = Collections.emptyList();
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    void addTemperatures(String temp) throws IOException {
        this.temperatureLock.lock();
        try {
            List<String> temperatures = Files.readAllLines(tempsPath);
            temperatures.add(temp);
            Files.write(tempsPath, (String.join("\n", temperatures)+"\n").getBytes(), StandardOpenOption.CREATE);
        }
        finally { this.temperatureLock.unlock(); }
    }

    // Write random temperature forecast
    void writeTemp() throws InterruptedException, IOException  {
        FakeRequest request = new FakeRequest();
        var temp = request.get("http://weather.com/london/", true);
        addTemperatures(temp);
    }

    void addRainfall(String rain) throws IOException {
        this.rainfallLock.lock();
        try {
            List<String> rainfall = Files.readAllLines(rainfallPath);
            rainfall.add(rain);
            Files.write(rainfallPath, (String.join("\n", rainfall)+"\n").getBytes(), StandardOpenOption.CREATE);
        }
        finally { this.rainfallLock.unlock(); }
    }

    // Write random rainfall forecast
    void writeRainfall() throws InterruptedException, IOException  {
        FakeRequest request = new FakeRequest();
        var rain = request.get("http://weather.com/london/", false);
        addRainfall(rain);
    }
}
