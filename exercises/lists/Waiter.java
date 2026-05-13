import java.util.ArrayList;
import java.util.List;

class Waiter {
    private List<Integer> tables = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    void addOrder(int table, Order order) {
        tables.add(table);
        orders.add(order);
    }

    void removeOrder(int table) {
        // TODO: remove the table and its corresponding order
    }

    String status() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tables.size(); i++) {
            sb.append("Table ").append(tables.get(i)).append(": ")
                .append(orders.get(i).items.size()).append(" items");
            if (i < tables.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
