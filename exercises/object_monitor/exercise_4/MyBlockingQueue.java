import java.util.*;
import java.util.function.BooleanSupplier;

class MyBlockingQueue<T> {
    static final int SIZE = 100; // Limit queue size
    final Queue<T> items  = new LinkedList<T>();
    private boolean notEmpty() { return items.size() != 0; };
    private boolean notFull() { return items.size() != SIZE; };

    private void myWait(BooleanSupplier p) {
        while (!p.getAsBoolean()) {
            // spin-wait
            continue;
        }
    }

    T pop() throws InterruptedException {
        myWait(this::notEmpty);
        return items.poll();
    }

    void push(T item) throws InterruptedException {
        myWait(this::notFull);
        items.offer(item);
    }
}
