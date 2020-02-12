public class Barber extends Thread {

    private BarberShop barberShop;

    Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                System.out.println("Barber sleeps\n");

                barberShop.takeSeatAndSleep();

                System.out.println("Barber woken up");

                cutHair();

                barberShop.release();

                System.out.println("Shop is not busy, possibly waking up waiting customer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cutHair() throws InterruptedException {
        System.out.println("Barber starts cutting hair");

        Thread.sleep(5000);
        barberShop.wakeUpSleeping();

        System.out.println("Barber finished cutting hair");
    }
}
