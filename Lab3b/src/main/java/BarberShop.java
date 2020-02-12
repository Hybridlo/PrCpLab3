import java.util.concurrent.Semaphore;

public class BarberShop {
    private Semaphore isBusy = new Semaphore(1);

    synchronized void takeSeatAndSleep() throws InterruptedException {
        wait();
    }

    synchronized void wakeUpSleeping() {
        notify();
    }

    boolean tryAcquire() {
        return isBusy.tryAcquire();
    }

    void acquire() throws InterruptedException {
        isBusy.acquire();
    }

    void release() {
        isBusy.release();
    }
}
