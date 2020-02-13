public class Honeypot {
    private Semaphore gulps;

    Honeypot(int gulps) {
        this.gulps = new Semaphore(gulps);
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
        gulps.releaseAll();
        System.out.println("Honeypot drained");
    }

    private boolean isFull() {
        return gulps.availablePermits() == 0;
    }
}
