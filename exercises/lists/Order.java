import java.util.ArrayList;
import java.util.List;

class Order {
    // -----------//
    // Exercise 2 //
    // -----------//

    // TODO: create a private backing field to store the items in the order

    void addItem(Item item) {
        // TODO: add item to the order
    }

    void applyDiscount(double percentage) {
        // TODO: apply the given percentage discount to all items in the order
    }

    // -----------//
    // Exercise 3 //
    // -----------//
    void applyCheapestFree() {
        // TODO: remove the cheapest item from the order
    }

    void applyBudget(float maxPrice) {
        // TODO: remove all items that are more expensive than maxPrice
    }

    // Helper method to print items in the order (to check your code)
    void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
