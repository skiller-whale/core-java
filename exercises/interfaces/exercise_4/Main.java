/* INTERFACES
 * ----------
 *
 * Run this program using `Javac Main.java`. You should see a compilation error:
 *
 * undefined: IcelandicProduct
 *
 * Define an `IcelandicProduct` interface using the three interfaces provided: `pricedInKrona`,
 * `coloured` and `titled`.
 *
 * This should make the `printIcelandicProducts` function type-check.
 *
 * Update the definition of `items` in `Main` so the program compiles.
 *
 * Return to the slide instructions to check that your code is working.
 */

public class Main {
    public static void main(String[] args) {
        BaseProduct[] items = new BaseProduct[3];
        items[0] = new BaseProduct("Whale soft toy", "Red", 995);
        items[1] = new BaseProduct("Poster of the Icelandic plains", "White, entirely", 1495);
        items[2] = new BaseProduct("Puffin keychain", "Orange", 300);
        BaseProduct.printIcelandicProducts(items);
    }
}


interface pricedInKrona {
    int price();
}


interface Coloured {
    String colour();
}


interface Titled {
    String title();
}


class BaseProduct implements IcelandicProduct {
    String titleEnglish;
    String looksLike;
    int pricePence;

    BaseProduct(String titleEnglish, String looksLike, int pricePence) {
        this.titleEnglish = titleEnglish;
        this.looksLike = looksLike;
        this.pricePence = pricePence;
    }

    @Override
    public int price() {
        return (this.pricePence * 171) / 100;
    }

    @Override
    public String colour() {
        // Always list colour first
        return this.looksLike.split(",")[0];
    }

    @Override
    public String title() {
        // eigum við að þýða þetta sjálfkrafa?
        return this.titleEnglish;
    }

    static void printIcelandicProducts(IcelandicProduct[] items) {
        System.out.printf("|Item name                     |Price (kr)|Colour         |\n");
        System.out.printf("-----------------------------------------------------------\n");
        for (IcelandicProduct item : items) {
            System.out.printf("|%-30s|%-10s|%-15s|\n", item.title(), item.price(), item.colour());
        }
    }
}
