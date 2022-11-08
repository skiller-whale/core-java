import java.util.function.*;
import java.io.IOException;
import java.io.File;

public class ExceptionSuppressor {

    interface UnaryOperatorThrowingIOException<T> { T apply(T f) throws IOException; }

    public static void main(String[] args) {
        UnaryOperatorThrowingIOException<String> expandPath = (n) -> new File(n).getCanonicalPath();

        Function< xxx, yyy > suppressIOE = zzz

        UnaryOperator<String> expandPathNoExceptions = suppressIOE.apply(expandPath);

        for (var path : new String[]{ "/", ".", "C:\\", "COM1.txt", ".".repeat(5000), "\u0000" }) {
            String expanded = expandPathNoExceptions.apply(path);
            if (expanded == null) {
                System.out.println("Path not valid "+path);
            } else {
                System.out.println("Path "+path+" expanded to "+expanded);
            }
        }
    }
}
