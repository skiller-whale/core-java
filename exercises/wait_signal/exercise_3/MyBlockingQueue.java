import java.util.*;
import java.util.concurrent.locks.*;
import java.util.function.BooleanSupplier;

class MyBlockingQueue<T> {
    static final int SIZE = 50; // Limit queue size
    final Queue<T> items  = new LinkedList<T>();
    final Lock lock       = new ReentrantLock();
    private boolean notEmpty() { return items.size() != 0; };
    private boolean notFull() { return items.size() != SIZE; };

    private void spinWhile(BooleanSupplier p) {
        while (!p.getAsBoolean()) {
            lock.unlock();
            lock.lock();
        }
    }

    T pop() throws InterruptedException {
        lock.lock();
        try {
            spinWhile(this::notEmpty);
            return items.poll(); // Get front element
        } finally { lock.unlock(); }
    }

    boolean push(T item) throws InterruptedException {
        lock.lock();
        try {
            spinWhile(this::notFull);
            items.offer(item);
            return true;
        } finally { lock.unlock(); }
    }
}
