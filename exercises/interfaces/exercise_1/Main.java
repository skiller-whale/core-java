/* ABSTRACT CLASSES
 * ----------------
 *
 * Try to see why this program does not compile.
 *
 * Modify the three concrete types, and add any required methods and constructors, so that the code
 * compiles.
 *
 * Return to the slide instructions to check that your code is working.
 */

public class Main {
    public static void main(String[] args) {
        Priced[] items = new Priced[3];
        items[0] = new Handbag(7999, "Aegean Blue");
        items[1] = new Eyedrops(499);
        items[2] = new ColaBottle();

        int sum = 0;
        for (Priced item : items) {
            sum += item.price();
            System.out.printf("Adding %s\n", item.getClass().getSimpleName());
        }
        System.out.println("------------------");
        System.out.printf("Total price = £%s\n", sum / 100);
    }
}

abstract class Priced {
    // VAT is 20% of the price of an item
    static final double VAT = 0.2;

    protected abstract double price();
}

class Handbag {
    int pence;
    String colour;

    double pence() {
        return this.pence + this.pence * Priced.VAT;
    }
}

class Eyedrops {
    int pence;
    // Eyedrops are exempt from VAT
}

class ColaBottle {
    double price() {
        return 100d;
        // Always costs £1 before VAT
    }
}
