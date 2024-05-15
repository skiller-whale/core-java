import java.util.*;
import java.util.stream.*;
import java.io.*;

// NEW FEATURES JAVA 11-21: Exercise 3
// -------------
// The below code extracts some information about the frequency of baby names.
// The provided file is in the format:
//      name_1, frequency_1
//      name_2, frequency_2
//      ...

// Part 1
//
// * Update the namesStartingWithX method to use mapMulti and toList instead of map and filter.
// * Do you think the newer version is more readable and/or easier to write and understand?

// Part 2
//
// * Now do the same for the popularUnisexNames method.
//
// Hints:
//  - You can use `accept` multiple times in `mapMulti` to emit multiple values.
//  - You may need to use a type witness to help the compiler infer the type of `mapMulti`.

public class Exercise3 {

    record NameData(String name, String gender, int count) { }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        var femaleNameCounts = NameParser.parseNames("popular_female_names_1990s.csv");
        var maleNameCounts = NameParser.parseNames("popular_male_names_1990s.csv");

        System.out.println("\nFemale Names Starting with 'X':\n");
        namesStartingWithX(femaleNameCounts).forEach(System.out::println);

        System.out.println("\nMost Popular Unisex Names (>20k each):\n");
        popularUnisexNames(femaleNameCounts, maleNameCounts).forEach(System.out::println);
    }

    // Part 1
    static List<NameData> namesStartingWithX(HashMap<String, Integer> nameCounts) {
        return nameCounts.entrySet()
            .stream()
            .filter(x -> x.getKey().startsWith("X"))
            .map(x -> new NameData(x.getKey(), "female", x.getValue()))
            .collect(Collectors.toList());
    }

    // Part 2
    static List<NameData> popularUnisexNames(HashMap<String, Integer> femaleNameCounts, HashMap<String, Integer> maleNameCounts) {
        return femaleNameCounts.entrySet()
            .stream()
            .filter(x -> x.getValue() > 20000)                               // More than 20,000 females with the name
            .filter(x -> maleNameCounts.getOrDefault(x.getKey(), 0) > 20000) // More than 20000 males with the name
            .map(x -> new NameData(x.getKey(), "female", x.getValue()))      // NameData object for the female name
            .flatMap(                                                        // Add this to a stream with NameData for the identical male name
                x -> Stream.of(
                    x,
                    new NameData(x.name(), "male", maleNameCounts.get(x.name()))
                )
            )
            .collect(Collectors.toList());
    }

    // You can ignore this class - it is just used for loading data.
    class NameParser {
        public static HashMap<String, Integer> parseNames(String filename) throws FileNotFoundException, IOException {
            var nameCounts = new HashMap<String, Integer>();

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                var values = line.split(",");
                nameCounts.put(values[0], Integer.parseInt(values[1]));
            }

            return nameCounts;
        }
    }
}

