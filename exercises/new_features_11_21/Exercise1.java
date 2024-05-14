import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.stream.Collectors;

// NEW FEATURES JAVA 11-21: Exercise 1
// -------------
// The below code finds the number of likes for each movie
//   from a list of movies using streams.
// 
// Part 1
//   * Use `var` where possible to simplify this code (up to Part 2 below). 
// 
// Part 2
//   * What's the type of `mostLikedMovie`?
//      You would need to type this yourself if `var` didn't exist.
//   * To check your answer, uncomment the print statements at the end of this file.
// 

public class Exercise1 {
    public static void main(String[] args) {
        // Part 1
        HashMap<String, List<String>> likedMovies = new HashMap<>() {{
            put("alice", List.of("Casablanca", "Deadpool"));
            put("bob", List.of("Gone With the Wind", "Deadpool"));
            put("andy", List.of("Avatar"));
        }};

        HashMap<String, Integer> likedCounts = new HashMap<>();
        for(List<String> movies: likedMovies.values()) {
            for (String movie: movies) {
                likedCounts.putIfAbsent(movie, 0);
                likedCounts.compute(movie, (k, v) -> v + 1);
            }
        }

        System.out.println("Movie like counts:");
        System.out.println(likedCounts);

        // Part 2
        var mostLikedMovie = likedMovies.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream().max(HashMap.Entry.comparingByValue())
                .get();


        // TODO: Uncomment these lines to check your answer.
        // System.out.println("\nMost liked movie:");
        // System.out.println(mostLikedMovie);
        // System.out.println(mostLikedMovie.getClass());
    }
}
