import java.util.Arrays;
import java.util.stream.*;
import java.util.function.*;
import java.nio.file.*;
import java.io.IOException;

public class JeopardyPresidents {
    public static void main(String[] args) throws IOException {
        // Stream the file contents as a series of Strings
        Stream<String> tabSeparatedData = Files.lines(Path.of("JeopardyData.tsv"));

        // 1. split lines into fields on tabs e.g.
        //
        //        "field 1\tfield 2".split("\t") ==> String[2] { "field 1", "field 2" }
        //
        // 2. does a string contain a particular substring? e.g.
        //
        //        "Scarborough".contains("car") ==> true
        //
        // Otherwise everything should just be doable with map, filter & foreach.
    }
}
