import java.util.List;

class Main {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.addItem(new Item("Ice Tea", 3.50f));
        order1.addItem(new Item("Penne Alfredo", 9.15f));
        order1.addItem(new Item("Waffles", 4.75f));
        order1.applyDiscount(0.1f); // 10% discount

        Order order2 = new Order();
        order2.addItem(new Item("Ice Tea", 3.50f));
        order2.addItem(new Item("Penne Alfredo", 9.15f));
        order2.addItem(new Item("Waffles", 4.75f));
        order2.addItem(new Item("Carrot Juice", 2.00f));
        order2.addItem(new Item("Pancakes", 4.00f));

        order2.applyCheapestFree();
        System.out.println("Cheapest free discount applied:");
        order2.printItems();

        order2.applyBudget(4.00f);
        System.out.println("Budget applied:");
        order2.printItems();

        Waiter waiter = new Waiter();
        waiter.addOrder(1, order1);
        waiter.addOrder(2, order2);
        waiter.removeOrder(1);
        System.out.println("After table 1 has been served:");
        System.out.println(waiter.status());
    }
}
