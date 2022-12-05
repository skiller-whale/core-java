import java.util.Arrays;
import java.util.stream.*;
import java.util.function.*;
import java.nio.file.*;
import java.io.IOException;

public class JeopardyPresidents {
    public static void main(String[] args) throws IOException {
        // Stream the file contents as a series of Strings
        Stream<String> tabSeparatedDataLines = Files.lines(Path.of("JeopardyData.tsv"));

        // Two utility methods you'll need:
        //
        // 1. split a String into an array of smaller Strings e.g.
        //
        //    "field 1\tfield 2".split("\t") ==> String[2] { "field 1", "field 2" }
        //
        // 2. test whether a string contains a particular substring e.g.
        //
        //    "Scarborough".contains("car") ==> true
        //    "Cambridge".contains("car") ==> false
        //
        // Otherwise this is achievable with a combination of map, filter & forEach.
    }
}
