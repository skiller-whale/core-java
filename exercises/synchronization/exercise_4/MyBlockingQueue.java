import java.util.*;

class MyBlockingQueue<T> {
    static final int SIZE = 50; // Limit queue size
    final Queue<T> items = new LinkedList<T>();

    T pop() throws InterruptedException {
        if (items.size() == 0) { // The queue is empty!
            return null;
        }
        return items.poll(); // Get front element
    }

    boolean push(T item) throws InterruptedException {
        if (items.size() == SIZE) { // The queue is full!
            return false;
        }
        items.offer(item);
        return true;
    }
}
