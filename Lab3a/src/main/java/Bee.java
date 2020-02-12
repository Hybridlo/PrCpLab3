public class Bee extends Thread {
    private Honeypot honeypot;
    private int delay;

    Bee(Honeypot honeypot, int delay) {
        this.honeypot = honeypot;
        this.delay = delay;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {

            try {
                Thread.sleep(delay);
                honeypot.giveHoney();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
