// FIXME: Add RunnerType, ParserType, BuilderType and FinderType

import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.util.function.*;

public class FunctionTypesTest2 {

    public static String fetchMobyDick() throws IOException, InterruptedException, URISyntaxException {
        return HttpClient.newBuilder().build().send(
            HttpRequest.newBuilder().uri(
                new URI("https://www.gutenberg.org/files/2701/2701-0.txt")
            ).GET().build(),
            HttpResponse.BodyHandlers.ofString()).body();
    }
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        String mobyDickByHermanMelville = fetchMobyDick();

        // FIXME: Change the XXXs for types in the java.util.function package

        XXX runner     = () -> System.out.println("Hello there!");
        XXX parser     = Integer::parseInt;
        XXX builder    = String::new;
        XXX mobyDickMatcher = mobyDickByHermanMelville::contains;

        runner.run();
        System.out.println(parser.apply("42"));
        System.out.println(builder.get().concat("Hello!"));
        for (String word : new String[]{"fish","whale","Ahab","phone"}) {
            System.out.println(word + " : " + mobyDickMatcher.test(word));
        }
    }
}
