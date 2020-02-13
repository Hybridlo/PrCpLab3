public class Semaphore {
    private int maxPermits;
    private int permits = 0;

    Semaphore(int permits) {
        this.maxPermits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == maxPermits) wait();
        permits++;
    }

    public synchronized void releaseAll() {
        permits = 0;
    }

    public synchronized int availablePermits() {
        return maxPermits - permits;
    }
}
