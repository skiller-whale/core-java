import java.util.List;

class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(List.of(
            new Item("Ice Tea", 3.50f),
            new Item("Carrot Juice", 2.00f),
            new Item("Pancakes", 4.00f),
            new Item("Penne Alfredo", 9.15f),
            new Item("Waffles", 4.75f)
        ));
        menu.printMenu();
        System.out.println("Total: " + menu.totalCost());
        System.out.println("Has Ice Tea: " + menu.isAvailable(new Item("Ice Tea", 3.50f)));
        System.out.println("Has Pizza: " + menu.isAvailable(new Item("Pizza", 9.95f)));
    }
}
