import java.util.concurrent.locks.*;

public class MyCountDownLatch {
    private int count;
    private Lock lock = new ReentrantLock();
    final Condition isZero = lock.newCondition();

    public MyCountDownLatch(int count) {
        this.count = count;
    }

    public void countDown() {
       // TODO: implement this method
    }

    public void await() throws InterruptedException {
        lock.lock();
        while (count != 0) {
            isZero.await();
        }
        lock.unlock();
    }
}
