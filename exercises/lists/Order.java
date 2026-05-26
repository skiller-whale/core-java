import java.util.ArrayList;
import java.util.List;

class Order {
    // ---------- //
    // Exercise 2 //
    // ---------- //

    final List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        // TODO: add item to the order
    }

    float totalCost() {
        // TODO: return the total cost of all items in the order
        return 0;
    }

    void applyDiscount(double percentage) {
        // TODO: apply the given percentage discount to all items in the order
    }

    // ---------- //
    // Exercise 3 //
    // ---------- //
    void applyCheapestFree() {
        // TODO: remove the cheapest item from the order
    }

    // ----------------- //
    // Optional Exercise //
    // ----------------- //
    void applyBudget(float maxPrice) {
        // TODO: remove all items that are more expensive than maxPrice
    }
}
