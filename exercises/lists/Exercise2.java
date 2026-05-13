import java.util.List;

class Main {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.addItem(new Item("Ice Tea", 3.50f));
        order1.addItem(new Item("Penne Alfredo", 9.15f));
        order1.addItem(new Item("Waffles", 4.75f));
        order1.applyDiscount(0.1f); // 10% discount
        order1.printItems();
    }
}
