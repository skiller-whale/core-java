import java.util.*;

class Fibonacci implements Iterable<Integer> {
        private int m,n;
        private int count;

        Fibonacci(int max) { count=max; m = 0; n = 1; }

        // TODO: Implement the iterator() method

        public static void main(String[] args) {
                for (var i : new Fibonacci(10)) {
                        System.out.print(i);
                        System.out.print(",");
                }
                System.out.println();
        }
}

