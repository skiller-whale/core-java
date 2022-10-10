import java.util.function.*;

public class LambdaComposer {
    public static void main(String[] args) {
        // FIXME: Write lambda which applies two other lambdas
        BinaryOperator< XXX > composer = (a,b) -> XXX

        Function<String,String> trimAndToUpperCase = composer.compose(String::toUpperCase, String::trim);

        System.out.println(trimAndToUpperCase.apply("    Hello!     "));
    }
}
