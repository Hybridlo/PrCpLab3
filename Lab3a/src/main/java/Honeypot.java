import java.util.concurrent.Semaphore;

public class Honeypot {
    private Semaphore gulps;
    private int gulpsAmount;

    Honeypot(int gulps) {
        this.gulps = new Semaphore(gulps);
        this.gulpsAmount = gulps;
    }

    synchronized void giveHoney() throws InterruptedException {
        gulps.acquire();

        if (isFull()) {
            notify();
        }

        System.out.println("Space available: " + gulps.availablePermits());
    }

    synchronized void takeHoney() throws InterruptedException {
        wait();
        gulps.release(gulpsAmount);
        System.out.println("Honeypot drained");
    }

    private boolean isFull() {
        return gulps.availablePermits() == 0;
    }
}