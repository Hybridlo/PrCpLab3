public class Bear extends Thread {
    private Honeypot honeypot;

    Bear(Honeypot honeypot) {
        this.honeypot = honeypot;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {

            try {
                honeypot.takeHoney();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
