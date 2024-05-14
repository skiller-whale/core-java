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
// 
// * Update `.collect(Collectors.toList())` to use `toList`.
// * Change all stream operations to use `mapMulti` instead of `map` and `filter`.
// * For each of the changes you made, think whether it made the code more readable
//      and/or easier to write and understand.
//  * Discuss this with your coach.
//
// Part 2 Hints: You can use `accept` multiple times.

record NameData(String name, String gender, int count) { }

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

public class Exercise3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        var femaleNameCounts = NameParser.parseNames("popular_female_names_1990s.csv");
        var maleNameCounts = NameParser.parseNames("popular_male_names_1990s.csv");

        // Part 1
        var namesStartingWithX = femaleNameCounts.entrySet()
            .stream()
            .filter(x -> x.getKey().startsWith("X"))
            .map(x -> new NameData(x.getKey(), "female", x.getValue()))
            .collect(Collectors.toList());
        
        System.out.println("\nFemale Names starting with 'X':");
        System.out.println(namesStartingWithX);


        // Get all names with counts > 250_000
        var allNamesMoreThan250k = femaleNameCounts.entrySet()
            .stream()
            .filter(x -> x.getValue() > 250000)
            .map(x -> new NameData(x.getKey(), "female", x.getValue()))
            .collect(Collectors.toList());

        System.out.println("\nFemale names that were used more than 250k times:");
        System.out.println(allNamesMoreThan250k);

        // Part 2
        var maleFemaleNamesMoreThan150k = femaleNameCounts.entrySet()
            .stream()
            .filter(x -> maleNameCounts.containsKey(x.getKey()) && x.getValue() > 150000)
            .map(x -> new NameData(x.getKey(), "female", x.getValue()))
            .flatMap(
                x -> Stream.of(
                    x,
                    new NameData(
                        x.name(), "male", maleNameCounts.get(x.name())
                    )
                )
            )
            .collect(Collectors.toList());

        System.out.println("\nMale/Female names used more than 150k times:\n");
        System.out.println(maleFemaleNamesMoreThan150k);
    }
}
