
import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.util.function.*;

public class FunctionTypesTest {

    // FIXME: Add RunnerType, ParserType, BuilderType and FinderType here

    public static String fetchMobyDick() throws IOException, InterruptedException, URISyntaxException {
        return HttpClient.newBuilder().build().send(
            HttpRequest.newBuilder().uri(
                new URI("https://www.gutenberg.org/files/2701/2701-0.txt")
            ).GET().build(),
            HttpResponse.BodyHandlers.ofString()).body();
    }
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        String mobyDickByHermanMelville = fetchMobyDick();

        RunnerType  runner  = () -> System.out.println("Hello there!");
        ParserType  parser  = Integer::parseInt;
        BuilderType builder = String::new;
        FinderType mobyDickMatcher = mobyDickByHermanMelville::contains;

        runner.run();
        System.out.println(parser.apply("42"));
        System.out.println(builder.get().concat("Hello!"));
        for (String word : new String[]{"fish","whale","Ahab","phone"}) {
            System.out.println(word + " : " + mobyDickMatcher.test(word));
        }
    }
}
