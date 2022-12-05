import java.util.*;
import java.util.stream.*;

public class JavaSnackBar {
    record MenuItem(String description, int price, int calories, Set<Flag> flags) {
        public String toString() {
            var flagsStr = flags.isEmpty() ? "" : " ("+String.join(",",
                flags.stream().map(f -> f.abbr).toList()
            )+")";
            return String.format("%s: £%d.%02d - %dkcal", description, price/100, price%100, calories) + flagsStr;
        }
        enum Flag {
            Vegan("V"),
            GlutenFree("GF");

            final String abbr;
            Flag(String abbr) { this.abbr = abbr; }
        }
    }

    static final MenuItem[] menu = new MenuItem[]{
        new MenuItem("Ice Tea", 295, 12, EnumSet.of(MenuItem.Flag.Vegan, MenuItem.Flag.GlutenFree)),
        new MenuItem("Carrot Juice", 195, 39, EnumSet.of(MenuItem.Flag.Vegan, MenuItem.Flag.GlutenFree)),
        new MenuItem("Beetroot And Lentil Tabouleh", 895, 359, EnumSet.of(MenuItem.Flag.Vegan, MenuItem.Flag.GlutenFree)),
        new MenuItem("Minute Steak with Fries", 1195, 744, EnumSet.of(MenuItem.Flag.GlutenFree)),
        new MenuItem("Veggie Burger with Fries", 895, 701, EnumSet.of(MenuItem.Flag.Vegan)),
        new MenuItem("Penne Alfredo", 595, 650, Collections.emptySet()),
        new MenuItem("Waffles and Ice Cream", 395, 477, Collections.emptySet()),
        new MenuItem("Fruit Platter", 495, 250, EnumSet.of(MenuItem.Flag.Vegan, MenuItem.Flag.GlutenFree))
    };

    public static void main(String[] args) {
        // Print out the vegan menu items with their prices
        //
        // 1. Turn the array into a Stream with `Stream.of()`
        // 2. Filter the stream by testing each element for the vegan flag
        // 3. Print each item found
        //

        // (in the next exercise)
        //
        // 4. Use reduce() and write a lambda argument which finds the cheapest calories
        // 5. Print its result
    }
}
