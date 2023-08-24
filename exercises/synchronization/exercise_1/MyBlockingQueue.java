import java.util.*;
import java.util.concurrent.locks.*;

class MyBlockingQueue<T> {
    static final int SIZE = 50; // Limit queue size
    final Queue<T> items = new LinkedList<T>();
    final Lock lock = new ReentrantLock();

    T pop() throws InterruptedException {
        lock.lock();
        try {
            if (items.size() == 0) { // The queue is empty!
               return null;
            }
            return items.poll(); // Get front element
        } finally { lock.unlock(); }
    }

    boolean push(T item) throws InterruptedException {
        lock.lock();
        try {
            if (items.size() == SIZE) { // The queue is full!
              return false;
            }
            items.offer(item);
            return true;
        } finally { lock.unlock(); }
    }
}
