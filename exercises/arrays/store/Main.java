class Main {
    public static void main(String[] args) {
        var icedTea = new Item("Ice Tea", 3.5f);
        var carrotJuice = new Item("Carrot Juice", 2.0f);
        var pancakes = new Item("Pancakes", 4.0f);
        var penneAlfredo = new Item("Penne Alfredo", 9.15f);
        var waffles = new Item("Waffles", 4.75f);
        float discount = 0.1f;

        System.out.printf("%s: %.2f\n", icedTea.name, Basket.applyDiscount(icedTea, discount));
        System.out.printf("%s: %.2f\n", carrotJuice.name, Basket.applyDiscount(carrotJuice, discount));
        System.out.printf("%s: %.2f\n", pancakes.name, Basket.applyDiscount(pancakes, discount));
        System.out.printf("%s: %.2f\n", penneAlfredo.name, Basket.applyDiscount(penneAlfredo, discount));
        System.out.printf("%s: %.2f\n", waffles.name, Basket.applyDiscount(waffles, discount));
    }
}
