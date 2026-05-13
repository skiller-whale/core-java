import java.util.Objects;

final class Item {
    public final String name;
    public final float price;

    Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", name, price);
    }
}
