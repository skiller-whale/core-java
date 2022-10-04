public class LambdaTest {

    // FIXME: 1) Write a receiver type, giving it a relevant name
    //
    public static void main(String[] args) {
        // FIXME: 2) Change `var` for a receiver type:
        //
        var interpolate = (a,b) -> {
            var ca = a.toCharArray();
            var cb = b.toCharArray();
            var out = new String();
            for (int i=0; i<ca.length || i<cb.length; i++) {
                if (i < ca.length) { out += ca[i]; }
                if (i < cb.length) { out += cb[i]; }
            }
            return out;
        };

        System.out.println(interpolate.apply("HloWrd", "el ol!"));
    }
}
